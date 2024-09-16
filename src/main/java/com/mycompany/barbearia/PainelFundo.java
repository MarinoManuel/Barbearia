package com.mycompany.barbearia;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainelFundo extends JPanel {
    private BufferedImage imagemFundo;
    
    public PainelFundo(String caminho){
        try{
        imagemFundo = ImageIO.read(new File(caminho));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagemFundo != null){
            g.drawImage(imagemFundo, 0, 0,getWidth(), getHeight(), this);
        }
    }
    ///aa
}
