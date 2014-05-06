package view;

import java.util.ResourceBundle;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;

public class TelaPassagemCompraPassageiros extends JDialog implements ActionListener{

	
	private JPanel painelPassagem;
	private JPanel painelRetorno;
	private JPanel painel;
	private JSpinner spAdulto;
	private JSpinner spCrianca;
	private JSpinner spBebe;
	private JLabel lbQuantidadePassageiros;
	private JLabel lbDataRetorno;
	private JLabel lbHorario;
	private JLabel lbDiaMesAnoRetorno;
	private JLabel lbHora;
	private JLabel lbDestino;
	private JLabel lbAeroporto;
	private JLabel lbData;
	private JLabel lbDiaMesAno;
	private JLabel lbHoraR;
	private JLabel lbHorarioR;
	private JLabel lbCidade;
	private JLabel lbNomeAeroporto;
	private JLabel lbAdulto;
	private JLabel lbCrianca;
	private JLabel lbBebe;
	private JButton bProximo;
	private ResourceBundle bundle = null;

	public TelaPassagemCompraPassageiros(ResourceBundle bundle,JFrame compra) {
		super(compra,true);
		this.bundle = bundle;
		setTitle("TelaPassagemCompraPassageiros");
		
		getContentPane().setLayout(null);
		setBounds(100, 100, 1000, 580);
		
		painel         = new JPanel();
		painelPassagem = new JPanel();
		painelRetorno  = new JPanel();
		
		//---------------------------
		
		lbAdulto                = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.adulto"));
		lbCrianca               = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.crianca"));
		lbBebe                  = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.bebe"));
		lbQuantidadePassageiros = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.qntPassageiro"));
		lbDataRetorno           = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.data"));
		lbHorario               = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.horario"));
		lbDestino               = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.destino"));
		lbAeroporto             = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.aeroporto"));
		lbData                  = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.data"));
		lbHorarioR              = new JLabel(bundle.getString("telaPassagemCompraPassageiros.label.horario"));
		
	 	bProximo                = new JButton(bundle.getString("telaPassagemCompraPassageiros.botao.proximo"));
		
		lbDiaMesAnoRetorno = new JLabel("20/12/2013");
		lbHora             = new JLabel("20:00");
		lbDiaMesAno        = new JLabel("20/12/2013");
		lbHoraR            = new JLabel("20:00");
		lbCidade           = new JLabel("Rio De Janeiro");
		lbNomeAeroporto    = new JLabel("Principal da Cidade");
		
		spAdulto  = new JSpinner();
		spCrianca = new JSpinner();
		spBebe    = new JSpinner();
		
		//---------------------------------
		
		lbAdulto.setBounds(23, 124, 73, 20);
		getContentPane().add(lbAdulto);
		
		lbCrianca.setBounds(23, 152, 73, 20);
		getContentPane().add(lbCrianca);
		
		lbBebe.setBounds(23, 183, 73, 20);
		getContentPane().add(lbBebe);
		
		spAdulto.setBounds(100, 124, 48, 20);
		getContentPane().add(spAdulto);
		
		spCrianca.setBounds(100, 152, 48, 20);
		getContentPane().add(spCrianca);
		
		spBebe.setBounds(100, 183, 48, 20);
		getContentPane().add(spBebe);
		
		painel.setBorder(        new TitledBorder(null, bundle.getString("telaPassagemCompraPassageiros.borda.compra"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelPassagem.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraPassageiros.borda.passagem"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelRetorno.setBorder( new TitledBorder(null, bundle.getString("telaPassagemCompraPassageiros.borda.retorno"), TitledBorder.LEADING, TitledBorder.TOP, null, null));

		painel.setBounds(10, 38, 651, 350);
		getContentPane().add(painel);
		painel.setLayout(null);
		
		painelPassagem.setBounds(341, 32, 286, 293);
		painel.add(painelPassagem);
		painelPassagem.setLayout(null);
		
		painelRetorno.setBounds(23, 126, 240, 156);
		painelPassagem.add(painelRetorno);
		painelRetorno.setLayout(null);
		
		lbQuantidadePassageiros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbQuantidadePassageiros.setBounds(23, 99, 178, 14);
		getContentPane().add(lbQuantidadePassageiros);
		
		lbDataRetorno.setBounds(10, 63, 46, 14);
		painelRetorno.add(lbDataRetorno);
		
		lbHorario.setBounds(129, 63, 46, 14);
		painelRetorno.add(lbHorario);
		
		lbDiaMesAnoRetorno.setBounds(46, 63, 73, 14);
		painelRetorno.add(lbDiaMesAnoRetorno);
		
		lbHora.setBounds(171, 63, 46, 14);
		painelRetorno.add(lbHora);
		
		lbDestino.setBounds(23, 32, 67, 14);
		painelPassagem.add(lbDestino);
		
		lbAeroporto.setBounds(23, 54, 67, 14);
		painelPassagem.add(lbAeroporto);
		
		lbData.setBounds(23, 79, 46, 14);
		painelPassagem.add(lbData);
		
		lbDiaMesAno.setBounds(79, 79, 73, 14);
		painelPassagem.add(lbDiaMesAno);
		
		lbHoraR.setBounds(196, 79, 46, 14);
		painelPassagem.add(lbHoraR);
		
		lbHorarioR.setBounds(148, 79, 46, 14);
		painelPassagem.add(lbHorarioR);
		
		lbCidade.setBounds(100, 32, 163, 14);
		painelPassagem.add(lbCidade);
		
		lbNomeAeroporto.setBounds(100, 54, 163, 14);
		painelPassagem.add(lbNomeAeroporto);
		
		bProximo.setBounds(49, 178, 89, 23);
		painel.add(bProximo);
		bProximo.addActionListener(this);
		
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bProximo){
			dispose();
			TelaPassagemCompraValores p = new TelaPassagemCompraValores(bundle,null);
			p.setVisible(true);
		}
			
	}
}
