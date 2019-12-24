package br.com.ibm.challenge.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@ApiModel
public class Saque {

    @Id
    @ApiModelProperty(hidden = true)
    private long id;

    private long idContaCorrente;
    private long idTerminalAtm;
    private BigDecimal valor;

    @ApiModelProperty(hidden = true)
    private int cedulasReal_2;

    @ApiModelProperty(hidden = true)
    private int cedulasReal_5;

    @ApiModelProperty(hidden = true)
    private int cedulasReal_10;

    @ApiModelProperty(hidden = true)
    private int cedulasReal_20;

    @ApiModelProperty(hidden = true)
    private int cedulasReal_50;

    @ApiModelProperty(hidden = true)
    private int cedulasReal_100;

    public Saque() {
    }

    public Saque(long id, long idContaCorrente, long idTerminalAtm, BigDecimal valor, int cedulasReal_2, int cedulasReal_5, int cedulasReal_10, int cedulasReal_20, int cedulasReal_50, int cedulasReal_100) {
        this.id = id;
        this.idContaCorrente = idContaCorrente;
        this.idTerminalAtm = idTerminalAtm;
        this.valor = valor;
        this.cedulasReal_2 = cedulasReal_2;
        this.cedulasReal_5 = cedulasReal_5;
        this.cedulasReal_10 = cedulasReal_10;
        this.cedulasReal_20 = cedulasReal_20;
        this.cedulasReal_50 = cedulasReal_50;
        this.cedulasReal_100 = cedulasReal_100;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdContaCorrente() {
        return idContaCorrente;
    }

    public void setIdContaCorrente(long idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public long getIdTerminalAtm() {
        return idTerminalAtm;
    }

    public void setIdTerminalAtm(long idTerminalAtm) {
        this.idTerminalAtm = idTerminalAtm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getCedulasReal_2() {
        return cedulasReal_2;
    }

    public void setCedulasReal_2(int cedulasReal_2) {
        this.cedulasReal_2 = cedulasReal_2;
    }

    public int getCedulasReal_5() {
        return cedulasReal_5;
    }

    public void setCedulasReal_5(int cedulasReal_5) {
        this.cedulasReal_5 = cedulasReal_5;
    }

    public int getCedulasReal_10() {
        return cedulasReal_10;
    }

    public void setCedulasReal_10(int cedulasReal_10) {
        this.cedulasReal_10 = cedulasReal_10;
    }

    public int getCedulasReal_20() {
        return cedulasReal_20;
    }

    public void setCedulasReal_20(int cedulasReal_20) {
        this.cedulasReal_20 = cedulasReal_20;
    }

    public int getCedulasReal_50() {
        return cedulasReal_50;
    }

    public void setCedulasReal_50(int cedulasReal_50) {
        this.cedulasReal_50 = cedulasReal_50;
    }

    public int getCedulasReal_100() {
        return cedulasReal_100;
    }

    public void setCedulasReal_100(int cedulasReal_100) {
        this.cedulasReal_100 = cedulasReal_100;
    }

    @Override
    public String toString() {
        return "Saque{" +
                "id=" + id +
                ", idContaCorrente=" + idContaCorrente +
                ", idTerminalAtm=" + idTerminalAtm +
                ", valor=" + valor +
                ", cedulasReal_2=" + cedulasReal_2 +
                ", cedulasReal_5=" + cedulasReal_5 +
                ", cedulasReal_10=" + cedulasReal_10 +
                ", cedulasReal_20=" + cedulasReal_20 +
                ", cedulasReal_50=" + cedulasReal_50 +
                ", cedulasReal_100=" + cedulasReal_100 +
                '}';
    }
}
