package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Transferencia;
import br.com.ibm.challenge.domain.builder.ContaCorrenteBuilder;
import br.com.ibm.challenge.service.interfaces.ITransferenciaService;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.TransferenciaRules;
import br.com.ibm.challenge.service.utils.TransferenciaUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Service
public class TransferenciaService implements ITransferenciaService {

    public Transferencia efetuarTransferencia(short versaoApi, Transferencia transferencia, double valorTransferencia) {
        TransferenciaRules.versaoApiEfetuarTransferenciaValida(true, versaoApi);
        TransferenciaRules.transferenciaNotNull(true, transferencia);
        TransferenciaRules.idsContaCorrenteValidos(true, transferencia);
        TransferenciaRules.valorTransferenciaValido(true, BigDecimal.valueOf(valorTransferencia));
        transferencia.setValor(BigDecimal.valueOf(valorTransferencia));

        ContaCorrente contaCorrenteOrigem = new ContaCorrenteBuilder(1, "0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(transferencia.getIdContaCorrenteOrigem()).build();
        ContaCorrente contaCorrenteDestino = new ContaCorrenteBuilder(2, "0050", "5670012", true).setSaldo(BigDecimal.valueOf(10000)).setId(transferencia.getIdContaCorrenteDestino()).build();

        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrenteOrigem);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrenteDestino);

        TransferenciaRules.remetentePossuiSaldoParaTransferencia(true, transferencia, contaCorrenteOrigem);

        contaCorrenteOrigem = TransferenciaUtils.debitarCorrentista(transferencia, contaCorrenteOrigem);
        contaCorrenteDestino = TransferenciaUtils.creditarCorrentista(transferencia, contaCorrenteDestino);

        transferencia.setDataOperacao(ZonedDateTime.now().toEpochSecond());

        return transferencia;
    }
}
