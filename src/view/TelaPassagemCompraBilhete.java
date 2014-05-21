package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class TelaPassagemCompraBilhete extends JDialog implements ActionListener{

	private JButton bMenu;
	private JButton bEmitir;
	private ResourceBundle bundle;

	public TelaPassagemCompraBilhete(ResourceBundle bundle,JFrame jd) {
		super(jd,true);
		this.bundle  = bundle;
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		JPanel painel = new JPanel();
		painel.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraBilhete.borda.titulo"),	TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painel.setBounds(102, 96, 580, 368);
		getContentPane().add(painel);
		painel.setLayout(null);

		JLabel lbCompraRealizada = new JLabel(bundle.getString("telaPassagemCompraBilhete.label.compraRealizada"));
		lbCompraRealizada.setFont(new Font("Georgia", Font.BOLD, 21));
		lbCompraRealizada.setHorizontalAlignment(SwingConstants.CENTER);
		lbCompraRealizada.setBounds(10, 38, 560, 49);
		painel.add(lbCompraRealizada);

		bMenu = new JButton(bundle.getString("telaPassagemCompraBilhete.botao.menu"));
		bMenu.setBounds(400, 323, 150, 34);
		painel.add(bMenu);
		
		JPanel painelPassagem = new JPanel();
		painelPassagem.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraBilhete.borda.passagem"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelPassagem.setBounds(10, 113, 560, 199);
		painel.add(painelPassagem);
		painelPassagem.setLayout(null);
		
		JLabel lbNumeroSolicitacao = new JLabel(bundle.getString("telaPassagemCompraBilhete.label.numero"));
		lbNumeroSolicitacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNumeroSolicitacao.setFont(new Font("Georgia", Font.BOLD, 18));
		lbNumeroSolicitacao.setBounds(10, 49, 261, 49);
		painelPassagem.add(lbNumeroSolicitacao);
		
		JLabel lbEmitirPassagem = new JLabel(bundle.getString("telaPassagemCompraBilhete.label.emitirPassagem"));
		lbEmitirPassagem.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEmitirPassagem.setFont(new Font("Georgia", Font.BOLD, 18));
		lbEmitirPassagem.setBounds(10, 94, 261, 49);
		painelPassagem.add(lbEmitirPassagem);
		
		bEmitir = new JButton(bundle.getString("telaPassagemCompraBilhete.botao.emitir"));
		bEmitir.setBounds(281, 104, 121, 34);
		painelPassagem.add(bEmitir);
		
		JLabel lbNumero = new JLabel("0012376-A");
		lbNumero.setForeground(Color.RED);
		lbNumero.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbNumero.setBounds(281, 49, 269, 49);
		painelPassagem.add(lbNumero);
		bMenu.addActionListener(this);
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bMenu){
			dispose();
		}		
	}
}