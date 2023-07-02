package com.foodexpress.model.dto;


public class TokenVerificacaoDTO {
    private String emailUsuario;
    private String token;
    
    public TokenVerificacaoDTO(String emailUsuario, String token) {
        this.emailUsuario = emailUsuario;
        this.token = token;
    }
    
    public TokenVerificacaoDTO() {}

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
