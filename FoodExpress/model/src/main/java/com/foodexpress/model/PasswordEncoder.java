package com.foodexpress.model;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;


public class PasswordEncoder {
    private Argon2PasswordEncoder encoder;
    
    private static PasswordEncoder self = null;
    
    private PasswordEncoder() {
        encoder = new Argon2PasswordEncoder(32, 64, 1, 15 * 1024, 2);
    }
    
    public static PasswordEncoder getEncoder() {
        if(self == null)
            self = new PasswordEncoder();
        
        return self;
    }
    
    public String encode(String target) {
        String encoded = encoder.encode(target);
        
        return encoded;
    }
    
    public boolean check(String password, String encoded) {
        return encoder.matches(password, encoded);
    }
}
