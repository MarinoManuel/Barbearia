package com.mycompany.barbearia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PainelLogin extends PainelFundo implements ActionListener {
    JPanel painelCenntralizado;
    JButton botaoReconectar;
    JPanel painelBotaoReconectar;
    
    public PainelLogin() {
        super("5570834.jpg");
        this.setLayout(new BorderLayout());
        criarPainelCentralizado();
        botaoReconectar = new JButton("Reconectar");
        botaoReconectar.setPreferredSize(new Dimension(100,100));
        botaoReconectar.addActionListener(this);
    }
    
    public void addPainelCentralizado(){
     this.add(painelCenntralizado);
    }
    
    public void removerPainelCentralizado(){
        if(painelCenntralizado != null){
        super.remove(painelCenntralizado);
        }
    }
    
    public void removerTudo(){
        removerPainelBotaoReconectar();
        removerPainelCentralizado();
    }
    
    public void addpainelBotaoReconectar(){
        painelBotaoReconectar = new JPanel();
        painelBotaoReconectar.setLayout(new GridBagLayout());
        painelBotaoReconectar.setOpaque(false);
        painelBotaoReconectar.add(botaoReconectar);
        this.add(painelBotaoReconectar);
    }
    public void removerPainelBotaoReconectar(){
        if(painelBotaoReconectar != null){
        this.remove(painelBotaoReconectar);
        }
    }
    
    private void criarPainelCentralizado(){
        painelCenntralizado = new JPanel();
        painelCenntralizado.setLayout(new GridBagLayout());
        
        JLabel labelTesteConexao = new JLabel("Verificando sua conexao");
        labelTesteConexao.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel fotoConexao = new JLabel();
        fotoConexao.setIcon(new ImageIcon("grey-9026_256.gif"));
       
        painelCenntralizado.add(labelTesteConexao);
        painelCenntralizado.add(fotoConexao);
        painelCenntralizado.setOpaque(false);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if( (JButton)e.getSource() == botaoReconectar){
            Controlador.listenerBotaoReconectar();
        }
    }
}
