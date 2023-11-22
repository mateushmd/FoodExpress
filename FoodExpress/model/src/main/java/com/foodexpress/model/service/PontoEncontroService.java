package com.foodexpress.model.service;

import com.foodexpress.model.dao.PontoEncontroDAO;
import com.foodexpress.model.dto.PontoEncontroDTO;

import java.util.ArrayList;

public class PontoEncontroService {
    private PontoEncontroDAO pontoEncontroDAO;

    private static PontoEncontroService instance = null;

    private PontoEncontroService() { pontoEncontroDAO = PontoEncontroDAO.getInstance(); }

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

    public boolean remover(int idLoja, int id) {
        return pontoEncontroDAO.remover(idLoja, id);
    }
}
