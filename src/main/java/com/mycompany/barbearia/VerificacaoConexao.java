package com.mycompany.barbearia;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


public class VerificacaoConexao {
    public static boolean VerificarConexao(){
        try{
            URL url = new URL("http://www.google.com");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            
            conexao.setConnectTimeout(5000);
            conexao.setReadTimeout(5000);
            
            conexao.connect();
            
            if (conexao.getResponseCode()==200){
                return true;
            }else{
                return false;
            }
        }catch(IOException e){
            return false;
        }
    }
}
