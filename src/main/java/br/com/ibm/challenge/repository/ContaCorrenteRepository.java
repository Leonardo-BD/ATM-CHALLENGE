package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.ContaCorrente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContaCorrenteRepository extends MongoRepository<ContaCorrente, String> {
}
