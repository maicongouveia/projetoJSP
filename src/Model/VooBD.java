package Model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Voo;


public class VooBD {

	private PreparedStatement stm = null;
	private String query = "";
	
	public TableModel pesquisarVooCompraIda(TableModel tableModel){
		DateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat formataHora = new SimpleDateFormat("HH:mm");
		DefaultTableModel model = (DefaultTableModel) tableModel;
		String query;
		query = "SELECT destino,data_dia,hora,valor from voo where origem = 'São Paulo' ORDER BY destino";
		
		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(query);
			ResultSet rs;
			rs = stm.executeQuery();
			model.setNumRows(0);
			while (rs.next()) {
				model.addRow(new Object[] { 
						rs.getString("destino"), 
						formataData.format(rs.getDate("data_dia")), 
						formataHora.format(rs.getTime("hora")),
						rs.getString("valor")}

				);
			}

		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
		}

		return model;
		
	}
	
	public TableModel pesquisarVooCompraVolta(TableModel tableModel, int vooSelecionado){
		
		DateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat formataHora = new SimpleDateFormat("HH:mm");
		DefaultTableModel model = (DefaultTableModel) tableModel;
		
		String query;
		
		query = "SELECT destino,data_dia,hora,valor from voo";
		
		
		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(query);
			ResultSet rs;
			rs = stm.executeQuery();
			model.setNumRows(0);
			while (rs.next()) {
				model.addRow(new Object[] { 
						rs.getString("destino"), 
						formataData.format(rs.getDate("data_dia")), 
						formataHora.format(rs.getTime("hora")),
						rs.getString("valor")}

				);
			}

		} catch (SQLException ex) {
			System.out.println(query);
			System.out.println("ocorreu um erro de SQL!");	
		}

		return model;
		
	}
	
	public TableModel pesquisarVoo(TableModel tableModel){
		DateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat formataHora = new SimpleDateFormat("HH:mm");
		DefaultTableModel model = (DefaultTableModel) tableModel;
		String query;
		query = "SELECT codigo,origem,destino,data_dia,hora,status_vo,valor from voo";

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
						rs.getString("origem"), 
						rs.getString("destino"), 
						formataData.format(rs.getDate("data_dia")), 
						formataHora.format(rs.getTime("hora")), 
						rs.getString("status_vo"),
						rs.getDouble("valor")}

				);
			}

		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
		}

		return model;
	}

	public int getLastIdVoo(){
		try{
			String query = "SELECT MAX(codigo) as codigo FROM voo";
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

	
	public void cadastraVoo(Voo vo) {
		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			
			query = "INSERT INTO voo(origem,destino,data_dia,hora,status_vo,valor,cod_aeronave) VALUES (?, ?, ?, ?, ?, ?, ?)";
			stm = conn.prepareStatement(query);
			stm.setString(1, vo.getOrigem());
			stm.setString(2, vo.getDestino());
			stm.setDate(3,   vo.getData());
			stm.setTime(4,   vo.getHora());
			stm.setString(5, vo.getStatus());
			stm.setString(6, vo.getValor());
			stm.setInt(7,    vo.getAero());

			stm.executeUpdate();
			stm.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
		}
	}
	
	public void alterarVoo(Voo voo) {			
		try {			
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			query = "UPDATE VOO set origem = ?,destino = ?,data_dia = ?,hora = ?,status_vo = ?,valor = ?,cod_aeronave = ? where codigo = ?";
			stm = conn.prepareStatement(query);
			
			System.out.println(voo.getCodigo());
			
			stm.setString(1, voo.getOrigem());
			stm.setString(2, voo.getDestino());
			stm.setDate(  3, voo.getData());
			stm.setTime(  4, voo.getHora());
			stm.setString(5, voo.getStatus());
			stm.setString(6, voo.getValor());
			stm.setInt(   7, voo.getAero());
			stm.setInt(   8, voo.getCodigo());
			
			stm.executeUpdate();
			stm.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
			ex.printStackTrace();
		}
	}
	
	public Voo consultaVoo(int codigo){
		String query;
		query = "SELECT * from voo WHERE codigo = ?";

		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(query);
			
			stm.setInt(1,codigo);
			
			ResultSet rs;
			rs = stm.executeQuery();
			rs.next();
			
			Voo voo = new Voo(
					rs.getInt("codigo"),
					rs.getString("origem"),
					rs.getString("destino"),
					rs.getDate("data_dia"),
					rs.getTime("hora"),
					rs.getString("status_vo"),
					rs.getString("valor"),
					rs.getInt("cod_aeronave")
					);
			return voo;
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("ocorreu um erro de SQL!");
			
		}
		return null;
	}
	
	public void deletarAeronave(int cod) {
		try {
			Conexao bd = new Conexao();
			Connection conn = bd.obtemConexao();
			String query;
			query = "DELETE FROM voo WHERE codigo = ?";
			stm = conn.prepareStatement(query);

			stm.setInt(1, cod);

			stm.executeUpdate();
			stm.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("ocorreu um erro de SQL!");
		}
	}
	
}

