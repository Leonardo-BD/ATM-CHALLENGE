package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Saque;
import br.com.ibm.challenge.domain.TerminalAtm;
import br.com.ibm.challenge.repository.ContaCorrenteRepository;
import br.com.ibm.challenge.repository.SaqueRepository;
import br.com.ibm.challenge.repository.TerminalAtmRepository;
import br.com.ibm.challenge.service.interfaces.ISaqueService;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.SaqueRules;
import br.com.ibm.challenge.service.rules.TerminalAtmRules;
import br.com.ibm.challenge.service.utils.ContaCorrenteUtils;
import br.com.ibm.challenge.service.utils.SaqueUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaqueService implements ISaqueService {

    @Autowired
    private SaqueRepository saqueRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private TerminalAtmRepository terminalAtmRepository;

    public Saque sacarContaCorrenteViaAtm(short versaoApi, Saque saque) {
        SaqueRules.versaoApiSacarContaCorrenteViaAtmValida(true, versaoApi);
        SaqueRules.saqueNotNull(true, saque);

        TerminalAtm terminalAtm = terminalAtmRepository.findById(saque.getIdTerminalAtm()).orElse(null);
        ContaCorrente contaCorrente = contaCorrenteRepository.findById(saque.getIdContaCorrente()).orElse(null);

        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrente);
        TerminalAtmRules.terminalAtmNotNull(true, terminalAtm);
        TerminalAtmRules.terminalAtivo(true, terminalAtm);

        saque = SaqueUtils.montarNovoSaque(terminalAtm, contaCorrente, saque.getValor());

        Saque ultimoSaque = saqueRepository.findTopByOrderByIdDesc().orElse(null);
        long lastId = ultimoSaque != null ? ultimoSaque.getId() : 0;

        saque.setId(lastId+1);
        saque = saqueRepository.save(saque);

        contaCorrente = ContaCorrenteUtils.debitarConta(contaCorrente, saque.getValor());
        contaCorrenteRepository.save(contaCorrente);

        return saque;
    }
}
