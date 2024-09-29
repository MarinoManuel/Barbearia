package com.mycompany.barbearia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PainelMarcacao extends PainelFundo {

    BotoesBarbearia botaoAgendar;
    JComboBox<String> comboBoxtrancas;
    JComboBox<String> comboBoxcortes;
    JComboBox<String> comboBoxPintar;
    List<String> trancas;
    List<String> cortes;
    List<String> pintar;
    JLabel labelNome;
    JLabel labelApelido;
    JLabel labelEmail;
    JLabel labelestado;
    JTextField caixaTelefone;

    public PainelMarcacao() {
        super("src\\main\\java\\Imagens\\servicos_background.png");
        super.setLayout(new BorderLayout());

        botaoAgendar = new BotoesBarbearia("Agendar", Color.WHITE, 20);
        comboBoxcortes = new JComboBox<>();
        comboBoxtrancas = new JComboBox<>();
        comboBoxPintar = new JComboBox<>();
        comboBoxcortes.setBackground(Color.WHITE);
        comboBoxcortes.setPreferredSize(new Dimension(120, 30));
        comboBoxtrancas.setBackground(Color.WHITE);
        comboBoxtrancas.setPreferredSize(new Dimension(120, 30));
        comboBoxPintar.setBackground(Color.WHITE);
        comboBoxPintar.setPreferredSize(new Dimension(120, 30));

        caixaTelefone = new JTextField(10);
        caixaTelefone.setFont(new Font("Algerian", Font.BOLD, 20));
        caixaTelefone.setForeground(Color.WHITE);
        caixaTelefone.setOpaque(false);
        caixaTelefone.setText("Telefone");
        caixaTelefone.setHorizontalAlignment(JTextField.CENTER);
        caixaTelefone.setPreferredSize(new Dimension(90, 20));
        labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font("Algerian", Font.BOLD, 20));
        labelNome.setForeground(Color.WHITE);
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelApelido = new JLabel("Apelido:");
        labelApelido.setFont(new Font("Algerian", Font.BOLD, 20));
        labelApelido.setForeground(Color.WHITE);
        labelApelido.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Algerian", Font.BOLD, 20));
        labelEmail.setForeground(Color.WHITE);
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelestado = new JLabel("");
        labelestado.setFont(new Font("Algerian", Font.BOLD, 20));
        labelestado.setForeground(Color.WHITE);
        labelestado.setAlignmentX(Component.CENTER_ALIGNMENT);
        listenerCaixaTelefone();
        criarFundo();

    }

    public void ativarLabelEstado() {
        labelestado.setForeground(Color.WHITE);
    }

    public void desativarLabelEstado() {
        labelestado.setForeground(new Color(0, 0, 0, 0));
    }

    public void MudarLabelEstado(String a) {
        labelestado.setText(a);
    }

    public String obterTexto() {
        return caixaTelefone.getText();
    }

    private void listenerCaixaTelefone() {
        caixaTelefone.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (caixaTelefone.getText().length() != 9) {
                    ativarLabelEstado();
                    MudarLabelEstado("cliente nao existe");
                    labelApelido.setText("Apelido: ");
                    labelNome.setText("Nome: ");
                    labelEmail.setText("Email: ");
                } else {
                    try {
                        Controlador.listenerMarcacaoCaixaTelefone();
                    } catch (SQLException ex) {
                        Logger.getLogger(PainelMarcacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (caixaTelefone.getText().length() != 9) {
                    MudarLabelEstado("cliente nao existe");
                    labelApelido.setText("Apelido: ");
                    labelNome.setText("Nome: ");
                    labelEmail.setText("Email: ");
                    ativarLabelEstado();
                    MudarLabelEstado("cliente nao existe");
                } else {
                    try {
                        Controlador.listenerMarcacaoCaixaTelefone();
                    } catch (SQLException ex) {
                        Logger.getLogger(PainelMarcacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    private void criarFundo() {
        // label de marcacao de atendimento
        JLabel labelMarcarAtendimento = new JLabel("Marcar Atendimento");
        labelMarcarAtendimento.setFont(new Font("Algerian", Font.BOLD, 20));
        labelMarcarAtendimento.setForeground(Color.WHITE);
        //painel de marcacao de atendimento
        JPanel painelMarcarAtendimento = new JPanel();
        painelMarcarAtendimento.setLayout(new GridBagLayout());
        painelMarcarAtendimento.setOpaque(false);
        painelMarcarAtendimento.setPreferredSize(new Dimension(0, 100));
        painelMarcarAtendimento.add(labelMarcarAtendimento);

        //criar painel de botao centralizado
        JPanel painelbotaoCenter = new JPanel();
        painelbotaoCenter.setLayout(new GridBagLayout());
        painelbotaoCenter.setOpaque(false);
        painelbotaoCenter.setPreferredSize(new Dimension(0, 100));
        painelbotaoCenter.add(botaoAgendar);

        // criar dois paineis caixas para agrupar as opcoes
        JPanel painel1 = new JPanel();
        painel1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        JPanel painel2 = new JPanel();
        painel2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        painel1.setOpaque(false);
        painel2.setOpaque(false);

        //configurar painel1;
        painel1.setLayout(new BorderLayout());
        JLabel labelServicos = new JLabel("Servicos");
        labelServicos.setFont(new Font("Algerian", Font.BOLD, 20));
        labelServicos.setForeground(Color.WHITE);
        JPanel painelServicos = new JPanel();
        painelServicos.setOpaque(false);
        painelServicos.setLayout(new GridBagLayout());
        painelServicos.setPreferredSize(new Dimension(0, 75));
        painelServicos.add(labelServicos);
        painel1.add(painelServicos, BorderLayout.NORTH);
        JPanel painelComboBox = new JPanel();
        painelComboBox.setOpaque(false);
        painelComboBox.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel painela = new JPanel();
        JPanel painelb = new JPanel();
        painela.setOpaque(false);
        painelb.setOpaque(false);
        painela.setPreferredSize(new Dimension(0, 30));
        painelb.setPreferredSize(new Dimension(0, 30));

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelComboBox.add(comboBoxcortes, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelComboBox.add(painela, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelComboBox.add(comboBoxtrancas, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelComboBox.add(painelb, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        painelComboBox.add(comboBoxPintar, gbc);
        painel1.add(painelComboBox, BorderLayout.CENTER);

        //configurando painel2;
        painel2.setLayout(new BoxLayout(painel2, BoxLayout.Y_AXIS));
        painel2.add(Box.createRigidArea(new Dimension(0, 50)));
        JPanel painelCaixa = new JPanel();
        painelCaixa.setOpaque(false);
        painelCaixa.add(caixaTelefone);
        painel2.add(painelCaixa);
        painel2.add(labelNome);
        painel2.add(labelApelido);
        painel2.add(labelEmail);
        painel2.add(Box.createRigidArea(new Dimension(0, 70)));
        painel2.add(labelestado);

        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 10));
        painelEsquerdo.setLayout(new BorderLayout());
        painelEsquerdo.add(painel1, BorderLayout.CENTER);

        JPanel painelDireito = new JPanel();
        painelDireito.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 40));
        painelDireito.setLayout(new BorderLayout());
        painelDireito.add(painel2, BorderLayout.CENTER);

        // criar painel do tipo gridLayout para deixar os elemntos lado a lado
        JPanel painelCenter = new JPanel();
        painelCenter.setLayout(new GridLayout(1, 2));
        painelCenter.add(painelEsquerdo);
        painelCenter.add(painelDireito);

        // colocando sem opacidade;
        painelCenter.setOpaque(false);
        painelEsquerdo.setOpaque(false);
        painelDireito.setOpaque(false);

        this.add(painelCenter, BorderLayout.CENTER);
        this.add(painelbotaoCenter, BorderLayout.SOUTH);
        this.add(painelMarcarAtendimento, BorderLayout.NORTH);
    }

    public void adicionarCortes(String a) {
        comboBoxcortes.addItem(a);
    }

    public void adicionarTrancas(String a) {
        comboBoxtrancas.addItem(a);
    }

    public void adicionarPinuras(String a) {
        comboBoxPintar.addItem(a);
    }

    public String obterCorte() {
        return (String) comboBoxcortes.getSelectedItem();
    }

    public String obterTranca() {
        return (String) comboBoxtrancas.getSelectedItem();
    }

    public String obterPintura() {
        return (String) comboBoxPintar.getSelectedItem();
    }
}
