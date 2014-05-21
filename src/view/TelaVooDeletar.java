package view;

import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controller.Voo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVooDeletar extends JDialog {
	
	public TelaVooDeletar(final ResourceBundle bundle,JFrame fr,final Voo voo){
		
		super(fr, true);
		setBounds(100, 100, 400, 400);
		setResizable(false);
		getContentPane().setLayout(null);
		
		//Titulo da Janela
		JLabel tituloTela = new JLabel(bundle.getString("telaVooDeletar.tituloBorda.deletar"));
		tituloTela.setBounds(5, 5, 400, 50);
		tituloTela.setFont(new Font(null , Font.BOLD, 40));
		getContentPane().add(tituloTela);
		tituloTela.setLayout(null);
		
		//Painel
		JPanel painelBordaPassagem = new JPanel();
		painelBordaPassagem.setBorder(new TitledBorder(null,bundle.getString("telaVoo.titulo.voo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBordaPassagem.setBounds(10, 60, 380, 150);
		getContentPane().add(painelBordaPassagem);
		painelBordaPassagem.setLayout(null);
		
		//Painel com Borda Pergunta
		JPanel painelBordaPergunta = new JPanel();
		painelBordaPergunta.setBorder(new TitledBorder(null,bundle.getString("telaVooDeletar.tituloBorda.deletar"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBordaPergunta.setBounds(10, 220, 380, 130);
		getContentPane().add(painelBordaPergunta);
		painelBordaPergunta.setLayout(null);
		
		/* Dados do Vôo */
		
		//Codigo do Vôo
		JLabel lblCodVoo = new JLabel(bundle.getString("telaVooDeletar.label.codigoVoo")+ ":");
		lblCodVoo.setBounds(40, 35, 100, 20);
		lblCodVoo.setFont(new Font(null , Font.BOLD, 16));
		
		JLabel lblCodVoo2 = new JLabel(""+voo.getCodigo());
		lblCodVoo2.setBounds(150, 36, 130, 20);		
		
		//
		JLabel lblOrigem = new JLabel(bundle.getString("telaVooDeletar.label.origem")+ ":");
		lblOrigem.setBounds(40, 65, 100, 20);
		lblOrigem.setFont(new Font(null , Font.BOLD, 16));
		
		JLabel lOrigem = new JLabel(""+voo.getOrigem());
		lOrigem.setBounds(150, 66, 130, 20);
			
		//Label Destino
		JLabel lblDestino = new JLabel(bundle.getString("telaVooDeletar.label.destino")+ ":");
		lblDestino.setBounds(40, 95, 100, 20);
		lblDestino.setFont(new Font(null , Font.BOLD, 16));
		
		JLabel lDestino = new JLabel(""+voo.getDestino());
		lDestino.setBounds(150, 96, 130, 20);

		
		//Pergunta
		JLabel lblPergunta = new JLabel(bundle.getString("telaVooDeletar.pergunta.pergunta"));
		lblPergunta.setBounds(20, 25, 360, 30);
		lblPergunta.setFont(new Font(null , Font.BOLD, 19));
		
		//Botões
		
		//Sim
		JButton sim = new JButton(bundle.getString("telaVooDeletar.pergunta.sim"));
		sim.setBounds(90, 70, 100, 30);
		//AdicionarEvento
				sim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, bundle.getString("telaVooDeletar.resposta.deletada"));
							dispose();
							voo.deletar();
					}
				});
		//Não
		JButton nao = new JButton(bundle.getString("telaVooDeletar.pergunta.nao"));
		nao.setBounds(200, 70, 100, 30);
		nao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							dispose();						
					}
				});
		
		
		
		//Adicionando Elementos no Painel do Fomulário
		painelBordaPassagem.add(lblCodVoo);
		painelBordaPassagem.add(lblCodVoo2);
		
		painelBordaPassagem.add(lblOrigem);
		painelBordaPassagem.add(lOrigem);
		
		painelBordaPassagem.add(lblDestino);
		painelBordaPassagem.add(lDestino);
		
		painelBordaPergunta.add(lblPergunta);
		painelBordaPergunta.add(sim);
		painelBordaPergunta.add(nao);
		
		
		
		//Centralizar Tela
		this.setLocationRelativeTo(null);
		
		
	}
	
		

}
