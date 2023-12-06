package com.foodexpress.model.service;

import com.foodexpress.model.dao.LojaDAO;
import com.foodexpress.model.dto.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LojaService {
    private final LojaDAO ldao;
    
    private static LojaService instance = null;

    private static AgendaLojaService agendaLojaService = null;
    
    private LojaService(){
        ldao = LojaDAO.getInstance();
        agendaLojaService = AgendaLojaService.getInstance();
    }
    
    public static LojaService getInstance(){
        if(instance == null)
            instance = new LojaService();
        
        return instance;
    }

    public LojaDTO getLoja(String idUsuario) {
        return ldao.getLoja(idUsuario);
    }

    public LojaDTO getLojaById(int idLoja) {
        LojaDTO loja = ldao.getLojaById(idLoja);

        loja.setAberto(estaAberto(idLoja));

        return loja;
    }

    public boolean estaAberto(int idLoja) {
        LocalDateTime now = LocalDateTime.now();

        DayOfWeek hoje = now.getDayOfWeek();

        AgendaLojaDTO agenda = agendaLojaService.getAgendaByLojaAndDia(idLoja, hoje.getValue());

        if(agenda == null)
            return false;

        LocalTime horaAtual = now.toLocalTime();

        return !horaAtual.isBefore(agenda.getAbertura().toLocalTime()) && !horaAtual.isAfter(agenda.getFechamento().toLocalTime());
    }

    public List<LojaDTO> buscarLoja(String busca) { return ldao.buscarLoja(busca); }

    public boolean updateNomeDescricao(int id, String nome, String descricao){
        return ldao.updateNomeDescricao(id, nome, descricao);
    }

    public boolean updateNome(int id, String nome) {
        return ldao.updateNome(id, nome);
    }
    
    public boolean updateAvaliacao(LojaDTO obj, int novaAvaliacao){
        obj.setQtdAvaliacoes(obj.getQtdAvaliacoes() + 1);
        
        obj.setSomaAvaliacoes(obj.getSomaAvaliacoes() + novaAvaliacao);
        
        obj.setAvaliacao((double) obj.getSomaAvaliacoes() / (double) obj.getQtdAvaliacoes());
        
        return ldao.updateAvaliacao(obj);
    }

    public boolean mudarAvaliacao(LojaDTO obj, int avaliacaoAntiga, int novaAvaliacao)
    {
        obj.setSomaAvaliacoes((obj.getSomaAvaliacoes() - avaliacaoAntiga) + novaAvaliacao);

        obj.setAvaliacao((double) obj.getSomaAvaliacoes() / (double) obj.getQtdAvaliacoes());

        return ldao.updateAvaliacao(obj);
    }

    public boolean removerAvaliacao(LojaDTO obj, int avaliacao)
    {
        obj.setSomaAvaliacoes(obj.getSomaAvaliacoes() - avaliacao);

        obj.setQtdAvaliacoes(obj.getQtdAvaliacoes() - 1);

        obj.setAvaliacao((double) obj.getSomaAvaliacoes() / (double) obj.getQtdAvaliacoes());

        return ldao.updateAvaliacao(obj);
    }
    
    public void cadastrar(String email){
        ldao.cadastrar(email);
    }

    public List<GrupoLojasDTO> agruparLojas() {
        List<GrupoLojasDTO> lista = new ArrayList<>();

        lista.add(getMaisBemAvaliados());

        GrupoLojasDTO grupo = getMaisRecentes();

        if(grupo != null)
            lista.add(grupo);

        return lista;
    }

    public List<LojaDTO> listarLojas(int callNumber) {
        int offSet = (callNumber - 1) * 8;

        ArrayList<LojaDTO> lojas = (ArrayList<LojaDTO>) ldao.listarLojas(offSet);

        for(LojaDTO loja : lojas) {
            loja.setAberto(estaAberto(loja.getId()));
        }

        return lojas;
    }

    public GrupoLojasDTO getMaisBemAvaliados() {
        ArrayList<LojaDTO> lojas = (ArrayList<LojaDTO>) ldao.getMaisBemAvaliadas();

        for(LojaDTO loja : lojas) {
            loja.setAberto(estaAberto(loja.getId()));
        }

        GrupoLojasDTO grupo = new GrupoLojasDTO("MAIS BEM AVALIADOS", lojas);

        return grupo;
    }

    public GrupoLojasDTO getMaisRecentes() {
        ArrayList<LojaDTO> lojas = (ArrayList<LojaDTO>) ldao.getMaisRecentes();

        if(lojas.isEmpty())
            return null;

        for(LojaDTO loja : lojas) {
            loja.setAberto(estaAberto(loja.getId()));
        }

        GrupoLojasDTO grupo = new GrupoLojasDTO("MAIS RECENTES", lojas);

        return grupo;
    }


    public boolean temMaisLojas(int quantidadeAtual) {
        return quantidadeAtual < ldao.getTotalLojas();
    }
}
