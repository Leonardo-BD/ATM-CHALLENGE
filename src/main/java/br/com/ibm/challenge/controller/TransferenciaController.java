package br.com.ibm.challenge.controller;

import br.com.ibm.challenge.domain.Transferencia;
import br.com.ibm.challenge.service.TransferenciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    private static final Logger log = LoggerFactory.getLogger(TransferenciaController.class);
    private static final String MSG_EXCEPTION = "Exception :: ";

    @ResponseBody
    @PostMapping("/v{versaoApi}/transferencia")
    public Transferencia efetuarTransferencia(@PathVariable("versaoApi") short versaoApi, @RequestBody Transferencia transferencia, @RequestParam("valorTransferencia") double valorTransferencia) {
        try {
            return transferenciaService.efetuarTransferencia(versaoApi, transferencia, valorTransferencia);
        } catch (Exception e) {
            log.error(MSG_EXCEPTION, e);
            throw e;
        }
    }
}
