/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.dao;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
    
    /**
     * Envia um email para algum endereço
     * @param session
     * @param destinatario
     * @param assunto
     * @param corpo 
     */
    protected static void sendEmail(Session session, String destinatario, String assunto, String corpo) {
        try {
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject(assunto, "UTF-8");

            msg.setText(corpo, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario, false));
            
            System.out.println("Message is ready");
            
            Transport.send(msg);
        } catch(MessagingException | UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
}
