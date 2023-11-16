package com.foodexpress.model.service;

import com.foodexpress.model.dao.TokenVerificacaoDAO;
import com.foodexpress.model.dto.TokenVerificacaoDTO;

public class TokenVerificacaoService {
    private TokenVerificacaoDAO dao;

    private UsuarioService usuarioService;

    private static TokenVerificacaoService instance = null;

    private TokenVerificacaoService() {
        dao = TokenVerificacaoDAO.getInstance();
    };

    public static TokenVerificacaoService getInstance() {
        if(instance == null)
            instance = new TokenVerificacaoService();

        return instance;
    }

    protected boolean validarToken(TokenVerificacaoDTO obj) {
        return dao.validateToken(obj);
    }

    protected boolean addToken(String email) {
        return dao.addToken(email);
    }

    protected boolean removerToken(String email) {
        return dao.delete(email);
    }

    public boolean reenviarToken(String email) {
        boolean check = removerToken(email);

        if(!check)
            return false;

        return addToken(email);
    }
}
