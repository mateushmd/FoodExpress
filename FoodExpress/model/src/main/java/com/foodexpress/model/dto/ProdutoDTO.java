package com.foodexpress.model.dto;

public class ProdutoDTO {
    int id;
    int idLoja;
    int idCategoria;
    String nome;
    double preco;
    String descricao;
    boolean disponivel;
    boolean destaque;

    public ProdutoDTO(int idLoja, int idCategoria) {
        this.idLoja = idLoja;
        this.idCategoria = idCategoria;

        nome = "Novo produto";
        preco = 0.00;
    }

    public ProdutoDTO(int idLoja, int idCategoria, String nome, double preco, boolean disponivel, boolean destaque) {
        this(idLoja, idCategoria);
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
        this.destaque = destaque;
    }
    
    public ProdutoDTO(int idLoja, int idCategoria, String nome, double preco, boolean disponivel, boolean destaque, String descricao) {
        this(idLoja, idCategoria, nome, preco, disponivel, destaque);
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

    public boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }
}
