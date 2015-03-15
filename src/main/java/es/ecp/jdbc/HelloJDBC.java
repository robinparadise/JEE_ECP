package es.ecp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC {
	public static void main(String[] args) {
		Connection conexion = null;
		Statement sentencia = null;
		String url = "jdbc:mysql://localhost:3306/jee";
		String user = "root";
		String pass = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, pass);
			sentencia = conexion.createStatement();
			System.out.println("OK. Driver cargado");
		} catch (ClassNotFoundException e) {
			System.out.println("Imposible cargar el driver: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Imposible conectar: " + e.getMessage());
		}
	}
}
