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

    public int addItem(ItemSacolaDTO item) {
        return itemSacolaDAO.addItem(item);
    }

    public boolean removerItem(int id) {
        return itemSacolaDAO.removerItem(id);
    }

    public List<ItemSacolaDTO> getItens(String idUsuario) {
        return itemSacolaDAO.getItens(idUsuario);
    }

    public List<ItemSacolaViewDTO> getItensView(String idUsuario) {
        return itemSacolaViewDAO.getItensView(idUsuario);
    }

    public ItemSacolaViewDTO getItemNovo(String idUsuario, List<ItemSacolaViewDTO> itensAtuais) {
        return itemSacolaViewDAO.getItemNovo(idUsuario, itensAtuais);
    }

    public boolean limparSacola(String idUsuario) { return itemSacolaDAO.limparSacola(idUsuario); }
}
