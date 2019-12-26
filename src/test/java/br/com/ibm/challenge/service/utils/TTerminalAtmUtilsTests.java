package br.com.ibm.challenge.service.utils;

import br.com.ibm.challenge.domain.Saque;
import br.com.ibm.challenge.domain.TerminalAtm;
import br.com.ibm.challenge.domain.builder.SaqueBuilder;
import br.com.ibm.challenge.domain.builder.TerminalAtmBuilder;
import br.com.ibm.challenge.exception.GeneralException;
import br.com.ibm.challenge.exception.enumerator.SaqueExceptionEnum;
import br.com.ibm.challenge.exception.enumerator.TerminalAtmExceptionEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class TTerminalAtmUtilsTests {

    private TerminalAtm terminalAtm;

    private Saque saque;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void initObjects() {
        terminalAtm = new TerminalAtmBuilder("Rua B, 127 - Porto Alegre, RS", true).setCedulasReal(100, 100, 100, 100, 100, 100).setId(1).build();
        saque = new SaqueBuilder(1, 1, BigDecimal.valueOf(1000)).build();
    }

    @Test
    public void getCedulasParaSaqueTest() {
        saque.setValor(BigDecimal.valueOf(293));
        saque = TerminalAtmUtils.getCedulasParaSaque(terminalAtm, saque);

        Assert.assertEquals("Número de cédulas de 100 está incorreto.", 98, terminalAtm.getCedulasReal_100());
        Assert.assertEquals("Número de cédulas de 50 está incorreto.", 99, terminalAtm.getCedulasReal_50());
        Assert.assertEquals("Número de cédulas de 20 está incorreto.", 99, terminalAtm.getCedulasReal_20());
        Assert.assertEquals("Número de cédulas de 10 está incorreto.", 99, terminalAtm.getCedulasReal_10());
        Assert.assertEquals("Número de cédulas de 5 está incorreto.", 99, terminalAtm.getCedulasReal_5());
        Assert.assertEquals("Número de cédulas de 2 está incorreto.", 96, terminalAtm.getCedulasReal_2());
    }

    @Test
    public void getCedulasParaSaqueNullTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(TerminalAtmExceptionEnum.TERMINALL_NULL.getException().getMessage());

        terminalAtm = null;
        TerminalAtmUtils.getCedulasParaSaque(terminalAtm, saque);
    }

    @Test
    public void getCedulasParaSaqueTerminalInativoTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(TerminalAtmExceptionEnum.TERMINAL_INATIVO.getException().getMessage());

        terminalAtm.setAtivo(false);
        TerminalAtmUtils.getCedulasParaSaque(terminalAtm, saque);
    }

    @Test
    public void getCedulasParaSaqueTerminalSemCedulasTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(TerminalAtmExceptionEnum.TERMINAL_SEM_CEDULAS.getException().getMessage());

        terminalAtm.setCedulasReal_100(0);
        terminalAtm.setCedulasReal_50(0);
        terminalAtm.setCedulasReal_20(0);
        terminalAtm.setCedulasReal_10(0);
        terminalAtm.setCedulasReal_5(0);
        terminalAtm.setCedulasReal_2(0);

        TerminalAtmUtils.getCedulasParaSaque(terminalAtm, saque);
    }

    @Test
    public void getCedulasParaSaqueValorInsuficienteTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(TerminalAtmExceptionEnum.VALOR_INSUFICIENTE_SAQUE.getException().getMessage());

        saque.setValor(BigDecimal.valueOf(1000));

        terminalAtm.setCedulasReal_100(9);
        terminalAtm.setCedulasReal_50(1);
        terminalAtm.setCedulasReal_20(2);
        terminalAtm.setCedulasReal_10(0);
        terminalAtm.setCedulasReal_5(1);
        terminalAtm.setCedulasReal_2(2);

        TerminalAtmUtils.getCedulasParaSaque(terminalAtm, saque);
    }

    @Test
    public void getCedulasParaSaqueValorInvalidoTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(SaqueExceptionEnum.SAQUE_ABAIXO_DO_MINIMO.getException().getMessage());

        saque.setValor(BigDecimal.valueOf(4.99));
        TerminalAtmUtils.getCedulasParaSaque(terminalAtm, saque);
    }
}
