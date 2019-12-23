package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.ContaCorrente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ContaCorrenteRepository extends MongoRepository<ContaCorrente, String> {

    Optional<ContaCorrente> findById(long id);

    @Query(fields="{ '_id' : 1 }")
    Optional<ContaCorrente> findTopByOrderByIdDesc();
}
