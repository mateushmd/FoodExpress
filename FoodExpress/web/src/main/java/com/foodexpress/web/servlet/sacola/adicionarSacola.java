package com.foodexpress.web.servlet.sacola;

import com.foodexpress.model.dto.ItemSacolaDTO;
import com.foodexpress.model.dto.ItemSacolaViewDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.ItemSacolaService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "adicionar-sacola", urlPatterns = {"/sacola/adicionar-sacola"})
public class adicionarSacola extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        String idCliente = ((UsuarioDTO) session.getAttribute("usuario")).getEmail();

        int idProduto = Integer.parseInt(request.getParameter("idProduto"));

        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        double precoItem = Double.parseDouble(request.getParameter("precoItem"));

        double precoTotal = Double.parseDouble(request.getParameter("precoTotal"));

        ItemSacolaDTO item = new ItemSacolaDTO();
        item.setIdUsuario(idCliente);
        item.setIdProduto(idProduto);
        item.setQuantidade(quantidade);
        item.setPrecoItem(precoItem);
        item.setPrecoTotal(precoTotal);

        ItemSacolaService iService = ItemSacolaService.getInstance();

        Object sacolaSessionObject = session.getAttribute("sacola");

        if(!(sacolaSessionObject instanceof List))
            Logger.getAnonymousLogger().warning("'sacola' não é do tipo List");

        List<ItemSacolaViewDTO> sacola;

        sacola = (List<ItemSacolaViewDTO>) sacolaSessionObject;

        iService.addItem(item);

        ItemSacolaViewDTO itemAdicionado = iService.getNovoItens(idCliente, sacola).get(0);

        sacola.add(itemAdicionado);

        session.setAttribute("sacola", sacola);

        Gson gson = new Gson();

        String jsonData = gson.toJson(itemAdicionado);

        response.setContentType("application/json");

        response.getWriter().write(jsonData);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
