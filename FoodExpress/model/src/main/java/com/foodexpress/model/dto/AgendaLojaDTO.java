package com.foodexpress.model.dto;

public class AgendaLojaDTO {
    int idLoja;
    String diaSemana;
    String abertura;
    String fechamento;
    boolean campus1;
    boolean campus2;

    public AgendaLojaDTO(int idLoja, String diaSemana, String abertura, String fechamento, boolean campus1, boolean campus2) {
        this.idLoja = idLoja;
        this.diaSemana = diaSemana;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.campus1 = campus1;
        this.campus2 = campus2;
    }

    public AgendaLojaDTO() {
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getAbertura() {
        return abertura;
    }

    public void setAbertura(String abertura) {
        this.abertura = abertura;
    }

    public String getFechamento() {
        return fechamento;
    }

    public void setFechamento(String fechamento) {
        this.fechamento = fechamento;
    }

    public boolean isCampus1() {
        return campus1;
    }

    public void setCampus1(boolean campus1) {
        this.campus1 = campus1;
    }

    public boolean isCampus2() {
        return campus2;
    }

    public void setCampus2(boolean campus2) {
        this.campus2 = campus2;
    }

    
}
