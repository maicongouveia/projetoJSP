package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Control.Aeronave;
import Control.Voo;

public class AeronaveBD {

	private PreparedStatement stm = null;
	private String query = "";

	public int getLastIdAeronave(){
		try{
		String query = "SELECT MAX(codigo) as codigo FROM aeronave";
		
		Conexao bd = new Conexao();
		Connection conn = bd.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(query);
		ResultSet rs;
		rs = stm.executeQuery();

		rs.next();
		int lastId = rs.getInt("codigo");

		rs.close();
		stm.close();

		return lastId+1;
		}catch(SQLException e){
			
		}
		return -1;
	}

	public void cadastraAeronave(Aeronave aero) {
		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();

			query = "INSERT INTO aeronave(codigo,nome,fileira,coluna,acentos,tipo) VALUES (?, ?, ?, ?, ?, ?)";
			
			stm = conn.prepareStatement(query);
			
			stm.setInt(1,    aero.getCodigo());
			stm.setString(2, aero.getNome());
			stm.setInt(3,    aero.getFileira());
			stm.setInt(4,    aero.getCodigo());
			stm.setInt(5,    aero.getQuantidade());
			stm.setString(6, aero.getTipo());

			stm.executeUpdate();
			stm.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
		}
	}

	public TableModel pesquisarAeronave(TableModel tableModel) {
		DefaultTableModel model = (DefaultTableModel) tableModel;
		String query;
		query = "SELECT codigo,nome,acentos,tipo from aeronave";

		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(query);
			ResultSet rs;
			rs = stm.executeQuery();
			model.setNumRows(0);
			while (rs.next()) {
				model.addRow(new Object[] { 
						rs.getInt("codigo"),
						rs.getString("nome"), 
						rs.getInt("acentos"), 
						rs.getString("tipo")}

				);
			}

		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
		}

		return model;
	}

	public void alterarAeronave(Aeronave aero) {
		
		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			query = "UPDATE aeronave set nome = ?,fileira = ?,coluna = ?,acentos = ?,tipo = ? where codigo = ?";
			stm = conn.prepareStatement(query);

			stm.setString(1, aero.getNome());
			stm.setInt(   2, aero.getFileira());
			stm.setInt(   3, aero.getColuna());
			stm.setInt(   4, aero.getQuantidade());
			stm.setString(5, aero.getTipo());
			stm.setInt(   6, aero.getCodigo());

			stm.executeUpdate();
			stm.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
			ex.printStackTrace();
		}
	}

	public void deletarAeronave(int cod) {
		try {
			String query;
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			query = "DELETE FROM aeronave WHERE codigo = ?";
			stm = conn.prepareStatement(query);

			stm.setInt(1, cod);

			stm.executeUpdate();
			stm.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
		}
	}
	
	public List<Aeronave> pesquisar() {
		
		ArrayList resultadoPesquisa = new ArrayList<Aeronave>();
		
		String sqlSelect = "SELECT * FROM aeronave";

		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlSelect);

			rs = stm.executeQuery();

			while (rs.next()) {
				Aeronave rsc = new Aeronave(
						rs.getInt("codigo"),
						rs.getInt("fileira"),
						rs.getInt("coluna"),
						rs.getString("nome"),
						rs.getString("tipo")
						);

				resultadoPesquisa.add(rsc);
			}
			return resultadoPesquisa;
			
		} catch (Exception e) {
			e.printStackTrace();
			return resultadoPesquisa;
			
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	public Aeronave consultaAeronave(int codigo){
		String query;
		query = "SELECT * from aeronave WHERE codigo = ?";

		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(query);
			
			stm.setInt(1,codigo);
			
			ResultSet rs;
			rs = stm.executeQuery();
			rs.next();
			Aeronave aeronave = new Aeronave(
					rs.getInt("codigo"),
					rs.getInt("fileira"),
					rs.getInt("coluna"),
					rs.getString("nome"),
					rs.getString("tipo")
					);
			return aeronave;
		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
			ex.printStackTrace();
		}
		return null;
	}
}
