package com.foodexpress.model.dto;

public class ProdutoDTO {
    int id;
    int idLoja;
    String nome;
    double preco;
    String descricao;
    int quantidade;

    public ProdutoDTO(int idLoja, String nome, double preco, int quantidade) {
        this.idLoja = idLoja;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public ProdutoDTO(int idLoja, String nome, double preco, int quantidade, String descricao) {
        this(idLoja, nome, preco, quantidade);
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

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
