package br.com.ibm.challenge.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class ContaCorrente {

    @Id
    private long id;

    private long idPessoaTitular;
    private String agencia;
    private String conta;
    private long dataAbertura;
    private boolean ativo;
    private BigDecimal saldo;

    public ContaCorrente() {
    }

    public ContaCorrente(long id, long idPessoaTitular, String agencia, String conta, long dataAbertura, boolean ativo, BigDecimal saldo) {
        this.id = id;
        this.idPessoaTitular = idPessoaTitular;
        this.agencia = agencia;
        this.conta = conta;
        this.dataAbertura = dataAbertura;
        this.ativo = ativo;
        this.saldo = saldo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPessoaTitular() {
        return idPessoaTitular;
    }

    public void setIdPessoaTitular(long idPessoaTitular) {
        this.idPessoaTitular = idPessoaTitular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public long getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(long dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "id=" + id +
                ", idPessoaTitular=" + idPessoaTitular +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", dataAbertura=" + dataAbertura +
                ", ativo=" + ativo +
                ", saldo=" + saldo +
                '}';
    }
}
