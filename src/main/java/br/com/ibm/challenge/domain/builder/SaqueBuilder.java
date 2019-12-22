package br.com.ibm.challenge.domain.builder;

import br.com.ibm.challenge.domain.Saque;

import java.math.BigDecimal;

public class SaqueBuilder {

    private Saque saque;

    public SaqueBuilder(long idContaCorrente, long idTerminalAtm, BigDecimal valor) {
        saque = new Saque();

        saque.setIdContaCorrente(idContaCorrente);
        saque.setIdTerminalAtm(idTerminalAtm);
        saque.setValor(valor);

        saque.setCedulasReal_2(0);
        saque.setCedulasReal_5(0);
        saque.setCedulasReal_10(0);
        saque.setCedulasReal_20(0);
        saque.setCedulasReal_50(0);
        saque.setCedulasReal_100(0);
    }

    public SaqueBuilder setId(long id) {
        saque.setId(id);

        return this;
    }

    public SaqueBuilder setCedulasReal(int cedulasReal_2, int cedulasReal_5, int cedulasReal_10, int cedulasReal_20, int cedulasReal_50, int cedulasReal_100) {
        saque.setCedulasReal_2(cedulasReal_2);
        saque.setCedulasReal_5(cedulasReal_5);
        saque.setCedulasReal_10(cedulasReal_10);
        saque.setCedulasReal_20(cedulasReal_20);
        saque.setCedulasReal_50(cedulasReal_50);
        saque.setCedulasReal_100(cedulasReal_100);

        return this;
    }

    public Saque build() {
        return saque;
    }
}
