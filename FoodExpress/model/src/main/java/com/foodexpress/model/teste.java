package com.foodexpress.model;
import com.foodexpress.model.dao.*;
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
        PontoEncontroDAO pe = PontoEncontroDAO.getInstance();
        PontoEncontroDTO p = new PontoEncontroDTO(24, "Hall p20");
        
        pe.cadastrar(p);
        
        List<PontoEncontroDTO> ls = pe.listarPontos();
        for(PontoEncontroDTO ps : ls)
            System.out.println(ps.getNome());
        
        ls = pe.getByLoja(24);
        for(PontoEncontroDTO ps : ls)
            System.out.println(ps.getNome());
    }
}