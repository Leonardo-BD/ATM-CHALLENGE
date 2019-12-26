package br.com.ibm.challenge.service;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Transferencia;
import br.com.ibm.challenge.exception.enumerator.TransferenciaExceptionEnum;
import br.com.ibm.challenge.repository.ContaCorrenteRepository;
import br.com.ibm.challenge.repository.TransferenciaRepository;
import br.com.ibm.challenge.service.interfaces.ITransferenciaService;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.TransferenciaRules;
import br.com.ibm.challenge.service.utils.TransferenciaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class TransferenciaService implements ITransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    private static final Logger log = LoggerFactory.getLogger(TransferenciaService.class);
    private static final String MSG_EXCEPTION = "Exception :: ";

    public Transferencia efetuarTransferencia(short versaoApi, Transferencia transferencia) {
        TransferenciaRules.versaoApiEfetuarTransferenciaValida(true, versaoApi);
        TransferenciaRules.transferenciaNotNull(true, transferencia);
        TransferenciaRules.idsContaCorrenteValidos(true, transferencia);
        TransferenciaRules.valorTransferenciaValido(true, transferencia.getValor());

        ContaCorrente contaCorrenteOrigem = contaCorrenteRepository.findById(transferencia.getIdContaCorrenteOrigem()).orElse(null);
        ContaCorrente contaCorrenteDestino = contaCorrenteRepository.findById(transferencia.getIdContaCorrenteDestino()).orElse(null);

        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrenteOrigem);
        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrenteDestino);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrenteOrigem);
        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrenteDestino);
        ContaCorrenteRules.saldoSuficienteDebito(true, contaCorrenteOrigem, transferencia.getValor());

        Transferencia ultimaTransferencia = transferenciaRepository.findTopByOrderByIdDesc().orElse(null);
        long lastId = ultimaTransferencia != null ? ultimaTransferencia.getId() : 0;

        transferencia.setId(lastId+1);

        if (TransferenciaRules.horarioDeTransferenciaValido()) {
            try {
                contaCorrenteOrigem = TransferenciaUtils.debitarCorrentista(transferencia, contaCorrenteOrigem);
                contaCorrenteDestino = TransferenciaUtils.creditarCorrentista(transferencia, contaCorrenteDestino);

                contaCorrenteRepository.save(contaCorrenteOrigem);
                contaCorrenteRepository.save(contaCorrenteDestino);
            } catch (Exception e) {
                log.error(MSG_EXCEPTION, e);

                transferencia.setCancelada(true);
                transferencia.setDataOperacao(ZonedDateTime.now().toEpochSecond());
                transferenciaRepository.save(transferencia);

                //Em caso real, enviar e-mail ou comunicado às pessoas e serviços interessados

                throw TransferenciaExceptionEnum.ERRO_INTERNO_TRANSFERENCIA.getException();
            } finally {
                transferencia.setExecutada(true);
                transferencia.setDataOperacao(ZonedDateTime.now().toEpochSecond());
            }
        } else {
            transferencia.setDataAgendamento(ZonedDateTime.now().toEpochSecond());
        }

        transferencia = transferenciaRepository.save(transferencia);

        return transferencia;
    }
}
