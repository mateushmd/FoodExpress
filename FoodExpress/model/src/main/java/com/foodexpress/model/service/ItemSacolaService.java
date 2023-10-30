package com.foodexpress.model.service;

import com.foodexpress.model.dao.ItemSacolaDAO;
import com.foodexpress.model.dao.ItemSacolaViewDAO;
import com.foodexpress.model.dto.ItemSacolaDTO;
import com.foodexpress.model.dto.ItemSacolaViewDTO;

import java.util.List;

public class ItemSacolaService {

    private ItemSacolaDAO itemSacolaDAO;
    private ItemSacolaViewDAO itemSacolaViewDAO;

    private static ItemSacolaService instance = null;

    private ItemSacolaService() {
        itemSacolaDAO = ItemSacolaDAO.getInstance();
        itemSacolaViewDAO = ItemSacolaViewDAO.getInstance();
    }

    public static ItemSacolaService getInstance(){
        if(instance == null)
            instance = new ItemSacolaService();

        return instance;
    }

    public void addItem(ItemSacolaDTO item) {
        itemSacolaDAO.addItem(item);
    }

    public void removerItem(int id) {
        itemSacolaDAO.removerItem(id);
    }

    public List<ItemSacolaDTO> getItens(String idUsuario) {
        return itemSacolaDAO.getItens(idUsuario);
    }

    public List<ItemSacolaViewDTO> getItensView(String idUsuario) {
        return itemSacolaViewDAO.getItensView(idUsuario);
    }

    public List<ItemSacolaViewDTO> getNovoItens(String idUsuario, List<ItemSacolaViewDTO> itensAtuais) {
        return itemSacolaViewDAO.getNovoItens(idUsuario, itensAtuais);
    }
}
