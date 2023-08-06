/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.imgFirebase;

import com.foodexpress.model.imgFirebase.FirebaseDAO;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 *
 * @author Samuel
 */
public class teste {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FirebaseDAO fdao = new FirebaseDAO();
        //fdao.delete("1_d399c1bb-b658-41a2-b5b2-7121714d2f10.png");//Nome do arquivo no Firebase     
        //fdao.readImageAsUrl("1.png");//Pegar link da imagem
        //fdao.upload("C:\\Users\\Samuel\\Documents\\CEFET-MG.png");//inserir pelo url do seu pc
        //fdao.uploadByLink("https://www.cnnbrasil.com.br/wp-content/uploads/sites/12/2023/08/GettyImages-1575024187-e1691095411585.jpg?w=876&h=484&crop=1");//upload de img por link
    }
}
