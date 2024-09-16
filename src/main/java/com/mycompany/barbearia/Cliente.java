package com.mycompany.barbearia;

public class Cliente {
    private String numTelefone;
    private String nomeCliente;
    private String apelidoCliente;
    private String email;

    // Construtor
    public Cliente(String numTelefone, String nomeCliente, String apelidoCliente, String email) {
        this.numTelefone = numTelefone;
        this.nomeCliente = nomeCliente;
        this.apelidoCliente = apelidoCliente;
        this.email = email;
    }

    // Getters e Setters
    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getApelidoCliente() {
        return apelidoCliente;
    }

    public void setApelidoCliente(String apelidoCliente) {
        this.apelidoCliente = apelidoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
