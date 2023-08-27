package com.foodexpress.model.dto;

public class ProdutoDTO {
    int id;
    int idLoja;
    String nome;
    double preco;
    String descricao;
    boolean disponivel;

    public ProdutoDTO(int idLoja, String nome, double preco, boolean disponivel) {
        this.idLoja = idLoja;
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
    }
    
    public ProdutoDTO(int idLoja, String nome, double preco, boolean disponivel, String descricao) {
        this(idLoja, nome, preco, disponivel);
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
    
    public boolean getDisponivel() {
        return disponivel;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
