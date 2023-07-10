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

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findClienteByEmailAndPassword(String email, String password);

    @Modifying
    @Query(value = "UPDATE cliente " +
            "SET "+
            "data_di_nascita = ?1 , " +
            "modify_on = ?2 , " +
            "codice_fiscale = ?3 , " +
            "cognome = ?4 ," +
            " email = ?5 , " +
            "modify_by = ?6 , " +
            "nome = ?7 ," +
            "password = ?8 ," +
            "status = ?9 ," +
            "telefono = ?10 " +
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
