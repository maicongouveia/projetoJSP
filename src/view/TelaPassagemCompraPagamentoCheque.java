package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

	public class TelaPassagemCompraPagamentoCheque extends JDialog implements ActionListener{
		private JTextField txtAgencia;
		private JTextField txtConta;
		private JTextField txtTitular;
		private JTextField txtCPF;
		private JTextField txtBanco;
		private ResourceBundle bundle;
		private JButton bProximo;
		private JLabel lbBanco;
		private JLabel lbAgencia;
		private JLabel lbConta;
		private JLabel lbNomeTitular;
		private JLabel lbCpf;
		private JPanel painel;
		
		public TelaPassagemCompraPagamentoCheque(ResourceBundle bundle,JFrame jd) {
			super(jd,true);
			this.bundle  = bundle;
			setBounds(100, 100, 800, 600);
			getContentPane().setLayout(null);
			
			painel      = new JPanel();
			
			txtAgencia = new JTextField();
			txtConta   = new JTextField();
			txtTitular = new JTextField();
			txtCPF     = new JTextField();
			txtBanco   = new JTextField();
			
			lbBanco        = new JLabel(bundle.getString("telaPassagemPagamentoCheque.label.banco"));
			lbAgencia      = new JLabel(bundle.getString("telaPassagemPagamentoCheque.label.agencia"));
			lbConta        = new JLabel(bundle.getString("telaPassagemPagamentoCheque.label.conta"));
			lbNomeTitular  = new JLabel(bundle.getString("telaPassagemPagamentoCheque.label.nome"));
			lbCpf          = new JLabel(bundle.getString("telaPassagemPagamentoCheque.label.cpf"));
			
			bProximo = new JButton(bundle.getString("telaPassagemPagamentoCheque.botao.proximo"));
			
			//----------------------------
			
			painel.setBorder(new TitledBorder(null, bundle.getString("telaPassagemPagamentoCheque.borda.titulo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
			painel.setBounds(102, 96, 580, 368);
			getContentPane().add(painel);
			painel.setLayout(null);
			
			lbBanco.setBounds(123, 121, 76, 14);
			painel.add(lbBanco);
			
			lbAgencia.setBounds(123, 146, 76, 14);
			painel.add(lbAgencia);
			
			lbConta.setBounds(123, 174, 76, 14);
			painel.add(lbConta);
			
			lbNomeTitular.setBounds(123, 227, 110, 14);
			painel.add(lbNomeTitular);
			
			lbCpf.setBounds(123, 202, 76, 14);
			painel.add(lbCpf);
			
			txtAgencia.setColumns(10);
			txtAgencia.setBounds(209, 143, 233, 17);
			painel.add(txtAgencia);
			
			txtConta.setColumns(10);
			txtConta.setBounds(209, 172, 233, 17);
			painel.add(txtConta);
			
			txtTitular.setColumns(10);
			txtTitular.setBounds(243, 225, 199, 17);
			painel.add(txtTitular);
			
			txtCPF.setColumns(10);
			txtCPF.setBounds(209, 200, 233, 17);
			painel.add(txtCPF);
			
			txtBanco.setColumns(10);
			txtBanco.setBounds(209, 118, 233, 17);
			painel.add(txtBanco);
			
			bProximo.setBounds(481, 334, 89, 23);
			bProximo.addActionListener(this);
			painel.add(bProximo);
			
			this.setLocationRelativeTo(null);
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bProximo){
				dispose();
				TelaPassagemCompraBilhete p = new TelaPassagemCompraBilhete(bundle,null);
				p.setVisible(true);
			}			
		}
		
	}
	
