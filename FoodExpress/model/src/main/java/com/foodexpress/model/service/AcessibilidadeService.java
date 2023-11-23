package com.foodexpress.model.service;

import com.foodexpress.model.dao.AcessibilidadeDAO;
import com.foodexpress.model.dto.AcessibilidadeDTO;

public class AcessibilidadeService {
    private AcessibilidadeDAO dao;

    private static AcessibilidadeService instance = null;

    private AcessibilidadeService() { dao = AcessibilidadeDAO.getInstance(); }

    public static AcessibilidadeService getInstance() {
        if(instance == null)
            instance = new AcessibilidadeService();

        return instance;
    }

    public boolean inserirConfiguracoes(String idUsuario) {
        return dao.inserirConfiguracoes(idUsuario);
    }

    public boolean atualizarConfiguracoes(AcessibilidadeDTO obj) {
        return dao.atualizarConfiguracoes(obj);
    }

    public AcessibilidadeDTO getConfiguracoes(String idUser) {
        return dao.getConfiguracoes(idUser);
    }
}
