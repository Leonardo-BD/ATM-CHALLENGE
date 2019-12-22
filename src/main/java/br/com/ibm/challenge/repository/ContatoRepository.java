package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.Contato;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContatoRepository extends MongoRepository<Contato, String> {
}
