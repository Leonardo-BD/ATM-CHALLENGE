package br.com.ibm.challenge.domain.builder;

import br.com.ibm.challenge.domain.Contato;

public class ContatoBuilder {

    private Contato contato;

    public ContatoBuilder() {
        contato = new Contato();
    }

    public ContatoBuilder setId(long id) {
        contato.setId(id);

        return this;
    }

    public ContatoBuilder setIdPessoaFisica(long idPessoaFisica) {
        contato.setIdPessoaFisica(idPessoaFisica);

        return this;
    }

    public ContatoBuilder setIdContaCorrente(long idContaCorrente) {
        contato.setIdContaCorrente(idContaCorrente);

        return this;
    }

    public ContatoBuilder setEmail(String email) {
        contato.setEmail(email);

        return this;
    }

    public ContatoBuilder setTelefone(String telefone) {
        contato.setTelefone(telefone);

        return this;
    }

    public ContatoBuilder setCelular(String celular) {
        contato.setCelular(celular);

        return this;
    }

    public ContatoBuilder setReceberMarketingPorEmail(boolean podeReceber) {
        contato.setReceberMarketingPorEmail(podeReceber);

        return this;
    }

    public ContatoBuilder setReceberMarketingPorTelefone(boolean podeReceber) {
        contato.setReceberMarketingPorTelefone(podeReceber);

        return this;
    }

    public Contato build() {
        return contato;
    }
}
