package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TelaPassagemCancelarConta extends JDialog implements ActionListener{
	
	private JTextField tAgencia;
	private JTextField tConta;
	private JTextField tTitular;
	private JTextField tCPF;
	private JLabel lAgencia;
	private JLabel lBanco;
	private JLabel lConta;
	private JLabel lTitular;
	private JLabel lCpf;
	private JPanel painelCentral;
	private JPanel painelConta;
	private JPanel painelCalculo;
	private JLabel lPassagem;
	private JLabel lMulta;
	private JLabel lDevolucao;
	private JLabel lValorPassagem;
	private JLabel lValorMulta;
	private JLabel lValorDevolucao;
	private JLabel lStatus;
	private JButton bFinalizar;
	private JButton bMenu;
	private ResourceBundle bundle;

	public TelaPassagemCancelarConta(ResourceBundle bundle,JFrame jd) {
		super(jd,true);
		this.bundle = bundle;
		setBounds(100, 100, 702, 505);
		getContentPane().setLayout(null);

		painelCentral = new JPanel();
		painelCentral.setLayout(null);
		painelCentral.setBorder(new TitledBorder(null,bundle.getString("telaPassagemCancelarConta.borda.titulo"),TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelCentral.setBounds(10, 73, 666, 338);
		getContentPane().add(painelCentral);

		painelConta = new JPanel();
		painelConta.setLayout(null);
		painelConta.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCancelarConta.borda.conta"), TitledBorder.LEADING,TitledBorder.TOP, null, null));
		painelConta.setBounds(37, 25, 285, 254);
		painelCentral.add(painelConta);
		
		painelCalculo = new JPanel();
		painelCalculo.setLayout(null);
		painelCalculo.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCancelarConta.borda.calculo"),TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelCalculo.setBounds(347, 25, 285, 254);
		painelCentral.add(painelCalculo);
		
		//Rotulos
		lBanco     = new JLabel(bundle.getString("telaPassagemCancelarConta.label.banco"));
		lAgencia   = new JLabel(bundle.getString("telaPassagemCancelarConta.label.agencia"));
		lConta     = new JLabel(bundle.getString("telaPassagemCancelarConta.label.conta"));
		lTitular   = new JLabel(bundle.getString("telaPassagemCancelarConta.label.titular"));
		lCpf       = new JLabel(bundle.getString("telaPassagemCancelarConta.label.cpf"));
		lPassagem  = new JLabel(bundle.getString("telaPassagemCancelarConta.label.passagem"));
		lMulta     = new JLabel(bundle.getString("telaPassagemCancelarConta.label.multa"));
		lDevolucao = new JLabel(bundle.getString("telaPassagemCancelarConta.label.devolucao"));
		
		lValorPassagem  = new JLabel("R$ 500,00");
		lValorMulta     = new JLabel("R$ 50,00");
		lValorDevolucao = new JLabel("R$ 450,00");
		
		//Botoes
		bFinalizar = new JButton(bundle.getString("telaPassagemCancelarConta.botao.finalizar"));
		bMenu      = new JButton(bundle.getString("telaPassagemCancelarConta.botao.menu"));
		
		//--------------------------------
		
		tCPF = new JTextField();
		tCPF.setBounds(108, 155, 136, 20);
		tCPF.setColumns(10);
		painelConta.add(tCPF);
		
		tTitular = new JTextField();
		tTitular.setBounds(108, 130, 136, 20);
		tTitular.setColumns(10);
		painelConta.add(tTitular);
		
		tConta = new JTextField();
		tConta.setBounds(108, 108, 86, 20);
		tConta.setColumns(10);
		painelConta.add(tConta);
		
		tAgencia = new JTextField();
		tAgencia.setBounds(108, 86, 86, 20);
		tAgencia.setColumns(10);
		painelConta.add(tAgencia);
		
		//----------------------------
		
		lCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lCpf.setBounds(32, 161, 66, 14);
		painelConta.add(lCpf);
		
		lTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lTitular.setBounds(32, 136, 66, 14);
		painelConta.add(lTitular);
		
		lConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lConta.setBounds(32, 111, 66, 14);
		painelConta.add(lConta);
		
		lAgencia.setFont(new Font("Tahoma", Font.BOLD, 12));
		lAgencia.setBounds(32, 86, 66, 14);
		painelConta.add(lAgencia);

		lBanco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lBanco.setBounds(32, 61, 66, 14);
		painelConta.add(lBanco);


		lPassagem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lPassagem.setBounds(10, 88, 109, 14);
		painelCalculo.add(lPassagem);

		lMulta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lMulta.setBounds(10, 113, 109, 14);
		painelCalculo.add(lMulta);

		lDevolucao.setForeground(Color.RED);
		lDevolucao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lDevolucao.setBounds(10, 138, 109, 14);
		painelCalculo.add(lDevolucao);

		lValorPassagem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lValorPassagem.setBounds(129, 88, 146, 14);
		painelCalculo.add(lValorPassagem);

		lValorMulta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lValorMulta.setBounds(129, 113, 146, 14);
		painelCalculo.add(lValorMulta);

		lValorDevolucao.setForeground(Color.BLACK);
		lValorDevolucao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lValorDevolucao.setBounds(129, 138, 146, 14);
		painelCalculo.add(lValorDevolucao);

		lStatus = new JLabel("");
		lStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lStatus.setBounds(10, 290, 646, 32);
		painelCentral.add(lStatus);
		
		//---------------------------------
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(108, 58, 86, 20);
		painelConta.add(comboBox);
		
		//---------------------------------
		
		bFinalizar.setBounds(488, 422, 89, 23);
		getContentPane().add(bFinalizar);
		bFinalizar.addActionListener(this);
		bMenu.setBounds(587, 422, 89, 23);
		getContentPane().add(bMenu);
		bMenu.addActionListener(this);
		
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bFinalizar){
			lStatus.setText(bundle.getString("telaPassagemCancelarConta.label.msg"));
		}
		if(e.getSource() == bMenu){
			dispose();
		}
	}
}
