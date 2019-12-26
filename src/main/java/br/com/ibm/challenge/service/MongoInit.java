package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.TerminalAtm;
import br.com.ibm.challenge.domain.builder.ContaCorrenteBuilder;
import br.com.ibm.challenge.domain.builder.TerminalAtmBuilder;
import br.com.ibm.challenge.repository.ContaCorrenteRepository;
import br.com.ibm.challenge.repository.TerminalAtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class MongoInit {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private TerminalAtmRepository terminalAtmRepository;

    @PostConstruct
    public void init() {
        salvarContas();
        salvarTerminais();
    }

    private void salvarContas() {
        ContaCorrente ultimaContaCorrente = contaCorrenteRepository.findTopByOrderByIdDesc().orElse(null);
        long lastId = ultimaContaCorrente != null ? ultimaContaCorrente.getId() : 0;

        ContaCorrente contaCorrenteOrigem = new ContaCorrenteBuilder("0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(lastId+1).build();
        ContaCorrente contaCorrenteDestino = new ContaCorrenteBuilder("0050", "5670012", true).setSaldo(BigDecimal.valueOf(10000)).setId(lastId+2).build();

        contaCorrenteRepository.save(contaCorrenteOrigem);
        contaCorrenteRepository.save(contaCorrenteDestino);
    }

    private void salvarTerminais() {
        TerminalAtm ultimoTerminal = terminalAtmRepository.findTopByOrderByIdDesc().orElse(null);
        long lastId = ultimoTerminal != null ? ultimoTerminal.getId() : 0;

        TerminalAtm terminalAtm = new TerminalAtmBuilder("Rua B, 127 - Porto Alegre, RS", true).setCedulasReal(100, 100, 100, 100, 100, 100).setId(lastId+1).build();

        terminalAtmRepository.save(terminalAtm);
    }
}
