package com.foodexpress.model;

import com.foodexpress.model.dao.AcessibilidadeDAO;
import com.foodexpress.model.dao.UsuarioDAO;

public class removerUsuario {
    public static void main(String[] args) {
        String id = "chenri48155@gmail.com";

        System.out.println(AcessibilidadeDAO.getInstance().removerConfiguracao(id));
        System.out.println(UsuarioDAO.getInstance().removerUsuario(id));
    }
}
