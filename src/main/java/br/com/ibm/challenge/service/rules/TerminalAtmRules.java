package br.com.ibm.challenge.service.rules;

import br.com.ibm.challenge.domain.TerminalAtm;
import br.com.ibm.challenge.exception.enumerator.GenericExceptionEnum;
import br.com.ibm.challenge.exception.enumerator.TerminalAtmExceptionEnum;

import java.math.BigDecimal;

import static br.com.ibm.challenge.exception.GeneralException.returnFalseOrException;

public class TerminalAtmRules {

    public static boolean terminalAtmNotNull(boolean throwException, TerminalAtm terminalAtm) {
        if (terminalAtm != null) {
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.ERRO_PREENCHIMENTO.getException());
        }
    }

    public static boolean localizacaoCadastrada(boolean throwException, TerminalAtm terminalAtm) {
        if (terminalAtm.getLocalizacao() != null && !terminalAtm.getLocalizacao().isEmpty()) {
            return true;
        } else {
            return returnFalseOrException(throwException, TerminalAtmExceptionEnum.LOCALIZACAO_NAO_CADASTRADA.getException());
        }
    }

    public static boolean terminalAtivo(boolean throwException, TerminalAtm terminalAtm) {
        if (terminalAtm.isAtivo()) {
            return true;
        } else {
            return returnFalseOrException(throwException, TerminalAtmExceptionEnum.TERMINAL_INATIVO.getException());
        }
    }

    public static boolean terminalPossuiCedulas(boolean throwException, TerminalAtm terminalAtm, BigDecimal valorSaque) {
        boolean possuiCedulas = terminalAtm.getCedulasReal_2() > 0 ||
                                terminalAtm.getCedulasReal_5() > 0 ||
                                terminalAtm.getCedulasReal_10() > 0 ||
                                terminalAtm.getCedulasReal_20() > 0 ||
                                terminalAtm.getCedulasReal_50() > 0 ||
                                terminalAtm.getCedulasReal_100() > 0;

        boolean valorSaqueImpar = valorSaque.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.ZERO) != 0;

        boolean possuiCedulasParaValorImpar =   valorSaqueImpar &&
                                                ((valorSaque.remainder(BigDecimal.valueOf(5)).compareTo(BigDecimal.ZERO) == 0 &&
                                                terminalAtm.getCedulasReal_5() > 0) ||
                                                (terminalAtm.getCedulasReal_5() > 0 &&
                                                terminalAtm.getCedulasReal_2() > 0));

        if ((!valorSaqueImpar && possuiCedulas) || (valorSaqueImpar && possuiCedulasParaValorImpar)) {
            return true;
        } else {
            return returnFalseOrException(throwException, TerminalAtmExceptionEnum.TERMINAL_SEM_CEDULAS.getException());
        }
    }

    public static boolean valorSuficienteParaSaque(boolean throwException, BigDecimal valorDisponivel, BigDecimal valorSaque) {
        if (valorDisponivel.compareTo(valorSaque) >= 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, TerminalAtmExceptionEnum.VALOR_INSUFICIENTE_SAQUE.getException());
        }
    }
}
