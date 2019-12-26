package br.com.ibm.challenge.service.utils;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;

import java.math.BigDecimal;

public class ContaCorrenteUtils {

    public static ContaCorrente debitarConta(ContaCorrente contaCorrente, BigDecimal valor) {
        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrente);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrente);
        ContaCorrenteRules.saldoSuficienteDebito(true, contaCorrente, valor);

        contaCorrente.setSaldo(contaCorrente.getSaldo().subtract(valor));

        return contaCorrente;
    }

    public static ContaCorrente creditarNaConta(ContaCorrente contaCorrente, BigDecimal valor) {
        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrente);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrente);

        contaCorrente.setSaldo(contaCorrente.getSaldo().add(valor));

        return contaCorrente;
    }
}
