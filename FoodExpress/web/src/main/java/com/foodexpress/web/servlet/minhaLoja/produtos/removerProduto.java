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

@WebServlet(name = "remover-produto", urlPatterns = {"/minha-loja/produtos/remover-produto"})
public class removerProduto extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));

        int id = Integer.parseInt(request.getParameter("id"));

        @SuppressWarnings("unchecked")
        ArrayList<CategoriaDTO> categorias = (ArrayList<CategoriaDTO>) session.getAttribute("categorias");

        ProdutoService produtoService = ProdutoService.getInstance();

        produtoService.removerProduto(id);

        boolean categoriaVazia = false;

        for(CategoriaDTO categoria : categorias) {
            if(categoria.getId() == idCategoria) {
                for(ProdutoDTO produto : categoria.getProdutos()) {
                    if(produto.getId() == id) {
                        categoria.removerProduto(produto);

                        if(categoria.getProdutos().isEmpty())
                            categoriaVazia = true;

                        break;
                    }
                }
                break;
            }
        }

        session.setAttribute("categorias", categorias);

        responseData.addProperty("responseType", "success");
        
        responseData.addProperty("categoriaVazia", categoriaVazia);

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
