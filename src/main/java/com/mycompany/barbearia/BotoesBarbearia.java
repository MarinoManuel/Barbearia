package com.mycompany.barbearia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotoesBarbearia extends JButton {

    // Construtor da classe
    BotoesBarbearia(String nome, Color cor, int tamanhoLetra) {
        super(nome);
        Font fonteNegrito = new Font("Algerian", Font.BOLD, tamanhoLetra);
        super.setFont(fonteNegrito);
        super.setForeground(cor);
        super.setContentAreaFilled(false); // Remove a cor de fundo
        super.setFocusPainted(false); // Remove o foco visual
        super.setBorderPainted(false); // Remove a borda do botão
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // Adicionar um MouseListener para mostrar a borda ao passar o mouse
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Mostrar a borda preta ao passar o mouse
                setBorder(BorderFactory.createLineBorder(Color.BLACK));
                BotoesBarbearia.this.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remover a borda ao sair com o mouse
                setBorder(BorderFactory.createEmptyBorder());
                BotoesBarbearia.this.setBorderPainted(false);
            }
        });
    }
}
