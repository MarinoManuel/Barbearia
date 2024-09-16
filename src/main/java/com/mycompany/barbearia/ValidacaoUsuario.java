package com.mycompany.barbearia;


import com.mycompany.barbearia.Funcoes_BD;
import java.sql.SQLException;

/**
 *
 * @author zimba
 */
public class ValidacaoUsuario {
    
    
    public static byte verificarAdicionarUsuario(String username, String userpassword) {
        
        if (username.isEmpty()){
            return 0;
        }

        try {
            Funcoes_BD.addUsuario(username, userpassword);
            return 1;
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return 2;
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return 3;
        }

    }
    
}
