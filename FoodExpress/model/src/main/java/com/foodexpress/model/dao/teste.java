package com.foodexpress.model.dao;
import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.*;
import java.sql.SQLException;

public class teste {
    public static void main(String[] args) throws SQLException {
        LojaService lo = LojaService.getInstance();
        
        lo.adicionarAoCard(new ProdutoDTO(lo.getLoja("washingtonwagner2020@gmail.com").getId(), "bolo de cenoura com cobertura", 5.0, "Melhor bolo"));
    }
}
