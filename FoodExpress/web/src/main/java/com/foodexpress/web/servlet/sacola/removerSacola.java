package com.foodexpress.web.servlet.sacola;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.ItemSacolaService;
import com.foodexpress.model.service.LojaService;
import com.foodexpress.model.service.ProdutoService;
import com.foodexpress.model.service.SacolaService;
import com.foodexpress.model.util.JsonHandler;
import com.google.api.client.json.Json;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "remover-sacola", urlPatterns = {"/sacola/remover-sacola"})
public class removerSacola extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        SacolaViewDTO sacola = (SacolaViewDTO) session.getAttribute("sacola");

        int idItem = Integer.parseInt(request.getParameter("idItem"));

        ItemSacolaService itemSacolaService = ItemSacolaService.getInstance();

        itemSacolaService.removerItem(idItem);

        JsonObject responseData = new JsonObject();

        sacola.removerItem(idItem);
        responseData.addProperty("responseType", "remover");

        if(sacola.estaVazia()) {
            sacola = new SacolaViewDTO();
            responseData.addProperty("responseType", "esvaziar");
        } else {
            responseData = JsonHandler.addToJson(sacola, responseData);
        }

        session.setAttribute("sacola", sacola);

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
