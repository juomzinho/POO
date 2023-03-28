package com.uel.br.Prova1ConsumidorJoaoSouza.Models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="item_cardapio")
public class ItemCardapio implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_restaurante", insertable = false, updatable = false)
    private Restaurante restaurante;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private String descricao;

    @NotNull
    private int id_restaurante;

    @NotNull(message = "O preço é obrigatório")
    private double preco;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }    

    public void setRestaurante(Restaurante restaurante){
        this.restaurante = restaurante;
    }

    public Restaurante getRestaurante(){
        return restaurante;
    }

    public void setIdRestaurante(int id_restaurante){
        this.id_restaurante = id_restaurante;
    }

    public int getIdRestaurante(){
        return id_restaurante;
    }
}
