package br.com.ibm.challenge.service.rules;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Transferencia;
import br.com.ibm.challenge.exception.enumerator.GenericExceptionEnum;
import br.com.ibm.challenge.exception.enumerator.TransferenciaExceptionEnum;

import java.math.BigDecimal;

import static br.com.ibm.challenge.exception.GeneralException.returnFalseOrException;

public class TransferenciaRules {

    public static boolean versaoApiEfetuarTransferenciaValida(boolean throwException, short versaoApi) {
        if (versaoApi == 1) { //Adicionar mais condicionais conforme houverem novas versões.
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.VERSAO_API_INVALIDA.getException());
        }
    }

    public static boolean transferenciaNotNull(boolean throwException, Transferencia transferencia) {
        if (transferencia != null) {
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.ERRO_PREENCHIMENTO.getException());
        }
    }

    public static boolean valorTransferenciaValido(boolean throwException, BigDecimal valor) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, TransferenciaExceptionEnum.VALOR_INVALIDO.getException());
        }
    }

    public static boolean idsContaCorrenteValidos(boolean throwException, Transferencia transferencia) {
        if (transferencia.getIdContaCorrenteOrigem() == transferencia.getIdContaCorrenteDestino()) {
            returnFalseOrException(throwException, TransferenciaExceptionEnum.TRANSFERENCIA_CONTAS_IGUAIS.getException());
        }

        if (transferencia.getIdContaCorrenteOrigem() > 0 && transferencia.getIdContaCorrenteDestino() > 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, GenericExceptionEnum.ERRO_PREENCHIMENTO.getException());
        }
    }

    public static boolean remetentePossuiSaldoParaTransferencia(boolean throwException, Transferencia transferencia, ContaCorrente contaCorrenteOrigem) {
        if (contaCorrenteOrigem.getSaldo().compareTo(transferencia.getValor()) >= 0) {
            return true;
        } else {
            return returnFalseOrException(throwException, TransferenciaExceptionEnum.REMETENTE_SEM_SALDO.getException());
        }
    }
}
