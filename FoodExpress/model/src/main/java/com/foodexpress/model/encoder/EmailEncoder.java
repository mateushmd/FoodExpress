package com.foodexpress.model.encoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class EmailEncoder {

    private static final String DES_ALGORITHM = "DES";
    
    private static final String KEY = "asd151w2";

    private static EmailEncoder self = null;

    private EmailEncoder() {}

    public static EmailEncoder getEncoder() {
        if (self == null) {
            self = new EmailEncoder();
        }

        return self;
    }

    public String encode(String target) {
        byte[] encryptedBytes = null;
        
        try {
            DESKeySpec keySpec = new DESKeySpec(KEY.getBytes(StandardCharsets.UTF_8));
            
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
            SecretKey key = keyFactory.generateSecret(keySpec);
            
            Cipher cipher = Cipher.getInstance(DES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            
            encryptedBytes = cipher.doFinal(target.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            Logger.getLogger(EmailEncoder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(encryptedBytes == null)
                return null;
            
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }
    }

    public String decode(String encryptedEmail) {
        byte[] decryptedBytes = null;
        
        try {
            DESKeySpec keySpec = new DESKeySpec(KEY.getBytes(StandardCharsets.UTF_8));
            
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
            SecretKey key = keyFactory.generateSecret(keySpec);
            
            Cipher cipher = Cipher.getInstance(DES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedEmail);
            
            decryptedBytes = cipher.doFinal(encryptedBytes);    
        } catch (Exception ex) {
            Logger.getLogger(EmailEncoder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(decryptedBytes == null)
                return null;
            
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        }
    }
}
