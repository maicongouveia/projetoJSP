package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

public class TelaPassagemCompraResponsavel extends JDialog implements ActionListener{
	private JTextField tEmail;
	private JTextField tTelefone;
	private JTable table;
	private ResourceBundle bundle = null;
	private JButton lbProximo;

	public TelaPassagemCompraResponsavel(ResourceBundle bundle,JFrame jd) {
		super(jd,true);
		this.bundle  = bundle;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraResponsavel.borda"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(102, 96, 580, 368);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbResponsavel = new JLabel(bundle.getString("telaPassagemCompraResponsavel.label.responsavel"));
		lbResponsavel.setBounds(20, 81, 188, 23);
		panel.add(lbResponsavel);
		
		JLabel lbEmail = new JLabel(bundle.getString("telaPassagemCompraResponsavel.label.email"));
		lbEmail.setBounds(20, 333, 77, 23);
		panel.add(lbEmail);
		
		tEmail = new JTextField();
		tEmail.setColumns(10);
		tEmail.setBounds(107, 333, 191, 22);
		panel.add(tEmail);
		
		JLabel lbTelefone = new JLabel(bundle.getString("telaPassagemCompraResponsavel.label.telefone"));
		lbTelefone.setBounds(20, 303, 77, 19);
		panel.add(lbTelefone);
		
		tTelefone = new JTextField();
		tTelefone.setColumns(10);
		tTelefone.setBounds(107, 300, 191, 22);
		
		panel.add(tTelefone);
		TableModel model = new DefaultTableModel(
				new String[] {  
						bundle.getString("telaPassagemCompraResponsavel.tabela.tipo"), 
						bundle.getString("telaPassagemCompraResponsavel.tabela.tratamento"),
						bundle.getString("telaPassagemCompraResponsavel.tabela.nome"),
						bundle.getString("telaPassagemCompraResponsavel.tabela.dataNasc")
				},13);
		
		lbProximo = new JButton(bundle.getString("telaPassagemCompraResponsavel.botao.proximo"));
		lbProximo.setBounds(481, 333, 89, 23);
		panel.add(lbProximo);
		lbProximo.addActionListener(this);
		
		JPanel paninelTable = new JPanel();
		paninelTable.setBounds(10, 115, 560, 157);
		panel.add(paninelTable);
		paninelTable.setLayout(null);
		
		table = new JTable();
		table.setModel(model);
		
        // Sem o scroll pane o JTable fica zuado        
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 5, 540, 238);
		paninelTable.add(scroll);
		scroll.setViewportView(table);
		
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == lbProximo){
			dispose();
			TelaPassagemCompraFormaPagamento p = new TelaPassagemCompraFormaPagamento(bundle, null);
			p.setVisible(true);
		}
	}
}
