package view;

import java.awt.Font;
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
import javax.swing.border.TitledBorder;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

import Controller.Voo;
import Model.VooBD;

public class TelaPassagemCompraPerguntaVolta extends JDialog implements ActionListener{
	
	private ResourceBundle bundle = null;
	private JPanel painelBorda;
	private JButton btSim;
	private JButton btNao;
	private JLabel lblVocDesejaComprar;
	private int vooSelecionado;

	
	public TelaPassagemCompraPerguntaVolta(final ResourceBundle bundle,JFrame p, int vooSelecionado) {

		super(p,true);
		
		this.bundle = bundle;
		this.vooSelecionado = vooSelecionado;
		
		setTitle("Passagem - Pergunta");
		setBounds(100,100,500,190);
		getContentPane().setLayout(null);		
		this.setLocationRelativeTo(null);
		
		
		painelBorda  = new JPanel();
		painelBorda.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraPerguntaVolta.label.pergunta"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBorda.setBounds(10, 10, 465, 135);
		painelBorda.setLayout(null);
		getContentPane().add(painelBorda);
		
		lblVocDesejaComprar = new JLabel(bundle.getString("telaPassagemCompraPerguntaVolta.label.escrita"));
		lblVocDesejaComprar.setBounds(40, 30, 390, 40);
		lblVocDesejaComprar.setFont(new Font("Tahoma", Font.BOLD, 18));
		painelBorda.add(lblVocDesejaComprar);
		
		btSim = new JButton(bundle.getString("telaPassagemCompraPerguntaVolta.bt.sim"));
		btSim.setBounds(250, 95, 90, 25);
		btSim.addActionListener(this); 
		painelBorda.add(btSim);
		
		btNao = new JButton(bundle.getString("telaPassagemCompraPerguntaVolta.bt.nao"));
		btNao.setBounds(120, 95, 90, 25);
		btNao.addActionListener(this); 
		painelBorda.add(btNao);
		
	}
		
	public void actionPerformed(ActionEvent e){
	
		if(e.getSource() == btNao){
			dispose();
			TelaPassagemCompraQtdPassageiros tela = new TelaPassagemCompraQtdPassageiros(bundle, null, vooSelecionado, 0);
			tela.setVisible(true);
			
		}
		if(e.getSource() == btSim){
			dispose();
			TelaPassagemCompraVolta tela = new TelaPassagemCompraVolta(bundle, null, vooSelecionado);
			tela.setVisible(true);
		}
	
	}	
}