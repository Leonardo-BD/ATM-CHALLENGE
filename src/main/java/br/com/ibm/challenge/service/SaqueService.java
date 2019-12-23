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
import br.com.ibm.challenge.service.utils.SaqueUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaqueService implements ISaqueService {

    @Autowired
    private SaqueRepository saqueRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private TerminalAtmRepository terminalAtmRepository;

    public Saque sacarContaCorrenteViaAtm(short versaoApi, Saque saque, double valorSaqueDouble) {
        SaqueRules.versaoApiSacarContaCorrenteViaAtmValida(true, versaoApi);
        SaqueRules.saqueNotNull(true, saque);
        BigDecimal valorSaque = BigDecimal.valueOf(valorSaqueDouble);

        TerminalAtm terminalAtm = terminalAtmRepository.findById(saque.getIdTerminalAtm()).orElse(null);
        ContaCorrente contaCorrente = contaCorrenteRepository.findById(saque.getIdContaCorrente()).orElse(null);

        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrente);
        TerminalAtmRules.terminalAtmNotNull(true, terminalAtm);

        saque = SaqueUtils.montarNovoSaque(terminalAtm, contaCorrente, valorSaque);

        Saque ultimoSaque = saqueRepository.findTopByOrderByIdDesc().orElse(null);

        if (ultimoSaque != null) {
            saque.setId(ultimoSaque.getId() + 1);
        } else {
            saque.setId(1);
        }

        saqueRepository.save(saque);

        return saque;
    }
}
