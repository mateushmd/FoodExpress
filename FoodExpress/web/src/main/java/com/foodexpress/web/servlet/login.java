/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.AcessibilidadeService;
import com.foodexpress.model.service.ItemSacolaService;
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
import java.util.ArrayList;
import java.util.Objects;

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

        UsuarioService uService = UsuarioService.getInstance();
        UsuarioDTO uDTO;

        ItemSacolaService iService = ItemSacolaService.getInstance();
        ArrayList<ItemSacolaViewDTO> lista;
        ArrayList<ItemSacolaViewDTO> itensSacola;

        AcessibilidadeService aService = AcessibilidadeService.getInstance();
        AcessibilidadeDTO aDTO;

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        int check = uService.login(email, password);

        String URL = "common?url=";

        if(check < 1) {
            String msg;
            
            if(check == 0)
                msg = "O email associado a esta conta não foi verificado.";
            else 
                msg = "Email ou senha incorretos.";
            
            URL += "login&action=RD&attrName=msg&attrValue=" + msg;
            
            response.sendRedirect(URL);
            
            return;
        }
        
        URL += "menuPrincipal&action=F";
        
        uDTO = uService.getUsuario(email);

        lista = (ArrayList<ItemSacolaViewDTO>) iService.getItensView(uDTO.getEmail());

        itensSacola = Objects.requireNonNullElseGet(lista, ArrayList::new);

        aDTO = aService.getConfiguracoes(email);
        
        LojaService lservice = LojaService.getInstance();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("usuario", uDTO);

        if(itensSacola.isEmpty()) {
            session.setAttribute("sacola", new SacolaViewDTO());
        } else {
            ProdutoDTO produto = lservice.getProdutoById(itensSacola.get(0).getProdutoId());
            LojaDTO loja = lservice.getLojaById(produto.getIdLoja());

            session.setAttribute("sacola", new SacolaViewDTO(loja.getId(), loja.getNome(), itensSacola));
        }

        session.setAttribute("acessibilidade", aDTO);
        
        if(uDTO.getTipo() == 2) {
            LojaDTO lDTO = lservice.getLoja(uDTO.getEmail());
            
            session.setAttribute("loja", lDTO);
            
            ArrayList<ProdutoDTO> produtos = lservice.listarProdutos(lDTO.getId());
            
            session.setAttribute("produtos", produtos);
        }
        
        response.sendRedirect(URL);
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
