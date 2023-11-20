package com.foodexpress.web.servlet.minhaLoja.categorias;

import com.foodexpress.model.dto.CategoriaDTO;
import com.foodexpress.model.service.CategoriaService;
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
import java.util.Iterator;

@WebServlet(name = "remover-categoria", urlPatterns = {"/minha-loja/categorias/remover-categoria"})
public class removerCategoria extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        int id = Integer.parseInt(request.getParameter("id"));

        ProdutoService produtoService = ProdutoService.getInstance();

        produtoService.removerByCategoria(id);

        CategoriaService categoriaService = CategoriaService.getInstance();

        categoriaService.remover(id);

        @SuppressWarnings("unchecked")
        ArrayList<CategoriaDTO> categorias = (ArrayList<CategoriaDTO>) session.getAttribute("categorias");

        for(CategoriaDTO categoria : categorias) {
            if(categoria.getId() == id) {
                categorias.remove(categoria);
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
