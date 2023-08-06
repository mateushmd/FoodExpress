/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.TokenVerificacaoDTO;
import com.foodexpress.model.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author chsdi
 */
@WebServlet(name = "validarEmail", urlPatterns = {"/validarEmail"})
public class validarEmail extends HttpServlet {

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
        
        response.setContentType("text/html;charset=UTF-8");
        
        UsuarioService uservice = UsuarioService.getInstance();
        
        TokenVerificacaoDTO tDTO = new TokenVerificacaoDTO();
        
        String[] tokenNumbers = request.getParameterValues("code");
        
        StringBuilder token = new StringBuilder();
        
        for(String value : tokenNumbers) {
            token.append(value);
        }
        
        tDTO.setEmailUsuario(request.getParameter("email"));
        tDTO.setToken(token.toString());
        
        boolean check = uservice.verificarEmail(tDTO);
        
        RequestDispatcher rd;
        
        if(!check) {
            request.setAttribute("msg", "Código inválido.");
            request.setAttribute("email", tDTO.getEmailUsuario());
            
            rd = request.getRequestDispatcher("verificacaoemail.jsp");
            rd.forward(request, response);
            
            return;
        }
        
        request.setAttribute("msg", "Email verificado e cadastro feito! Aproveite o nosso site!");
        
        rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
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
