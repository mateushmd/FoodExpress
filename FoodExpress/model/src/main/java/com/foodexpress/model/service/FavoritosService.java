package com.foodexpress.model.service;

import com.foodexpress.model.dao.FavoritosDAO;
import com.foodexpress.model.dto.FavoritosDTO;
import com.foodexpress.model.dto.LojaDTO;

import java.util.List;
import java.util.ArrayList;

public class FavoritosService {
    private FavoritosDAO dao;
    private LojaService lojaService;

    private static FavoritosService instance = null;

    private FavoritosService() {
        dao = FavoritosDAO.getInstance();
        lojaService = LojaService.getInstance();
    }

    public static FavoritosService getInstance() {
        if(instance == null)
            instance = new FavoritosService();

        return instance;
    }

    public boolean adicionarFavorito(String idCliente, int idLoja) {
        return dao.adicionarFav(idCliente, idLoja);
    }

    public boolean removerFavorito(String idCliente, int idLoja) {
        return dao.removerFav(idCliente, idLoja);
    }

    public List<FavoritosDTO> getFavoritos(String idCliente) {
        return dao.getFav(idCliente);
    }

    public List<LojaDTO> getLojasFavoritos(String idCliente) {
        ArrayList<FavoritosDTO> favoritos = (ArrayList<FavoritosDTO>) getFavoritos(idCliente);

        List<LojaDTO> lojas = new ArrayList<LojaDTO>();

        for(FavoritosDTO favorito : favoritos) {
            LojaDTO loja = lojaService.getLojaById(favorito.getIdLoja());

            if(loja != null)
                lojas.add(loja);
        }

        return lojas;
    }

    public boolean checkFavorito(String idCliente, int idLoja) {
        return dao.searchFav(idCliente, idLoja) != null;
    }
}
