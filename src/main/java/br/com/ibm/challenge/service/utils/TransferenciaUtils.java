package br.com.ibm.challenge.service.utils;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Transferencia;

public class TransferenciaUtils {

    public static ContaCorrente debitarCorrentista(Transferencia transferencia, ContaCorrente contaCorrenteOrigem) {
        contaCorrenteOrigem.setSaldo(contaCorrenteOrigem.getSaldo().subtract(transferencia.getValor()));

        return contaCorrenteOrigem;
    }

    public static ContaCorrente creditarCorrentista(Transferencia transferencia, ContaCorrente contaCorrenteDestino) {
        contaCorrenteDestino.setSaldo(contaCorrenteDestino.getSaldo().add(transferencia.getValor()));

        return contaCorrenteDestino;
    }
}
