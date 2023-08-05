/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.imgFirebase;

import com.google.cloud.storage.Blob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Samuel
 */
public class FirebaseDAO extends FirebaseStorage{
     @Override
    public void upload(String imgLocal) throws FileNotFoundException {
        String firebaseStoragePath = generateUniqueFileName();
        Blob blob = bucket.create(firebaseStoragePath, new FileInputStream(imgLocal), "image/png");
        System.out.println("Upload da imagem concluído: " + blob.getMediaLink());
    }
}
