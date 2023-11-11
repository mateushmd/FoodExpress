package com.foodexpress.model.dto;

public class PontoEncontroDTO {
    int id;
    int idLoja;
    String nome;

    public PontoEncontroDTO(int id, int idLoja, String nome) {
        this.id = id;
        this.idLoja = idLoja;
        this.nome = nome;
    }

    public PontoEncontroDTO(int idLoja, String nome) {
        this.idLoja = idLoja;
        this.nome = nome;
    }

    public PontoEncontroDTO() {
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
    
    
}
