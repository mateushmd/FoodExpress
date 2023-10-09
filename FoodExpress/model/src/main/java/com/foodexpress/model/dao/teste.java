package com.foodexpress.model.dao;
import com.foodexpress.model.dto.*;
import com.foodexpress.model.email.EmailUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) throws SQLException {
        EmailUtil.sendEmailVerificacao(new TokenVerificacaoDTO("chenri48155@gmail.com", "123456"));
    }
}