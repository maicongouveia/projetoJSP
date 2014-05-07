package view;

import java.awt.Window;
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
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class TelaPassagemCompraFormaPagamento extends JDialog implements ActionListener{

	private ResourceBundle bundle;
	private JButton bProximo;
	private JRadioButton rdCartao;
	private JRadioButton rdCheque;

	public TelaPassagemCompraFormaPagamento(ResourceBundle bundle,JFrame jd) {
		super(jd,true);
		this.bundle  = bundle;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraFormaPagamento.borda.titulo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(102, 96, 580, 368);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbFormaPagamento = new JLabel(bundle.getString("telaPassagemCompraFormaPagamento.label.forma"));
		lbFormaPagamento.setBounds(20, 81, 267, 23);
		panel.add(lbFormaPagamento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(149, 172, 281, 23);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		rdCartao = new JRadioButton(bundle.getString("telaPassagemCompraFormaPagamento.radio.cartao"));
		rdCartao.setBounds(0, 0, 109, 23);
		panel_1.add(rdCartao);
		
		rdCheque = new JRadioButton(bundle.getString("telaPassagemCompraFormaPagamento.radio.cheque"));
		rdCheque.setBounds(172, 0, 109, 23);
		panel_1.add(rdCheque);
		
		bProximo = new JButton(bundle.getString("telaPassagemCompraFormaPagamento.botao.proximo"));
		bProximo.setBounds(481, 334, 89, 23);
		panel.add(bProximo);
		bProximo.addActionListener(this);
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == bProximo){
			
			if(rdCartao.isSelected()){
				dispose();
				TelaPassagemCompraPagamentoCartao p = new TelaPassagemCompraPagamentoCartao(bundle,null);
				p.setVisible(true);
			}
			else 
				if(rdCheque.isSelected()){
					dispose();
					TelaPassagemCompraPagamentoCheque p = new TelaPassagemCompraPagamentoCheque(bundle,null);
					p.setVisible(true);
			}
			
		}
		
	}
}
