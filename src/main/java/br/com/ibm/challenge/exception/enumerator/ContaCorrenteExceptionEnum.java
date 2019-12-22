package br.com.ibm.challenge.exception.enumerator;

import br.com.ibm.challenge.exception.GeneralException;
import org.springframework.http.HttpStatus;

public enum ContaCorrenteExceptionEnum {

    CONTA_INATIVA   (new GeneralException("Operação não efetuada: conta corrente inativa.", HttpStatus.FORBIDDEN));

    private final GeneralException exception;

    ContaCorrenteExceptionEnum(GeneralException exception) {
        this.exception = exception;
    }

    public GeneralException getException() {
        return exception;
    }
}
