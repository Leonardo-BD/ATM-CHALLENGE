package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.Saque;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SaqueRepository extends MongoRepository<Saque, String> {
}
