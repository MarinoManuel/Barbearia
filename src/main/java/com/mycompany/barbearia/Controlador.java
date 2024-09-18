package com.mycompany.barbearia;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Controlador {

    private static Object chave = new Object();
    private static boolean verificadorChave;
    private static boolean estadoConexao;

    static JanelaPrincipal janelaPrincipal;
    static PainelLogin painelLogin;

    Controlador() {
        janelaPrincipal = new JanelaPrincipal();
        painelLogin = new PainelLogin();
        janelaPrincipal.add(painelLogin);
        primeiraIteracao();
    }

    public static void primeiraIteracao() {
        SwingUtilities.invokeLater(() -> {
            verificadorChave = false;
            painelLogin.removerTudo();
            painelLogin.addPainelCentralizado();
            painelLogin.revalidate();
            painelLogin.repaint();
            janelaPrincipal.repaint();
            janelaPrincipal.revalidate();

            Thread verificarInternet = new Thread(() -> {
                synchronized (chave) {
                    estadoConexao = VerificacaoConexao.VerificarConexao();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    verificadorChave = true;
                    chave.notify();
                }
            });
            verificarInternet.start();

            Thread oquefazer = new Thread(() -> {

                synchronized (chave) {
                    while (!verificadorChave) {
                        try {
                            chave.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (estadoConexao == true) {
                        System.out.println("all Right programer");
                        System.out.println("estado if");
                    } else {
                        System.out.println("estado else");
                        painelLogin.removerTudo();
                        painelLogin.addpainelBotaoReconectar();
                        janelaPrincipal.repaint();
                        janelaPrincipal.revalidate();
                    }
                }
            });
            oquefazer.start();
        });
    }

    public static void listenerBotaoReconectar() {
        primeiraIteracao();
    }
}
