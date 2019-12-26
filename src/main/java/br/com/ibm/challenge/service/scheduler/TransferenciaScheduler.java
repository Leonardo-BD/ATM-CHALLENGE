package br.com.ibm.challenge.service.scheduler;

import br.com.ibm.challenge.domain.ContaCorrente;
import br.com.ibm.challenge.domain.Transferencia;
import br.com.ibm.challenge.repository.ContaCorrenteRepository;
import br.com.ibm.challenge.repository.TransferenciaRepository;
import br.com.ibm.challenge.service.rules.ContaCorrenteRules;
import br.com.ibm.challenge.service.rules.TransferenciaRules;
import br.com.ibm.challenge.service.utils.TransferenciaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;

@Component
public class TransferenciaScheduler {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    private static final Logger log = LoggerFactory.getLogger(TransferenciaScheduler.class);
    private static final String MSG_EXCEPTION = "Exception :: ";

    @Scheduled(initialDelayString = "${agendamento.transferencia.initial-delay}", fixedRateString = "${agendamento.transferencia.time-rate}")
    public void efetivarTransferenciasAgendadas() {
        if (TransferenciaRules.horarioDeTransferenciaValido()) {
            List<Transferencia> transferenciaList = transferenciaRepository.findTransferenciasAgendadas();

            for (Transferencia transferencia : transferenciaList) {
                try {
                    if (TransferenciaRules.transferenciaNaoExecutada(true, transferencia) && TransferenciaRules.transferenciaPorAgendamentoAutorizada(transferencia)) {
                        ContaCorrente contaCorrenteOrigem = contaCorrenteRepository.findById(transferencia.getIdContaCorrenteOrigem()).orElse(null);
                        ContaCorrente contaCorrenteDestino = contaCorrenteRepository.findById(transferencia.getIdContaCorrenteDestino()).orElse(null);

                        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrenteOrigem);
                        ContaCorrenteRules.contaCorrenteNotNull(true, contaCorrenteDestino);
                        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrenteOrigem);
                        ContaCorrenteRules.contaCorrenteAtiva(true, contaCorrenteDestino);
                        ContaCorrenteRules.saldoSuficienteDebito(true, contaCorrenteOrigem, transferencia.getValor());

                        contaCorrenteOrigem = TransferenciaUtils.debitarCorrentista(transferencia, contaCorrenteOrigem);
                        contaCorrenteDestino = TransferenciaUtils.creditarCorrentista(transferencia, contaCorrenteDestino);

                        contaCorrenteRepository.save(contaCorrenteOrigem);
                        contaCorrenteRepository.save(contaCorrenteDestino);

                        transferencia.setExecutada(true);
                        transferencia.setDataOperacao(ZonedDateTime.now().toEpochSecond());
                        transferenciaRepository.save(transferencia);
                    }
                } catch (Exception e) {
                    log.error(MSG_EXCEPTION, e);

                    transferencia.setCancelada(true);
                    transferencia.setDataOperacao(ZonedDateTime.now().toEpochSecond());
                    transferenciaRepository.save(transferencia);

                    //Em caso real, enviar e-mail ou comunicado às pessoas e serviços interessados.
                }
            }
        }
    }
}
