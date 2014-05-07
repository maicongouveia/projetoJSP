package view;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import java.awt.Font;
import java.util.ResourceBundle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaPassagemCompraMetodoPag extends JDialog implements ActionListener{
	
	private ResourceBundle bundle;
	private JButton btProximo;
	private int vooSelecionado;
	private int vooVoltaSelecionado;

	public TelaPassagemCompraMetodoPag(final ResourceBundle bundle,JFrame fr, int vooSelecionado, int vooVoltaSelecionado) {
		
		super(fr, true);
		setBounds(100, 100, 400, 160);
		setResizable(false);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		this.bundle = bundle;
		this.vooSelecionado = vooSelecionado;
		this.vooVoltaSelecionado = vooVoltaSelecionado;
				
		JLabel lblQtdPassageiros = new JLabel(bundle.getString("telaCompraQtdPassageiros.label.qtdPassageiros")+":");
		lblQtdPassageiros.setBounds(56, 11, 280, 30);
		lblQtdPassageiros.setFont(new Font(null , Font.BOLD, 20));
		getContentPane().add(lblQtdPassageiros);
		
		SpinnerNumberModel modeloF = new SpinnerNumberModel(1,1,99,1);
		
		btProximo = new JButton(bundle.getString("telaCompraQtdPassageiros.jbuttom.proximo"));
		btProximo.setBounds(126, 96, 140, 25);
		btProximo.addActionListener(this);
		getContentPane().add(btProximo);	
		
		JRadioButton rdbtnCartoDeCredito = new JRadioButton("Cart\u00E3o de Credito");
		rdbtnCartoDeCredito.setBounds(66, 52, 124, 23);
		getContentPane().add(rdbtnCartoDeCredito);
		
		JRadioButton rdbtnCheque = new JRadioButton("Cheque");
		rdbtnCheque.setBounds(211, 52, 109, 23);
		getContentPane().add(rdbtnCheque);
		
		
	}
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == btProximo){
			dispose();
			TelaPassagemCompraCadastroPassageiro tela = new TelaPassagemCompraCadastroPassageiro(bundle, null, vooSelecionado, vooVoltaSelecionado);
			tela.setVisible(true);
		}
	
	}	
}
