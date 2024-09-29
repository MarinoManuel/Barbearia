package com.mycompany.barbearia;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Controlador {

    static JanelaPrincipal janelaPrincipal;
    static PainelLogin painelLogin;
    static PainelMarcacao painelMarcacao;
    static PainelPrincipal painelPrincipal;

    Controlador() throws InterruptedException {
        Conexao.Conexao();
        SwingUtilities.invokeLater(() -> {
            janelaPrincipal = new JanelaPrincipal();
            painelLogin = new PainelLogin();
            painelMarcacao = new PainelMarcacao();
            janelaPrincipal.add(painelLogin);
            painelLogin.addPainelCentralizado();
            janelaPrincipal.r();
        });
        Thread.sleep(1000);

        SwingUtilities.invokeLater(() -> {
            painelLogin.removerTudo();
            painelLogin.addPainelEntrada();
            janelaPrincipal.r();
        });
    }

    public static void removerPainelLogin() {
        janelaPrincipal.remove(painelLogin);
    }

    public static void listenerBotaoMarcar() {
        janelaPrincipal.remove(painelPrincipal);
        janelaPrincipal.add(painelMarcacao);
        janelaPrincipal.r();
    }
    
    public static void listenerMarcacaoCaixaTelefone() throws SQLException{
        String numTelefone = painelMarcacao.obterTexto();
        Cliente cliente = Funcoes_BD.consultarCliente(numTelefone);
        if(cliente != null){
            painelMarcacao.desativarLabelEstado();
            painelMarcacao.labelNome.setText("Nome: "+ cliente.getNomeCliente());
            painelMarcacao.labelApelido.setText("Apelido: "+ cliente.getApelidoCliente());
            painelMarcacao.labelEmail.setText("Email: "+ cliente.getEmail());
            janelaPrincipal.r();
        }
    }
    public static void listenerBotaoEntrar() {
        SwingUtilities.invokeLater(() -> {
            byte a = ValidacaoUsuario.ValidarConsultausuario(painelLogin.getUsuario(), painelLogin.getPassword());
            switch (a) {
                case 0:
                    janelaPrincipal.remove(painelLogin);
                    painelPrincipal = new PainelPrincipal(painelLogin.caixaUsuario.getText());
                    janelaPrincipal.add(painelPrincipal);
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
