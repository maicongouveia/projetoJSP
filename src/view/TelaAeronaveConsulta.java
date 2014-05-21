package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import BD.AeronaveBD;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import Control.Aeronave;

public class TelaAeronaveConsulta extends JDialog implements ActionListener{
		
	private int altura;
	private JTable tabelaResultado;
	private DefaultTableModel modelo;
	private TableRowSorter<TableModel> rowSorter;
	
	public TelaAeronaveConsulta(final ResourceBundle bundle,JFrame fr, String opcao){
		
		super(fr, true);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		getContentPane().setLayout(null);
		
		if( opcao.equals("alterar") || opcao.equals("deletar") || opcao.equals("cadastrarVoo") )	
			altura = 330;	
		else
			altura = 380;
				
		//Titulo da tela
		JLabel tituloTela = new JLabel(bundle.getString("telaAeronave.titulo.aeronave"));
		tituloTela.setBounds(15, 10, 250, 40);
	    tituloTela.setFont(new Font(null , Font.BOLD, 40));
	    //Adicionando
		getContentPane().add(tituloTela);
		
		//Painel com Borda
		JPanel painelBorda = new JPanel();
		painelBorda.setBorder(new TitledBorder(null,bundle.getString("telaAeronaveConsulta.tituloBorda.consultaDeAeronave"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBorda.setBounds(10, 50, 750, 500);
		painelBorda.setLayout(null);
		//Adicionando
		getContentPane().add(painelBorda);
		
		
		//Painel com Borda de Pesquisa
		JPanel painelBordaPesquisa = new JPanel();
		painelBordaPesquisa.setBorder(new TitledBorder(null,bundle.getString("telaAeronaveConsulta.tituloBorda.pesquisar"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBordaPesquisa.setBounds(10, 15, 730, 80);
		painelBordaPesquisa.setLayout(null);
		//Adicionando
		painelBorda.add(painelBordaPesquisa);
		
		//Itens do Painel de Pesquisa
		
		//Codigo da Aeronave
		JLabel lblCodAeronave = new JLabel(bundle.getString("telaAeronaveCadastra.label.codigoAeronave")+ ":");
		lblCodAeronave.setBounds(15, 20, 130, 20);
		//Adicionando
		painelBordaPesquisa.add(lblCodAeronave);
		
		//Campo - Codigo da Aeronave
		final JTextField codAeronave = new JTextField();
		codAeronave.addCaretListener(new CaretListener() {
			   public void caretUpdate(CaretEvent arg0) {
				    String text = codAeronave.getText().trim();
				    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text, 0));
				   }
				  });

		codAeronave.setBounds(140, 20, 100, 20);
		codAeronave.setEnabled(true);
		codAeronave.setColumns(20);
	    //Adicionando
		painelBordaPesquisa.add(codAeronave);
		
		//Nome da Aeronave
		JLabel lblNomeAeronave = new JLabel(bundle.getString("telaAeronaveCadastra.label.nomeAeronave")+ ":");
		lblNomeAeronave.setBounds(250, 20, 130, 20);
		//Adicionando
		painelBordaPesquisa.add(lblNomeAeronave);
		//Campo - Nome da Aeronave
		final JTextField nomeAeronave = new JTextField();
		nomeAeronave.addCaretListener(new CaretListener() {
			   public void caretUpdate(CaretEvent arg0) {
				    String text = nomeAeronave.getText().trim();
				    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text, 1));
				   }
				  });
		nomeAeronave.setBounds(373, 20, 95, 20);
		nomeAeronave.setEnabled(true);
		nomeAeronave.setColumns(20);
		//Adicionando
		painelBordaPesquisa.add(nomeAeronave);
		
		//Quantidade de Acentos
		JLabel lblqtdAcentos = new JLabel(bundle.getString("telaAeronaveCadastra.label.qtdAcentos")+ ":");
		lblqtdAcentos.setBounds(483, 20, 150, 20);
		
		JLabel lblTipo = new JLabel(bundle.getString("telaAeronaveCadastra.label.tipo")+ ":");
		lblTipo.setBounds(483, 40, 150, 25);
		//Adicionando
		painelBordaPesquisa.add(lblTipo);
		painelBordaPesquisa.add(lblqtdAcentos);
		
		final JComboBox cTipo = new JComboBox();
		cTipo.setModel(new DefaultComboBoxModel(new String[] {"Selecione..","Transporte","Carga","Particular"}));
		cTipo.setBounds(630, 40, 95, 20);
		cTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String text = (String)cTipo.getSelectedItem(); 
					if(!text.equals("Selecione..")){
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text, 3));
					}
					
				}
			});
		painelBordaPesquisa.add(cTipo);
		
		//Campo - Quantidade de Acentos
		final JTextField qtdAcentos  = new JTextField();
		qtdAcentos.addCaretListener(new CaretListener() {
			   public void caretUpdate(CaretEvent arg0) {
				    String text = qtdAcentos.getText().trim();
				    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,2));
				   }
				  });
		qtdAcentos.setBounds(630, 20, 95, 20);
		qtdAcentos.setEnabled(true);
		qtdAcentos.setColumns(10);
		//Adicionando
		painelBordaPesquisa.add(qtdAcentos);
		
		if(opcao.equals("consulta")){
			//Botão de Voltar
			JButton voltar = new JButton(bundle.getString("telaAeronaveConsulta.button.voltar"));
			voltar.setBounds(15, 51, 100, 20);
			
			//AdicionarEvento
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						dispose();
				}
			});
			painelBordaPesquisa.add(voltar);
			
		}
		
		//Tabela com Resultado
		
		JPanel painelTabela = new JPanel();
		painelTabela.setBounds(12, 100, 725, altura);
		painelTabela.setLayout(new BorderLayout(0, 0));
		
		//Adicionando
		painelBorda.add(painelTabela);
		
		//Configurando Tabela
		tabelaResultado = new JTable();
		
		modelo = new DefaultTableModel(new String[]
				 			{ 
								bundle.getString("telaAeronaveCadastra.label.codigoAeronave"),
								bundle.getString("telaAeronaveCadastra.label.nomeAeronave"),
								bundle.getString("telaAeronaveCadastra.label.qtdAcentos"),
								bundle.getString("telaAeronaveCadastra.label.tipo")
							 },30);
		
		tabelaResultado.setModel(modelo);
		
		// Largura das Colunas		
		tabelaResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabelaResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelaResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        // Sem o scroll pane o JTable fica zuado        
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tabelaResultado);
		painelTabela.add(scroll, BorderLayout.CENTER);
		pesquisar();
		
		// Esse metodo filtra os campos do JTable
		sort();

		//Botão
		String botao;
		
		if(opcao.equals("cadastrarVoo")){ botao = bundle.getString("telaAeronaveCadastra.button.cadastrar");}
		else						    { botao = bundle.getString("telaAeronaveCadastra.button.proximo");}
		JButton proximo = new JButton(botao);
		proximo.setBounds(600, 450, 100, 30);
		
		if( opcao.equals("alterar")){
			//Botão de Voltar
			JButton voltar = new JButton(bundle.getString("telaAeronaveConsulta.button.voltar"));
			voltar.setBounds(490, 450, 100, 30);
			
			//AdicionarEvento
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						dispose();
				}
			});
			painelBorda.add(voltar);
			proximo.addActionListener(
		              new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		                	 TelaAeronaveAlterar tAeronaveAlterar = new TelaAeronaveAlterar(bundle,null,aeronaveSelecionada());
		                	 tAeronaveAlterar.setVisible(true);
		                	 pesquisar();
		                 }
		              });
			painelBorda.add(proximo);
		}
		else if(opcao.equals("deletar") ){
			//Botão de Voltar
			JButton voltar = new JButton(bundle.getString("telaAeronaveConsulta.button.voltar"));
			voltar.setBounds(490, 450, 100, 30);
			
			//AdicionarEvento
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						dispose();
				}
			});
			painelBorda.add(voltar);
			proximo.addActionListener(
		              new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		                	 TelaAeronaveDeletar tAeronaveDeletar = new TelaAeronaveDeletar(bundle,null,aeronaveSelecionada());
		                	 tAeronaveDeletar.setVisible(true);
		                 
		                 }
		              });
			painelBorda.add(proximo);
			
		}
		else if(opcao.equals("cadastrarVoo") ){
			//Botão de Voltar
			JButton voltar = new JButton(bundle.getString("telaAeronaveConsulta.button.voltar"));
			voltar.setBounds(490, 450, 100, 30);
			
			//AdicionarEvento
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						dispose();
				}
			});
			painelBorda.add(voltar);
			proximo.addActionListener(
		              new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		                	 JOptionPane.showMessageDialog(null, bundle.getString("telaVooCadastra.resposta.cadastroSucesso"));
		                	 dispose();
		                 
		                 }
		              });
			painelBorda.add(proximo);
			
		}
				
		this.setLocationRelativeTo(null);
	}
	
	//nao esta usando.
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void pesquisar(){		
		AeronaveBD bd = new AeronaveBD();
		modelo = (DefaultTableModel) bd.pesquisarAeronave(tabelaResultado.getModel());		
	}
	
	public Aeronave aeronaveSelecionada(){
   	 	String cod = ""+tabelaResultado.getValueAt(tabelaResultado.getSelectedRow(),0);
   	 	int codigo = Integer.parseInt(cod);
   	 	Aeronave aeronave = new Aeronave(codigo);
   	 	return aeronave.pesquisar(codigo);
	}
	
	public void sort(){
	  if (rowSorter == null) {
	   rowSorter = new TableRowSorter<TableModel>(tabelaResultado.getModel());
	   tabelaResultado.setRowSorter(rowSorter);
	  }
	}
	
	
}
