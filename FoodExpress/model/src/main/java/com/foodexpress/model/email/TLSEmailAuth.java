package com.foodexpress.model.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSEmailAuth {

    private static final String EMAIL = "equipefoodexpress@gmail.com";
    private static final String PASSWORD = "dwqszhkyydzxctqn";
    
    private static Session SESSION = null;

    protected static Session getSession() {
        if(SESSION == null) {
            Properties props = new Properties();
        
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL, PASSWORD);
                }
            };

            SESSION =  Session.getInstance(props, auth);
        }
        
        return SESSION;
    }
}
