package br.com.ibm.challenge.domain.builder;

import br.com.ibm.challenge.domain.TerminalAtm;

public class TerminalAtmBuilder {

    private TerminalAtm terminalAtm;

    public TerminalAtmBuilder(String localizacao, boolean ativo) {
        terminalAtm = new TerminalAtm();

        terminalAtm.setLocalizacao(localizacao);
        terminalAtm.setAtivo(ativo);

        terminalAtm.setCedulasReal_2(0);
        terminalAtm.setCedulasReal_5(0);
        terminalAtm.setCedulasReal_10(0);
        terminalAtm.setCedulasReal_20(0);
        terminalAtm.setCedulasReal_50(0);
        terminalAtm.setCedulasReal_100(0);
    }

    public TerminalAtmBuilder setId(long id) {
        terminalAtm.setId(id);
        return this;
    }

    public TerminalAtmBuilder setCedulasReal(int cedulasReal_2, int cedulasReal_5, int cedulasReal_10, int cedulasReal_20, int cedulasReal_50,int cedulasReal_100) {
        terminalAtm.setCedulasReal_2(cedulasReal_2);
        terminalAtm.setCedulasReal_5(cedulasReal_5);
        terminalAtm.setCedulasReal_10(cedulasReal_10);
        terminalAtm.setCedulasReal_20(cedulasReal_20);
        terminalAtm.setCedulasReal_50(cedulasReal_50);
        terminalAtm.setCedulasReal_100(cedulasReal_100);

        return this;
    }

    public TerminalAtm build() {
        return terminalAtm;
    }
}
