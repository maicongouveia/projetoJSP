package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import BD.VooBD;
import Control.Voo;

public class TelaPassagemCompraIda extends JDialog implements ActionListener{
	
	private ResourceBundle bundle = null;
	private JPanel painelBorda;
	private JPanel painelTabela;
	private JTable tabelaResultado;
	private JLabel lblDestino;
	private JButton btProximo;
	private JButton btCancelar;
	private TableRowSorter<TableModel> rowSorter;
	private TableModel modelo;

	
	public TelaPassagemCompraIda(final ResourceBundle bundle,JFrame p) {
		
		super(p,true);
		this.bundle = bundle;
		setTitle("Passagem - Compra Ida");
		getContentPane().setLayout(null);
		setBounds(100,100,785,360);
		this.setLocationRelativeTo(null);
		
		painelBorda  = new JPanel();
		painelBorda.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraDestino.botao.proximo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBorda.setBounds(10, 10, 761, 300);
		painelBorda.setLayout(null);
		getContentPane().add(painelBorda);
				
		painelTabela = new JPanel();
		painelTabela.setBounds(250, 15, 500, 250);
		painelBorda.add(painelTabela);	
		
		lblDestino = new JLabel(bundle.getString("telaPassagemCompraIda.label.destino"));
		lblDestino.setBounds(24, 37, 46, 14);
		painelBorda.add(lblDestino);
		
		final JComboBox<String> destinoBox = new JComboBox<String>();
		destinoBox.setBounds(44, 61, 110, 20);
		painelBorda.add(destinoBox);
		destinoBox.setModel(modeloComboCidades());
		destinoBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = destinoBox.getSelectedItem().toString();
			    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,2));
			}
		});
		
		JLabel lblData = new JLabel(bundle.getString("telaPassagemCompraIda.label.data"));
		lblData.setBounds(24, 92, 46, 14);
		painelBorda.add(lblData);
		
		final JTextField data = new JTextField();
		data.setBounds(44, 117, 86, 20);
		painelBorda.add(data);
		data.addCaretListener(new CaretListener() {
			   public void caretUpdate(CaretEvent arg0) {
				    String text = data.getText().trim();
				    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,3));
				   }
				  });
		
		JLabel lblHorario = new JLabel(bundle.getString("telaPassagemCompraIda.label.horario"));
		lblHorario.setBounds(24, 148, 46, 14);
		painelBorda.add(lblHorario);
		
		final JTextField hora = new JTextField();
		hora.setBounds(44, 173, 86, 20);
		painelBorda.add(hora);
		hora.addCaretListener(new CaretListener() {
			   public void caretUpdate(CaretEvent arg0) {
				    String text = hora.getText().trim();
				    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text,4));
				   }
				  });
		
		btProximo = new JButton(bundle.getString("telaPassagemCompraIda.bt.proximo"));
		btProximo.setBounds(126, 237, 89, 23);
		btProximo.addActionListener(this); 
		painelBorda.add(btProximo);
		
		btCancelar = new JButton(bundle.getString("telaPassagemCompraIda.bt.cancelar"));
		btCancelar.setBounds(27, 237, 89, 23);
		btCancelar.addActionListener(this); 
		painelBorda.add(btCancelar);

		tabelaResultado = new JTable();
		
		modelo = new DefaultTableModel(
				new String[] { 
						bundle.getString("telaPassagemCompraIda.tabela.destino"),
						bundle.getString("telaPassagemCompraIda.tabela.data"),
						bundle.getString("telaPassagemCompraIda.tabela.hora"),
						bundle.getString("telaPassagemCompraIda.tabela.preco")
						},0);
		
		tabelaResultado.setModel(modelo);
		
		// Largura das Colunas		
        tabelaResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabelaResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelaResultado.getColumnModel().getColumn(2).setPreferredWidth(55);
        tabelaResultado.getColumnModel().getColumn(3).setPreferredWidth(55);
        
        // Sem o scroll pane o JTable fica zuado        
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tabelaResultado);
		painelTabela.add(scroll);
		pesquisar();
		sort();
		

	}
	public void pesquisar(){		
		VooBD bd = new VooBD();
		modelo = (DefaultTableModel) bd.pesquisarVooCompraIda(tabelaResultado.getModel());		
	}
	public int getCodigoVooSelecionado(){
		Integer x = (Integer) tabelaResultado.getValueAt(tabelaResultado.getSelectedRow(),0);
		String cod = ""+x;
		int codigo = Integer.parseInt(cod);
		return codigo;
	}
	
	//Metodo responsavel pelo filtro das colunas da tabela.
	public void sort(){
	  if (rowSorter == null) {
	   rowSorter = new TableRowSorter<TableModel>(tabelaResultado.getModel());
	   tabelaResultado.setRowSorter(rowSorter);
	  }
	}
	
	public DefaultComboBoxModel<String> modeloComboCidades(){
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(
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
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == btCancelar){
			dispose();
		}
		if(e.getSource() == btProximo){
			dispose();
			TelaPassagemCompraPerguntaVolta tela = new TelaPassagemCompraPerguntaVolta(bundle, null, tabelaResultado.getSelectedRow());
			tela.setVisible(true);
		}
	
	}
}