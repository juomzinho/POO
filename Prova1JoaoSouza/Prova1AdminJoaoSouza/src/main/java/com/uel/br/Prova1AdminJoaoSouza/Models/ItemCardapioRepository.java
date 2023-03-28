package com.uel.br.Prova1AdminJoaoSouza.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;


public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Integer>{
    List<ItemCardapio> findByRestauranteId( int idRestaurante);

    void deleteByRestauranteId(int idRestaurante);
    
    @Transactional
    @Modifying
    @Query("UPDATE ItemCardapio i SET i.nome = :nome, i.descricao = :descricao, i.preco = :preco WHERE i.id = :id")
    void updateItemCardapio(@Param("id") int id, @Param("nome") String nome, @Param("descricao") String descricao, @Param("preco") double preco);
}
