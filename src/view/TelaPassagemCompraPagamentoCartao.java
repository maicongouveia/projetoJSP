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

	public class TelaPassagemCompraPagamentoCartao extends JDialog implements ActionListener{
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private ResourceBundle bundle;
		private JButton bProximo;

		public TelaPassagemCompraPagamentoCartao(ResourceBundle bundle,JFrame jd) {
			super(jd,true);
			this.bundle  = bundle;
			setBounds(100, 100, 800, 600);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, bundle.getString("telaPassagemPagamentoCartao.borda.titulo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(102, 96, 580, 368);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lbNome = new JLabel(bundle.getString("telaPassagemPagamentoCartao.label.cartao"));
			lbNome.setBounds(20, 81, 120, 23);
			panel.add(lbNome);
			
			bProximo = new JButton(bundle.getString("telaPassagemPagamentoCartao.botao.proximo"));
			bProximo.setBounds(481, 334, 89, 23);
			panel.add(bProximo);
			
			JLabel lbBandeira = new JLabel(bundle.getString("telaPassagemPagamentoCartao.label.bandeira"));
			lbBandeira.setBounds(20, 106, 56, 14);
			panel.add(lbBandeira);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(76, 105, 96, 17);
			panel.add(comboBox);
			
			JLabel lbValidade = new JLabel(bundle.getString("telaPassagemPagamentoCartao.label.validade"));
			lbValidade.setBounds(20, 131, 56, 14);
			panel.add(lbValidade);
			
			textField = new JTextField();
			textField.setBounds(76, 128, 96, 17);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lbNumero = new JLabel(bundle.getString("telaPassagemPagamentoCartao.label.numero"));
			lbNumero.setBounds(200, 106, 76, 14);
			panel.add(lbNumero);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(286, 103, 130, 17);
			panel.add(textField_1);
			
			JLabel lbCodigoSegurana = new JLabel(bundle.getString("telaPassagemPagamentoCartao.label.codigo"));
			lbCodigoSegurana.setBounds(200, 131, 130, 14);
			panel.add(lbCodigoSegurana);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(330, 128, 86, 17);
			panel.add(textField_2);
			
			JLabel lbNomeTitular = new JLabel(bundle.getString("telaPassagemPagamentoCartao.label.nome"));
			lbNomeTitular.setBounds(20, 156, 96, 14);
			panel.add(lbNomeTitular);
			
			JLabel lbCpf = new JLabel(bundle.getString("telaPassagemPagamentoCartao.label.cpf"));
			lbCpf.setBounds(20, 181, 56, 14);
			panel.add(lbCpf);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(126, 153, 204, 17);
			panel.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(76, 178, 149, 17);
			panel.add(textField_4);
			
			bProximo.addActionListener(this);
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
