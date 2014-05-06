package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;

public class TelaPassagemCompraValores extends JDialog implements ActionListener {

	private JButton bProxima;
	private ResourceBundle bundle = null;
	
	private JLabel lbHorario;
	private JLabel lbLinha1;
	private JLabel lbLinha2;
	private JLabel lbLinha3;
	private JLabel lbLinha4;
	private JLabel lbLinha5;
	private JLabel lbLinha6;
	private JLabel lbAdulto;
	private JLabel lbCriancas;
	private JLabel lbBebe;
	private JLabel lbQuantidadeAdulto;
	private JLabel lbQuantidadeCrianca;
	private JLabel lbQuantidadeBebe;
	private JLabel lbValorAdulto;
	private JLabel lbValorCrianca;
	private JLabel lbValorBebe;
	private JLabel lbValorVolta;
	private JLabel lbValorTotal;
	private JLabel lbValorTaxaEmbarque;
	private JLabel lbVolta;
	private JLabel lbTaxaEmbarque;
	private JLabel lbTotal;
	private JLabel lbDataRetorno;
	private JLabel lbHorarioRetorno;
	private JLabel lbDiaMesAnoRetorno;
	private JLabel lbHoraRetorno;
	private JLabel lbDestino;
	private JLabel lbData;
	private JLabel lbAeroporto;
	private JLabel lbDiaMesAno;
	private JLabel lbHora;
	private JLabel lbCidadeDestino;
	private JLabel lbNomeAeroporto;
	private JPanel painelBordaCompra;
	private JPanel painelValores;
	private JPanel painelPassagem;
	private JPanel painelRetorno;

