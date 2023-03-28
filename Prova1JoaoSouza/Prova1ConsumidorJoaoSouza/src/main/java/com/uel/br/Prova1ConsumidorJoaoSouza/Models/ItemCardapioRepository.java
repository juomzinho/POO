package com.uel.br.Prova1ConsumidorJoaoSouza.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Integer>{
    List<ItemCardapio> findByRestauranteId( int idRestaurante);

    @Query("select case when count(i)> 0 then true else false end from ItemCardapio i where i.id = :id")
    int existsItem(@Param("id") int id);

    @Query("select preco from ItemCardapio i where i.id = :id")
    double precoById(@Param("id") int id);

    @Query("select nome from ItemCardapio i where i.id = :id")
    String nomeById(@Param("id") int id);
}
