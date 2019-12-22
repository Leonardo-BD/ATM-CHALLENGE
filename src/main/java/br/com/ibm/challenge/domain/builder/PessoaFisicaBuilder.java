package br.com.ibm.challenge.domain.builder;

import br.com.ibm.challenge.domain.PessoaFisica;

public class PessoaFisicaBuilder {

    private PessoaFisica pessoaFisica;

    public PessoaFisicaBuilder(String nome, String rg, String cpf, long dataNascimento) {
        pessoaFisica = new PessoaFisica();

        pessoaFisica.setNome(nome);
        pessoaFisica.setRg(rg);
        pessoaFisica.setCpf(cpf);
        pessoaFisica.setDataNascimento(dataNascimento);
    }

    public PessoaFisicaBuilder setId(long id) {
        pessoaFisica.setId(id);

        return this;
    }

    public PessoaFisicaBuilder setResponsavelLegal(Long idResponsavelLegal) {
        pessoaFisica.setIdResponsavelLegal(idResponsavelLegal);

        return this;
    }

    public PessoaFisica build() {
        return pessoaFisica;
    }
}
