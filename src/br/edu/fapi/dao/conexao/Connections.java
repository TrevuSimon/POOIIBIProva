package br.edu.fapi.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	
    public static String url = "jdbc:mysql://localhost:3306/ForcaDB";
    public static String usuario = "root";
    public static String senha = "";

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);

    }


}