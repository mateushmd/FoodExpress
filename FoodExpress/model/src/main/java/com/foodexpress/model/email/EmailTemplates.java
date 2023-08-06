/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.foodexpress.model.email;


public class EmailTemplates {
    private static final String EMAIL_VERIFICACAO = """
                                                    <!DOCTYPE html>
                                                    <html>
                                                    <head>
                                                        <meta charset="UTF-8">
                                                        <meta name="viewport" content="width=device-width, initial-scale=1">
                                                        <title>Confirma\u00e7\u00e3o de email</title>
                                                        <style type="text/css">
                                                            @media screen {
                                                                @font-face {
                                                                    font-family: 'Source Sans Pro';
                                                                    font-style: normal;
                                                                    font-weight: 400;
                                                                    src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff) format('woff');
                                                                }
                                                    
                                                                @font-face {
                                                                    font-family: 'Source Sans Pro';
                                                                    font-style: normal;
                                                                    font-weight: 700;
                                                                    src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff) format('woff');
                                                                }
                                                            }
                                                    
                                                            body,
                                                            table,
                                                            td,
                                                            a {
                                                                -ms-text-size-adjust: 100%;
                                                                -webkit-text-size-adjust: 100%;
                                                            }
                                                    
                                                            img {
                                                                -ms-interpolation-mode: bicubic;
                                                            }
                                                    
                                                            a[x-apple-data-detectors] {
                                                                font-family: inherit !important;
                                                                font-size: inherit !important;
                                                                font-weight: inherit !important;
                                                                line-height: inherit !important;
                                                                color: inherit !important;
                                                                text-decoration: none !important;
                                                            }
                                                    
                                                            div[style*="margin: 16px 0;"] {
                                                                margin: 0 !important;
                                                            }
                                                    
                                                            body {
                                                                width: 100% !important;
                                                                height: 100% !important;
                                                                padding: 0 !important;
                                                                margin: 0 !important;
                                                            }
                                                    
                                                            table {
                                                                border-collapse: collapse !important;
                                                            }
                                                    
                                                            a {
                                                                color: #0f7496;
                                                            }
                                                    
                                                            img {
                                                                height: auto;
                                                                line-height: 100%;
                                                                text-decoration: none;
                                                                border: 0;
                                                                outline: none;
                                                            }
                                                        </style>
                                                    </head>
                                                    <body style="background-color: #e6f1f5;">
                                                        <div class="preheader"
                                                            style="display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;">
                                                            Confirma\u00e7\u00e3o de endere\u00e7o de email.
                                                        </div>
                                                    
                                                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                            <tr>
                                                                <td align="center" bgcolor="#e9ecef" style="padding-top: 100px;">
                                                                    <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                                                                        <tr>
                                                                            <td align="left" bgcolor="#cd606b"
                                                                                style="padding: 36px 24px 0; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; border-top: 3px solid #e6f1f5;">
                                                                                <h1
                                                                                    style="margin: 0; font-size: 32px; font-weight: 700; letter-spacing: -1px; line-height: 48px; color: #e6f1f5;">
                                                                                    Confirme o seu endere\u00e7o de email</h1>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td align="center" bgcolor="#e9ecef">
                                                                    <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                                                                        <tr>
                                                                            <td align="left" bgcolor="#cd606b"
                                                                                style="padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; color: #e6f1f5;">
                                                                                <p style="margin: 0;">Utilize o c\u00f3digo abaixo para confirmar o seu endere\u00e7o de email.
                                                                                    Se voc\u00ea n\u00e3o criou uma conta no FoodExpress,
                                                                                    delete este email.</p>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td align="left" bgcolor="#cd606b"
                                                                                style="padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-weight: bold; letter-spacing: 20px; font-size: 80px; line-height: 24px; color: #e6f1f5;">
                                                                                <p style="margin: 0;">
                                                                                    [Token]</p>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td align="left" bgcolor="#cd606b"
                                                                                style="padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; color: #e6f1f5;">
                                                                                <p style="margin: 0;">Este c\u00f3digo \u00e9 v\u00e1lido por <b>10 minutos</b>, contados a partir da realiza\u00e7\u00e3o do pedido de cadastro.</p>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td align="left" bgcolor="#cd606b"
                                                                                style="padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #e6f1f5; color: #e6f1f5;">
                                                                                <p style="margin: 0;">FoodExpress</p>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td align="center" bgcolor="#e9ecef" style="padding: 24px;">
                                                                    <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                                                                        <tr>
                                                                            <td align="center" bgcolor="#e9ecef"
                                                                                style="padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;">
                                                                                <p style="margin: 0;">Voc\u00ea recebeu este email devido a uma requisi\u00e7\u00e3o que recebemos para confirmar
                                                                                o email da sua conta. Se voc\u00ea n\u00e3o criou uma conta com este endere\u00e7o de email, delete esta mensagem.</p>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </body>
                                                    
                                                    </html>""";
    
    public static String getEmailVerificacao(String token) {
        return EMAIL_VERIFICACAO.replace("[Token]", token);
    }
}
