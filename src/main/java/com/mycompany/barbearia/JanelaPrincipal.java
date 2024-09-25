package com.mycompany.barbearia;


import java.awt.Component;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        super("Janela principal");
        super.setSize(650, 650);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    
    public void r(){
        super.revalidate();
        super.repaint();
    }
    
    @Override
    public Component add(Component e) {
        super.add(e);
        super.repaint();
        super.revalidate();
        return e;
    }
    
}
