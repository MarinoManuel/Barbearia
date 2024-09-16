
import com.mycompany.barbearia.Funcoes_BD;
import java.sql.SQLException;

/**
 *
 * @author zimba
 */
public class ValidacaoUsuario {
    
    
    public static String verificarAdicionarUsuario(String username, String userpassword) {

        try {
            Funcoes_BD.addUsuario(username, userpassword);
            return "message: Usuario adicionado com sucesso";
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Banco de Dados - Username ja em uso";
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Contacte o Admin";
        }

    }
    
}
