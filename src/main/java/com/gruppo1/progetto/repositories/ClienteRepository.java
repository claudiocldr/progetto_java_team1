package com.gruppo1.progetto.repositories;

import com.gruppo1.progetto.models.Cliente;
import com.gruppo1.progetto.models.RecordStatusEnum;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findClienteByEmailAndPassword(String email, String password);
    Optional<Cliente> findById (Long id);

    @Modifying
    @Query(value = "UPDATE cliente " +
            "SET "+
            "data_di_nascita = CASE WHEN ?1 IS NOT NULL THEN ?1 ELSE data_di_nascita END, " +
            "modify_on = ?2, " +
            "codice_fiscale = CASE WHEN ?3 IS NOT NULL THEN ?3 ELSE codice_fiscale END, " +
            "cognome = CASE WHEN ?4 IS NOT NULL THEN ?4 ELSE cognome END ," +
            " email = CASE WHEN ?5 IS NOT NULL THEN ?5 ELSE email END ,  " +
            "modify_by = ?6 , " +
            "nome = CASE WHEN ?7 IS NOT NULL THEN ?7 ELSE nome END ," +
            "password = CASE WHEN ?8 IS NOT NULL THEN ?8 ELSE password END ," +
            "status = ?9 ," +
            "telefono = CASE WHEN ?10 IS NOT NULL THEN ?10 ELSE telefono END " +
            "WHERE id = ?11", nativeQuery = true)
    void updateClienteById(LocalDate data_di_nascita,
                           LocalDateTime modifyOn,
                           String codiceFiscale,
                           String cognome,
                           String email,
                           String modifyBy,
                           String nome,
                           String password,
                           String recordStatus,
                           String telefono,
                           Long id);

}
