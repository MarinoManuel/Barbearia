package com.mycompany.barbearia;

import java.sql.SQLException;

/**
 *
 * @author zimba
 */
public class ValidacaoCliente {

    public static String verificarAdicionarCliente(String username, String userpassword) {

        try {
            Funcoes_BD.addUsuario(username, userpassword);
            return "message: Cliente adicionado com sucesso";
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Banco de Dados - Username ja em uso";
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Contacte o Admin";
        }

    }

    public static String verificarEditarNomeCliente(String numTelefone, String novoNomeCliente) {

        try {
            Funcoes_BD.editarNomeCliente(numTelefone, novoNomeCliente);
            return "message: nomeCliente actualizado com sucesso";
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Banco de Dados - Username ja em uso";
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Contacte o Admin";
        }

    }

    public static String verificarEditarApelidoCliente(String numTelefone, String novoApelidoCliente) {

        try {
            Funcoes_BD.editarNomeCliente(numTelefone, novoApelidoCliente);
            return "message: apelidoCliente actualizado com sucesso";
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Banco de Dados - Ocorreu um erro";
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Contacte o Admin";
        }

    }

    public static String verificarEditarEmailCliente(String numTelefone, String novoEmailCliente) {

        try {
            Funcoes_BD.editarNomeCliente(numTelefone, novoEmailCliente);
            return "message: emailCliente actualizado com sucesso";
        } catch (SQLException e) {

            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Banco de Dados - Email ja em uso";
        } catch (Exception e) {
            System.out.println("Erro no console: " + e.getMessage());
            return "erro: Contacte o Admin";
        }

    }

}
