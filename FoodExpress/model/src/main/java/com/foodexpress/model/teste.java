package com.foodexpress.model;
import com.foodexpress.model.dao.*;
import com.foodexpress.model.dto.*;
import com.foodexpress.model.email.EmailUtil;
import com.foodexpress.model.service.*;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) throws SQLException {
        AgendaLojaService ag = AgendaLojaService.getInstance();
        AgendaLojaDTO agt = new AgendaLojaDTO(24, "Segunda", "12:00:00", "16:20:00", false, true);
        if(ag.switchCampus1(agt))
            System.out.println("Alterou campus 1");
        if(ag.switchCampus2(agt))
            System.out.println("Alterou campus 2");
    }
}