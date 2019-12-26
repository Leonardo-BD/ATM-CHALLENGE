package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Deposito;
import br.com.ibm.challenge.repository.ContaCorrenteRepository;
import br.com.ibm.challenge.repository.DepositoRepository;
import br.com.ibm.challenge.service.interfaces.IDepositoService;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.DepositoRules;
import br.com.ibm.challenge.service.utils.ContaCorrenteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class DepositoService implements IDepositoService {

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    public Deposito efetuarDeposito(short versaoApi, Deposito deposito) {
        DepositoRules.versaoApiEfetuarDepositoValida(true, versaoApi);
        DepositoRules.depositoNotNull(true, deposito);
        DepositoRules.contaParaDepositoPreenchida(true, deposito);
        DepositoRules.tipoDepositoValido(true, deposito);
        DepositoRules.valorDepositoValido(true, deposito.getValorDeposito());

        ContaCorrente contaCorrente = contaCorrenteRepository.findById(deposito.getIdContaCorrenteDeposito()).orElse(null);
        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrente);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrente);
        contaCorrente = ContaCorrenteUtils.creditarNaConta(contaCorrente, deposito.getValorDeposito());

        contaCorrenteRepository.save(contaCorrente);

        Deposito ultimoDeposito = depositoRepository.findTopByOrderByIdDesc().orElse(null);
        long lastId = ultimoDeposito != null ? ultimoDeposito.getId() : 0;

        deposito.setId(lastId+1);
        deposito.setDataOperacao(ZonedDateTime.now().toEpochSecond());
        deposito = depositoRepository.save(deposito);

        return deposito;
    }
}
