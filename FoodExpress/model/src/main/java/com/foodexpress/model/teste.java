package com.foodexpress.model;
import com.foodexpress.model.dao.FavoritosDAO;
import com.foodexpress.model.dto.*;
import com.foodexpress.model.email.EmailUtil;
import com.foodexpress.model.service.AcessibilidadeService;
import com.foodexpress.model.service.AvaliacaoService;
import com.foodexpress.model.service.UsuarioService;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) throws SQLException {
        EmailUtil.sendEmailVerificacao(new TokenVerificacaoDTO("chenri48155@gmail.com", "123456"));
    }
}