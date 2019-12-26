package br.com.ibm.challenge.repository;

import br.com.ibm.challenge.domain.Transferencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransferenciaRepository extends MongoRepository<Transferencia, String> {

    Optional<Transferencia> findById(long id);

    @Query(fields="{ '_id' : 1 }")
    Optional<Transferencia> findTopByOrderByIdDesc();

    @Query("{ 'dataAgendamento' : {$gt : 0}, 'executada' : false, 'cancelada' : false }")
    List<Transferencia> findTransferenciasAgendadas();
}
