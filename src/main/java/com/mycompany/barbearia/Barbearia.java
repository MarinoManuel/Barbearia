package com.mycompany.barbearia;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Barbearia {

    public static void main(String[] args) throws InterruptedException, SQLException {
        JFrame frame = new JFrame("Tabela de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);

        Object[][] dadosClientes = new Object[2000][3]; // 100 linhas de dados

        // Preenchendo o array com 100 registros fictícios
        for (int i = 0; i < 2000; i++) {
            dadosClientes[i][0] = "Cliente " + (i + 1); // Nome do cliente
            dadosClientes[i][1] = 20 + (i % 50); // Idade (aleatória)
            dadosClientes[i][2] = "cliente" + (i + 1) + "@example.com"; // Email fictício
        }

        // Definindo os nomes das colunas
        String[] colunas = {"Nome", "Idade", "Email"};

        // Criando o modelo de tabela (TableModel) com os dados e colunas
        DefaultTableModel model = new DefaultTableModel(dadosClientes, colunas);

        // Criando a JTable com o modelo de dados
        JTable tabelaClientes = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelaClientes,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Criando o JFrame
        // Adicionando o JScrollPane (que contém a tabela) ao JFrame
        frame.add(scrollPane, BorderLayout.CENTER);
        // Adicionando a tabela em um JScrollPane, sem barras de rolagem visíveis

        // Tornando o JFrame visível
    }
}
