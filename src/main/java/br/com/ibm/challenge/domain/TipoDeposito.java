package br.com.ibm.challenge.domain;

import org.springframework.data.annotation.Id;

public class TipoDeposito {

    @Id
    private long id;

    private String descricao;

    public TipoDeposito() {
    }

    public TipoDeposito(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoDeposito{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
