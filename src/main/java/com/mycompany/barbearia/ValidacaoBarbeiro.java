package com.mycompany.barbearia;

import java.sql.SQLException;

/**
 *
 * @author zimba
 */
public class ValidacaoBarbeiro {

    public static byte verificaraddBarbeiro(String nomeBarbeiro) {
        if (nomeBarbeiro.isEmpty()) {
            return 0;
        }

        try {
            Funcoes_BD.addBarbeiro(nomeBarbeiro);
            return 1;
        } catch (SQLException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        }
    }

    public static byte verificarRemoverBarbeiro(String nomeBarbeiro) {
        try {
            Funcoes_BD.removerBarbeiro(nomeBarbeiro);
            return 0;
        } catch (SQLException e) {
            return 1;
        }

    }
    
    
}
