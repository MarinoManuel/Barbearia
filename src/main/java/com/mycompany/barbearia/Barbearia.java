package com.mycompany.barbearia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Barbearia {

    public static void main(String[] args) throws SQLException {
        Conexao.Conexao();
        // Testa o método para obter todos os recibos
        List<Recibo> todosRecibos = Funcoes_BD.obterTodosRecibos();
        // Imprime os recibos
        for (Recibo recibo : todosRecibos) {
            System.out.println("ID do Recibo: " + recibo.getIdRecibo());
            System.out.println("Data do Recibo: " + recibo.getDataRecibo());
            System.out.println("Data de Atendimento: " + recibo.getDataAtendimento());
            System.out.println("Estado: " + recibo.getEstado());
            System.out.println("------------------------------");
        }
   
    }
}
