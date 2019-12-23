package br.com.ibm.challenge.service.utils;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Deposito;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.DepositoRules;

public class DepositoUtils {

    public static ContaCorrente depositarNaContaCorrente(Deposito deposito, ContaCorrente contaCorrente) {
        DepositoRules.depositoNotNull(true, deposito);
        DepositoRules.tipoDepositoValido(true, deposito);
        DepositoRules.valorDepositoValido(true, deposito.getValorDeposito());
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrente);

        contaCorrente.setSaldo(contaCorrente.getSaldo().add(deposito.getValorDeposito()));

        return contaCorrente;
    }
}
