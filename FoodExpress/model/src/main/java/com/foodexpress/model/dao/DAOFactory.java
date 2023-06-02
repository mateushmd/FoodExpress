package com.foodexpress.model.dao;
import com.foodexpress.model.dao.ConexaoBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFactory {
    public static UsuarioDAO createUsuarioDAO() {
        try {
            return new UsuarioDAO(ConexaoBD.getConexao());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
