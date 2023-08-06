package com.foodexpress.model.service;

import com.foodexpress.model.email.EmailUtil;
import com.foodexpress.model.encoder.TokenGenerator;
import com.foodexpress.model.dao.UsuarioDAO;
import com.foodexpress.model.dao.TokenVerificacaoDAO;
import com.foodexpress.model.dto.TokenVerificacaoDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao;
    
    private static UsuarioService instance = null;
    
    private UsuarioService() {
        dao = UsuarioDAO.getInstance();
    }
    
    public static UsuarioService getInstance() {
        if(instance == null)
            instance = new UsuarioService();
        
        return instance;
    }
    
    public int login(String email, String senha){
        int check = dao.login(email, senha);
        System.out.println(check);
        
        return check;
    }
    
    public boolean verificarEmail(TokenVerificacaoDTO token) {
        System.out.println("verificarEmail() " + token.getEmailUsuario());
        System.out.println("verificarEmail() " + token.getToken());
        
        TokenVerificacaoDAO tokenDAO = TokenVerificacaoDAO.getInstance();
        
        boolean check = tokenDAO.validateToken(token);
        
        System.out.println("verificarEmail(): check " + check);
        
        if(check)
            check = dao.updateVerificacao(token.getEmailUsuario());
        
        System.out.println("verificarEmail(): check " + check);

        return check;
    }
    
    public boolean update(UsuarioDTO obj) {
        return dao.update(obj);
    }

    public UsuarioDTO getUsuario(String email) {
        return dao.getUsuario(email);
    }

    public void cadastrar(UsuarioDTO obj) {
        TokenVerificacaoDAO tokenDAO = TokenVerificacaoDAO.getInstance();
        
        dao.cadastrar(obj);
        
        String generatedToken = TokenGenerator.generateToken();
        
        TokenVerificacaoDTO token = new TokenVerificacaoDTO(obj.getEmail(), generatedToken);
        
        EmailUtil.sendEmailVerificacao(token);
        
        tokenDAO.insert(token);
    }
    
    public boolean redefinirSenha(String email, String senha) {
        return dao.redefinirSenha(email, senha);
    }

    public List<UsuarioDTO> ListarUsuario() throws SQLException {
        return dao.ListarUsuarios();
    }
    
    public UsuarioDTO getUser(){
        return dao.getUser();
    }

}
