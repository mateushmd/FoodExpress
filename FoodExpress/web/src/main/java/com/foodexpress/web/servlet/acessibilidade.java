package com.foodexpress.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.foodexpress.model.dto.AcessibilidadeDTO;
import com.foodexpress.model.service.AcessibilidadeService;
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
@WebServlet(name = "acessibilidade", urlPatterns = {"/acessibilidade"})
public class acessibilidade extends HttpServlet {

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

        HttpSession session = request.getSession();

        AcessibilidadeService aservice = AcessibilidadeService.getInstance();

        AcessibilidadeDTO aDTO = (AcessibilidadeDTO) session.getAttribute("acessibilidade");

        boolean temaEscuro = request.getParameter("tema") != null;
        boolean contraste = request.getParameter("contraste") != null;
        boolean visibilidadeTexto = request.getParameter("visibilidade") != null;
        int tamanhoTexto = Integer.parseInt(request.getParameter("tamanho"));

        aDTO.setTemaEscuro(temaEscuro);
        aDTO.setContraste(contraste);
        aDTO.setVisibilidadeTexto(visibilidadeTexto);
        aDTO.setTamanhoTexto(tamanhoTexto);

        aservice.atualizarConfiguracoes(aDTO);

        session.setAttribute("acessibilidade", aDTO);

        response.sendRedirect("acessibilidade.jsp");
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
