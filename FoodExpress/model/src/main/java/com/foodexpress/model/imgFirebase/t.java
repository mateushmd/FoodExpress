/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.imgFirebase;

import java.io.FileNotFoundException;

/**
 *
 * @author Samuel
 */
public class t {
    public static void main (String []args) throws FileNotFoundException{
        //teste
        FirebaseDAO fd = new FirebaseDAO();
        fd.upload("C:/Users/Samuel/Documents/f.jpg");
    }
}
