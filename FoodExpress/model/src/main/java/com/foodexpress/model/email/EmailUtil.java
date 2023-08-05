/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.email;

import com.foodexpress.model.email.EmailTemplates;
import com.foodexpress.model.dto.TokenVerificacaoDTO;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
    private static void send(Session session, String destinatario, String assunto, String corpo) {
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
    
    private static void sendEmail(String destinatario, String assunto, String corpo) {
        send(TLSEmailAuth.getSession(), destinatario, assunto, corpo);
    }
    
    public static void sendEmailVerificacao(TokenVerificacaoDTO token) {
        sendEmail(token.getEmailUsuario(), "Confirmação de endereço de email", EmailTemplates.getEmailVerificacao(token.getToken()));
    }
}
