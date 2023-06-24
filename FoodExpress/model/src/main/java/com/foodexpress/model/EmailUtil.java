/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

    /**
     * Envia um email para algum endereço
     *
     * @param session
     * @param destinatario
     * @param assunto
     * @param corpo
     */
    protected static void send(Session session, String destinatario, String assunto, String corpo) {
        try {
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("equipefoodexpress@gmail.com", "FoodExpress"));

            msg.setReplyTo(InternetAddress.parse("equipefoodexpress@gmail.com", false));

            msg.setSubject(assunto, "UTF-8");

            msg.setContent(corpo, "text/HTML; charset=UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario, false));

            System.out.println("Message is ready");

            Transport.send(msg);
        } catch (MessagingException | UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }

    public static void sendInsecure(Session session, String destinatario, String assunto, String corpo) {
        try {
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("equipefoodexpress@gmail.com", "FoodExpress"));

            msg.setReplyTo(InternetAddress.parse("equipefoodexpress@gmail.com", false));

            msg.setSubject(assunto, "UTF-8");

            msg.setText(corpo, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario, false));

            System.out.println("Message is ready");

            Transport.send(msg);
        } catch (MessagingException | UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void sendEmail(String destinatario, String assunto, String corpo) {
        send(TLSEmailAuth.getSession(), destinatario, assunto, corpo);

        /*System.out.println("SimpleEmail Start");
		
        String smtpHostServer = "smtp.gmail.com";
        String emailID = "equipefoodexpress@gmail.com";

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);

        sendInsecure(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");*/
    }
}
