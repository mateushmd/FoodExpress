package com.foodexpress.model.dto;

import java.util.ArrayList;

public class GrupoLojasDTO {
    private String titulo;

    private ArrayList<LojaDTO> lojas;

    public GrupoLojasDTO(String titulo, ArrayList<LojaDTO> lojas) {
        this.titulo = titulo;
        this.lojas = lojas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<LojaDTO> getLojas() {
        return lojas;
    }

    public void setLojas(ArrayList<LojaDTO> lojas) {
        this.lojas = lojas;
    }
}
