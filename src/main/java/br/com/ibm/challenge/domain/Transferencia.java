package br.com.ibm.challenge.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Transferencia {

    @Id
    private long id;

    private long idContaCorrenteOrigem;
    private long idContaCorrenteDestino;
    private BigDecimal valor;

    private long dataOperacao;

    public Transferencia() {
    }

    public Transferencia(long id, long idContaCorrenteOrigem, long idContaCorrenteDestino, BigDecimal valor, long dataOperacao) {
        this.id = id;
        this.idContaCorrenteOrigem = idContaCorrenteOrigem;
        this.idContaCorrenteDestino = idContaCorrenteDestino;
        this.valor = valor;
        this.dataOperacao = dataOperacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdContaCorrenteOrigem() {
        return idContaCorrenteOrigem;
    }

    public void setIdContaCorrenteOrigem(long idContaCorrenteOrigem) {
        this.idContaCorrenteOrigem = idContaCorrenteOrigem;
    }

    public long getIdContaCorrenteDestino() {
        return idContaCorrenteDestino;
    }

    public void setIdContaCorrenteDestino(long idContaCorrenteDestino) {
        this.idContaCorrenteDestino = idContaCorrenteDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public long getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(long dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", idContaCorrenteOrigem=" + idContaCorrenteOrigem +
                ", idContaCorrenteDestino=" + idContaCorrenteDestino +
                ", valor=" + valor +
                ", dataOperacao=" + dataOperacao +
                '}';
    }
}
