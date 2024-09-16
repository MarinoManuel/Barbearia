package com.mycompany.barbearia;

public class Recibo {

    private String idRecibo;
    private java.sql.Timestamp dataRecibo;
    private java.sql.Timestamp dataAtendimento;
    private double estado;  // Alterado para boolean

    // Construtor
    public Recibo(String idRecibo, java.sql.Timestamp dataRecibo, java.sql.Timestamp dataAtendimento, double estado) {
        this.idRecibo = idRecibo;
        this.dataRecibo = dataRecibo;
        this.dataAtendimento = dataAtendimento;
        this.estado = estado;
    }

    // Getters e Setters
    public String getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(String idRecibo) {
        this.idRecibo = idRecibo;
    }

    public java.sql.Timestamp getDataRecibo() {
        return dataRecibo;
    }

    public void setDataRecibo(java.sql.Timestamp dataRecibo) {
        this.dataRecibo = dataRecibo;
    }

    public java.sql.Timestamp getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(java.sql.Timestamp dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public double isEstado() {
        return estado;
    }

    public void setEstado(double estado) {
        this.estado = estado;
    }
    public double getEstado(){
        return estado;
    }
}
