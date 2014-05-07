package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class TelaPassagemCancelarNumero extends JDialog implements ActionListener {
	
	private JTextField tNumeroPassagem;
	private JLabel lNumeroPassagem;
	private JLabel lDataNascimento;
	private JLabel lNomePassageiro;
	private JLabel lDestino;
	private JLabel lDataPartida;
	private JLabel lHorarioPartida;
	private JLabel lDataRetorno;
	private JLabel lHorarioRetorno;
	private JLabel lNomePassageiro2;
	private JLabel lDataNascimento2;
	private JLabel lDestino2;
	private JLabel lDataPartida2;
	private JLabel lHorarioPartida2;
	private JLabel lDataRetorno2;
	private JLabel lHorarioRetorno2;
	private JPanel painelDadosPassagem;
	private JPanel painelCancelamento;
	private JButton bConsultar;
	private JButton bProximo;
	private ResourceBundle bundle;

	public TelaPassagemCancelarNumero(ResourceBundle bundle,JFrame jf) {
		super(jf,true);
		this.bundle = bundle;
		
		setBounds(100, 100, 699, 488);
		getContentPane().setLayout(null);
		
		painelCancelamento = new JPanel();
		painelCancelamento.setLayout(null);
		painelCancelamento.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCancelarNumero.borda.titulo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelCancelamento.setBounds(27, 44, 631, 360);
		getContentPane().add(painelCancelamento);
		
		painelDadosPassagem = new JPanel();
		painelDadosPassagem.setLayout(null);
		painelDadosPassagem.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCancelarNumero.borda.passagem"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelDadosPassagem.setBounds(24, 130, 581, 206);
		painelCancelamento.add(painelDadosPassagem);
		
		lNumeroPassagem = new JLabel(bundle.getString("telaPassagemCancelarNumero.label.numero"));
		lNomePassageiro = new JLabel(bundle.getString("telaPassagemCancelarNumero.label.nome"));
		lDataNascimento = new JLabel(bundle.getString("telaPassagemCancelarNumero.label.dataNasc"));
		lDestino        = new JLabel(bundle.getString("telaPassagemCancelarNumero.label.destino"));
		lDataPartida    = new JLabel(bundle.getString("telaPassagemCancelarNumero.label.dataPartida"));
		lHorarioPartida = new JLabel(bundle.getString("telaPassagemCancelarNumero.label.horarioPartida"));
		lDataRetorno    = new JLabel(bundle.getString("telaPassagemCancelarNumero.label.dataRetorno"));
		lHorarioRetorno = new JLabel(bundle.getString("telaPassagemCancelarNumero.label.horarioRetorno"));
		
		lNomePassageiro2 = new JLabel("Jefferson Alves da Costa");
		lDataNascimento2 = new JLabel("18/04/1994");
		lDestino2        = new JLabel("Fortaleza - CE");
		lDataPartida2    = new JLabel("15/12/2013");
		lHorarioPartida2 = new JLabel("09:00");
		lDataRetorno2    = new JLabel("05/01/2014");
		lHorarioRetorno2 = new JLabel("15:00");

		bProximo   = new JButton(bundle.getString("telaPassagemCancelarNumero.botao.proximo"));
		bConsultar = new JButton(bundle.getString("telaPassagemCancelarNumero.botao.consultar"));
		
		//---------------------------------
		
		lNumeroPassagem.setBounds(116, 48, 115, 14);
		lNumeroPassagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lNumeroPassagem.setHorizontalAlignment(SwingConstants.RIGHT);
		painelCancelamento.add(lNumeroPassagem);
		
		tNumeroPassagem = new JTextField();
		tNumeroPassagem.setBounds(237, 46, 217, 20);
		tNumeroPassagem.setColumns(10);
		painelCancelamento.add(tNumeroPassagem);
		
		//---------------------------------
		
		lNomePassageiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lNomePassageiro.setBounds(32, 31, 150, 14);
		painelDadosPassagem.add(lNomePassageiro);
		
		lDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lDataNascimento.setBounds(32, 56, 150, 14);
		painelDadosPassagem.add(lDataNascimento);
		
		lDestino.setFont(new Font("Tahoma", Font.BOLD, 11));
		lDestino.setBounds(32, 81, 150, 14);
		painelDadosPassagem.add(lDestino);
		
		lDataPartida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lDataPartida.setBounds(32, 106, 150, 14);
		painelDadosPassagem.add(lDataPartida);
		
		lHorarioPartida.setFont(new Font("Tahoma", Font.BOLD, 11));
		lHorarioPartida.setBounds(32, 131, 150, 14);
		painelDadosPassagem.add(lHorarioPartida);
		
		lDataRetorno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lDataRetorno.setBounds(32, 156, 150, 14);
		painelDadosPassagem.add(lDataRetorno);
		
		lHorarioRetorno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lHorarioRetorno.setBounds(32, 181, 150, 14);
		painelDadosPassagem.add(lHorarioRetorno);
		
		//---------------------------------
		
		lNomePassageiro2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lNomePassageiro2.setBounds(192, 31, 247, 14);
		painelDadosPassagem.add(lNomePassageiro2);
		
		lDataNascimento2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lDataNascimento2.setBounds(192, 56, 247, 14);
		painelDadosPassagem.add(lDataNascimento2);
		
		lDestino2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lDestino2.setBounds(192, 81, 247, 14);
		painelDadosPassagem.add(lDestino2);
		
		lDataPartida2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lDataPartida2.setBounds(192, 106, 247, 14);
		painelDadosPassagem.add(lDataPartida2);
		
		lHorarioPartida2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lHorarioPartida2.setBounds(192, 131, 247, 14);
		painelDadosPassagem.add(lHorarioPartida2);
		
		lDataRetorno2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lDataRetorno2.setBounds(192, 156, 247, 14);
		painelDadosPassagem.add(lDataRetorno2);
		
		lHorarioRetorno2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lHorarioRetorno2.setBounds(192, 181, 247, 14);
		painelDadosPassagem.add(lHorarioRetorno2);
		
		//---------------------------------
		
		bConsultar.setBounds(237, 74, 89, 23);
		painelCancelamento.add(bConsultar);
		
		bProximo.setBounds(584, 415, 89, 23);
		getContentPane().add(bProximo);
		bProximo.addActionListener(this);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bProximo){
			dispose();
			TelaPassagemCancelarConta tCancela = new TelaPassagemCancelarConta(bundle, null);
			tCancela.setVisible(true);
		}
	}
	
	
}
