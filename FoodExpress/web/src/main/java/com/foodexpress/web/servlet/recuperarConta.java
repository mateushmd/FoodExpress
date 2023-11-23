package com.foodexpress.web.servlet;

import com.foodexpress.model.service.TokenVerificacaoService;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "recuperar-conta", urlPatterns = {"/recuperar-conta"})
public class recuperarConta extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        String email = request.getParameter("email");

        session.setAttribute("email", email);

        TokenVerificacaoService tokenVerificacaoService = TokenVerificacaoService.getInstance();

        tokenVerificacaoService.removerToken(email);

        tokenVerificacaoService.addToken(email);

        responseData.addProperty("responseType", "redirect");

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
