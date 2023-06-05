package com.foodexpress.model.dao;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;


class PasswordEncoder {
    private Argon2PasswordEncoder encoder;
    
    private PasswordEncoder() {
        encoder = new Argon2PasswordEncoder(32, 64, 1, 15 * 1024, 2);
    }
    
    protected static PasswordEncoder createEncoder() {
        return new PasswordEncoder();
    }
    
    protected String encode(String password) {
        String encoded = encoder.encode(password);
        
        return encoded;
    }
    
    protected boolean check(String password, String encoded) {
        return encoder.matches(password, encoded);
    }
}
