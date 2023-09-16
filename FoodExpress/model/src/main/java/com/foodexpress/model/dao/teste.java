package com.foodexpress.model.dao;
import com.foodexpress.model.dto.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) throws SQLException {
        AvaliacaoDAO ava = AvaliacaoDAO.getInstance();
        
        if(ava.updateNotaComentario(5, "Melhor atendimento", 4))
            System.out.println("Passou!!!");
    }
}