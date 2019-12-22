package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.TerminalAtm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TerminalAtmRepository extends MongoRepository<TerminalAtm, String> {
}
