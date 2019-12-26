package br.com.ibm.challenge.service.rules;

import br.com.ibm.challenge.domain.Transferencia;
import br.com.ibm.challenge.exception.enumerator.GenericExceptionEnum;
import br.com.ibm.challenge.exception.enumerator.TransferenciaExceptionEnum;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

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

    public static boolean transferenciaNaoExecutada(boolean throwException, Transferencia transferencia) {
        if (!transferencia.isExecutada()) {
            return true;
        } else {
            return returnFalseOrException(throwException, TransferenciaExceptionEnum.TRANSFERENCIA_JA_EXECUTADA.getException());
        }
    }

    public static boolean horarioDeTransferenciaValido() {
        ZonedDateTime dateNow = ZonedDateTime.now();
        ZonedDateTime dataAbertura = ZonedDateTime.now().withHour(7).withMinute(30).withSecond(0).withNano(0);
        ZonedDateTime dataFechamento = ZonedDateTime.now().withHour(22).withMinute(0).withSecond(0).withNano(0);

        boolean horarioValido =     (dateNow.getDayOfWeek().getValue() >= 1 &&
                                    dateNow.getDayOfWeek().getValue() <= 5) &&
                                    (dateNow.isAfter(dataAbertura) &&
                                    dateNow.isBefore(dataFechamento));

        if (horarioValido) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean transferenciaPorAgendamentoAutorizada(Transferencia transferencia) {
        if (ZonedDateTime.now().toEpochSecond() >= transferencia.getDataAgendamento()) {
            return true;
        } else {
            return false;
        }
    }
}
