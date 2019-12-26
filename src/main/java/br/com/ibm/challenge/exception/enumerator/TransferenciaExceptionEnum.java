package br.com.ibm.challenge.exception.enumerator;

import br.com.ibm.challenge.exception.GeneralException;
import org.springframework.http.HttpStatus;

public enum TransferenciaExceptionEnum {

    VALOR_INVALIDO              (new GeneralException("Operação não efetuada: um valor maior que zero deve ser transferido.", HttpStatus.BAD_REQUEST)),
    TRANSFERENCIA_CONTAS_IGUAIS (new GeneralException("Operação não efetuada: não é possível transferir recursos entre contas iguais.", HttpStatus.BAD_REQUEST)),
    TRANSFERENCIA_JA_EXECUTADA  (new GeneralException("Operação não efetuada: a transferência já foi executada anteriormente.", HttpStatus.BAD_REQUEST)),
    ERRO_INTERNO_TRANSFERENCIA  (new GeneralException("Erro interno: a transferência não pôde ser efetuada. Contate o suporte.", HttpStatus.BAD_REQUEST));

    private final GeneralException exception;

    TransferenciaExceptionEnum(GeneralException exception) {
        this.exception = exception;
    }

    public GeneralException getException() {
        return exception;
    }
}
