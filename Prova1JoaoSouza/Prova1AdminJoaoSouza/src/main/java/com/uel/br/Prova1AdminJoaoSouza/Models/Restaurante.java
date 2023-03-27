package com.uel.br.Prova1AdminJoaoSouza.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="restaurante")
public class Restaurante {

    @OneToMany(mappedBy = "restaurante")
    private List<ItemCardapio> itensCardapio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome é obratório")
    private String nome;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome = nome;}
}
