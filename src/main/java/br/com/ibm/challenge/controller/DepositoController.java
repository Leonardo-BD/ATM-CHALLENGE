package br.com.ibm.challenge.controller;

import br.com.ibm.challenge.domain.Deposito;
import br.com.ibm.challenge.service.DepositoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepositoController {

    @Autowired
    private DepositoService depositoService;

    private static final Logger log = LoggerFactory.getLogger(DepositoController.class);
    private static final String MSG_EXCEPTION = "Exception :: ";

    @PostMapping("/v{versaoApi}/deposito")
    public Deposito efetuarDeposito(@PathVariable("versaoApi") short versaoApi, @RequestBody Deposito deposito) {
        try {
            return depositoService.efetuarDeposito(versaoApi, deposito);
        } catch (Exception e) {
            log.error(MSG_EXCEPTION, e);
            throw e;
        }
    }
}
