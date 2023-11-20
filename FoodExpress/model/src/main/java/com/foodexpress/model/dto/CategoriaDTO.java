package com.foodexpress.model.dto;

import java.util.ArrayList;

public class CategoriaDTO {
    private int id;
    private int idLoja;
    private String nome;
    private boolean visivel;

    private ArrayList<ProdutoDTO> produtos;

    public CategoriaDTO(int idLoja, String nome, boolean visivel) {
        this();

        this.idLoja = idLoja;
        this.nome = nome;
        this.visivel = visivel;
    }

    public CategoriaDTO(int idLoja, String nome) {
        this(idLoja, nome, false);
    }

    public CategoriaDTO() {
        produtos = new ArrayList<>();
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

    public boolean getVisivel() { return visivel; }

    public void setVisivel(boolean visivel) { this.visivel = visivel; }

    public ArrayList<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void addProduto(ProdutoDTO produto) {
        produtos.add(produto);
    }

    public void removerProduto(ProdutoDTO produto) { produtos.remove(produto); }

    public void setProdutos(ArrayList<ProdutoDTO> produtos) {
        if(produtos == null)
            return;

        this.produtos = produtos;
    }
}
