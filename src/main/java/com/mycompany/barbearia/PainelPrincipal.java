package com.mycompany.barbearia;

import java.awt.BorderLayout;

public class PainelPrincipal extends PainelFundo {

    BotoesBarbearia botaoMarcar;
    BotoesBarbearia botaoServicos;
    BotoesBarbearia botaoFuncioanarios;
    BotoesBarbearia botaoCliente;

    public PainelPrincipal() {
        super("src\\main\\java\\Imagens\\funcionarios_background.png");
        super.setLayout(new BorderLayout());
    }

}
