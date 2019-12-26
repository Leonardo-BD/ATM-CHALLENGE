package br.com.ibm.challenge.exception.enumerator;

import br.com.ibm.challenge.exception.GeneralException;
import org.springframework.http.HttpStatus;

public enum DepositoExceptionEnum {

    TIPO_DEPOSITO_INVALIDO  (new GeneralException("Operação não efetuada: modalidade de depósito não suportada.", HttpStatus.BAD_REQUEST)),
    CONTA_DEPOSITO_INVALIDA (new GeneralException("Operação não efetuada: insira uma conta válida para depósito.", HttpStatus.BAD_REQUEST)),
    VALOR_DEPOSITO_INVALIDO (new GeneralException("Operação não efetuada: o depósito deve ter um valor maior que zero.", HttpStatus.BAD_REQUEST));

    private final GeneralException exception;

    DepositoExceptionEnum(GeneralException exception) {
        this.exception = exception;
    }

    public GeneralException getException() {
        return exception;
    }
}
