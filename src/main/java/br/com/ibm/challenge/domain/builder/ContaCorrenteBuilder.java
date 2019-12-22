package br.com.ibm.challenge.domain.builder;

import br.com.ibm.challenge.domain.ContaCorrente;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class ContaCorrenteBuilder {

    private ContaCorrente contaCorrente;

    public ContaCorrenteBuilder(long idPessoaTitular, String agencia, String conta, boolean ativo) {
        contaCorrente = new ContaCorrente();
        contaCorrente.setIdPessoaTitular(idPessoaTitular);
        contaCorrente.setAgencia(agencia);
        contaCorrente.setConta(conta);
        contaCorrente.setAtivo(ativo);
        contaCorrente.setDataAbertura(ZonedDateTime.now().toEpochSecond());
        contaCorrente.setSaldo(BigDecimal.valueOf(0));
    }

    public ContaCorrenteBuilder setId(long id) {
        contaCorrente.setId(id);

        return this;
    }

    public ContaCorrenteBuilder setSaldo(BigDecimal saldo) {
        contaCorrente.setSaldo(saldo);

        return this;
    }

    public ContaCorrente build() {
        return contaCorrente;
    }
}
