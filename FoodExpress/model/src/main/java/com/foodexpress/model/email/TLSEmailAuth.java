package com.foodexpress.model.email;

import java.util.Properties;
import javax.mail.*;

@Deprecated
public class TLSEmailAuth {

    private static final String CLIENT_ID = "294719564927-lgmm5s7ta6m429orn19th8d1usksshv7.apps.googleusercontent.com";
    private static final String PASSWORD = "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";

    private static Session SESSION = null;

    protected static Session getSession() {
        if(SESSION == null) {
            Properties props = new Properties();

            props.put("mail.imap.ssl.enable", "true");
            props.put("mail.imap.auth.mechanisms", "XOAUTH2");

            SESSION = Session.getInstance(props);

            try {
                Store store = SESSION.getStore("imap");
                store.connect("imap.gmail.com", CLIENT_ID, PASSWORD);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
        
        return SESSION;
    }
}
