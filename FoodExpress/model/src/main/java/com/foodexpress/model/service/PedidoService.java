package com.foodexpress.model.service;

import com.foodexpress.model.dao.ItemPedidoDAO;
import com.foodexpress.model.dao.ItemPedidoViewDAO;
import com.foodexpress.model.dao.PedidoDAO;
import com.foodexpress.model.dto.ItemPedidoDTO;
import com.foodexpress.model.dto.PedidoDTO;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private final PedidoDAO pedidoDAO;

    private final ItemPedidoDAO itemPedidoDAO;

    private final ItemPedidoViewDAO itemPedidoViewDAO;

    private static PedidoService instance = null;

    private PedidoService() {
        pedidoDAO = PedidoDAO.getInstance();
        itemPedidoDAO = ItemPedidoDAO.getInstance();
        itemPedidoViewDAO = ItemPedidoViewDAO.getInstance();
    }

    public static PedidoService getInstance() {
        if(instance == null)
            instance = new PedidoService();

        return instance;
    }

    public boolean realizarPedido(PedidoDTO pedido) {
        pedidoDAO.realizarPedido(pedido);

        int id = pedidoDAO.getPedidoId();

        if(id == -1)
            return false;

        itemPedidoDAO.addItens(pedido.getProdutos(), id);

        return true;
    }

    public List<PedidoDTO> getPedidosCliente(String idCliente) {
        ArrayList<PedidoDTO> pedidos = (ArrayList<PedidoDTO>) pedidoDAO.getPedidoByIdCliente(idCliente);

        for(PedidoDTO pedido : pedidos) {
            ArrayList<ItemPedidoDTO> produtos = (ArrayList<ItemPedidoDTO>) itemPedidoViewDAO.getItensView(pedido.getId());
            pedido.setProdutos(produtos);
        }

        return pedidos;
    }

    public List<PedidoDTO> getPedidosLoja(int idLoja) {
        ArrayList<PedidoDTO> pedidos = (ArrayList<PedidoDTO>) pedidoDAO.getPedidoByIdLoja(idLoja);

        if(pedidos == null)
            return null;

        for(PedidoDTO pedido : pedidos) {
            ArrayList<ItemPedidoDTO> produtos = (ArrayList<ItemPedidoDTO>) itemPedidoViewDAO.getItensView(pedido.getId());
            pedido.setProdutos(produtos);
        }

        return pedidos;
    }
}
