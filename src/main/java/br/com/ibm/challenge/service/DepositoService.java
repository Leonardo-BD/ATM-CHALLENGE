package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Deposito;
import br.com.ibm.challenge.repository.ContaCorrenteRepository;
import br.com.ibm.challenge.repository.DepositoRepository;
import br.com.ibm.challenge.service.interfaces.IDepositoService;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.DepositoRules;
import br.com.ibm.challenge.service.utils.DepositoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Service
public class DepositoService implements IDepositoService {

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    public Deposito efetuarDeposito(short versaoApi, Deposito deposito, double valorDeposito) {
        DepositoRules.versaoApiEfetuarDepositoValida(true, versaoApi);
        DepositoRules.depositoNotNull(true, deposito);
        DepositoRules.contaParaDepositoPreenchida(true, deposito);
        DepositoRules.tipoDepositoValido(true, deposito);
        DepositoRules.valorDepositoValido(true, BigDecimal.valueOf(valorDeposito));

        deposito.setValorDeposito(BigDecimal.valueOf(valorDeposito));

        ContaCorrente contaCorrente = contaCorrenteRepository.findById(deposito.getIdContaCorrenteDeposito()).orElse(null);//new ContaCorrenteBuilder(1, "0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(deposito.getIdContaCorrenteDeposito()).build();
        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrente);
        contaCorrente = DepositoUtils.depositarNaContaCorrente(deposito, contaCorrente);

        contaCorrenteRepository.save(contaCorrente);

        Deposito ultimoDeposito = depositoRepository.findTopByOrderByIdDesc().orElse(null);
        long lastId = ultimoDeposito != null ? ultimoDeposito.getId() : 0;

        deposito.setId(lastId+1);
        deposito.setDataOperacao(ZonedDateTime.now().toEpochSecond());
        deposito = depositoRepository.save(deposito);

        return deposito;
    }
}
