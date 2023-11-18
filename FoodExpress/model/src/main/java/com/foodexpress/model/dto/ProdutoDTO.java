package com.foodexpress.model.dto;

public class ProdutoDTO {
    int id;
    int idLoja;
    int idCategoria;
    String nome;
    double preco;
    String descricao;
    boolean disponivel;

    public ProdutoDTO(int idLoja, int idCategoria) {
        this.idLoja = idLoja;
        this.idCategoria = idCategoria;

        nome = "Novo produto";
        preco = 0.00;
    }

    public ProdutoDTO(int idLoja, int idCategoria, String nome, double preco, boolean disponivel) {
        this(idLoja, idCategoria);
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
    }
    
    public ProdutoDTO(int idLoja, int idCategoria, String nome, double preco, boolean disponivel, String descricao) {
        this(idLoja, idCategoria, nome, preco, disponivel);
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

    public int getIdCategoria() { return idCategoria; }

    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

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
