package com.foodexpress.model.encoder;

import java.security.SecureRandom;

public class TokenGenerator {
    private static final String TOKEN_CHARACTERS = "0123456789";
    private static final int TOKEN_LENGTH = 6;
    
    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder tokenBuilder = new StringBuilder(TOKEN_LENGTH);
        
        for(int i = 0; i < TOKEN_LENGTH; i++) {
            int randomIndex = secureRandom.nextInt(TOKEN_CHARACTERS.length());
            char randomChar = TOKEN_CHARACTERS.charAt(randomIndex);
            tokenBuilder.append(randomChar);
        }
        
        return tokenBuilder.toString();
    }
}