	public TelaPassagemCompraValores(ResourceBundle bundle,JFrame jd) {
		super(jd,true);
		this.bundle  = bundle;
		setTitle("TelaPassagemCompraValores");
		
		setBounds(100, 100, 701, 492);
		getContentPane().setLayout(null);
		
		//------------------------------
		
		painelBordaCompra = new JPanel();
		painelBordaCompra.setLayout(null);
		painelBordaCompra.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraValores.borda.Compra"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBordaCompra.setBounds(25, 30, 637, 412);
		getContentPane().add(painelBordaCompra);
		
		painelValores = new JPanel();
		painelValores.setLayout(null);
		painelValores.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraValores.borda.valores"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelValores.setBounds(29, 36, 281, 365);
		painelBordaCompra.add(painelValores);
		
		painelPassagem = new JPanel();
		painelPassagem.setLayout(null);
		painelPassagem.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraValores.borda.passagem"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelPassagem.setBounds(320, 36, 286, 365);
		painelBordaCompra.add(painelPassagem);
		
		painelRetorno = new JPanel();
		painelRetorno.setLayout(null);
		painelRetorno.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraValores.borda.retorno"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelRetorno.setBounds(21, 187, 240, 156);
		painelPassagem.add(painelRetorno);
		
		//-------------------------------
		
		lbLinha1 = new JLabel("_________________________________");
		lbLinha2 = new JLabel("___________");
		lbLinha3 = new JLabel("___________");
		lbLinha4 = new JLabel("___________");
		lbLinha5 = new JLabel("_________________________________");
		lbLinha6 = new JLabel("___________");
		
		lbAdulto   = new JLabel(bundle.getString("telaPassagemCompraValores.label.adulto")+":");
		lbCriancas = new JLabel(bundle.getString("telaPassagemCompraValores.label.criancas")+":");
		lbBebe     = new JLabel(bundle.getString("telaPassagemCompraValores.label.bebe")+":");
		
		lbQuantidadeAdulto  = new JLabel("3");
		lbQuantidadeCrianca = new JLabel("3");
		lbQuantidadeBebe    = new JLabel("3");
		
		lbValorAdulto       = new JLabel("R$ 300,00");
		lbValorCrianca      = new JLabel("R$ 300,00");
		lbValorBebe         = new JLabel("R$ 300,00");
		lbValorVolta        = new JLabel("R$ 300,00");
		lbValorTotal        = new JLabel("R$ 300,00");
		lbValorTaxaEmbarque = new JLabel("R$ 300,00");
		
		lbVolta        = new JLabel(bundle.getString("telaPassagemCompraValores.label.volta")+":");
		lbTaxaEmbarque = new JLabel(bundle.getString("telaPassagemCompraValores.label.taxaEmbarque")+":");
		lbTotal        = new JLabel(bundle.getString("telaPassagemCompraValores.label.total")+":");
		
		lbDataRetorno      = new JLabel(bundle.getString("telaPassagemCompraValores.label.data")+":");
		lbHorarioRetorno   = new JLabel(bundle.getString("telaPassagemCompraValores.label.horario")+":");
		lbDiaMesAnoRetorno = new JLabel("20/12/2013");
		lbHoraRetorno      = new JLabel("20:00");
		
		lbDestino       = new JLabel(bundle.getString("telaPassagemCompraValores.label.destino")+":");
		lbAeroporto     = new JLabel(bundle.getString("telaPassagemCompraValores.label.aeroporto")+":");
		lbData          = new JLabel(bundle.getString("telaPassagemCompraValores.label.data")+":");
		lbHorario       = new JLabel(bundle.getString("telaPassagemCompraValores.label.horario")+":");
		lbCidadeDestino = new JLabel(bundle.getString("telaPassagemCompraValores.label.cidade")+":");
		lbNomeAeroporto = new JLabel(bundle.getString("telaPassagemCompraValores.label.nomeAeroporto")+":");
		lbDiaMesAno     = new JLabel("20/12/2013");
		lbHora          = new JLabel("20:00");
		
		bProxima        = new JButton(bundle.getString("telaPassagemCompraValores.botao.proximo"));
		//---------------------------

		lbLinha1.setBounds(22, 89, 235, 14);
		painelValores.add(lbLinha1);
		
		lbLinha2.setBounds(114, 114, 83, 14);
		painelValores.add(lbLinha2);
		
		lbLinha3.setBounds(114, 139, 83, 14);
		painelValores.add(lbLinha3);
		
		lbLinha4.setBounds(114, 164, 83, 14);
		painelValores.add(lbLinha4);
		
		lbLinha5.setBounds(22, 176, 235, 14);
		painelValores.add(lbLinha5);
		
		lbLinha6.setBounds(114, 199, 83, 14);
		painelValores.add(lbLinha6);
		
		//---------------------------
		
		lbAdulto.setBounds(22, 114, 64, 14);
		painelValores.add(lbAdulto);
		
		lbCriancas.setBounds(22, 139, 64, 14);
		painelValores.add(lbCriancas);
		
		lbBebe.setBounds(22, 164, 64, 14);
		painelValores.add(lbBebe);
		
		//----------------------------
		
		lbQuantidadeAdulto.setBounds(96, 114, 29, 14);
		painelValores.add(lbQuantidadeAdulto);
		
		lbQuantidadeCrianca.setBounds(96, 139, 29, 14);
		painelValores.add(lbQuantidadeCrianca);
		
		lbQuantidadeBebe.setBounds(96, 164, 29, 14);
		painelValores.add(lbQuantidadeBebe);
		
		//----------------------------
		
		lbValorAdulto.setBounds(207, 114, 64, 14);
		painelValores.add(lbValorAdulto);
		
		lbValorCrianca.setBounds(207, 139, 64, 14);
		painelValores.add(lbValorCrianca);
		
		lbValorBebe.setBounds(207, 164, 64, 14);
		painelValores.add(lbValorBebe);
		
		lbValorVolta.setBounds(207, 199, 64, 14);
		painelValores.add(lbValorVolta);
		
		lbValorTotal.setBounds(207, 250, 64, 14);
		painelValores.add(lbValorTotal);
		
		lbValorTaxaEmbarque.setBounds(207, 224, 64, 14);
		painelValores.add(lbValorTaxaEmbarque);
		
		//----------------------------
		
		lbVolta.setBounds(22, 199, 46, 14);
		painelValores.add(lbVolta);
		
		lbTaxaEmbarque.setBounds(22, 224, 115, 14);
		painelValores.add(lbTaxaEmbarque);
		
		lbTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbTotal.setBounds(22, 249, 46, 14);
		painelValores.add(lbTotal);
		
		//---------------------------
		
		lbDataRetorno.setBounds(10, 63, 46, 14);
		painelRetorno.add(lbDataRetorno);
		
		lbDiaMesAnoRetorno.setBounds(46, 63, 80, 14);
		painelRetorno.add(lbDiaMesAnoRetorno);
		
		lbHorarioRetorno.setBounds(112, 63, 46, 14);
		painelRetorno.add(lbHorarioRetorno);
		
		lbHoraRetorno.setBounds(184, 63, 46, 14);
		painelRetorno.add(lbHoraRetorno);
		
		//---------------------------------
		
		lbDestino.setBounds(21, 93, 67, 14);
		painelPassagem.add(lbDestino);
		
		lbAeroporto.setBounds(21, 115, 67, 14);
		painelPassagem.add(lbAeroporto);
		
		lbData.setBounds(21, 140, 46, 14);
		painelPassagem.add(lbData);
		
		lbDiaMesAno.setBounds(60, 140, 76, 14);
		painelPassagem.add(lbDiaMesAno);
		
		lbHorario.setBounds(134, 140, 46, 14);
		painelPassagem.add(lbHorario);
		
		lbHora.setBounds(202, 140, 46, 14);
		painelPassagem.add(lbHora);
		
		lbCidadeDestino.setBounds(98, 93, 163, 14);
		painelPassagem.add(lbCidadeDestino);
		
		lbNomeAeroporto.setBounds(98, 115, 163, 14);
		painelPassagem.add(lbNomeAeroporto);
		
		//-------------------------------
		
		bProxima.setBounds(168, 275, 89, 23);
		painelValores.add(bProxima);
		bProxima.addActionListener(this);
		
		//----------------------------------
		
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bProxima){
			dispose();
			TelaPassagemCompraCadastroPassageiros p = new TelaPassagemCompraCadastroPassageiros(bundle,null);
			p.setVisible(true);
		}
	}
}
