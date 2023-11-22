package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

@WebServlet(name = "loja", urlPatterns = {"/loja"})
public class loja extends HttpServlet {

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

        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));

        UsuarioDTO usuario = ((UsuarioDTO) session.getAttribute("usuario"));
        
        LojaService lService = LojaService.getInstance();
        LojaDTO loja = lService.getLojaById(id);

        CategoriaService categoriaService = CategoriaService.getInstance();
        ArrayList<CategoriaDTO> categorias = (ArrayList<CategoriaDTO>) categoriaService.listarCliente(loja.getId());

        ProdutoService produtoService = ProdutoService.getInstance();
        ArrayList<ProdutoDTO> destaques = (ArrayList<ProdutoDTO>) produtoService.getProdutosDestaqueCliente(loja.getId());

        AvaliacaoService avaliacaoService = AvaliacaoService.getInstance();
        ArrayList<AvaliacaoDTO> avaliacoes = (ArrayList<AvaliacaoDTO>) avaliacaoService.getAvaliacaoByIdLoja(loja.getId());
        AvaliacaoDTO avaliacaoUsuario = avaliacaoService.getAvaliacaoByIdLojaCliente(loja.getId(), usuario.getEmail());

        FavoritosService favoritosService = FavoritosService.getInstance();
        boolean favorito = favoritosService.checkFavorito(usuario.getEmail(), loja.getId());
        
        request.setAttribute("loja", loja);
        request.setAttribute("categorias", categorias);
        request.setAttribute("destaques", destaques);
        request.setAttribute("avaliacoes", avaliacoes);
        request.setAttribute("avaliacaoUsuario", avaliacaoUsuario);
        request.setAttribute("favorito", favorito);
        
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
