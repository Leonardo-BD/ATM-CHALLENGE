package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Saque;
import br.com.ibm.challenge.domain.TerminalAtm;
import br.com.ibm.challenge.domain.builder.ContaCorrenteBuilder;
import br.com.ibm.challenge.domain.builder.TerminalAtmBuilder;
import br.com.ibm.challenge.repository.SaqueRepository;
import br.com.ibm.challenge.service.interfaces.ISaqueService;
import br.com.ibm.challenge.service.rules.SaqueRules;
import br.com.ibm.challenge.service.utils.SaqueUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaqueService implements ISaqueService {

    @Autowired
    private SaqueRepository saqueRepository;

    public Saque sacarContaCorrenteViaAtm(short versaoApi, Saque saque, double valorSaqueDouble) {
        SaqueRules.versaoApiValida(true, versaoApi);
        SaqueRules.saqueNotNull(true, saque);

        BigDecimal valorSaque = BigDecimal.valueOf(valorSaqueDouble);
        TerminalAtm terminalAtm = new TerminalAtmBuilder("Rua B, 127 - Porto Alegre, RS", true).setCedulasReal(100, 100, 100, 100, 100, 100).setId(saque.getIdTerminalAtm()).build();
        ContaCorrente contaCorrente = new ContaCorrenteBuilder(1, "0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(saque.getIdContaCorrente()).build();

        return SaqueUtils.montarNovoSaque(terminalAtm, contaCorrente, valorSaque);
    }
}
