package com.mycompany.barbearia;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Controlador {

    static JanelaPrincipal janelaPrincipal;
    static PainelLogin painelLogin;

    Controlador() throws InterruptedException {
        Conexao.Conexao();
        SwingUtilities.invokeLater(() -> {
            janelaPrincipal = new JanelaPrincipal();
            painelLogin = new PainelLogin();
            janelaPrincipal.add(painelLogin);
            painelLogin.addPainelCentralizado();
            janelaPrincipal.r();
        });
        Thread.sleep(4000);

        SwingUtilities.invokeLater(() -> {
            painelLogin.removerTudo();
            painelLogin.addPainelEntrada();
            janelaPrincipal.r();
        });
    }

    public static void removerPainelLogin(){
        janelaPrincipal.remove(painelLogin);
    }
    
    public static void listenerBotaoEntrar() {
        SwingUtilities.invokeLater(() -> {
            byte a = ValidacaoUsuario.ValidarConsultausuario(painelLogin.getUsuario(), painelLogin.getPassword());
            switch (a) {
                case 0:
                    janelaPrincipal.remove(painelLogin);
                    janelaPrincipal.add(new PainelPrincipal());
                    janelaPrincipal.r();
                    break;
                case 1:
                    painelLogin.mudarEstadoVarivelLogin1();
                    janelaPrincipal.r();
                    break;
                case 2:
                    painelLogin.mudarEstadoVarivelLogin2();
                    janelaPrincipal.r();
                    break;
                case 3:
                    painelLogin.mudarEstadoVarivelLogin3();
                    janelaPrincipal.r();
                    break;
            }
        });
    }
}
