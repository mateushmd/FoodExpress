package com.foodexpress.model.dao;


public class DAOFactory {
    public static UsuarioDAO createUsuarioDAO() {
        return new UsuarioDAO(ConexaoBD.getConnection());
    }
}
