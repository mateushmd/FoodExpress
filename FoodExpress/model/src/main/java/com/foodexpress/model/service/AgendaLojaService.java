package com.foodexpress.model.service;

import com.foodexpress.model.dao.AgendaLojaDAO;
import com.foodexpress.model.dto.AgendaLojaDTO;

import java.util.ArrayList;
import java.util.List;

public class AgendaLojaService {
    private static AgendaLojaService instance = null;
    
    private AgendaLojaDAO dao = AgendaLojaDAO.getInstance();
    
    public static AgendaLojaService getInstance(){
        if(instance == null)
            instance = new AgendaLojaService();
        
        return instance;
    }
    
    public boolean cadastrar(AgendaLojaDTO obj){
        return dao.cadastrar(obj);
    }
    
    public List<AgendaLojaDTO> getAgendas(){
        return dao.getAgendas();
    }
    
    public List<AgendaLojaDTO> getAgendasByLoja(int idLoja){
        ArrayList<AgendaLojaDTO> novaAgenda = (ArrayList<AgendaLojaDTO>) AgendaLojaDTO.gerarNovaAgenda();

        ArrayList<AgendaLojaDTO> agenda = (ArrayList<AgendaLojaDTO>) dao.getAgendasByLoja(idLoja);

        for(AgendaLojaDTO a : agenda) {
            int index = a.getDiaSemana() - 1;

            if(index >= 0 && index < novaAgenda.size()) {
                novaAgenda.set(index, a);
            }
        }

        return novaAgenda;
    }

    public List<AgendaLojaDTO> updateAgenda(int idLoja, List<AgendaLojaDTO> novaAgenda) {
        dao.resetarAgenda(idLoja);

        for(AgendaLojaDTO agenda : novaAgenda) {
            agenda.setIdLoja(idLoja);

            dao.cadastrar(agenda);
        }

        return dao.getAgendasByLoja(idLoja);
    }
    
    public List<AgendaLojaDTO> getAgendasByDiaSemana(String dia){
        return dao.getAgendasByDiaSemana(dia);
    }
    
    public List<AgendaLojaDTO> getAgendaCampus1(){
        return dao.getAgendaCampus1();
    }
    
    public List<AgendaLojaDTO> getAgendaCampus2(){
        return dao.getAgendaCampus2();
    }
    
    public boolean updateAbertura(AgendaLojaDTO ag, String ab){
        return dao.updateAbertura(ag, ab);
    }
    
    public boolean updateFechamento(AgendaLojaDTO ag, String fc){
        return dao.updateFechamento(ag, fc);
    }
    
    public boolean updateDiaSemana(AgendaLojaDTO ag, String dia){
        return dao.updateDiaSemana(ag, dia);
    }
    
    public boolean switchCampus1(AgendaLojaDTO ag){
        return dao.switchCampus1(ag);
    }
    
    public boolean switchCampus2(AgendaLojaDTO ag){
        return dao.switchCampus2(ag);
    }
}
