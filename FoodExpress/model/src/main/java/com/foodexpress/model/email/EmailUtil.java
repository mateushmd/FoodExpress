/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.email;

import com.foodexpress.model.email.EmailTemplates;
import com.foodexpress.model.dto.TokenVerificacaoDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class EmailUtil {

    /*
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
    */

    public static void sendEmail(String destinatario, String assunto, String corpo) {
        new Thread(() -> {
            HttpClient httpClient = HttpClients.createDefault();

            HttpPost httpPost = new HttpPost("http://localhost:3000/enviaremail");
            httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");

            //String requestBody = String.format("{\"email\": \"%s\", \"subject\": \"%s\", \"html\": \"%s\"}", destinatario, assunto, corpo);

            JSONObject requestBody = new JSONObject();
            requestBody.put("email", destinatario);
            requestBody.put("subject", assunto);
            requestBody.put("html", corpo);

            System.out.println(requestBody.toString());

            try {
                StringEntity requestEntity = new StringEntity(requestBody.toString(), StandardCharsets.UTF_8);

                httpPost.setEntity(requestEntity);

                HttpResponse response = httpClient.execute(httpPost);

                int statusCode = response.getStatusLine().getStatusCode();

                String responseBody = EntityUtils.toString(response.getEntity());

                if (statusCode == 200) {
                    System.out.println("Email enviado com sucesso");
                } else {
                    System.out.println("Erro ao enviar email: " + responseBody);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    
    public static void sendEmailVerificacao(TokenVerificacaoDTO token) {
        sendEmail(token.getEmailUsuario(), "Confirmação de endereço de email", EmailTemplates.getEmailVerificacao(token.getToken()));
    }
}
