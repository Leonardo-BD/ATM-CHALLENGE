package br.com.ibm.challenge.domain;

import org.springframework.data.annotation.Id;

public class Contato {

    @Id
    private long id;

    private long idPessoaFisica;
    private long idContaCorrente;
    private String email;
    private String telefone;
    private String celular;
    private boolean receberMarketingPorEmail;
    private boolean receberMarketingPorTelefone;

    public Contato() {
    }

    public Contato(long id, long idPessoaFisica, long idContaCorrente, String email, String telefone, String celular, boolean receberMarketingPorEmail, boolean receberMarketingPorTelefone) {
        this.id = id;
        this.idPessoaFisica = idPessoaFisica;
        this.idContaCorrente = idContaCorrente;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.receberMarketingPorEmail = receberMarketingPorEmail;
        this.receberMarketingPorTelefone = receberMarketingPorTelefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(long idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

    public long getIdContaCorrente() {
        return idContaCorrente;
    }

    public void setIdContaCorrente(long idContaCorrente) {
        this.idContaCorrente = idContaCorrente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isReceberMarketingPorEmail() {
        return receberMarketingPorEmail;
    }

    public void setReceberMarketingPorEmail(boolean receberMarketingPorEmail) {
        this.receberMarketingPorEmail = receberMarketingPorEmail;
    }

    public boolean isReceberMarketingPorTelefone() {
        return receberMarketingPorTelefone;
    }

    public void setReceberMarketingPorTelefone(boolean receberMarketingPorTelefone) {
        this.receberMarketingPorTelefone = receberMarketingPorTelefone;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", idPessoaFisica=" + idPessoaFisica +
                ", idContaCorrente='" + idContaCorrente + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", receberMarketingPorEmail=" + receberMarketingPorEmail +
                ", receberMarketingPorTelefone=" + receberMarketingPorTelefone +
                '}';
    }
}
