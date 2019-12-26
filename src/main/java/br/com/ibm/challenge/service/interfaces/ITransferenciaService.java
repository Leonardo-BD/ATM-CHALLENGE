package br.com.ibm.challenge.service.interfaces;

import br.com.ibm.challenge.domain.Transferencia;

public interface ITransferenciaService {

    Transferencia efetuarTransferencia(short versaoApi, Transferencia transferencia);
}
