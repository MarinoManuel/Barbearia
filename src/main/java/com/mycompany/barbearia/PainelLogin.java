package com.mycompany.barbearia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PainelLogin extends PainelFundo implements ActionListener {

    JLabel labelGirando = new JLabel();
    JPanel painelBotaoEntrar_LabelGirando;

    JPanel painelEntrada;
    JTextField caixaUsuario;
    JPasswordField caixaPassword;
    JButton botaoEntrar;
    JLabel labelEstadoPainelLogin;

    JPanel painelCenntralizado;

    public PainelLogin() {
        super("src\\main\\java\\Imagens\\5570834.jpg");
        this.setLayout(new BorderLayout());

        labelGirando = new JLabel();
        labelGirando.setIcon(new ImageIcon("src\\main\\java\\Imagens\\grey-9026_256.gif"));

        painelBotaoEntrar_LabelGirando = new JPanel();
        painelBotaoEntrar_LabelGirando.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        painelBotaoEntrar_LabelGirando.setOpaque(false);

        botaoEntrar = new JButton("Entrar");
        
        caixaUsuario = new JTextField(25);
        caixaPassword = new JPasswordField(25);
        botaoEntrar.addActionListener(this);
        criarPainelCentralizado();
        criarPainelEntrada();
    }

    public void addPainelCentralizado() {
        this.add(painelCenntralizado);
    }

    public void removerPainelCentralizado() {
        super.remove(painelCenntralizado);
    }

    public void removerTudo() {
        removerPainelCentralizado();
        removerPainelEntrada();
    }

    private void criarPainelEntrada() {
        JLabel labelDigitarUsuario = new JLabel("Qual seu nome de usuario?");
        labelDigitarUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel labelDigitePassword = new JLabel("qual e a sua senha?");
        labelDigitePassword.setFont(new Font("Arial", Font.BOLD, 20));
        painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelEntrada.add(labelDigitarUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelEntrada.add(caixaUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelEntrada.add(labelDigitePassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painelEntrada.add(caixaPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 0, 1, 0);  // Margens ao redor do componente (topo, esquerda, baixo, direita)
        painelBotaoEntrar_LabelGirando.add(botaoEntrar);
        painelBotaoEntrar_LabelGirando.add(labelGirando);
        painelEntrada.add(painelBotaoEntrar_LabelGirando, gbc);

        labelEstadoPainelLogin = new JLabel();
        labelEstadoPainelLogin.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;
        gbc.gridy = 5;
        painelEntrada.add(labelEstadoPainelLogin, gbc);
        painelEntrada.setOpaque(false);
    }

    public void addPainelEntrada() {
        this.add(painelEntrada);

    }
    public void ativarLabelGirando(){
        labelGirando.setVisible(true);
    }
    public void desativarLabelGirando(){
        labelGirando.setVisible(false);
    }
    
    public void removerPainelEntrada() {
        this.remove(painelEntrada);
    }
    public void ativarLabelGirandoDesativarBotao (){
         ativarLabelGirando();
         botaoEntrar.setEnabled(false);
    }
    
    public void desativarLabelGirandoAtivarBotao(){
             desativarLabelGirando();
             botaoEntrar.setEnabled(true);
    }

    private void criarPainelCentralizado() {
        painelCenntralizado = new JPanel();
        painelCenntralizado.setLayout(new GridBagLayout());

        JLabel labelTesteConexao = new JLabel("Carregando recursos");
        labelTesteConexao.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel fotoConexao = new JLabel();
        fotoConexao.setIcon(new ImageIcon("src\\main\\java\\Imagens\\grey-9026_256.gif"));
        desativarLabelGirando();
        painelCenntralizado.add(labelTesteConexao);
        painelCenntralizado.add(fotoConexao);
        painelCenntralizado.setOpaque(false);
    }

    public String getPassword() {
        return new String(caixaPassword.getPassword());
    }

    public String getUsuario() {
        return caixaUsuario.getText();
    }

    public void mudarEstadoVarivelLogin0() {
        labelEstadoPainelLogin.setText("Bem sucedido");
    }

    public void mudarEstadoVarivelLogin1() {
        labelEstadoPainelLogin.setText("Numero de caracteres excedido!");
    }

    public void mudarEstadoVarivelLogin2() {
        labelEstadoPainelLogin.setText("Nome de usuario nao existe");
    }

    public void mudarEstadoVarivelLogin3() {
        labelEstadoPainelLogin.setText("Senha errada!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ((JButton) e.getSource() == botaoEntrar) {
            Controlador.listenerBotaoEntrar();
        }
    }
}
