package com.mycompany.barbearia;

import java.sql.SQLException;

/**
 *
 * @author zimba
 */
public class ValidacaoServicos {
    
    public static byte verificarAdicionarServicos(String nomeServico, String tipoServico, int preco){
        if (nomeServico.isEmpty()){
            return 0;
        }
        if (tipoServico.isEmpty()){
            return 1;
        }
        if (preco < 0){
            return 2;
        }
        try{
            Funcoes_BD.addServicos(nomeServico, tipoServico, preco);
            return 3;
        }
        catch(SQLException e){
            return 4;
        }
        catch(Exception e){
            return 5;
        }
        
    }
    
    
        public static byte verificarEditarServicos(String nomeServico, String tipoServico, int novoPreco){
        if (nomeServico.isEmpty()){
            return 0;
        }
        if (tipoServico.isEmpty()){
            return 1;
        }
        if (novoPreco < 0){
            return 2;
        }
        try{
            Funcoes_BD.editarPrecoServicos(nomeServico, tipoServico, novoPreco);
            return 3;
        }
        catch(SQLException e){
            return 4;
        }
        catch(Exception e){
            return 5;
        }
        
    }
    
        
        public static byte verificarRemoverServicos(String nomeServico, String tipoServico){
            try {
                Funcoes_BD.removerServico(nomeServico, tipoServico);
                return 0;
            } catch (SQLException e) {
                return 1;
            }
            
        }
        
        
       
    
}
