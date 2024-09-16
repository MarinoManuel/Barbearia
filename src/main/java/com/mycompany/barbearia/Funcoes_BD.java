package com.mycompany.barbearia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Funcoes_BD {

    private static String sql;
    private static PreparedStatement pst;

    // Usuários
    public static void addUsuario(String username, String userpassword) throws SQLException {
        sql = "INSERT INTO usuarios (username, userpassword) VALUES(?,?)";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, userpassword);
        pst.executeUpdate();
        pst.close();
    }

    // Clientes
    public static void addCliente(String numTelefone, String nomeCliente, String apelidoCliente, String email) throws SQLException {
        sql = "INSERT INTO clientes (numtelefone, nomecliente, apelidocliente, email) VALUES(?,?,?,?)";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, numTelefone);
        pst.setString(2, nomeCliente);
        pst.setString(3, apelidoCliente);
        pst.setString(4, email);
        pst.executeUpdate();
        pst.close();
    }

    public static boolean editarNomeCliente(String numTelefone, String novoNomeCliente) throws SQLException {
        sql = "UPDATE clientes SET nomecliente = ? WHERE numtelefone = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, novoNomeCliente);
        pst.setString(2, numTelefone);
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static boolean editarApelidoCliente(String numTelefone, String novoApelidoCliente) throws SQLException {
        sql = "UPDATE clientes SET apelidocliente = ? WHERE numtelefone = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, novoApelidoCliente);
        pst.setString(2, numTelefone);
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static boolean editarEmailCliente(String numTelefone, String novoEmail) throws SQLException {
        sql = "UPDATE clientes SET email = ? WHERE numtelefone = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, novoEmail);
        pst.setString(2, numTelefone);
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static boolean removerCliente(String numTelefone) throws SQLException {
        sql = "DELETE FROM clientes WHERE numtelefone = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, numTelefone);
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static Cliente consultarCliente(String numTelefone) throws SQLException {
        Cliente cliente = null;

        sql = "SELECT nomecliente, apelidocliente, email FROM clientes WHERE numtelefone = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, numTelefone); // Usando o número de telefone para identificar o cliente

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            // Cria o objeto Cliente com os dados retornados
            String nomeCliente = rs.getString("nomecliente");
            String apelidoCliente = rs.getString("apelidocliente");
            String email = rs.getString("email");

            cliente = new Cliente(numTelefone, nomeCliente, apelidoCliente, email);
        }

        // Fecha o ResultSet, PreparedStatement e a conexão
        rs.close();
        pst.close();

        return cliente;
    }

    public static List<Cliente> obterTodosClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        sql = "SELECT numtelefone, nomecliente, apelidocliente, email FROM clientes";
        pst = Conexao.getC().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String numTelefone = rs.getString("numtelefone");
            String nomeCliente = rs.getString("nomecliente");
            String apelidoCliente = rs.getString("apelidocliente");
            String email = rs.getString("email");

            Cliente cliente = new Cliente(numTelefone, nomeCliente, apelidoCliente, email);
            clientes.add(cliente);
        }

        rs.close();
        pst.close();

        return clientes;
    }

    // Serviços
    public static void addServicos(String nomeServico, String tipoServico, int preco) throws SQLException {
        sql = "INSERT INTO servicos (nomeservico, tiposervico, preco) VALUES(?,?,?)";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, nomeServico);
        pst.setString(2, tipoServico);
        pst.setInt(3, preco);
        pst.executeUpdate();
        pst.close();
    }

    public static boolean editarPrecoServicos(String nomeServico, String tipoServico, int novoPreco) throws SQLException {
        sql = "UPDATE servicos SET preco = ? WHERE nomeservico = ? AND tiposervico = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setInt(1, novoPreco);         // Novo valor para o preço
        pst.setString(2, nomeServico);   // Identificador do nome do serviço
        pst.setString(3, tipoServico);   // Identificador do tipo do serviço
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static List<Servico> obterTodosServicos() throws SQLException {
        List<Servico> servicos = new ArrayList<>();

        sql = "SELECT nomeservico, tiposervico, preco FROM servicos";
        pst = Conexao.getC().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String nomeServico = rs.getString("nomeservico");
            String tipoServico = rs.getString("tiposervico");
            int preco = rs.getInt("preco");

            Servico servico = new Servico(nomeServico, tipoServico, preco);
            servicos.add(servico);
        }

        rs.close();
        pst.close();

        return servicos;
    }

    public static boolean removerServico(String nomeServico, String tipoServico) throws SQLException {
        sql = "DELETE FROM servicos WHERE nomeservico = ? AND tiposervico = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, nomeServico);
        pst.setString(2, tipoServico);

        int linhasAfetadas = pst.executeUpdate();
        pst.close();

        return linhasAfetadas == 1;
    }

    // Barbeiros
    public static void addBarbeiro(String nomeBarbeiro) throws SQLException {
        sql = "INSERT INTO barbeiros (nomeBarbeiro) VALUES(?)";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, nomeBarbeiro);
        pst.executeUpdate();
        pst.close();
    }

    public static boolean removerBarbeiro(String nomeBarbeiro) throws SQLException {
        sql = "DELETE FROM barbeiros WHERE nomeBarbeiro = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, nomeBarbeiro);
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static List<String> obterTodosBarbeiros() throws SQLException {
        List<String> barbeiros = new ArrayList<>();

        sql = "SELECT nomeBarbeiro FROM barbeiros";
        pst = Conexao.getC().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String nomeBarbeiro = rs.getString("nomeBarbeiro");
            barbeiros.add(nomeBarbeiro);
        }

        rs.close();
        pst.close();

        return barbeiros;
    }

    // Recibos
    public static void addRecibo(String idRecibo, java.sql.Timestamp dataRecibo, java.sql.Timestamp dataAtendimento, double estado) throws SQLException {
        sql = "INSERT INTO recibos (idRecibo, dataRecibo, dataAtendimento, estado) VALUES (?, ?, ?, ?)";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, idRecibo);
        pst.setTimestamp(2, dataRecibo);
        pst.setTimestamp(3, dataAtendimento);
        pst.setDouble(4, estado);  // Alterado para double
        pst.executeUpdate();
        pst.close();
    }

    public static boolean alterarEstadoRecibo(String idRecibo, double estado) throws SQLException {
        sql = "UPDATE recibos SET estado = ? WHERE idRecibo = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setDouble(1, estado);  // Novo valor para o estado
        pst.setString(2, idRecibo);
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static boolean alterarDataAtendimentoRecibo(String idRecibo, java.sql.Timestamp novaDataAtendimento) throws SQLException {
        sql = "UPDATE recibos SET dataAtendimento = ? WHERE idRecibo = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setTimestamp(1, novaDataAtendimento);  // Nova data de atendimento
        pst.setString(2, idRecibo);
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static boolean removerRecibo(String idRecibo) throws SQLException {
        sql = "DELETE FROM recibo WHERE idRecibo = ?";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, idRecibo);
        int linhasAfetadas = pst.executeUpdate();
        pst.close();
        return linhasAfetadas == 1;
    }

    public static List<Recibo> obterTodosRecibos() throws SQLException {
        List<Recibo> recibos = new ArrayList<>();
        sql = "SELECT idRecibo, dataRecibo, dataAtendimento, estado FROM recibos";
        pst = Conexao.getC().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String idRecibo = rs.getString("idRecibo");
            java.sql.Timestamp dataRecibo = rs.getTimestamp("dataRecibo");
            java.sql.Timestamp dataAtendimento = rs.getTimestamp("dataAtendimento");
            double estado = rs.getDouble("estado");

            Recibo recibo = new Recibo(idRecibo, dataRecibo, dataAtendimento, estado);
            recibos.add(recibo);
        }

        rs.close();
        pst.close();

        return recibos;
    }

    // Recibos Relacoes
    public static void addReciboRelacoes(String idRecibo, String userName, String nomeServico, String tipoServico, String numTelefone, String nomeBarbeiro) throws SQLException {
        sql = "INSERT INTO reciboRelacoes (idRecibo, userName, nomeServico, tipoServico, numTelefone, nomeBarbeiro) VALUES(?,?,?,?,?,?)";
        pst = Conexao.getC().prepareStatement(sql);
        pst.setString(1, idRecibo);
        pst.setString(2, userName);
        pst.setString(3, nomeServico);
        pst.setString(4, tipoServico);
        pst.setString(5, numTelefone);
        pst.setString(6, nomeBarbeiro);
        pst.executeUpdate();
        pst.close();
    }
}
