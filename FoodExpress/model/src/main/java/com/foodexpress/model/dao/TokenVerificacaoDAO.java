/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.foodexpress.model.dao;

import com.foodexpress.model.email.EmailUtil;
import com.foodexpress.model.encoder.Argon2Encoder;
import com.foodexpress.model.dto.TokenVerificacaoDTO;
import com.foodexpress.model.encoder.TokenGenerator;

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
        
        instance.setConnection();
        
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
    
    public boolean addToken(String email) {
        delete(email);

        TokenVerificacaoDTO dto = new TokenVerificacaoDTO(email, TokenGenerator.generateToken());

        String sql = "INSERT INTO token_verificacao VALUES(?, ?)";
        
        boolean check = executeUpdate(sql, dto.getEmailUsuario(), encoder.encode(dto.getToken()));

        if(check)
            EmailUtil.sendEmailVerificacao(dto);

        return check;
    }
    
    public boolean validateToken(TokenVerificacaoDTO obj) {
        String sql = "SELECT * FROM token_verificacao WHERE usuario_id = ?";
        
        List<TokenVerificacaoDTO> tokens = executeQuery(sql, obj.getEmailUsuario());
        
        if(tokens.isEmpty())
            return false;
        
        TokenVerificacaoDTO token = tokens.get(0);
        
        if(!encoder.check(obj.getToken(), token.getToken()))
            return false;
        
        return delete(token.getEmailUsuario());
    }
    
    public boolean delete(String email) {
        
        String sql = "DELETE FROM token_verificacao WHERE usuario_id = ?";
        
        return executeUpdate(sql, email);
    }
}
