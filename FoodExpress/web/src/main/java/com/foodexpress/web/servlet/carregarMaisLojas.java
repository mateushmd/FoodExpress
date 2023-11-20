package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.service.LojaService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "carregar-mais-lojas", urlPatterns = {"/carregar-mais-lojas"})
public class carregarMaisLojas extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        int callNumber = Integer.parseInt(request.getParameter("callNumber"));

        LojaService lojaService = LojaService.getInstance();

        ArrayList<LojaDTO> lojas = (ArrayList<LojaDTO>) lojaService.listarLojas(callNumber);

        Gson gson = new Gson();

        String responseData = gson.toJson(lojas);

        response.getWriter().write(responseData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
