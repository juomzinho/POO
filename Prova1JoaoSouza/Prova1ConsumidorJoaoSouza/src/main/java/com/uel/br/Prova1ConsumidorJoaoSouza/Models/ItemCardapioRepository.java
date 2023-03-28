package com.uel.br.Prova1ConsumidorJoaoSouza.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Integer>{
    List<ItemCardapio> findByRestauranteId( int idRestaurante);
}
