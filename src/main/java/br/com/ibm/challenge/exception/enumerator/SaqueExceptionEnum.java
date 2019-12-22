package br.com.ibm.challenge.exception.enumerator;

import br.com.ibm.challenge.exception.GeneralException;
import org.springframework.http.HttpStatus;

public enum SaqueExceptionEnum {

    SALDO_INSUFICIENTE                  (new GeneralException("Operação não efetuada: saldo insuficiente para o saque.", HttpStatus.BAD_REQUEST)),
    SAQUE_ABAIXO_DO_MINIMO              (new GeneralException("Operação não efetuada: o saque mínimo é de 5 (cinco) reais.", HttpStatus.BAD_REQUEST)),
    SAQUE_E_CEDULAS_NAO_CORRESPONDENTES (new GeneralException("Operação não efetuada: o terminal não possui cédulas para este saque.", HttpStatus.INTERNAL_SERVER_ERROR));

    private final GeneralException exception;

	SaqueExceptionEnum(GeneralException exception){
        this.exception = exception;
    }

    public GeneralException getException(){
        return this.exception;
    }
}
