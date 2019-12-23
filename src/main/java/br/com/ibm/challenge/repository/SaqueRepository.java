package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.Saque;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface SaqueRepository extends MongoRepository<Saque, String> {

    Optional<Saque> findById(long id);

    @Query(fields="{ '_id' : 1 }")
    Optional<Saque> findTopByOrderByIdDesc();
}
