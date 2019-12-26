package br.com.ibm.challenge.service.interfaces;

import br.com.ibm.challenge.domain.Saque;

public interface ISaqueService {

    Saque sacarContaCorrenteViaAtm(short versaoApi, Saque saque);
}
