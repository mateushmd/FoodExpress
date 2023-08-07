/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.LojaService;
import com.foodexpress.model.service.UsuarioService;
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

        System.out.println("passei pelo login");

        UsuarioService uservice = UsuarioService.getInstance();
        UsuarioDTO uDTO;

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        int check = uservice.login(email, password);

        RequestDispatcher rd = null;

        if(check < 1) {
            if(check == 0)
                request.setAttribute("msg", "O email associado a esta conta não foi verificado.");
            else 
                request.setAttribute("msg", "Email ou senha incorretos.");

            rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);

            return;
        }
        
        uDTO = uservice.getUsuario(email);
        
        LojaService lservice = LojaService.getInstance();
        
        LojaDTO lDTO = null;
        
        if(uDTO.getTipo() == 2) {
            lDTO = lservice.getLoja(uDTO.getEmail());
        }
        
        HttpSession session = request.getSession();
        
        session.setAttribute("usuario", uDTO);
        session.setAttribute("loja", lDTO);

        rd = request.getRequestDispatcher("menuprincipal.jsp");
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
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
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
