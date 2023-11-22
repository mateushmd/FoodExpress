package com.foodexpress.web.servlet.minhaLoja.produtos;

import com.foodexpress.model.dao.CategoriaDAO;
import com.foodexpress.model.dto.CategoriaDTO;
import com.foodexpress.model.dto.LojaDTO;
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

@WebServlet(name = "adicionar-produto", urlPatterns = {"/minha-loja/produtos/adicionar-produto"})
public class adicionarProduto extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));

        @SuppressWarnings("unchecked")
        ArrayList<CategoriaDTO> categorias = (ArrayList<CategoriaDTO>) session.getAttribute("categorias");

        LojaDTO loja = (LojaDTO) session.getAttribute("loja");

        ProdutoService produtoService = ProdutoService.getInstance();

        ProdutoDTO novoProduto = produtoService.adicionarProduto(loja.getId(), idCategoria);

        for(CategoriaDTO categoria : categorias) {
            if(categoria.getId() == idCategoria) {
                categoria.addProduto(novoProduto);
                break;
            }
        }

        session.setAttribute("categorias", categorias);

        responseData.addProperty("responseType", "success");
        responseData.addProperty("id", novoProduto.getId());

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
