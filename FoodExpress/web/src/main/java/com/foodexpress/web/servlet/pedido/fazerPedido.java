package com.foodexpress.web.servlet.pedido;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.*;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "fazer-pedido", urlPatterns = {"/pedidos/fazer-pedido"})
public class fazerPedido extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        String localEntrega = request.getParameter("localEntrega");

        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

        SacolaViewDTO sacola = (SacolaViewDTO) session.getAttribute("sacola");

        LojaService lojaService = LojaService.getInstance();
        LojaDTO loja = lojaService.getLojaById(sacola.getIdLoja());

        UsuarioService usuarioService = UsuarioService.getInstance();
        String telefone = usuarioService.getTelefone(loja.getIdUser());

        if(sacola.getIdLoja() == -1 || sacola.estaVazia()) {
            responseData.addProperty("responseType", "cancel");
            response.getWriter().write(responseData.toString());
        }

        StringBuilder pedidoText = new StringBuilder();

        pedidoText.append("Olá, este é o meu pedido:\n\n");

        ArrayList<ItemPedidoDTO> itens = new ArrayList<>();

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        for(ItemSacolaViewDTO item : sacola.getItens()) {
            pedidoText.append(item.getQuantidade())
                    .append("x ")
                    .append(item.getProdutoNome())
                    .append(" (R$ ")
                    .append(decimalFormat.format(item.getPrecoTotal())
                            .replace(".", ","))
                    .append(")\n");

            itens.add(new ItemPedidoDTO(item.getProdutoId(), item.getQuantidade(), item.getPrecoTotal()));
        }

        pedidoText.append("\nTotal: R$ ")
                .append(decimalFormat.format(sacola.getTotal())
                        .replace(".", ","))
                .append("\n\nLocal de entrega: ")
                .append(localEntrega);

        PedidoDTO pedido = new PedidoDTO(sacola.getIdLoja(), usuario.getEmail(), localEntrega, sacola.getTotal(), itens);

        PedidoService pedidoService = PedidoService.getInstance();
        pedidoService.realizarPedido(pedido);

        responseData.addProperty("responseType", "success");

        ItemSacolaService itemSacolaService = ItemSacolaService.getInstance();
        itemSacolaService.limparSacola(usuario.getEmail());

        session.setAttribute("sacola", new SacolaViewDTO());

        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(telefone);

        telefone = matcher.replaceAll("");

        responseData.addProperty("numero", telefone);
        responseData.addProperty("pedido", pedidoText.toString());

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
