package com.foodexpress.web.servlet.vendedor;

import com.foodexpress.model.dto.CategoriaDTO;
import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.service.CategoriaService;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "adicionar-categoria", urlPatterns = {"/adicionar-categoria"})
public class adicionarCategoria extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        LojaDTO loja = (LojaDTO) session.getAttribute("loja");

        JsonObject responseData = new JsonObject();

        CategoriaService categoriaService = CategoriaService.getInstance();

        CategoriaDTO categoria = categoriaService.novaCategoria(loja.getId());

        @SuppressWarnings({"Unchecked", "unchecked"})
        ArrayList<CategoriaDTO> categorias = (ArrayList<CategoriaDTO>) session.getAttribute("categorias");
        categorias.add(categoria);

        session.setAttribute("categorias", categorias);

        responseData.addProperty("responseType", "success");
        responseData.addProperty("id", categoria.getId());

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
