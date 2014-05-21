package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Aeronave;
import Controller.Voo;

public class Conexao {

	private PreparedStatement stm = null;
	private String query = "";
	private Connection conn;
	
	/**
	 * Classe responsável pela conexão com banco de dados MySQL
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// -----------------------------------------------------------
	// Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/aeroporto?user=root&password=");
	}

}
