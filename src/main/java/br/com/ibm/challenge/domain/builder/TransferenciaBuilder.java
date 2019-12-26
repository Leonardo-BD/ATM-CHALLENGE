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
        transferencia.setExecutada(false);
        transferencia.setCancelada(false);
    }

    public TransferenciaBuilder setId(long id) {
        transferencia.setId(id);

        return this;
    }

    public TransferenciaBuilder setDataOperacao(long dataOperacao) {
        transferencia.setDataOperacao(dataOperacao);

        return this;
    }

    public TransferenciaBuilder setDataAgendamento(long dataAgendamento) {
        transferencia.setDataAgendamento(dataAgendamento);

        return this;
    }

    public TransferenciaBuilder setExecutada(boolean executada) {
        transferencia.setExecutada(executada);

        return this;
    }

    public TransferenciaBuilder setCancelada(boolean cancelada) {
        transferencia.setCancelada(cancelada);

        return this;
    }

    public Transferencia build() {
        return transferencia;
    }
}
