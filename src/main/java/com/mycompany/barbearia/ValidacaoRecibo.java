package com.mycompany.barbearia;

import java.sql.SQLException;

/**
 *
 * @author zimba
 */
public class ValidacaoRecibo {
    
    public static byte verificarAddRecibo(String idRecibo, java.sql.Timestamp dataRecibo, java.sql.Timestamp dataAtendimento, double estado){
        if (idRecibo.isEmpty()){
            return 0;
        }  
        try{
            Funcoes_BD.addRecibo(idRecibo, dataRecibo, dataAtendimento, estado);
            return 1;
        }catch(SQLException e){
            return 2;
        }
    }
    
    
    public static byte verificarAlterarEstadoRecibo(String idRecibo, double estado){
        
        if (idRecibo.isEmpty()){
            return 0;
        }
        
        try {
            Funcoes_BD.alterarEstadoRecibo(idRecibo, estado);
            return 1;
        } catch (SQLException e) {
            return 2;
        }
    }
    
    public static byte verificarAlterarDataAtendimentoRecibo(String idRecibo, java.sql.Timestamp novaDataAtendimento){
        
        if (idRecibo.isEmpty()){
            return 0;
        }
        
        try{
            Funcoes_BD.alterarDataAtendimentoRecibo(idRecibo, novaDataAtendimento);
            return 1;
        }
        catch(SQLException e){
            return 2;
        }
        
    }
    
   public static byte verificarRemoverRecibo(String idRecibo){
       if (idRecibo.isEmpty()){
            return 0;
        }
        
        try{
            Funcoes_BD.removerRecibo(idRecibo);
            return 1;
        }
        catch(SQLException e){
            return 2;
        }
        
   }
    
}
