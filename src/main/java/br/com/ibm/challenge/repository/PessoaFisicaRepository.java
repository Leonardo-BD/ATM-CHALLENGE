package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.PessoaFisica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PessoaFisicaRepository extends MongoRepository<PessoaFisica, String> {

    Optional<PessoaFisica> findById(long id);

    @Query(fields="{ '_id' : 1 }")
    Optional<PessoaFisica> findTopByOrderByIdDesc();
}
