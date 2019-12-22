package br.com.ibm.challenge.service.utils;

import br.com.ibm.challenge.domain.Saque;
import br.com.ibm.challenge.domain.TerminalAtm;
import br.com.ibm.challenge.service.rules.SaqueRules;
import br.com.ibm.challenge.service.rules.TerminalAtmRules;

import java.math.BigDecimal;

public class TerminalAtmUtils {

    public static Saque getCedulasParaSaque(TerminalAtm terminalAtm, Saque saque) {
        TerminalAtmRules.terminalAtmNotNull(true, terminalAtm);
        TerminalAtmRules.terminalAtivo(true, terminalAtm);
        TerminalAtmRules.terminalPossuiCedulas(true, terminalAtm, saque.getValor());
        TerminalAtmRules.valorSuficienteParaSaque(true, getValorDisponivelEmCaixa(terminalAtm, saque.getValor()), saque.getValor());
        SaqueRules.valorSaqueValido(true, saque.getValor());

        BigDecimal valorSaque = saque.getValor();

        if (valorSaque.remainder(BigDecimal.valueOf(5)).compareTo(BigDecimal.ZERO) != 0) {
            terminalAtm.setCedulasReal_5(terminalAtm.getCedulasReal_5() - 1);
            saque.setCedulasReal_5(saque.getCedulasReal_5() + 1);

            valorSaque = valorSaque.subtract(BigDecimal.valueOf(5));

            while (valorSaque.remainder(BigDecimal.valueOf(5)).compareTo(BigDecimal.ZERO) != 0) {
                terminalAtm.setCedulasReal_2(terminalAtm.getCedulasReal_2() - 1);
                saque.setCedulasReal_2(saque.getCedulasReal_2() + 1);

                valorSaque = valorSaque.subtract(BigDecimal.valueOf(2));
            }
        }

        while (valorSaque.compareTo(BigDecimal.valueOf(100)) >= 0 && terminalAtm.getCedulasReal_100() > 0) {
            terminalAtm.setCedulasReal_100(terminalAtm.getCedulasReal_100() - 1);
            saque.setCedulasReal_100(saque.getCedulasReal_100() + 1);

            valorSaque = valorSaque.subtract(BigDecimal.valueOf(100));
        }

        while (valorSaque.compareTo(BigDecimal.valueOf(50)) >= 0 && terminalAtm.getCedulasReal_50() > 0) {
            terminalAtm.setCedulasReal_50(terminalAtm.getCedulasReal_50() - 1);
            saque.setCedulasReal_50(saque.getCedulasReal_50() + 1);

            valorSaque = valorSaque.subtract(BigDecimal.valueOf(50));
        }

        while (valorSaque.compareTo(BigDecimal.valueOf(20)) >= 0 && terminalAtm.getCedulasReal_20() > 0) {
            terminalAtm.setCedulasReal_20(terminalAtm.getCedulasReal_20() - 1);
            saque.setCedulasReal_20(saque.getCedulasReal_20() + 1);

            valorSaque = valorSaque.subtract(BigDecimal.valueOf(20));
        }

        while (valorSaque.compareTo(BigDecimal.valueOf(10)) >= 0 && terminalAtm.getCedulasReal_10() > 0) {
            terminalAtm.setCedulasReal_10(terminalAtm.getCedulasReal_10() - 1);
            saque.setCedulasReal_10(saque.getCedulasReal_10() + 1);

            valorSaque = valorSaque.subtract(BigDecimal.valueOf(10));
        }

        while (valorSaque.compareTo(BigDecimal.valueOf(5)) >= 0 && terminalAtm.getCedulasReal_5() > 0) {
            terminalAtm.setCedulasReal_5(terminalAtm.getCedulasReal_5() - 1);
            saque.setCedulasReal_5(saque.getCedulasReal_5() + 1);

            valorSaque = valorSaque.subtract(BigDecimal.valueOf(5));
        }

        while (valorSaque.compareTo(BigDecimal.valueOf(2)) >= 0 && terminalAtm.getCedulasReal_2() > 0) {
            terminalAtm.setCedulasReal_2(terminalAtm.getCedulasReal_2() - 1);
            saque.setCedulasReal_2(saque.getCedulasReal_2() + 1);

            valorSaque = valorSaque.subtract(BigDecimal.valueOf(2));
        }

        SaqueRules.valorSaqueCorrespondeComAsCedulas(true, saque);

        return saque;
    }

    public static BigDecimal getValorDisponivelEmCaixa(TerminalAtm terminalAtm, BigDecimal valorSaque) {
        TerminalAtmRules.terminalAtmNotNull(true, terminalAtm);
        TerminalAtmRules.terminalPossuiCedulas(true, terminalAtm, valorSaque);

        BigDecimal valor = new BigDecimal(0);

        valor = valor.add(BigDecimal.valueOf(terminalAtm.getCedulasReal_2()*2));
        valor = valor.add(BigDecimal.valueOf(terminalAtm.getCedulasReal_5()*5));
        valor = valor.add(BigDecimal.valueOf(terminalAtm.getCedulasReal_10()*10));
        valor = valor.add(BigDecimal.valueOf(terminalAtm.getCedulasReal_20()*20));
        valor = valor.add(BigDecimal.valueOf(terminalAtm.getCedulasReal_50()*50));
        valor = valor.add(BigDecimal.valueOf(terminalAtm.getCedulasReal_100()*100));

        return valor;
    }
}
