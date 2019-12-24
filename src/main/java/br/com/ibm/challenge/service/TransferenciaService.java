package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Transferencia;
import br.com.ibm.challenge.repository.ContaCorrenteRepository;
import br.com.ibm.challenge.repository.TransferenciaRepository;
import br.com.ibm.challenge.service.interfaces.ITransferenciaService;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.TransferenciaRules;
import br.com.ibm.challenge.service.utils.TransferenciaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Service
public class TransferenciaService implements ITransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    public Transferencia efetuarTransferencia(short versaoApi, Transferencia transferencia, double valorTransferencia) {
        TransferenciaRules.versaoApiEfetuarTransferenciaValida(true, versaoApi);
        TransferenciaRules.transferenciaNotNull(true, transferencia);
        TransferenciaRules.idsContaCorrenteValidos(true, transferencia);
        TransferenciaRules.valorTransferenciaValido(true, BigDecimal.valueOf(valorTransferencia));
        transferencia.setValor(BigDecimal.valueOf(valorTransferencia));

        ContaCorrente contaCorrenteOrigem = contaCorrenteRepository.findById(transferencia.getIdContaCorrenteOrigem()).orElse(null);//new ContaCorrenteBuilder(1, "0041", "4015871", true).setSaldo(BigDecimal.valueOf(10000)).setId(transferencia.getIdContaCorrenteOrigem()).build();
        ContaCorrente contaCorrenteDestino = contaCorrenteRepository.findById(transferencia.getIdContaCorrenteDestino()).orElse(null);//new ContaCorrenteBuilder(2, "0050", "5670012", true).setSaldo(BigDecimal.valueOf(10000)).setId(transferencia.getIdContaCorrenteDestino()).build();

        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrenteOrigem);
        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrenteDestino);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrenteOrigem);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrenteDestino);

        TransferenciaRules.remetentePossuiSaldoParaTransferencia(true, transferencia, contaCorrenteOrigem);

        contaCorrenteOrigem = TransferenciaUtils.debitarCorrentista(transferencia, contaCorrenteOrigem);
        contaCorrenteDestino = TransferenciaUtils.creditarCorrentista(transferencia, contaCorrenteDestino);

        contaCorrenteRepository.save(contaCorrenteOrigem);
        contaCorrenteRepository.save(contaCorrenteDestino);

        Transferencia ultimaTransferencia = transferenciaRepository.findTopByOrderByIdDesc().orElse(null);
        long lastId = ultimaTransferencia != null ? ultimaTransferencia.getId() : 0;

        transferencia.setId(lastId+1);
        transferencia.setDataOperacao(ZonedDateTime.now().toEpochSecond());

        transferencia = transferenciaRepository.save(transferencia);

        return transferencia;
    }
}
