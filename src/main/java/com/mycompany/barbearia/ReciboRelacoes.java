package com.mycompany.barbearia;

public class ReciboRelacoes {
    private String idRecibo;
    private String userName;
    private String nomeServico;
    private String tipoServico;
    private String numTelefone;
    private String nomeBarbeiro;

    // Construtor
    public ReciboRelacoes(String idRecibo, String userName, String nomeServico, String tipoServico, String numTelefone, String nomeBarbeiro) {
        this.idRecibo = idRecibo;
        this.userName = userName;
        this.nomeServico = nomeServico;
        this.tipoServico = tipoServico;
        this.numTelefone = numTelefone;
        this.nomeBarbeiro = nomeBarbeiro;
    }

    // Getters e Setters
    public String getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(String idRecibo) {
        this.idRecibo = idRecibo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public String getNomeBarbeiro() {
        return nomeBarbeiro;
    }

    public void setNomeBarbeiro(String nomeBarbeiro) {
        this.nomeBarbeiro = nomeBarbeiro;
    }
}
