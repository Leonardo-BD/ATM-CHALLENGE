package br.com.ibm.challenge.domain;

import org.springframework.data.annotation.Id;

public class TerminalAtm {

    @Id
    private long id;

    private String localizacao;
    private boolean ativo;

    private int cedulasReal_2;
    private int cedulasReal_5;
    private int cedulasReal_10;
    private int cedulasReal_20;
    private int cedulasReal_50;
    private int cedulasReal_100;

    public TerminalAtm() {
    }

    public TerminalAtm(long id, String localizacao, boolean ativo, int cedulasReal_2, int cedulasReal_5, int cedulasReal_10, int cedulasReal_20, int cedulasReal_50, int cedulasReal_100) {
        this.id = id;
        this.localizacao = localizacao;
        this.ativo = ativo;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
        return "TerminalAtm{" +
                "id=" + id +
                ", localizacao='" + localizacao + '\'' +
                ", ativo=" + ativo +
                ", cedulasReal_2=" + cedulasReal_2 +
                ", cedulasReal_5=" + cedulasReal_5 +
                ", cedulasReal_10=" + cedulasReal_10 +
                ", cedulasReal_20=" + cedulasReal_20 +
                ", cedulasReal_50=" + cedulasReal_50 +
                ", cedulasReal_100=" + cedulasReal_100 +
                '}';
    }
}
