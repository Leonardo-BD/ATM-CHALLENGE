package br.com.ibm.challenge.service.utils;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Saque;
import br.com.ibm.challenge.domain.TerminalAtm;
import br.com.ibm.challenge.domain.builder.ContaCorrenteBuilder;
import br.com.ibm.challenge.domain.builder.SaqueBuilder;
import br.com.ibm.challenge.domain.builder.TerminalAtmBuilder;
import br.com.ibm.challenge.service.rules.SaqueRules;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TSaqueUtilsTests {

    @Test
    public void montarNovoSaqueTest_200() {
        Saque saque = new SaqueBuilder(1, 1, BigDecimal.ZERO).build();
        TerminalAtm terminalAtm = new TerminalAtmBuilder("Rua B, 127 - Porto Alegre, RS", true).setCedulasReal(100, 100, 100, 100, 100, 100).setId(saque.getIdTerminalAtm()).build();
        ContaCorrente contaCorrente = new ContaCorrenteBuilder("0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(saque.getIdContaCorrente()).build();

        saque = SaqueUtils.montarNovoSaque(terminalAtm, contaCorrente, BigDecimal.valueOf(200));

        Assert.assertEquals("Erro na montagem do saque.", 2, saque.getCedulasReal_100());
        Assert.assertTrue("O valor do saque não corresponde ao das cédulas.", SaqueRules.valorSaqueCorrespondeComAsCedulas(true, saque));
    }

    @Test
    public void montarNovoSaqueTest_240() {
        Saque saque = new SaqueBuilder(1, 1, BigDecimal.ZERO).build();
        TerminalAtm terminalAtm = new TerminalAtmBuilder("Rua B, 127 - Porto Alegre, RS", true).setCedulasReal(100, 100, 100, 100, 100, 100).setId(saque.getIdTerminalAtm()).build();
        ContaCorrente contaCorrente = new ContaCorrenteBuilder("0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(saque.getIdContaCorrente()).build();

        saque = SaqueUtils.montarNovoSaque(terminalAtm, contaCorrente, BigDecimal.valueOf(240));

        Assert.assertEquals("Erro na montagem do saque.", 2, saque.getCedulasReal_100());
        Assert.assertEquals("Erro na montagem do saque.", 2, saque.getCedulasReal_20());
        Assert.assertTrue("O valor do saque não corresponde ao das cédulas.", SaqueRules.valorSaqueCorrespondeComAsCedulas(true, saque));
    }

    @Test
    public void montarNovoSaqueTest_255() {
        Saque saque = new SaqueBuilder(1, 1, BigDecimal.ZERO).build();
        TerminalAtm terminalAtm = new TerminalAtmBuilder("Rua B, 127 - Porto Alegre, RS", true).setCedulasReal(100, 100, 100, 100, 100, 100).setId(saque.getIdTerminalAtm()).build();
        ContaCorrente contaCorrente = new ContaCorrenteBuilder("0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(saque.getIdContaCorrente()).build();

        saque = SaqueUtils.montarNovoSaque(terminalAtm, contaCorrente, BigDecimal.valueOf(255));

        Assert.assertEquals("Erro na montagem do saque.", 2, saque.getCedulasReal_100());
        Assert.assertEquals("Erro na montagem do saque.", 1, saque.getCedulasReal_50());
        Assert.assertEquals("Erro na montagem do saque.", 1, saque.getCedulasReal_5());
        Assert.assertTrue("O valor do saque não corresponde ao das cédulas.", SaqueRules.valorSaqueCorrespondeComAsCedulas(true, saque));
    }

    @Test
    public void montarNovoSaqueTest_257() {
        Saque saque = new SaqueBuilder(1, 1, BigDecimal.ZERO).build();
        TerminalAtm terminalAtm = new TerminalAtmBuilder("Rua B, 127 - Porto Alegre, RS", true).setCedulasReal(100, 100, 100, 100, 100, 100).setId(saque.getIdTerminalAtm()).build();
        ContaCorrente contaCorrente = new ContaCorrenteBuilder("0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(saque.getIdContaCorrente()).build();

        saque = SaqueUtils.montarNovoSaque(terminalAtm, contaCorrente, BigDecimal.valueOf(257));

        Assert.assertEquals("Erro na montagem do saque.", 2, saque.getCedulasReal_100());
        Assert.assertEquals("Erro na montagem do saque.", 1, saque.getCedulasReal_50());
        Assert.assertEquals("Erro na montagem do saque.", 1, saque.getCedulasReal_5());
        Assert.assertEquals("Erro na montagem do saque.", 1, saque.getCedulasReal_2());
        Assert.assertTrue("O valor do saque não corresponde ao das cédulas.", SaqueRules.valorSaqueCorrespondeComAsCedulas(true, saque));
    }

    @Test
    public void montarNovoSaqueTest_261() {
        Saque saque = new SaqueBuilder(1, 1, BigDecimal.ZERO).build();
        TerminalAtm terminalAtm = new TerminalAtmBuilder("Rua B, 127 - Porto Alegre, RS", true).setCedulasReal(100, 100, 100, 100, 100, 100).setId(saque.getIdTerminalAtm()).build();
        ContaCorrente contaCorrente = new ContaCorrenteBuilder("0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(saque.getIdContaCorrente()).build();

        saque = SaqueUtils.montarNovoSaque(terminalAtm, contaCorrente, BigDecimal.valueOf(261));

        Assert.assertEquals("Erro na nota de 100.", 2, saque.getCedulasReal_100());
        Assert.assertEquals("Erro na nota de 50.", 1, saque.getCedulasReal_50());
        Assert.assertEquals("Erro na nota de 5.", 1, saque.getCedulasReal_5());
        Assert.assertEquals("Erro na nota de 2.", 3, saque.getCedulasReal_2());
        Assert.assertTrue("O valor do saque não corresponde ao das cédulas.", SaqueRules.valorSaqueCorrespondeComAsCedulas(true, saque));
    }
}
