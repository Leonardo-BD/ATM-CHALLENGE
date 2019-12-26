package br.com.ibm.challenge.service.interfaces;

import br.com.ibm.challenge.domain.Deposito;

public interface IDepositoService {

    Deposito efetuarDeposito(short versaoApi, Deposito deposito);
}
