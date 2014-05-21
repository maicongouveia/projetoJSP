package Model;

import java.sql.*;

public class TesteBD {
	public static void main(String args[]) {
		Conexao bd = new Conexao();
		Connection cn = null;
		try {
			cn = bd.obtemConexao();
			if (cn != null)
				System.out.println("Sucessoo!!!");

			else
				System.out.println("Bugggggggggg!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (Exception ex) {

			}

		}
		System.exit(0);
	}
}