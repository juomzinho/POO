package com.uel.br.Prova1ConsumidorJoaoSouza.Models;

import java.io.Serializable;

public class Pedido implements Serializable {
    private int id;

    private String nome_restaurante;

    private String nome;

    private int quantidade;

    private double preco;

    public Pedido(){

    }

    public Pedido(int id, String nome, String nome_restaurante, int quantidade, double preco){
        this.id = id;
        this.nome = nome;
        this.nome_restaurante = nome_restaurante;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }
    public String getNomeRestaurante() {
        return nome_restaurante;
    }
    public String getNome() {
        return nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNomeRestaurante(String nome_restaurante) {
        this.nome_restaurante = nome_restaurante;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
