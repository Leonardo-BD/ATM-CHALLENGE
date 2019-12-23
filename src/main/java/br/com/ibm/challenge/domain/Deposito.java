package br.com.ibm.challenge.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Deposito {

    @Id
    private long id;

    private long idContaCorrenteDeposito;
    private long idTipoDeposito;
    private BigDecimal valorDeposito;

    private long dataOperacao;

    public Deposito() {
    }

    public Deposito(long id, long idContaCorrenteDeposito, long idTipoDeposito, BigDecimal valorDeposito, long dataOperacao) {
        this.id = id;
        this.idContaCorrenteDeposito = idContaCorrenteDeposito;
        this.idTipoDeposito = idTipoDeposito;
        this.valorDeposito = valorDeposito;
        this.dataOperacao = dataOperacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdContaCorrenteDeposito() {
        return idContaCorrenteDeposito;
    }

    public void setIdContaCorrenteDeposito(long idContaCorrenteDeposito) {
        this.idContaCorrenteDeposito = idContaCorrenteDeposito;
    }

    public long getIdTipoDeposito() {
        return idTipoDeposito;
    }

    public void setIdTipoDeposito(long idTipoDeposito) {
        this.idTipoDeposito = idTipoDeposito;
    }

    public BigDecimal getValorDeposito() {
        return valorDeposito;
    }

    public void setValorDeposito(BigDecimal valorDeposito) {
        this.valorDeposito = valorDeposito;
    }

    public long getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(long dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "id=" + id +
                ", idContaCorrenteDeposito=" + idContaCorrenteDeposito +
                ", idTipoDeposito=" + idTipoDeposito +
                ", valorDeposito=" + valorDeposito +
                ", dataOperacao=" + dataOperacao +
                '}';
    }
}
