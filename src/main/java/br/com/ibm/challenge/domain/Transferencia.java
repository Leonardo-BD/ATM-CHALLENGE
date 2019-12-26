package br.com.ibm.challenge.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@ApiModel
public class Transferencia {

    @Id
    @ApiModelProperty(hidden = true)
    private long id;

    private long idContaCorrenteOrigem;
    private long idContaCorrenteDestino;
    private BigDecimal valor;

    @ApiModelProperty(hidden = true)
    private long dataOperacao;

    @ApiModelProperty(hidden = true)
    private long dataAgendamento;

    @ApiModelProperty(hidden = true)
    private boolean executada;

    @ApiModelProperty(hidden = true)
    private boolean cancelada;

    public Transferencia() {
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

    public long getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(long dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public boolean isExecutada() {
        return executada;
    }

    public void setExecutada(boolean executada) {
        this.executada = executada;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", idContaCorrenteOrigem=" + idContaCorrenteOrigem +
                ", idContaCorrenteDestino=" + idContaCorrenteDestino +
                ", valor=" + valor +
                ", dataOperacao=" + dataOperacao +
                ", dataAgendamento=" + dataAgendamento +
                ", executada=" + executada +
                ", cancelada=" + cancelada +
                '}';
    }
}
