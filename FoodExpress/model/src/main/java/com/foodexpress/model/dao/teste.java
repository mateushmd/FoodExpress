package com.foodexpress.model.dao;
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
        AcessibilidadeService acessibilidadeService = AcessibilidadeService.getInstance();

        AcessibilidadeDTO a = acessibilidadeService.getConfiguracoes("chenri48155@gmail.com");

        System.out.println(a.getTemaEscuro());
        System.out.println(a.getContraste());
        System.out.println(a.getVisibilidadeTexto());
        System.out.println(a.getTamanhoTexto());
    }
}