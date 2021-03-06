package br.com.ibm.challenge.service.rules;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.exception.enumerator.ContaCorrenteExceptionEnum;
import br.com.ibm.challenge.exception.enumerator.GenericExceptionEnum;

import java.math.BigDecimal;

import static br.com.ibm.challenge.exception.GeneralException.returnFalseOrException;

public class ContaCorrenteRules {

    public static boolean contaCorrenteNotNull(boolean throwException, ContaCorrente contaCorrente) {
        if (contaCorrente != null) {
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.ERRO_PREENCHIMENTO.getException());
        }
    }

    public static boolean contaCorrenteAtiva(boolean throwException, ContaCorrente contaCorrente) {
        if (contaCorrente.isAtivo()) {
            return true;
        } else {
            return returnFalseOrException(throwException, ContaCorrenteExceptionEnum.CONTA_INATIVA.getException());
        }
    }

    public static boolean saldoSuficienteDebito(boolean throwException, ContaCorrente contaCorrente, BigDecimal valorDebito) {
        if (valorDebito != null && contaCorrente.getSaldo().compareTo(valorDebito) >= 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, ContaCorrenteExceptionEnum.SALDO_INSUFICIENTE_PARA_DEBITO.getException());
        }
    }
}
