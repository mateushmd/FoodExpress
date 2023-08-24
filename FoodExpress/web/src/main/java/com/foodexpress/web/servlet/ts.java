/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet;

import com.foodexpress.model.imgFirebase.FirebaseDAO;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Samuel
 */
@WebServlet(name = "ts", urlPatterns = {"/ts"})
@MultipartConfig
public class ts extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

        } catch (Exception e) {
            response.getWriter().println("Erro durante o upload: " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        InputStream serviceAccount = new FileInputStream("C:\\Users\\Samuel\\Documents\\NetBeansProjects\\TCCSamuel2\\FoodExpress\\model\\src\\main\\java\\com\\foodexpress\\model\\imgFirebase\\restricted-d6b24-firebase-adminsdk-bw6ft-86b7489c7a.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("restricted-d6b24.appspot.com")
                .build();
        FirebaseApp.initializeApp(options);

        // Fazer o upload do arquivo para o Firebase Storage
        Part filePart = request.getPart("file"); // 'file' é o nome do campo de upload no formulário
        String fileName = filePart.getSubmittedFileName();
        InputStream fileInputStream = filePart.getInputStream();
        BlobId blobId = BlobId.of("restricted-d6b24.appspot.com", "/" + fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/png").build();
        Blob blob = StorageOptions.getDefaultInstance().getService().create(blobInfo, fileInputStream);

        // Recuperar o URL de download do arquivo
        String downloadUrl = blob.signUrl(30, TimeUnit.MINUTES).toString();

        // Agora você pode usar o 'downloadUrl' para exibir o link para download em sua página da web
        /*
        try {
            
            Part filePart = request.getPart("imageFile");
            String fileName = filePart.getSubmittedFileName();
           // FirebaseDAO fdao= new FirebaseDAO();
            out.println(fileName);
            //fdao.upload(fileName);

            response.getWriter().println("Upload realizado com sucesso.");
        } catch (ServletException | IOException e) {
            response.getWriter().println("Erro durante o upload: " + e.getMessage());
        }

         */
    }
}
