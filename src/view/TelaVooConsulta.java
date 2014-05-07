package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import BD.VooBD;
import Control.Voo;

public class TelaVooConsulta extends JDialog {
		
	private int altura;
	private DefaultTableModel modelo;
	private TableRowSorter<TableModel> rowSorter;
	private JTable tabelaResultado;
	
	private ResourceBundle bundle;
	
	public TelaVooConsulta(final ResourceBundle bundle,JFrame fr, String opcao){
		
		super(fr, true);
		setBounds(100, 100, 800, 650);
		setResizable(false);
		getContentPane().setLayout(null);
		
		this.bundle = bundle;
		
		if( opcao.equals("alterar") || opcao.equals("deletar") )	
			altura = 330;	
		else
			altura = 380;
				
		//Titulo da tela
		JLabel tituloTela = new JLabel(bundle.getString("telaVoo.titulo.voo"));
		tituloTela.setBounds(15, 10, 250, 40);
	    tituloTela.setFont(new Font(null , Font.BOLD, 40));
	    //Adicionando
		getContentPane().add(tituloTela);
		
		//Painel com Borda
		JPanel painelBorda = new JPanel();
		painelBorda.setBorder(new TitledBorder(null,bundle.getString("telaVooConsulta.tituloBorda.consultaDeVoo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBorda.setBounds(10, 50, 770, 640);
		painelBorda.setLayout(null);
		//Adicionando
		getContentPane().add(painelBorda);
		
		
		//Painel com Borda de Pesquisa
		JPanel painelBordaPesquisa = new JPanel();
		painelBordaPesquisa.setBorder(new TitledBorder(null,bundle.getString("telaVooConsulta.tituloBorda.pesquisar"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBordaPesquisa.setBounds(10, 15, 730, 140);
		painelBordaPesquisa.setLayout(null);
		//Adicionando
		painelBorda.add(painelBordaPesquisa);
		
		//Itens do Painel de Pesquisa
		
		//Codigo de Vôo
		JLabel lblCodVoo = new JLabel(bundle.getString("telaVooCadastra.label.codigoVoo")+ ":");
		lblCodVoo.setBounds(15, 20, 90, 20);
		//Adicionando
		painelBordaPesquisa.add(lblCodVoo);
		
		//Campo - Codigo da Voo
		final JTextField codVoo = new JTextField();
		codVoo.addCaretListener(new CaretListener() {
			   public void caretUpdate(CaretEvent arg0) {
				    String text = codVoo.getText().trim();
				    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,0));
				   }
				  });
		codVoo.setBounds(105, 20, 100, 20);
		codVoo.setEnabled(true);
	    //Adicionando
		painelBordaPesquisa.add(codVoo);
		
		//Origem
		JLabel lblOrigem = new JLabel(bundle.getString("telaVooCadastra.label.origem")+ ":");
		lblOrigem.setBounds(210, 20, 50, 20);
		//Adicionando
		painelBordaPesquisa.add(lblOrigem);
		
		//Campo - Origem
		final JComboBox origem = new JComboBox();
		origem.setModel(modelComboCidades());
		origem.setBounds(265, 20, 100, 20);
		origem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String text = origem.getSelectedItem().toString();
			    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,1));
			}
		});
		
		//Adicionando
		painelBordaPesquisa.add(origem);
		
