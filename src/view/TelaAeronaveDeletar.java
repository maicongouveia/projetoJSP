package view;

import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controller.Aeronave;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAeronaveDeletar extends JDialog {
	
	public TelaAeronaveDeletar(final ResourceBundle bundle,JFrame fr,final Aeronave aero){
		
		super(fr, true);
		setBounds(100, 100, 400, 400);
		setResizable(false);
		getContentPane().setLayout(null);
		
		//Titulo da Janela
		JLabel tituloTela = new JLabel(bundle.getString("telaAeronaveDeletar.tituloBorda.deletar"));
		tituloTela.setBounds(5, 5, 400, 50);
		tituloTela.setFont(new Font(null , Font.BOLD, 40));
		getContentPane().add(tituloTela);
		tituloTela.setLayout(null);
		
		//Painel com Borda Passagem
		JPanel painelBordaPassagem = new JPanel();
		painelBordaPassagem.setBorder(new TitledBorder(null,bundle.getString("telaPrincipal.menu.aeronave"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBordaPassagem.setBounds(10, 60, 380, 150);
		getContentPane().add(painelBordaPassagem);
		painelBordaPassagem.setLayout(null);
		
		//Painel com Borda Pegunta
		JPanel painelBordaPergunta = new JPanel();
		painelBordaPergunta.setBorder(new TitledBorder(null,bundle.getString("telaAeronaveDeletar.tituloBorda.deletar"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBordaPergunta.setBounds(10, 220, 380, 130);
		getContentPane().add(painelBordaPergunta);
		painelBordaPergunta.setLayout(null);
		
		//Dados da Aeronave
		
		//Codigo da Aeronave
		JLabel lblCodAeronave = new JLabel(bundle.getString("telaAeronaveCadastra.label.codigoAeronave")+ ":");
		lblCodAeronave.setBounds(40, 35, 165, 20);
		lblCodAeronave.setFont(new Font(null , Font.BOLD, 16));
		
		JLabel lblCodAeronave2 = new JLabel(""+aero.getCodigo());
		lblCodAeronave2.setBounds(210, 36, 130, 20);		
		
		//Nome da Aeronave
		JLabel lblNomeAeronave = new JLabel(bundle.getString("telaAeronaveCadastra.label.nomeAeronave")+ ":");
		lblNomeAeronave.setBounds(40, 65, 155, 20);
		lblNomeAeronave.setFont(new Font(null , Font.BOLD, 16));
		
		JLabel lblNomeAeronave2 = new JLabel(aero.getNome());
		lblNomeAeronave2.setBounds(200, 66, 130, 20);
			
		//Quantidade de Acentos
		JLabel lblQtdAcentos = new JLabel(bundle.getString("telaAeronaveCadastra.label.qtdAcentos")+ ":");
		lblQtdAcentos.setBounds(40, 95, 190, 20);
		lblQtdAcentos.setFont(new Font(null , Font.BOLD, 16));
		
		JLabel lblQtdAcentos2 = new JLabel(""+aero.getQuantidade());
		lblQtdAcentos2.setBounds(235, 96, 40, 20);

		
		//Pergunta
		JLabel lblPergunta = new JLabel(bundle.getString("telaAeronaveDeletar.pergunta.pergunta"));
		lblPergunta.setBounds(20, 25, 360, 30);
		lblPergunta.setFont(new Font(null , Font.BOLD, 19));
		
		//Botões
		
		//Sim
		JButton sim = new JButton(bundle.getString("telaAeronaveDeletar.pergunta.sim"));
		sim.setBounds(90, 70, 100, 30);
		//AdicionarEvento
				sim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							aero.deletar();
							JOptionPane.showMessageDialog(null, bundle.getString("telaAeronaveDeletar.resposta.deletada"));
							dispose();
					}
				});
		//Não
		JButton nao = new JButton(bundle.getString("telaAeronaveDeletar.pergunta.nao"));
		nao.setBounds(200, 70, 100, 30);
		nao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							dispose();						
					}
				});
		
		
		//Adicionando Elementos no Painel do Fomulário
		painelBordaPassagem.add(lblCodAeronave);
		painelBordaPassagem.add(lblCodAeronave2);
		
		painelBordaPassagem.add(lblNomeAeronave);
		painelBordaPassagem.add(lblNomeAeronave2);
		
		painelBordaPassagem.add(lblQtdAcentos);
		painelBordaPassagem.add(lblQtdAcentos2);
		
		painelBordaPergunta.add(lblPergunta);
		painelBordaPergunta.add(sim);
		painelBordaPergunta.add(nao);
		
		//Centralizar Tela
		this.setLocationRelativeTo(null);
		
	}
}
