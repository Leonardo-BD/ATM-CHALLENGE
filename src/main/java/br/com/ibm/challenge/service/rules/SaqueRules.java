package br.com.ibm.challenge.service.rules;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Saque;
import br.com.ibm.challenge.exception.enumerator.GenericExceptionEnum;
import br.com.ibm.challenge.exception.enumerator.SaqueExceptionEnum;

import java.math.BigDecimal;

import static br.com.ibm.challenge.exception.GeneralException.returnFalseOrException;

public class SaqueRules {

    public static boolean versaoApiValida(boolean throwException, short versaoApi) {
        if (versaoApi == 1) { //Adicionar mais condicionais conforme houverem novas versões.
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.VERSAO_API_INVALIDA.getException());
        }
    }

    public static boolean saqueNotNull(boolean throwException, Saque saque) {
        if (saque != null) {
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.ERRO_PREENCHIMENTO.getException());
        }
    }

    public static boolean valorSaqueNotNull(boolean throwException, BigDecimal valorSaque) {
        if (valorSaque != null) {
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.ERRO_PREENCHIMENTO.getException());
        }
    }

    public static boolean saldoSuficienteParaSaque(boolean throwException, ContaCorrente contaCorrente, BigDecimal valorSaque) {
        if (valorSaque.compareTo(contaCorrente.getSaldo()) < 1) {
            return true;
        } else {
            return returnFalseOrException(throwException, SaqueExceptionEnum.SALDO_INSUFICIENTE.getException());
        }
    }

    public static boolean valorSaqueValido(boolean throwException, BigDecimal valorSaque) {
        if (valorSaque.compareTo(BigDecimal.valueOf(5)) >= 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, SaqueExceptionEnum.SAQUE_ABAIXO_DO_MINIMO.getException());
        }
    }

    public static boolean valorSaqueCorrespondeComAsCedulas(boolean throwException, Saque saque) {
        BigDecimal valorCedulas = BigDecimal.ZERO;

        valorCedulas = valorCedulas.add(BigDecimal.valueOf(saque.getCedulasReal_2() * 2));
        valorCedulas = valorCedulas.add(BigDecimal.valueOf(saque.getCedulasReal_5() * 5));
        valorCedulas = valorCedulas.add(BigDecimal.valueOf(saque.getCedulasReal_10() * 10));
        valorCedulas = valorCedulas.add(BigDecimal.valueOf(saque.getCedulasReal_20() * 20));
        valorCedulas = valorCedulas.add(BigDecimal.valueOf(saque.getCedulasReal_50() * 50));
        valorCedulas = valorCedulas.add(BigDecimal.valueOf(saque.getCedulasReal_100() * 100));

        if (saque.getValor().compareTo(valorCedulas) == 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, SaqueExceptionEnum.SAQUE_E_CEDULAS_NAO_CORRESPONDENTES.getException());
        }
    }
}
