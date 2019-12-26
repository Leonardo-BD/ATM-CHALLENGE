package br.com.ibm.challenge.controller;

import br.com.ibm.challenge.domain.Saque;
import br.com.ibm.challenge.service.SaqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaqueController {

    @Autowired
    private SaqueService saqueService;

    private static final Logger log = LoggerFactory.getLogger(SaqueController.class);
    private static final String MSG_EXCEPTION = "Exception :: ";

    @PostMapping("/v{versaoApi}/saque")
    public Saque sacarContaCorrenteViaAtm(@PathVariable("versaoApi") short versaoApi, @RequestBody Saque saque/*, @RequestParam("valorSaque") double valorSaque*/) {
        try {
            return saqueService.sacarContaCorrenteViaAtm(versaoApi, saque);
        } catch (Exception e) {
            log.error(MSG_EXCEPTION, e);
            throw e;
        }
    }
}
