package com.foodexpress.model.dto;

public class PontoEncontroDTO {
    private int id;
    private int idLoja;
    private int campus;
    private String nome;

    public PontoEncontroDTO(int idLoja, int campus, String nome) {
        this.idLoja = idLoja;
        this.campus = campus;
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

    public int getCampus() { return campus; }

    public void setCampus(int campus) { this.campus = campus; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
