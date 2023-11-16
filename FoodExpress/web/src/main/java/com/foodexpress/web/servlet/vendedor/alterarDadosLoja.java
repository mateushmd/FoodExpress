/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet.vendedor;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.*;
import com.google.gson.JsonObject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "alterar-dados-loja", urlPatterns = {"/alterar-dados-loja"})
public class alterarDadosLoja extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        LojaDTO loja = (LojaDTO) session.getAttribute("loja");

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");

        LojaService lojaService = LojaService.getInstance();

        lojaService.updateNomeDescricao(loja.getId(), nome, descricao);

        loja.setNome(nome);
        loja.setDescricao(descricao);

        session.setAttribute("loja", loja);

        responseData.addProperty("responseType", "success");

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
