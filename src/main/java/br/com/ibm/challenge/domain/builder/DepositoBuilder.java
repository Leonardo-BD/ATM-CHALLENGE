package br.com.ibm.challenge.domain.builder;

import br.com.ibm.challenge.domain.Deposito;

import java.math.BigDecimal;

public class DepositoBuilder {

    private Deposito deposito;

    public DepositoBuilder(long idContaCorrenteDeposito, long idTipoDeposito, double valorDeposito) {
        deposito = new Deposito();

        deposito.setIdContaCorrenteDeposito(idContaCorrenteDeposito);
        deposito.setIdTipoDeposito(idTipoDeposito);
        deposito.setValorDeposito(BigDecimal.valueOf(valorDeposito));
    }

    public DepositoBuilder setId(long id) {
        deposito.setId(id);

        return this;
    }

    public DepositoBuilder setDataOperacao(long dataOperacao) {
        deposito.setDataOperacao(dataOperacao);

        return this;
    }

    public Deposito build() {
        return deposito;
    }
}
