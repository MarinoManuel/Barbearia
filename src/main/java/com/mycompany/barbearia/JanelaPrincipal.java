package com.mycompany.barbearia;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal(){
        super("BarberShop");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(400, 400 );
        PainelFundo painelInicial = new PainelFundo("Imagens\\FundoLogin.jpg");
        add(painelInicial);     
        
        setVisible(true);
    }
    
}
