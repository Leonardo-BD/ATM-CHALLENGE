package br.com.ibm.challenge.exception.enumerator;

import br.com.ibm.challenge.exception.GeneralException;
import org.springframework.http.HttpStatus;

public enum GenericExceptionEnum {

    VERSAO_API_INVALIDA (new GeneralException("Operação não efetuada: versão inexistente para esta API.", HttpStatus.NOT_FOUND)),
    ERRO_PREENCHIMENTO  (new GeneralException("Operação não efetuada: verifique o correto preenchimento dos campos.", HttpStatus.BAD_REQUEST));

    private final GeneralException exception;

    GenericExceptionEnum(GeneralException exception) {
        this.exception = exception;
    }

    public GeneralException getException() {
        return exception;
    }
}
