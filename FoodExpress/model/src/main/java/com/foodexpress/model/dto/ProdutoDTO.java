package com.foodexpress.model.dto;

public class ProdutoDTO {
    int id;
    int idLoja;
    String nome;
    float preco;
    String descricao;

    public ProdutoDTO(int id, int idLoja, String nome, float preco, String descricao) {
        this.id = id;
        this.idLoja = idLoja;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public ProdutoDTO(int idLoja, String nome, double preco, String descricao) {
        this.id = id;
        this.idLoja = idLoja;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public ProdutoDTO(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
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

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
