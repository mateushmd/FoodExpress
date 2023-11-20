package com.foodexpress.web.servlet.minhaLoja.categorias;

import com.foodexpress.model.dto.CategoriaDTO;
import com.foodexpress.model.service.CategoriaService;
import com.google.api.client.json.Json;
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

@WebServlet(name = "alterar-visibilidade-categoria", urlPatterns = {"/minha-loja/categorias/alterar-visibilidade-categoria"})
public class alterarVisibilidade extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        int id = Integer.parseInt(request.getParameter("id"));

        CategoriaService categoriaService = CategoriaService.getInstance();

        @SuppressWarnings("unchecked")
        ArrayList<CategoriaDTO> categorias = (ArrayList<CategoriaDTO>) session.getAttribute("categorias");

        for (CategoriaDTO categoria : categorias) {
            if (categoria.getId() == id) {
                categoria.setVisivel(!categoria.getVisivel());

                categoriaService.alterarVisibilidade(categoria.getId(), categoria.getVisivel());

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
