package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Deposito;
import br.com.ibm.challenge.domain.builder.ContaCorrenteBuilder;
import br.com.ibm.challenge.service.interfaces.IDepositoService;
import br.com.ibm.challenge.service.rules.DepositoRules;
import br.com.ibm.challenge.service.utils.DepositoUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Service
public class DepositoService implements IDepositoService {

    public Deposito efetuarDeposito(short versaoApi, Deposito deposito, double valorDeposito) {
        DepositoRules.versaoApiEfetuarDepositoValida(true, versaoApi);
        DepositoRules.depositoNotNull(true, deposito);
        DepositoRules.contaParaDepositoPreenchida(true, deposito);
        DepositoRules.tipoDepositoValido(true, deposito);
        DepositoRules.valorDepositoValido(true, BigDecimal.valueOf(valorDeposito));

        deposito.setValorDeposito(BigDecimal.valueOf(valorDeposito));

        ContaCorrente contaCorrente = new ContaCorrenteBuilder(1, "0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(deposito.getIdContaCorrenteDeposito()).build();
        contaCorrente = DepositoUtils.depositarNaContaCorrente(deposito, contaCorrente);

        deposito.setDataOperacao(ZonedDateTime.now().toEpochSecond());

        return deposito;
    }
}
