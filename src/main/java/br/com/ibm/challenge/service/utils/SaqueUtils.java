package br.com.ibm.challenge.service.utils;

import br.com.ibm.challenge.domain.TerminalAtm;
import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Saque;
import br.com.ibm.challenge.domain.builder.SaqueBuilder;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.SaqueRules;

import java.math.BigDecimal;

public class SaqueUtils {

    public static Saque montarNovoSaque(TerminalAtm atm, ContaCorrente contaCorrente, BigDecimal valorSaque) {
        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrente);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrente);
        SaqueRules.valorSaqueNotNull(true, valorSaque);
        SaqueRules.saldoSuficienteParaSaque(true, contaCorrente, valorSaque);

        Saque saque = new SaqueBuilder(contaCorrente.getId(), atm.getId(), valorSaque).build();

        return TerminalAtmUtils.getCedulasParaSaque(atm, saque);
    }
}
