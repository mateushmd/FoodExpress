package com.foodexpress.web.servlet.minhaLoja.produtos;

import com.foodexpress.model.dto.CategoriaDTO;
import com.foodexpress.model.dto.ProdutoDTO;
import com.foodexpress.model.service.ProdutoService;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "editar-produto", urlPatterns = {"/minha-loja/produtos/editar-produto"})
public class editarProduto extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        boolean disponivel = Boolean.parseBoolean(request.getParameter("disponivel"));

        ProdutoService produtoService = ProdutoService.getInstance();

        ProdutoDTO produto = produtoService.getProdutoById(id);

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setDisponivel(disponivel);

        produtoService.editarProduto(produto);

        @SuppressWarnings("unchecked")
        ArrayList<CategoriaDTO> categorias = (ArrayList<CategoriaDTO>) session.getAttribute("categorias");

        for(CategoriaDTO categoria : categorias) {
            if(categoria.getId() == produto.getIdCategoria()) {
                for(ProdutoDTO p : categoria.getProdutos()) {
                    if(p.getId() == produto.getId()) {
                        p.setNome(produto.getNome());
                        p.setDescricao(produto.getDescricao());
                        p.setPreco(produto.getPreco());
                        p.setDisponivel(produto.getDisponivel());
                        break;
                    }
                }
                break;
            }
        }

        session.setAttribute("categorias", categorias);

        responseData.addProperty("responseType", "success");

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
