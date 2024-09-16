package com.mycompany.barbearia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Barbearia {

    public static void main(String[] args) throws SQLException {
        Conexao.Conexao();
        // Substitua "SEU_ID_RECIBO" pelo ID do recibo que você deseja testar
        String idRecibo = "recibo123";

        try {
            // Chama o método para obter recibos com relações
            List<ReciboCompleto> recibosComRelacoes = Funcoes_BD.obterRecibosComRelacoes(idRecibo);

            // Verifica se a lista retornada não está vazia
            if (recibosComRelacoes.isEmpty()) {
                System.out.println("Nenhum recibo encontrado para o ID: " + idRecibo);
            } else {
                // Imprime os recibos completos com suas relações
                for (ReciboCompleto reciboCompleto : recibosComRelacoes) {
                    System.out.println("ID do Recibo: " + reciboCompleto.getIdRecibo());
                    System.out.println("Data do Recibo: " + reciboCompleto.getDataRecibo());
                    System.out.println("Data do Atendimento: " + reciboCompleto.getDataAtendimento());
                    System.out.println("Estado: " + reciboCompleto.getEstado());
                    System.out.println("Nome do Usuário: " + reciboCompleto.getUserName());
                    System.out.println("Nome do Serviço: " + reciboCompleto.getNomeServico());
                    System.out.println("Tipo do Serviço: " + reciboCompleto.getTipoServico());
                    System.out.println("Número de Telefone: " + reciboCompleto.getNumTelefone());
                    System.out.println("Nome do Barbeiro: " + reciboCompleto.getNomeBarbeiro());
                    System.out.println("-------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
