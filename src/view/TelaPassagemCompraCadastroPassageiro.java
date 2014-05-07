package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

import Control.Passageiro;

public class TelaPassagemCompraCadastroPassageiro extends JDialog implements ActionListener{
	
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtDataNascimento;
	private JComboBox<String> formaTratamento;
	private ResourceBundle bundle = null;
	private JButton bProximo;
	private int vooSelecionado;
	private int vooVoltaSelecionado;
	private int qtdPassageiros;
	private ArrayList<Passageiro> passageiros;

	public TelaPassagemCompraCadastroPassageiro(ResourceBundle bundle,JFrame jd, int vooSelecionado, int vooVoltaSelecionado, int qtdPassageiros, ArrayList passageiros) {
		
		super(jd,true);
		
		setBounds(100, 100, 585, 335);
		getContentPane().setLayout(null);
		
		this.bundle  = bundle;
		this.vooSelecionado = vooSelecionado;
		this.vooVoltaSelecionado = vooVoltaSelecionado;
		this.qtdPassageiros = qtdPassageiros;
		this.passageiros = passageiros;
		
		JPanel painel = new JPanel();
		painel.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraCadastroPassageiros.borda.titulo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painel.setBounds(10, 11, 549, 254);
		getContentPane().add(painel);
		painel.setLayout(null);
		
		JLabel lbFormaTratamento = new JLabel(bundle.getString("telaPassagemCompraCadastroPassageiros.label.tratamento"));
		lbFormaTratamento.setBounds(54, 50, 131, 23);
		painel.add(lbFormaTratamento);
		
		formaTratamento = new JComboBox<String>();
		formaTratamento.setBounds(195, 50, 66, 23);
		formaTratamento.setModel(new DefaultComboBoxModel(new String[]{
				bundle.getString("telaPassagemCompraCadastroPassageiros.combo.sr"),
				bundle.getString("telaPassagemCompraCadastroPassageiros.combo.dr")
				}));
		painel.add(formaTratamento);
		
		JLabel lbNome = new JLabel(bundle.getString("telaPassagemCompraCadastroPassageiros.label.nome"));
		lbNome.setBounds(54, 84, 108, 23);
		painel.add(lbNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(164, 84, 168, 22);
		painel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel(bundle.getString("telaPassagemCompraCadastroPassageiros.label.dataNasc"));
		lblDataDeNascimento.setBounds(54, 151, 108, 23);
		painel.add(lblDataDeNascimento);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(164, 151, 168, 22);
		painel.add(txtDataNascimento);
		
		
		
		painel.add(txtSobrenome);
		TableModel model = new DefaultTableModel(
				new String[] { 
						bundle.getString("telaPassagemCompraCadastroPassageiros.tabela.tipo"), 
						bundle.getString("telaPassagemCompraCadastroPassageiros.tabela.tratamento"),
						bundle.getString("telaPassagemCompraCadastroPassageiros.tabela.nome"),
						bundle.getString("telaPassagemCompraCadastroPassageiros.tabela.dataNasc") 
						},13);
		
		JButton bAnterior = new JButton(bundle.getString("telaPassagemCompraCadastroPassageiros.botao.anterior"));
		bAnterior.setBounds(344, 151, 89, 23);
		painel.add(bAnterior);
		
		bProximo = new JButton(bundle.getString("telaPassagemCompraCadastroPassageiros.botao.proximo"));
		bProximo.setBounds(448, 151, 89, 23);
		painel.add(bProximo);
		bProximo.addActionListener(this);
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bProximo){
			dispose();
			while(qtdPassageiros > 0){
				
				Passageiro user = new Passageiro();
				
				user.setNome(txtNome.getText());
				user.setSobrenome(txtSobrenome.getText());
				user.setDataNascimento(txtDataNascimento.getText());
				user.setFormaTratamento(""+formaTratamento.getSelectedItem());
				
				passageiros.add(user);
				
				qtdPassageiros--;
				dispose();
				TelaPassagemCompraCadastroPassageiro tela = new TelaPassagemCompraCadastroPassageiro(bundle, null, vooSelecionado, vooVoltaSelecionado, qtdPassageiros, passageiros);
				tela.setVisible(true);
			}
			//TelaPassagemCompraMetodoPag p = new TelaPassagemCompraMetodoPag(bundle,null);
			//p.setVisible(true);
		}
	}
}
