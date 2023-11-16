package com.foodexpress.model.service;

import com.foodexpress.model.dao.ProdutoDAO;
import com.foodexpress.model.dto.ProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private ProdutoDAO produtoDAO;

    public static ProdutoService instance = null;

    private ProdutoService() {
        produtoDAO = ProdutoDAO.getInstance();
    }

    public static ProdutoService getInstance() {
        if(instance == null)
            instance = new ProdutoService();

        return instance;
    }

    public boolean adicionarProduto(ProdutoDTO obj){
        return produtoDAO.cadastrar(obj);
    }

    public List<ProdutoDTO> listarProdutos(int idLoja) {
        return produtoDAO.listar(idLoja);
    }

    public boolean editarProduto(ProdutoDTO obj) {
        return produtoDAO.update(obj);
    }

    public ProdutoDTO getProdutoById(int id) {
        return produtoDAO.getProdutoById(id);
    }
}
