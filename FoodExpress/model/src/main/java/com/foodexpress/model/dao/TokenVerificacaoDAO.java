/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.foodexpress.model.dao;

import com.foodexpress.model.encoder.Argon2Encoder;
import com.foodexpress.model.dto.TokenVerificacaoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TokenVerificacaoDAO extends DAOTemplate<TokenVerificacaoDTO> {
    
    private static TokenVerificacaoDAO instance = null;
    
    private Argon2Encoder encoder;

    private TokenVerificacaoDAO() {
        super();
        
        encoder = Argon2Encoder.getEncoder();
    }
    
    public static synchronized TokenVerificacaoDAO getInstance() {
        if(instance == null)
            instance = new TokenVerificacaoDAO();
        
        return instance;
    }

    @Override
    protected TokenVerificacaoDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        TokenVerificacaoDTO token = null;
        
        try {
            token = new TokenVerificacaoDTO();
        
            token.setEmailUsuario(rs.getString("usuario_id"));
            token.setToken(rs.getString("token"));
        } catch (SQLException ex) {
            Logger.getLogger(TokenVerificacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return token;
    }
    
    public boolean insert(TokenVerificacaoDTO token) {
        String sql = "INSERT INTO token_verificacao VALUES(?, ?)";
        
        return executeUpdate(sql, token.getEmailUsuario(), encoder.encode(token.getToken()));
    }
    
    public boolean validateToken(TokenVerificacaoDTO obj) {
        String sql = "SELECT * FROM token_verificacao WHERE usuario_id = ?";
        
        List<TokenVerificacaoDTO> tokens = executeQuery(sql, obj.getEmailUsuario());
        
        if(tokens.isEmpty())
            return false;
        
        TokenVerificacaoDTO token = tokens.get(0);
        
        if(!encoder.check(obj.getToken(), token.getToken()))
            return false;
        
        return delete(token);
    }
    
    public boolean delete(TokenVerificacaoDTO token) {
        
        String sql = "DELETE FROM token_verificacao WHERE usuario_id = ?";
        
        return executeUpdate(sql, token.getEmailUsuario());
    }
}
