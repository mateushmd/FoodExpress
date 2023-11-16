package com.foodexpress.model.service;

import com.foodexpress.model.dao.CategoriaDAO;
import com.foodexpress.model.dto.CategoriaDTO;
import com.foodexpress.model.dto.ProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoriaService {
    private CategoriaDAO dao;

    private ProdutoService produtoService;

    public static CategoriaService instance = null;

    private CategoriaService() {
        dao = CategoriaDAO.getInstance();
        produtoService = ProdutoService.getInstance();
    }


    public static CategoriaService getInstance() {
        if(instance == null)
            instance = new CategoriaService();

        return instance;
    }

    public boolean inserir(CategoriaDTO obj) {
        return dao.inserir(obj);
    }

    public CategoriaDTO novaCategoria(int idLoja) {
        CategoriaDTO categoria = new CategoriaDTO(idLoja, "Nova categoria");

        if(!inserir(categoria))
            return null;

        categoria = dao.getUltimaCategoria();

        return categoria;
    }

    public boolean excluir(int id) {
        return dao.excluir(id);
    }

    public List<CategoriaDTO> listar(int idLoja) {
        return dao.listar(idLoja);
    }

    public List<CategoriaDTO> listarCompleto(int idLoja) {
        List<CategoriaDTO> lista = listar(idLoja);

        if(lista == null)
            return new ArrayList<CategoriaDTO>();

        for(CategoriaDTO dto : lista) {
            dto.setProdutos((ArrayList<ProdutoDTO>) produtoService.getProdutosByCategoria(dto.getId()));
        }

        return lista;
    }
}
