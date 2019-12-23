package br.com.ibm.challenge.exception.enumerator;

import br.com.ibm.challenge.exception.GeneralException;
import org.springframework.http.HttpStatus;

public enum TransferenciaExceptionEnum {

    VALOR_INVALIDO              (new GeneralException("Operação não efetuada: um valor maior que zero deve ser transferido.", HttpStatus.BAD_REQUEST)),
    REMETENTE_SEM_SALDO         (new GeneralException("Operação não efetuada: o remetente não possui saldo para a transferência.", HttpStatus.BAD_REQUEST)),
    TRANSFERENCIA_CONTAS_IGUAIS (new GeneralException("Operação não efetuada: não é possível transferir recursos entre contas iguais.", HttpStatus.BAD_REQUEST));

    private final GeneralException exception;

    TransferenciaExceptionEnum(GeneralException exception) {
        this.exception = exception;
    }

    public GeneralException getException() {
        return exception;
    }
}
