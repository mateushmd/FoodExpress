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

    private final UsuarioDAO dao;

    private final TokenVerificacaoService tokenVerificacaoService;
    
    private static UsuarioService instance = null;
    
    private UsuarioService() {
        dao = UsuarioDAO.getInstance();
        tokenVerificacaoService = TokenVerificacaoService.getInstance();
    }
    
    public static UsuarioService getInstance() {
        if(instance == null)
            instance = new UsuarioService();
        
        return instance;
    }
    
    public int login(String email, String senha) {
        return dao.login(email, senha);
    }
    
    public boolean alterarDados(String email, String novoNome, String novoTelefone) {
        return dao.alterarDados(email, novoNome, novoTelefone);
    }

    public UsuarioDTO getUsuario(String email) {
        return dao.getUsuario(email);
    }

    public int getTipoUsuario(String email) { return dao.getTipoUsuario(email); }

    public int cadastrar(UsuarioDTO obj) {
        int test = dao.cadastrar(obj);

        if(test == 0)
            return test;

        if(test == -1) {
            tokenVerificacaoService.removerToken(obj.getEmail());

            dao.removerUsuario(obj.getEmail());

            return cadastrar(obj);
        }
        
        tokenVerificacaoService.addToken(obj.getEmail());

        return test;
    }
    
    public boolean redefinirSenha(String email, String senha) {
        return dao.redefinirSenha(email, senha);
    }
    
    public boolean abrirLoja(String email) {
        return dao.abrirLoja(email);
    }

    public List<UsuarioDTO> ListarUsuario() throws SQLException {
        return dao.ListarUsuarios();
    }

    public boolean updateVerificacao(TokenVerificacaoDTO tDTO) {
        boolean check = tokenVerificacaoService.validarToken(tDTO);

        if(!check)
            return false;

        return dao.updateVerificacao(tDTO.getEmailUsuario());
    }
}
