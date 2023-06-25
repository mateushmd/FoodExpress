package com.foodexpress.model.service;

import com.foodexpress.model.EmailUtil;
import com.foodexpress.model.TokenGenerator;
import com.foodexpress.model.dao.UsuarioDAO;
import com.foodexpress.model.dao.DAOFactory;
import com.foodexpress.model.dao.TokenVerificacaoDAO;
import com.foodexpress.model.dto.TokenVerificacaoDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao = DAOFactory.createUsuarioDAO();
    
    public int login(String email, String senha){
        int check = dao.login(email, senha);
        System.out.println(check);
        
        return check;
    }
    
    public boolean verificarEmail(TokenVerificacaoDTO token) {
        System.out.println("verificarEmail() " + token.getEmailUsuario());
        System.out.println("verificarEmail() " + token.getToken());
        
        TokenVerificacaoDAO tokenDAO = DAOFactory.createTokenVerificacaoDAO();
        
        boolean check = tokenDAO.validateToken(token);
        
        System.out.println("verificarEmail(): check " + check);
        
        if(check)
            check = dao.updateVerificacao(token.getEmailUsuario());
        
        System.out.println("verificarEmail(): check " + check);

        return check;
    }
    
    public void update(UsuarioDTO obj) {
        dao.update(obj);
    }

    public void delete(String email) {
        dao.deleteByEmail(email);
    }

    public UsuarioDTO findByLogin(String email) throws SQLException {
        return dao.findByEmail(email);
    }

    public void cadastrar(UsuarioDTO obj) {
        TokenVerificacaoDAO tokenDAO = DAOFactory.createTokenVerificacaoDAO();
        
        dao.insert(obj);
        
        String generatedToken = TokenGenerator.generateToken();
        
        TokenVerificacaoDTO token = new TokenVerificacaoDTO(obj.getEmail(), generatedToken);
        
        EmailUtil.sendEmailVerificacao(token);
        
        tokenDAO.addToken(token);
    }

    public List<UsuarioDTO> ListarUsuario() throws SQLException {
        return dao.ListarUsuarios();
    }
    
    public UsuarioDTO getUser(){
        return dao.getUser();
    }

}
