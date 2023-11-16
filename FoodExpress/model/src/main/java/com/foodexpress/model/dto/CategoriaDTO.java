package com.foodexpress.model.dto;

import java.util.ArrayList;

public class CategoriaDTO {
    private int id;
    private int idLoja;
    private String nome;

    private ArrayList<ProdutoDTO> produtos;

    public CategoriaDTO(int idLoja, String nome) {
        this();

        this.idLoja = idLoja;
        this.nome = nome;
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

    public ArrayList<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void addProduto(ProdutoDTO produto) {
        produtos.add(produto);
    }

    public void setProdutos(ArrayList<ProdutoDTO> produtos) {
        if(produtos == null)
            return;

        this.produtos = produtos;
    }
}
