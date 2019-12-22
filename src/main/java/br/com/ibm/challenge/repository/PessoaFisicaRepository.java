package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.PessoaFisica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PessoaFisicaRepository extends MongoRepository<PessoaFisica, String> {
}
