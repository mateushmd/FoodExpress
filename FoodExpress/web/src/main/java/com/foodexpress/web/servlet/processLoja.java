package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.AvaliacaoDTO;
import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.dto.ProdutoDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.AvaliacaoService;
import com.foodexpress.model.service.LojaService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

@WebServlet(name = "processLoja", urlPatterns = {"/processLoja"})
public class processLoja extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println(id);
        
        LojaService lservice = LojaService.getInstance();
        
        AvaliacaoService aService = AvaliacaoService.getInstance();
        
        HttpSession session = request.getSession();
        
        LojaDTO loja = lservice.getLojaById(id);
        
        ArrayList<ProdutoDTO> produtos = lservice.listarProdutos(loja.getId());
        
        ArrayList<AvaliacaoDTO> avaliacoes = (ArrayList<AvaliacaoDTO>) aService.getAvaliacaoByIdLoja(loja.getId());
        
        AvaliacaoDTO avaliacaoUsuario = aService.getAvaliacaoByIdLojaCliente(loja.getId(), ((UsuarioDTO) session.getAttribute("usuario")).getEmail());
        
        request.setAttribute("loja", loja);
        request.setAttribute("produtos", produtos);
        request.setAttribute("avaliacoes", avaliacoes);
        request.setAttribute("avaliacaoUsuario", avaliacaoUsuario);
        
        RequestDispatcher rd = request.getRequestDispatcher("loja.jsp");
        
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
