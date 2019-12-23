package br.com.ibm.challenge.domain.builder;

import br.com.ibm.challenge.domain.Transferencia;

import java.math.BigDecimal;

public class TransferenciaBuilder {

    private Transferencia transferencia;

    public TransferenciaBuilder(long idContaCorrenteOrigem, long idContaCorrenteDestino, double valor) {
        transferencia = new Transferencia();

        transferencia.setIdContaCorrenteOrigem(idContaCorrenteOrigem);
        transferencia.setIdContaCorrenteDestino(idContaCorrenteDestino);
        transferencia.setValor(BigDecimal.valueOf(valor));
    }

    public TransferenciaBuilder setId(long id) {
        transferencia.setId(id);

        return this;
    }

    public TransferenciaBuilder setDataOperacao(long dataOperacao) {
        transferencia.setDataOperacao(dataOperacao);

        return this;
    }

    public Transferencia build() {
        return transferencia;
    }
}
