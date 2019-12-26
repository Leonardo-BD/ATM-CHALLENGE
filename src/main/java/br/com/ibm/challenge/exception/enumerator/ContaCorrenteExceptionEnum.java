package br.com.ibm.challenge.exception.enumerator;

import br.com.ibm.challenge.exception.GeneralException;
import org.springframework.http.HttpStatus;

public enum ContaCorrenteExceptionEnum {

    CONTA_INATIVA                   (new GeneralException("Operação não efetuada: conta corrente inativa.", HttpStatus.FORBIDDEN)),
    SALDO_INSUFICIENTE_PARA_DEBITO  (new GeneralException("Operação não efetuada: saldo insuficiente para a operação.", HttpStatus.BAD_REQUEST));

    private final GeneralException exception;

    ContaCorrenteExceptionEnum(GeneralException exception) {
        this.exception = exception;
    }

    public GeneralException getException() {
        return exception;
    }
}
