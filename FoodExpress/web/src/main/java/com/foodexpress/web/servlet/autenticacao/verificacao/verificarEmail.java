/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet.autenticacao.verificacao;

import com.foodexpress.model.dto.TokenVerificacaoDTO;
import com.foodexpress.model.service.AcessibilidadeService;
import com.foodexpress.model.service.TokenVerificacaoService;
import com.foodexpress.model.service.UsuarioService;
import com.google.gson.JsonObject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author chsdi
 */
@WebServlet(name = "verificar-email", urlPatterns = {"/verificar-email"})
public class verificarEmail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");

        JsonObject responseData = new JsonObject();

        HttpSession session = request.getSession();

        String email = (String) session.getAttribute("email");

        String token = request.getParameter("codigo");

        UsuarioService usuarioService = UsuarioService.getInstance();
        
        TokenVerificacaoDTO tDTO = new TokenVerificacaoDTO();

        tDTO.setEmailUsuario(email);
        tDTO.setToken(token);
        
        boolean check = usuarioService.updateVerificacao(tDTO);
        
        if(!check) {
            responseData.addProperty("responseType", "error");
            responseData.addProperty("message", "Código inválido.");

            response.getWriter().write(responseData.toString());

            return;
        }

        AcessibilidadeService aservice = AcessibilidadeService.getInstance();

        aservice.inserirConfiguracoes(email);
        
        responseData.addProperty("responseType", "redirect");
        responseData.addProperty("redirect", "login.jsp");

        session.removeAttribute("email");

        response.getWriter().write(responseData.toString());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
