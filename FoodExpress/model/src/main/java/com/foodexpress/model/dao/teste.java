package com.foodexpress.model.dao;
import com.foodexpress.model.dto.*;
import com.foodexpress.model.email.EmailUtil;
import com.foodexpress.model.service.AcessibilidadeService;
import com.foodexpress.model.service.AvaliacaoService;
import com.foodexpress.model.service.UsuarioService;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) throws SQLException {
        FavoritosDAO fav = FavoritosDAO.getInstance();
        
        System.out.println("\n\n\nOlha isso: " + fav.searchFav("washingtonwagner2020@gmail.com", 34).getIdCliente());
    }
}