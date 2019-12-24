package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.Deposito;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface DepositoRepository extends MongoRepository<Deposito, String> {

    Optional<Deposito> findById(long id);

    @Query(fields="{ '_id' : 1 }")
    Optional<Deposito> findTopByOrderByIdDesc();
}
