package br.com.ibm.challenge.exception.enumerator;

import br.com.ibm.challenge.exception.GeneralException;
import org.springframework.http.HttpStatus;

public enum TerminalAtmExceptionEnum {

    TERMINAL_INATIVO            (new GeneralException("Operação não efetuada: o terminal está desativado.", HttpStatus.BAD_REQUEST)),
    LOCALIZACAO_NAO_CADASTRADA  (new GeneralException("Operação não efetuada: localização do terminal não pôde ser validada.", HttpStatus.INTERNAL_SERVER_ERROR)),
    TERMINAL_SEM_CEDULAS        (new GeneralException("Operação não efetuada: sem cédulas no terminal.", HttpStatus.INTERNAL_SERVER_ERROR)),
    VALOR_INSUFICIENTE_SAQUE    (new GeneralException("Operação não efetuada: terminal sem valor suficiente para saque.", HttpStatus.INTERNAL_SERVER_ERROR));

    private final GeneralException exception;

	TerminalAtmExceptionEnum(GeneralException exception){
        this.exception = exception;
    }

    public GeneralException getException(){
        return this.exception;
    }
}
