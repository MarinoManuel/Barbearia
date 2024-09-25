package com.mycompany.barbearia;

import com.mycompany.barbearia.Funcoes_BD;
import static com.mycompany.barbearia.Funcoes_BD.consultarUsuario;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.SQLException;

/**
 *
 * @author zimba
 */
public class ValidacaoUsuario {

    public static byte verificarAdicionarUsuario(String username, String userpassword) {

        if (username.isEmpty()) {
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
    public static byte ValidarConsultausuario(String username, String userpassword) {
        // Define o valor de retorno padrão
        byte retorno = 0;
        
        try {
            // Verifica se o tamanho do username ou userpassword é maior que 45 caracteres
            if (username.length() > 45 || userpassword.length() > 45) {
                return 1;  // Retorna 1 se exceder o número de caracteres
            }
            Usuario usuario = consultarUsuario(username);
            if (usuario == null) {
                return 2; 
            }
            // Verifica se a senha é diferente
            if (!usuario.getUserpassword().equals(userpassword)) {
                return 3; 
            }
        } catch (SQLException e) {
              e.printStackTrace();
        }
        return retorno;
    }

}
