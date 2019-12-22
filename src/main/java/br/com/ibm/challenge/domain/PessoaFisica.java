package br.com.ibm.challenge.domain;

import org.springframework.data.annotation.Id;

public class PessoaFisica {

    @Id
    private long id;

    private String nome;
    private String rg;
    private String cpf;
    private long dataNascimento;
    private Long idResponsavelLegal;

    public PessoaFisica() {
    }

    public PessoaFisica(long id, String nome, String rg, String cpf, long dataNascimento, Long idResponsavelLegal) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idResponsavelLegal = idResponsavelLegal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(long dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getIdResponsavelLegal() {
        return idResponsavelLegal;
    }

    public void setIdResponsavelLegal(Long idResponsavelLegal) {
        this.idResponsavelLegal = idResponsavelLegal;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", idResponsavelLegal=" + idResponsavelLegal +
                '}';
    }
}
