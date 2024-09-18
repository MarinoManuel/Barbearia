package com.mycompany.barbearia;

import java.sql.SQLException;

/**
 *
 * @author zimba
 */
public class ValidacaoCliente {

    public static byte verificarAdicionarCliente(String username, String userPassword) {
        
        if (username.isEmpty()){
            return 0;
        }

        try {
            Funcoes_BD.addUsuario(username, userPassword);
            return 1;
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return 2;
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return 3;
        }

    }

    public static byte verificarEditarNomeCliente(String numTelefone, String novoNomeCliente) {
        
        if (novoNomeCliente.isEmpty()){
            return 0;
        }

        try {
            Funcoes_BD.editarNomeCliente(numTelefone, novoNomeCliente);
            return 1;
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return 2;
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return 3;
        }

    }

    public static byte verificarEditarApelidoCliente(String numTelefone, String novoApelidoCliente) {       
        
        if (novoApelidoCliente.isEmpty()){
            return 0;
        }

        try {
            Funcoes_BD.editarNomeCliente(numTelefone, novoApelidoCliente);
            return 1;
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return 2;
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return 3;
        }

    }

    public static byte verificarEditarEmailCliente(String numTelefone, String novoEmailCliente) {
        
        if (!novoEmailCliente.contains("@")){
            return 0;
        }

        try {
            Funcoes_BD.editarNomeCliente(numTelefone, novoEmailCliente);
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
