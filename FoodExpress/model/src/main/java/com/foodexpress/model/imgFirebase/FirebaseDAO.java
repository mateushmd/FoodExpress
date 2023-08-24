/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.imgFirebase;

import com.google.cloud.storage.Blob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Samuel
 */
public class FirebaseDAO extends FirebaseStorage {

    @Override
    public void upload(String imgLocal) throws FileNotFoundException {
        String firebaseStoragePath = generateUniqueFileName();
        Blob blob = bucket.create(firebaseStoragePath, new FileInputStream(imgLocal), "image/png");
       // System.out.println("Upload da imagem concluído: " + blob.getMediaLink());
    }
    

    @Override
    public void delete(String imgLocal) throws FileNotFoundException {
        Blob blob = bucket.get(imgLocal);
        if (blob != null) {
            boolean deleted;
            deleted = blob.delete();
            if (deleted) {
                System.out.println("Arquivo deletado com sucesso!");
            } else {
                System.out.println("Falha ao deletar o arquivo.");
            }
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }

    @Override
    public void readImageAsUrl(String imgLocal) throws FileNotFoundException {
        String baseUrl = "https://firebasestorage.googleapis.com/v0/b/";
        String bucketUrl = "restricted-d6b24.appspot.com"; // Nome do meu bucket
        String imagePath = imgLocal.replace("/", "%2F");
        String url = baseUrl + bucketUrl + "/o/" + imagePath + "?alt=media";
        System.out.println(url);// Saída desejada
    }
    
    @Override
    public void uploadByLink(String imageUrl) throws IOException {
        // Gerar um nome de arquivo único
        String firebaseStoragePath = generateUniqueFileName();

        // Fazer o upload da imagem
        byte[] imageData = getImageDataFromUrl(imageUrl);
        if (imageData != null) {
            Blob blob = bucket.create(firebaseStoragePath, imageData, "image/png");
            System.out.println("Upload da imagem concluído: " + blob.getMediaLink());
        } else {
            System.out.println("Falha ao obter os dados da imagem.");
        }
    }
    
    
    
     


}
