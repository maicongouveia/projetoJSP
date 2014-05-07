package view;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;

import BD.AeronaveBD;
import Control.Aeronave;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAeronaveCadastra extends JDialog implements ActionListener{
	
	private ResourceBundle bundle = null;
	private JTextField nomeAeronave;
	private JComboBox tipoAeronave;
	private JSpinner jsColunas;
	private JSpinner jsFileiras;
	private JTextField codAeronave;
	
	/**
	 * @param bundle
	 * @param fr
	 * @throws SQLException 
	 */
	public TelaAeronaveCadastra(final ResourceBundle bundle,JFrame fr){
		
		super(fr, true);
		this.bundle = bundle;
		setBounds(100, 100, 380, 350);
		setResizable(false);
		getContentPane().setLayout(null);
		
		//Titulo da tela
		JLabel tituloTela = new JLabel(bundle.getString("telaAeronave.titulo.aeronave"));
		tituloTela.setBounds(15, 10, 230, 40);
	    tituloTela.setFont(new Font(null , Font.BOLD, 40));
		getContentPane().add(tituloTela);
		
		//Painel com Borda
		JPanel painelBorda = new JPanel();
		painelBorda.setBorder(new TitledBorder(null,bundle.getString("telaAeronaveCadastra.tituloBorda.cadastraDeAeronave"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBorda.setBounds(10, 50, 350, 250);
		getContentPane().add(painelBorda);
		painelBorda.setLayout(null);
		
		//Formulario
		
		//Codigo da Aeronave
		JLabel lblCodAeronave = new JLabel(bundle.getString("telaAeronaveCadastra.label.codigoAeronave")+ ":");
		lblCodAeronave.setBounds(15, 35, 130, 20);
		
		//Campo de Codigo de Aeronave
		String ultimo = new AeronaveBD().getLastIdAeronave()+"";
		codAeronave = new JTextField(ultimo);
		codAeronave.setBounds(140, 35, 50, 20);
		codAeronave.setSelectionColor(Color.black);
		codAeronave.setEnabled(false);
		codAeronave.setColumns(20);
		
		//Nome da Aeronave
		JLabel lblNomeAeronave = new JLabel(bundle.getString("telaAeronaveCadastra.label.nomeAeronave")+ ":");
		lblNomeAeronave.setBounds(15, 65, 130, 20);
				
		//Campo de Nome de Aeronave
		nomeAeronave = new JTextField();
		nomeAeronave.setBounds(140, 65, 150, 20);
		nomeAeronave.setEnabled(true);
		nomeAeronave.setColumns(50);		
		
		//Quantidade de Acentos
		JLabel lblTipo = new JLabel(bundle.getString("telaAeronaveCadastra.label.tipo")+ ":");
		lblTipo.setBounds(15, 95, 150, 20);
		
		//Campo de Qtd de Acentos
		tipoAeronave = new JComboBox();
		tipoAeronave.setModel(
				new DefaultComboBoxModel(
						new String[] {
								"Selecione..",
								"Transporte",
								"Carga",
								"Particular"
						}
				)
		);		
		tipoAeronave.setBounds(140, 95, 150, 20);
		
		//Localização de Acentos
		JLabel lblLocAcentos = new JLabel(bundle.getString("telaAeronaveCadastra.label.locAcentos") + ":");
		lblLocAcentos.setBounds(15, 125, 150, 20);
		
		//Colunas
		JLabel lblColunas = new JLabel(bundle.getString("telaAeronaveConsulta.label.colunas") + ":");
		lblColunas.setBounds(15, 148, 70, 20);
		
		//Campo de Colunas
		SpinnerNumberModel modeloC = new SpinnerNumberModel(1,1,99,1);
		jsColunas = new JSpinner(modeloC);
		jsColunas.setBounds(80, 150, 50, 20);
		
		//Fileiras
		JLabel lblFileiras = new JLabel(bundle.getString("telaAeronaveConsulta.label.fileiras")  + ":");
		lblFileiras.setBounds(150, 148, 70, 20);
		
		//Campo de Fileiras
		SpinnerNumberModel modeloF = new SpinnerNumberModel(1,1,99,1);
		jsFileiras = new JSpinner(modeloF);
		jsFileiras.setBounds(220, 150, 50, 20);
		
		//Botão de Cadastrar
		JButton cadastrar = new JButton(bundle.getString("telaAeronaveCadastra.button.cadastrar"));
		cadastrar.setBounds(20, 200, 100, 30);
		//AdicionarEvento
		cadastrar.addActionListener(this);
		
		//Adicionando Elementos no Painel do Fomulário
		painelBorda.add(lblCodAeronave);
		painelBorda.add(codAeronave);
		
		painelBorda.add(lblNomeAeronave);
		painelBorda.add(nomeAeronave);
		
		painelBorda.add(lblTipo);
		painelBorda.add(tipoAeronave);
		
		painelBorda.add(lblLocAcentos);
		
		painelBorda.add(lblColunas);
		painelBorda.add(jsColunas);
		
		painelBorda.add(lblFileiras);
		painelBorda.add(jsFileiras);
		
		painelBorda.add(cadastrar);
		
		//Centralizar Tela
		this.setLocationRelativeTo(null);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
		int cod      = Integer.parseInt(codAeronave.getText());
		
		int fileiras = (Integer)jsFileiras.getValue();
		
		int colunas  = (Integer)jsColunas.getValue();
		
		String nome  = nomeAeronave.getText();
		
		String tipo  = (String)tipoAeronave.getSelectedItem();
		
		if(tipo.equals("Selecione..") || nome.length()<2){
			JOptionPane.showMessageDialog(null, bundle.getString("telaAeronaveCadastra.resposta.cadastroErrado"));
		}
		else{
			Aeronave aero = new Aeronave(cod,fileiras,colunas,nome,tipo);
			aero.incluir();
			JOptionPane.showMessageDialog(null, bundle.getString("telaAeronaveCadastra.resposta.cadastroSucesso"));
		}
	}

}
