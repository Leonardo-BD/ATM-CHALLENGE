package br.com.ibm.challenge.service.utils;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.builder.ContaCorrenteBuilder;
import br.com.ibm.challenge.exception.GeneralException;
import br.com.ibm.challenge.exception.enumerator.ContaCorrenteExceptionEnum;
import br.com.ibm.challenge.exception.enumerator.GenericExceptionEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class TContaCorrenteUtilsTests {

    private ContaCorrente contaCorrente;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void initObjects() {
        contaCorrente = new ContaCorrenteBuilder(1, "0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(1).build();
    }

    @Test
    public void debitarContaTest() {
        contaCorrente = ContaCorrenteUtils.debitarConta(contaCorrente, BigDecimal.valueOf(1000));

        Assert.assertEquals("Valor debitado está incorreto.", BigDecimal.valueOf(9000), contaCorrente.getSaldo());
    }

    @Test
    public void debitarContaNullTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(GenericExceptionEnum.ERRO_PREENCHIMENTO.getException().getMessage());

        contaCorrente = null;
        contaCorrente = ContaCorrenteUtils.debitarConta(contaCorrente, BigDecimal.valueOf(1000));
    }

    @Test
    public void debitarContaInativaTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(ContaCorrenteExceptionEnum.CONTA_INATIVA.getException().getMessage());

        contaCorrente.setAtivo(false);
        contaCorrente = ContaCorrenteUtils.debitarConta(contaCorrente, BigDecimal.valueOf(1000));
    }

    @Test
    public void debitarContaSaldoInsuficienteTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(ContaCorrenteExceptionEnum.SALDO_INSUFICIENTE_PARA_DEBITO.getException().getMessage());

        contaCorrente.setSaldo(BigDecimal.valueOf(500));
        contaCorrente = ContaCorrenteUtils.debitarConta(contaCorrente, BigDecimal.valueOf(1000));
    }

    @Test
    public void creditarContaTest() {
        contaCorrente = ContaCorrenteUtils.creditarNaConta(contaCorrente, BigDecimal.valueOf(1000));

        Assert.assertEquals("Valor creditado está incorreto.", BigDecimal.valueOf(11000), contaCorrente.getSaldo());
    }

    @Test
    public void creditarContaNullTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(GenericExceptionEnum.ERRO_PREENCHIMENTO.getException().getMessage());

        contaCorrente = null;
        contaCorrente = ContaCorrenteUtils.creditarNaConta(contaCorrente, BigDecimal.valueOf(1000));
    }

    @Test
    public void creditarContaInativaTest() {
        expectedException.expect(GeneralException.class);
        expectedException.expectMessage(ContaCorrenteExceptionEnum.CONTA_INATIVA.getException().getMessage());

        contaCorrente.setAtivo(false);
        contaCorrente = ContaCorrenteUtils.creditarNaConta(contaCorrente, BigDecimal.valueOf(1000));
    }
}
