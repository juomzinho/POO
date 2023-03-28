package com.uel.br.Prova1AdminJoaoSouza.Models;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface RestauranteRepository extends CrudRepository<Restaurante, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurante r WHERE r.id = :id")
    void deleteById(@Param("id") int id);
}