		//Destino
		JLabel lblDestino = new JLabel(bundle.getString("telaVooCadastra.label.destino")+ ":");
		lblDestino.setBounds(370, 20, 50, 20);
		//Adicionando
		painelBordaPesquisa.add(lblDestino);
		//Campo - Destino
		final JComboBox destino = new JComboBox();
		destino.setModel(modelComboCidades());
		destino.setBounds(425, 20, 100, 20);
		destino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = destino.getSelectedItem().toString();
			    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,2));
			}
		});
		//Adicionando
		painelBordaPesquisa.add(destino);
		
		//Data
		JLabel lblData = new JLabel(bundle.getString("telaVooCadastra.label.data")+ ":");
		lblData.setBounds(15, 50, 50, 20);
		//Adicionando
		painelBordaPesquisa.add(lblData);
		
		//Campo - Data
		final JTextField data = new JTextField();
		data.setBounds(70, 50, 80, 20);
		data.setEnabled(true);
		painelBordaPesquisa.add(data);
		data.addCaretListener(new CaretListener() {
			   public void caretUpdate(CaretEvent arg0) {
				    String text = data.getText().trim();
				    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,3));
				   }
				  });
		
		//Hora
		JLabel lblHora = new JLabel(bundle.getString("telaVooCadastra.label.hora")+ ":");
		lblHora.setBounds(160, 50, 50, 20);
		//Adicionando
		painelBordaPesquisa.add(lblHora);
		
		//Campo - Hora
		final JTextField hora= new JTextField();
		hora.setBounds(215, 50, 100, 20);
		hora.setEnabled(true);
		painelBordaPesquisa.add(hora);
		hora.addCaretListener(new CaretListener() {
			   public void caretUpdate(CaretEvent arg0) {
				    String text = hora.getText().trim();
				    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,4));
				   }
				  });
		
		//Situação
		JLabel lblSituacao = new JLabel(bundle.getString("telaVooCadastra.label.situacao")+ ":");
		lblSituacao.setBounds(15, 80, 60, 20);
		painelBordaPesquisa.add(lblSituacao);
		
		//Campo de situacao
		final JComboBox situacao = new JComboBox();
		situacao.setModel(modelComboStatus());
		situacao.setBounds(80, 80, 130, 20);
		painelBordaPesquisa.add(situacao);
		situacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = situacao.getSelectedItem().toString();
			    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,5));
			}
		});
				
		if(opcao.equals("consulta")){
			//Botão de Voltar
			JButton voltar = new JButton(bundle.getString("telaAeronaveConsulta.button.voltar"));
			voltar.setBounds(10, 110, 100, 20);
			
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
		painelTabela.setBounds(12, 160, 725, altura);
		painelTabela.setLayout(new BorderLayout(0, 0));
		
		//Adicionando
		painelBorda.add(painelTabela);
		
		//Configurando Tabela
		tabelaResultado = new JTable();
		
		modelo = new DefaultTableModel(new String[]
				 			{ 
								bundle.getString("telaVooCadastra.label.codigoVoo"),
								bundle.getString("telaVooCadastra.label.origem"),
								bundle.getString("telaVooCadastra.label.destino"),
								bundle.getString("telaVooCadastra.label.data"),
								bundle.getString("telaVooCadastra.label.hora"),
								bundle.getString("telaVooCadastra.label.situacao"),
								bundle.getString("telaVooCadastra.label.valor")
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
		sort();
		

		//Botão
		JButton proximo = new JButton(bundle.getString("telaAeronaveCadastra.button.proximo"));
		proximo.setBounds(600, 500, 100, 30);
		
		if( opcao.equals("alterar")){
			//Botão de Voltar
			JButton voltar = new JButton(bundle.getString("telaAeronaveConsulta.button.voltar"));
			voltar.setBounds(490, 500, 100, 30);
			
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
		                	 TelaVooAlterar tVooAlterar = new TelaVooAlterar(bundle,null,vooSelecionado());
		                	 tVooAlterar.setVisible(true);
		                	 //Atualizar JTable apos alteração
		                	 pesquisar();
		                 }
		              });
			painelBorda.add(proximo);
		}
		else if(opcao.equals("deletar") ){
			//Botão de Voltar
			JButton voltar = new JButton(bundle.getString("telaAeronaveConsulta.button.voltar"));
			voltar.setBounds(490, 500, 100, 30);
			
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
		                	 dispose();
		                	 TelaVooDeletar tVooDeletar = new TelaVooDeletar(bundle,null,vooSelecionado());
		                	 tVooDeletar.setVisible(true);
		                 
		                 }
		              });
			painelBorda.add(proximo);
			
		}
				
		this.setLocationRelativeTo(null);
	}
	
	public void pesquisar(){		
		VooBD bd = new VooBD();
		modelo = (DefaultTableModel) bd.pesquisarVoo(tabelaResultado.getModel());		
	}
	
	public Voo vooSelecionado(){
		Integer x = (Integer) tabelaResultado.getValueAt(tabelaResultado.getSelectedRow(),0);
		String cod = ""+x;
		int codigo = Integer.parseInt(cod);
		Voo voo = new Voo(codigo);
   	 	return voo.pesquisar(codigo);
	}
	
	//Metodo responsavel pelo filtro das colunas da tabela.
	public void sort(){
	  if (rowSorter == null) {
	   rowSorter = new TableRowSorter<TableModel>(tabelaResultado.getModel());
	   tabelaResultado.setRowSorter(rowSorter);
	  }
	}
	
	public DefaultComboBoxModel modelComboCidades(){
		DefaultComboBoxModel model = new DefaultComboBoxModel(
				new String[] {
						bundle.getString("telaVooCadastra.comboBox.selecione"),
						"São Paulo",
						"Rio de Janeiro",
						"Minas Gerais",
						"Mato Grosso"
					}
		);
		return model;		
	}		
	
	public DefaultComboBoxModel modelComboStatus(){
		DefaultComboBoxModel model = new DefaultComboBoxModel(
				new String[] {
						bundle.getString("telaVooCadastra.comboBox.selecione"),
						bundle.getString("telaVooCadastra.comboBox.emEspera"),
						bundle.getString("telaVooCadastra.comboBox.confirmado"),
						bundle.getString("telaVooCadastra.comboBox.concluido"),
						bundle.getString("telaVooCadastra.comboBox.cancelado")
				}
				);
		return model;		
	}
}
