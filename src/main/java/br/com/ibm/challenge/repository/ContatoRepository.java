package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.Contato;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ContatoRepository extends MongoRepository<Contato, String> {

    Optional<Contato> findById(long id);

    @Query(fields="{ '_id' : 1 }")
    Optional<Contato> findTopByOrderByIdDesc();
}
