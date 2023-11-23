package com.foodexpress.model.dto;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AgendaLojaDTO {
    private int idLoja;
    private int diaSemana;
    private Time abertura;
    private Time fechamento;
    private boolean campus1;
    private boolean campus2;

    private static String[] diasDaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", "Domingo"};

    public AgendaLojaDTO(int idLoja, int diaSemana, String abertura, String fechamento, boolean campus1, boolean campus2) {
        this(idLoja, diaSemana, campus1, campus2);

        this.abertura = Time.valueOf(abertura);
        this.fechamento = Time.valueOf(fechamento);
    }

    private AgendaLojaDTO(int idLoja, int diaSemana, Time abertura, Time fechamento, boolean campus1, boolean campus2) {
        this(idLoja, diaSemana, campus1, campus2);

        this.abertura = abertura;
        this.fechamento = fechamento;
    }

    private AgendaLojaDTO(int idLoja, int diaSemana, boolean campus1, boolean campus2) {
        this.idLoja = idLoja;
        this.diaSemana = diaSemana;
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

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Time getAbertura() {
        return abertura;
    }

    public void setAbertura(Time abertura) {
        this.abertura = abertura;
    }

    public void setAbertura(String abertura) { this.abertura = Time.valueOf(abertura); }

    public Time getFechamento() {
        return fechamento;
    }

    public void setFechamento(Time fechamento) {
        this.fechamento = fechamento;
    }

    public void setFechamento(String fechamento) { this.fechamento = Time.valueOf(fechamento); }

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

    public static List<AgendaLojaDTO> gerarNovaAgenda() {
        ArrayList<AgendaLojaDTO> agenda = new ArrayList<>();

        for(int i = 1; i <= 7; i++) {
            agenda.add(new AgendaLojaDTO(-1, i, (Time) null, null, false, false));
        }

        return agenda;
    }

    public String getDiaSemanaString() {
        if(diaSemana <= 0)
            return "";

        return diasDaSemana[diaSemana - 1];
    }
}
