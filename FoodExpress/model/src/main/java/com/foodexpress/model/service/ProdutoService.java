package com.foodexpress.model.service;

import com.foodexpress.model.dao.ProdutoDAO;
import com.foodexpress.model.dto.ProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private ProdutoDAO produtoDAO;

    private static ProdutoService instance = null;

    private ProdutoService() {
        produtoDAO = ProdutoDAO.getInstance();
    }

    public static ProdutoService getInstance() {
        if(instance == null)
            instance = new ProdutoService();

        return instance;
    }

    public ProdutoDTO adicionarProduto(int idLoja, int idCategoria){
        ProdutoDTO produto = new ProdutoDTO(idLoja, idCategoria);

        boolean check = produtoDAO.cadastrar(produto);

        if(!check)
            return null;

        return produtoDAO.getUltimoProduto();
    }

    public List<ProdutoDTO> listarProdutos(int idLoja) {
        return produtoDAO.listar(idLoja);
    }

    public boolean editarProduto(ProdutoDTO obj) {
        return produtoDAO.update(obj);
    }

    public boolean removerProduto(int id) { return produtoDAO.remover(id); };

    public boolean removerByCategoria(int idCategoria) { return produtoDAO.removerByCategoria(idCategoria); }

    public ProdutoDTO getProdutoById(int id) {
        return produtoDAO.getProdutoById(id);
    }

    public List<ProdutoDTO> getProdutosByCategoria(int idCategoria) { return produtoDAO.getProdutosByCategoria(idCategoria); }

    public List<ProdutoDTO> getProdutosByCategoriaCliente(int idCategoria) { return produtoDAO.getProdutosByCategoriaCliente(idCategoria); }

    public List<ProdutoDTO> getProdutosDestaqueCliente(int idLoja) { return produtoDAO.getProdutosDestacadosCliente(idLoja); }
}
