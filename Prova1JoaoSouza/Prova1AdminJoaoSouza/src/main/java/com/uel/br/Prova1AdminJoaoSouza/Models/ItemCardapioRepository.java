package com.uel.br.Prova1AdminJoaoSouza.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Integer>{
    List<ItemCardapio> findByRestauranteId( int idRestaurante);
}
