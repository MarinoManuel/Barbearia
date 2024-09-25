package com.mycompany.barbearia;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        super("Janela principal");
        super.setSize(650, 650);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    @Deprecated
    private void tamanhoMinimo() {
        final int larguraMinima = 400;
        final int alturaMinima = 300;
        JanelaPrincipal.this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Obter as dimensões atuais da janela
                Dimension tamanhoAtual = JanelaPrincipal.this.getSize();
                // Verificar se o tamanho é menor que o mínimo permitido
                if (tamanhoAtual.width < larguraMinima || tamanhoAtual.height < alturaMinima) {
                    // Se sim, restaurar para o tamanho mínimo
                    JanelaPrincipal.this.setSize(Math.max(tamanhoAtual.width, larguraMinima), Math.max(tamanhoAtual.height, alturaMinima));
                }
            }
        });
    }

    public void r() {
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
