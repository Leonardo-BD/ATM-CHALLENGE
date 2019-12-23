package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.TerminalAtm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TerminalAtmRepository extends MongoRepository<TerminalAtm, String> {

    Optional<TerminalAtm> findById(long id);

    @Query(fields="{ '_id' : 1 }")
    Optional<TerminalAtm> findTopByOrderByIdDesc();
}
