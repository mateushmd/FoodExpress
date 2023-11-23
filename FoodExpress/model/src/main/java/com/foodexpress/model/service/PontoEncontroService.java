package com.foodexpress.model.service;

import com.foodexpress.model.dao.PontoEncontroDAO;
import com.foodexpress.model.dto.AgendaLojaDTO;
import com.foodexpress.model.dto.PontoEncontroDTO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PontoEncontroService {
    private PontoEncontroDAO pontoEncontroDAO;

    private AgendaLojaService agendaLojaService;

    private static PontoEncontroService instance = null;

    private PontoEncontroService() {
        pontoEncontroDAO = PontoEncontroDAO.getInstance();
        agendaLojaService = AgendaLojaService.getInstance();
    }

    public static PontoEncontroService getInstance() {
        if(instance == null)
            instance = new PontoEncontroService();

        return instance;
    }

    public PontoEncontroDTO adicionar(PontoEncontroDTO obj) {
        pontoEncontroDAO.adicionar(obj);

        return pontoEncontroDAO.getInserted(obj.getIdLoja());
    }

    public ArrayList<ArrayList<PontoEncontroDTO>> getByLoja(int idLoja) {
        ArrayList<PontoEncontroDTO> pontos = (ArrayList<PontoEncontroDTO>) pontoEncontroDAO.getByLoja(idLoja);

        ArrayList<PontoEncontroDTO> pontosCampus1 = new ArrayList<>();
        ArrayList<PontoEncontroDTO> pontosCampus2 = new ArrayList<>();

        for(PontoEncontroDTO ponto : pontos) {
            if(ponto.getCampus() == 1)
                pontosCampus1.add(ponto);
            else
                pontosCampus2.add(ponto);
        }

        ArrayList<ArrayList<PontoEncontroDTO>> pontosEncontro = new ArrayList<>();

        pontosEncontro.add(pontosCampus1);
        pontosEncontro.add(pontosCampus2);

        return pontosEncontro;
    }

    public List<PontoEncontroDTO> getCliente(int idLoja) {
        LocalDateTime now = LocalDateTime.now();

        int dia = now.getDayOfWeek().getValue();

        AgendaLojaDTO agenda = agendaLojaService.getAgendaByLojaAndDia(idLoja, dia);

        if(agenda == null)
            return null;

        LocalTime horaAtual = now.toLocalTime();

        if(horaAtual.isBefore(agenda.getAbertura().toLocalTime()) || horaAtual.isAfter(agenda.getFechamento().toLocalTime()))
            return null;

        List<PontoEncontroDTO> pontos = pontoEncontroDAO.getByLojaAndCampus(idLoja, agenda.isCampus1() ? 1 : 2);

        return pontos == null ? new ArrayList<>() : pontos;
    }

    public boolean remover(int idLoja, int id) {
        return pontoEncontroDAO.remover(idLoja, id);
    }
}
