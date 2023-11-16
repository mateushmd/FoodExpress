/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet.autenticacao;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.*;
import com.google.api.client.json.Json;
import com.google.gson.JsonObject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        JsonObject responseData = new JsonObject();

        HttpSession session = request.getSession();

        UsuarioService usuarioService = UsuarioService.getInstance();
        UsuarioDTO usuario;

        String email = request.getParameter("email");

        int check = usuarioService.login(email, request.getParameter("password"));

        switch(check) {
            case -1:
                responseData.addProperty("responseType", "error");
                break;
            case 0:
                responseData.addProperty("responseType", "redirect");
                responseData.addProperty("redirect", "cadastro.html");
                break;
            case 1:
                responseData.addProperty("responseType", "redirect");
                responseData.addProperty("redirect", "inicio");
                break;
        }

        if(check < 1) {
            response.getWriter().write(responseData.toString());
            return;
        }

        usuario = usuarioService.getUsuario(email);

        SacolaService sacolaService = SacolaService.getInstance();
        SacolaViewDTO sacola;

        AcessibilidadeService acessibilidadeService = AcessibilidadeService.getInstance();
        AcessibilidadeDTO acessibilidade;

        sacola = sacolaService.getSacola(usuario.getEmail());

        acessibilidade = acessibilidadeService.getConfiguracoes(email);

        session.setAttribute("usuario", usuario);

        session.setAttribute("sacola", sacola);

        session.setAttribute("acessibilidade", acessibilidade);

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
