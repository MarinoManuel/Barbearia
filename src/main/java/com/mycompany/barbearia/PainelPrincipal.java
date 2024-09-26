package com.mycompany.barbearia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelPrincipal extends PainelFundo {

    JPanel painelCenter;
    JPanel painelNorth;
    BotoesBarbearia botaoMarcar;
    BotoesBarbearia botaoServicos;
    BotoesBarbearia botaoFuncioanarios;
    BotoesBarbearia botaoCliente;
    String usuario;

    public PainelPrincipal(String usuario) {
        super("src\\main\\java\\Imagens\\funcionarios_background.png");
        super.setLayout(new BorderLayout());
        this.usuario = usuario;
        addNorth();
        addCenter();
    }

    private void addNorth() {
        painelNorth = new JPanel();
        painelNorth.setLayout(new GridLayout(2, 1));

        // Criação do JLabel para o nome do usuário
        JLabel labelNome = new JLabel("Nome do usuário: " + usuario);
        JLabel labelSistemaGerenciamento = new JLabel("Sistema de gerenciamento da Barbearia");
        // Definições de fonte e cor
        labelSistemaGerenciamento.setFont(new Font("Algerian", Font.BOLD, 25));
        labelSistemaGerenciamento.setForeground(Color.WHITE);

        labelNome.setFont(new Font("Algerian", Font.BOLD, 25));
        labelNome.setForeground(Color.WHITE);

        // Painel para centralizar o título
        JPanel painelCenter1 = new JPanel();
        painelCenter1.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centraliza o conteúdo
        painelCenter1.add(labelSistemaGerenciamento);

        // Painel para centralizar o nome do usuário
        JPanel painelCenter2 = new JPanel();
        painelCenter2.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centraliza o conteúdo
        painelCenter2.add(labelNome);

        // Adiciona os painéis ao painel principal
        painelNorth.add(painelCenter1);
        painelNorth.add(painelCenter2);

        // Configurações do painel superior
        painelCenter1.setOpaque(false);
        painelCenter2.setOpaque(false);
        painelNorth.setOpaque(false); // Permite que o fundo seja visível
        add(painelNorth, BorderLayout.NORTH);
    }

    public void addCenter() {
    // Criação do JLabel para o menu
    JLabel labelMenu = new JLabel("Menu");
    labelMenu.setFont(new Font("Algerian", Font.BOLD, 20));
    labelMenu.setForeground(Color.WHITE);

    // Criação dos botões
    botaoMarcar = new BotoesBarbearia("MARCAR ATENDIMENTO", Color.WHITE, 20);
    botaoServicos = new BotoesBarbearia("SERVIÇOS", Color.WHITE, 20);
    botaoFuncioanarios = new BotoesBarbearia("FUNCIONÁRIOS", Color.WHITE, 20);
    botaoCliente = new BotoesBarbearia("CLIENTE", Color.WHITE, 20);

    // Definindo o layout e opacidade do painel central
    painelCenter = new JPanel();
    painelCenter.setLayout(new BoxLayout(painelCenter, BoxLayout.Y_AXIS)); // Layout vertical
    painelCenter.setOpaque(false); // Mantém o painel transparente

    // Adicionando componentes ao painel central
    painelCenter.add(Box.createVerticalStrut(20));
    painelCenter.add(labelMenu); // Coloca o rótulo no topo
    painelCenter.add(Box.createVerticalStrut(30)); // Espaço entre o rótulo e o primeiro botão
    painelCenter.add(botaoMarcar); // Primeiro botão
    painelCenter.add(Box.createVerticalStrut(10)); // Espaço entre os botões
    painelCenter.add(botaoServicos); // Segundo botão
    painelCenter.add(Box.createVerticalStrut(10)); // Espaço entre os botões
    painelCenter.add(botaoFuncioanarios); // Terceiro botão
    painelCenter.add(Box.createVerticalStrut(10)); // Espaço entre os botões
    painelCenter.add(botaoCliente); // Quarto botão

    // Adicionando o painel central ao layout da janela
    add(painelCenter, BorderLayout.CENTER); // Adiciona o painelCenter
    }
}
