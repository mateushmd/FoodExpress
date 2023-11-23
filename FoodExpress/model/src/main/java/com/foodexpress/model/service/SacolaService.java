package com.foodexpress.model.service;

import com.foodexpress.model.dao.SacolaViewDAO;
import com.foodexpress.model.dto.ItemSacolaViewDTO;
import com.foodexpress.model.dto.SacolaViewDTO;

import java.util.ArrayList;

public class SacolaService {

    private SacolaViewDAO sacolaViewDAO;

    private static SacolaService instance = null;

    private SacolaService() {
        sacolaViewDAO = SacolaViewDAO.getInstance();
    }

    public static SacolaService getInstance() {
        if(instance == null)
            instance = new SacolaService();

        return instance;
    }

    public SacolaViewDTO getSacola(String idUsuario) {
        SacolaViewDTO sacola = sacolaViewDAO.getSacola(idUsuario);

        if(sacola == null) {
            return new SacolaViewDTO();
        }

        ItemSacolaService itemSacolaService = ItemSacolaService.getInstance();

        ArrayList<ItemSacolaViewDTO> itens = (ArrayList<ItemSacolaViewDTO>) itemSacolaService.getItensView(idUsuario);

        sacola.setItens(itens);

        return sacola;
    }
}
