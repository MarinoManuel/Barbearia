package com.mycompany.barbearia;

public class ReciboCompleto {

    private String idRecibo;
    private java.sql.Timestamp dataRecibo;
    private java.sql.Timestamp dataAtendimento;
    private double estado;
    private String userName;
    private String nomeServico;
    private String tipoServico;
    private String numTelefone;
    private String nomeBarbeiro;

    public ReciboCompleto(String idRecibo, java.sql.Timestamp dataRecibo, java.sql.Timestamp dataAtendimento,
            double estado, String userName, String nomeServico, String tipoServico,
            String numTelefone, String nomeBarbeiro) {
        this.idRecibo = idRecibo;
        this.dataRecibo = dataRecibo;
        this.dataAtendimento = dataAtendimento;
        this.estado = estado;
        this.userName = userName;
        this.nomeServico = nomeServico;
        this.tipoServico = tipoServico;
        this.numTelefone = numTelefone;
        this.nomeBarbeiro = nomeBarbeiro;
    }

    // Getters
    public String getIdRecibo() {
        return idRecibo;
    }

    public java.sql.Timestamp getDataRecibo() {
        return dataRecibo;
    }

    public java.sql.Timestamp getDataAtendimento() {
        return dataAtendimento;
    }

    public double getEstado() {
        return estado;
    }

    public String getUserName() {
        return userName;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public String getNomeBarbeiro() {
        return nomeBarbeiro;
    }
}
