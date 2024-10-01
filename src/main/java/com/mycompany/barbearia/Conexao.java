package com.mycompany.barbearia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    private static Connection connection;

    public static Connection Conexao() {
        /*
        create table if not exists usuarios(username varchar(45), userpassword varchar(45) not null, primary key(username));
        create table if not exists clientes(numtelefone varchar(14), nomecliente varchar(15) not null, apelidocliente varchar(15) not null, email varchar(45), primary key(numtelefone) );
        create table if not exists servicos(nomeservico varchar(45), tiposervico varchar(45), preco decimal not null, primary key(nomeservico, tiposervico) );
        create table if not exists barbeiros(nomebarbeiro varchar(45) primary key);
        create table if not exists reciboRelacoes(idRecibo varchar(45) , username varchar(45) , nomeservico varchar(45) , tiposervico varchar(45) , numtelefone varchar(15)  , nomebarbeiro varchar(45) ,
        primary key(idrecibo, username, nomeservico, tiposervico, numtelefone, nomebarbeiro),foreign key (idrecibo) references Recibos(idrecibo), foreign key (username) references usuarios(username), foreign key (nomeservico, tiposervico) references servicos(nomeservico, tiposervico), foreign key (numtelefone) references clientes(numtelefone), foreign key (nomebarbeiro) references barbeiros(nomebarbeiro));
        create table recibos(idRecibo varchar(45) primary key, datarecibo datetime, dataAtendimento datetime, estado tinyint(1));
         */

        String url = "jdbc:mysql://localhost:3306/barbearia";
        String user = "root";
        String password = "*#MARLO321*#";

        connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao bem sucedida!");
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            return connection;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou consultar o banco de dados: " + e.getMessage());
            return connection;
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexao: " + e.getMessage());
        }
    }

    public static Connection getC() {
        return connection;
    }
}
