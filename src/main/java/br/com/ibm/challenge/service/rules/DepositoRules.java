package br.com.ibm.challenge.service.rules;

import br.com.ibm.challenge.domain.Deposito;
import br.com.ibm.challenge.enumerator.ETipoDeposito;
import br.com.ibm.challenge.exception.enumerator.DepositoExceptionEnum;
import br.com.ibm.challenge.exception.enumerator.GenericExceptionEnum;

import java.math.BigDecimal;

import static br.com.ibm.challenge.exception.GeneralException.returnFalseOrException;

public class DepositoRules {

    public static boolean versaoApiEfetuarDepositoValida(boolean throwException, short versaoApi) {
        if (versaoApi == 1) { //Adicionar mais condicionais conforme houverem novas versões.
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.VERSAO_API_INVALIDA.getException());
        }
    }

    public static boolean depositoNotNull(boolean throwException, Deposito deposito) {
        if (deposito != null) {
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.ERRO_PREENCHIMENTO.getException());
        }
    }

    public static boolean contaParaDepositoPreenchida(boolean throwException, Deposito deposito) {
        if (deposito.getIdContaCorrenteDeposito() > 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, DepositoExceptionEnum.CONTA_DEPOSITO_INVALIDA.getException());
        }
    }

    public static boolean tipoDepositoValido(boolean throwException, Deposito deposito) {
        if (ETipoDeposito.tipoDepositoExistente(deposito.getIdTipoDeposito())) {
            return true;
        } else {
            return returnFalseOrException(throwException, DepositoExceptionEnum.TIPO_DEPOSITO_INVALIDO.getException());
        }
    }

    public static boolean valorDepositoValido(boolean throwException, BigDecimal valorDeposito) {
        if (valorDeposito != null && valorDeposito.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, DepositoExceptionEnum.VALOR_DEPOSITO_INVALIDO.getException());
        }
    }
}
