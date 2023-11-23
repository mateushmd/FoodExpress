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
import java.util.ArrayList;

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

                response.getWriter().write(responseData.toString());
                return;
            case 0:
                TokenVerificacaoService tokenVerificacaoService = TokenVerificacaoService.getInstance();

                session.setAttribute("email", email);

                tokenVerificacaoService.reenviarToken(email);

                responseData.addProperty("responseType", "redirect");
                responseData.addProperty("redirect", "verificacao.jsp");

                response.getWriter().write(responseData.toString());
                return;
            case 1:
                usuario = usuarioService.getUsuario(email);

                session.setAttribute("usuario", usuario);

                if(usuario.getTipo() == 1) {
                    SacolaService sacolaService = SacolaService.getInstance();
                    SacolaViewDTO sacola;

                    AcessibilidadeService acessibilidadeService = AcessibilidadeService.getInstance();
                    AcessibilidadeDTO acessibilidade;

                    sacola = sacolaService.getSacola(usuario.getEmail());

                    PontoEncontroService pontoEncontroService = PontoEncontroService.getInstance();
                    ArrayList<PontoEncontroDTO> pontos = (ArrayList<PontoEncontroDTO>) pontoEncontroService.getCliente(sacola.getIdLoja());

                    sacola.setPontos(pontos);

                    acessibilidade = acessibilidadeService.getConfiguracoes(email);

                    session.setAttribute("sacola", sacola);

                    session.setAttribute("acessibilidade", acessibilidade);
                }

                responseData.addProperty("responseType", "redirect");
                responseData.addProperty("redirect", usuario.getTipo() == 1 ? "inicio" : "carregar-loja");

                break;
        }

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
