package com.mycompany.barbearia;

public class Servico {

    private String nomeServico;
    private String tipoServico;
    private int preco;

    // Construtor
    public Servico(String nomeServico, String tipoServico, int preco) {
        this.nomeServico = nomeServico;
        this.tipoServico = tipoServico;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
