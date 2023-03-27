package com.uel.br.Prova1AdminJoaoSouza.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Integer>{
    @Query("SELECT i FROM ItemCardapio i WHERE i.restaurante.id = :restauranteId")
    List<ItemCardapio> findByIdRestaurante(@Param("restauranteId") int restauranteId);
}
