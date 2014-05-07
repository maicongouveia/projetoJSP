package view;

import java.sql.Date;
import java.sql.Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import BD.VooBD;
import Control.Voo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVooCadastra extends JDialog {	
	
	private JComboBox<String> destino;
	private JComboBox<String> origem;
	private JTextField data;
	private JTextField hora;
	private JComboBox<String> status;
	private JTextField valor;
	private JButton cadastrar;
	
	private ResourceBundle bundle;
	
	public TelaVooCadastra(final ResourceBundle bundle,JFrame fr){
		
		super(fr, true);
		setBounds(100, 100, 278, 350);
		setResizable(false);
		getContentPane().setLayout(null);
		this.bundle = bundle;
		
		//Titulo da tela
		JLabel tituloTela = new JLabel(bundle.getString("telaVoo.titulo.voo"));
		tituloTela.setBounds(15, 10, 250, 40);
	    tituloTela.setFont(new Font(null , Font.BOLD, 40));
		getContentPane().add(tituloTela);
		
		//Painel com Borda
		JPanel painelBorda = new JPanel();
		painelBorda.setBorder(new TitledBorder(null,bundle.getString("telaVooCadastra.tituloBorda.cadastraDeVoo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBorda.setBounds(10, 50, 250, 231);
		getContentPane().add(painelBorda);
		painelBorda.setLayout(null);
		
		
		//Formulario
		
		//Origem
		JLabel lblOrigem = new JLabel(bundle.getString("telaVooCadastra.label.origem")+ ":");
		lblOrigem.setBounds(29, 21, 60, 20);
				
		//Campo de Origem
		origem = new JComboBox();
		origem.setModel(modelComboCidades());
		origem.setBounds(99	, 21, 130, 20);
	
		//Destino
		JLabel lblDestino = new JLabel(bundle.getString("telaVooCadastra.label.destino")+ ":");
		lblDestino.setBounds(29, 51, 60, 20);
		
		//Campo de Destino
		destino = new JComboBox();
		destino.setModel(modelComboCidades());
		destino.setBounds(99, 51, 130, 20);
		
		//Data
		JLabel lblData = new JLabel(bundle.getString("telaVooCadastra.label.data") + ":");
		lblData.setBounds(29, 81, 60, 20);
		
		//Campo de Data
		data = new JFormattedTextField(mascara("##/##/####"));
		data.setBounds(99, 81, 100, 20);
		data.setEnabled(true);
		
		//Hora
		JLabel lblHora = new JLabel(bundle.getString("telaVooCadastra.label.hora") + ":");
		lblHora.setBounds(29, 111, 60, 20);
		
		//Campo de Hora
		hora = new JFormattedTextField(mascara("##:##"));
		hora.setBounds(99, 111, 100, 20);
		hora.setEnabled(true);
		
		//Situação
		JLabel lblSituacao = new JLabel(bundle.getString("telaVooCadastra.label.situacao")+ ":");
		lblSituacao.setBounds(29, 141, 60, 20);
		
		//Campo de situacao
		status = new JComboBox<String>();
		status.setModel(modelComboStatus());
		status.setSelectedIndex(1);
		status.setBounds(99, 141, 130, 20);
		
		//Valor
		JLabel lblValor = new JLabel(bundle.getString("telaVooCadastra.label.valor")+ ":");
		lblValor.setBounds(29, 172, 70, 20);
		
		valor = new JTextField();
		valor.setBounds(99, 172, 70, 20);
		valor.setEnabled(true);		
		
		//Botão de Cadastrar
		cadastrar = new JButton(bundle.getString("telaVooCadastra.button.cadastrar"));
		cadastrar.setBounds(160, 281, 100, 30);
		//AdicionarEvento
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(verificaCampos()){
						TelaAeronaveConsulta tAeronaveConsulta = new TelaAeronaveConsulta(bundle,null, "cadastrarVoo");
		           	 	tAeronaveConsulta.setVisible(true);
		           	 	int c = tAeronaveConsulta.aeronaveSelecionada().getCodigo();
		           	 	cadastraVoo(c);
		           	 	dispose();
					}
			}
		});
		
		painelBorda.add(lblOrigem);
		painelBorda.add(origem);
		
		painelBorda.add(lblDestino);
		painelBorda.add(destino);
		
		painelBorda.add(lblData);
		painelBorda.add(data);
		
		painelBorda.add(lblHora);
		painelBorda.add(hora);
		
		painelBorda.add(lblSituacao);
		painelBorda.add(status);
		
		painelBorda.add(lblValor);
		painelBorda.add(valor);
			
		getContentPane().add(cadastrar);
		
		//Centralizar Tela
		this.setLocationRelativeTo(null);	
		
	}
	
	public void cadastraVoo(int codAero){
		try{
			DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat formatHora = new SimpleDateFormat("HH:mm");
			String val = valor.getText();
			String  orig = (String)origem.getSelectedItem(); 
			String  dest = (String)destino.getSelectedItem(); 
			String  stat = (String)status.getSelectedItem();
			String dataString = data.getText();
			String horaString = hora.getText();
			Date dataSQL = new Date(formatData.parse(dataString).getTime());
			Time horaSQL = new Time(formatHora.parse(horaString).getTime());		
			Voo v = new Voo(orig,dest,dataSQL,horaSQL,stat,val,codAero);
			v.incluir();
		}catch(ParseException e){
			e.printStackTrace();
		}	
		
	}
	
	public boolean verificaCampos(){
		
		if(origem.getSelectedItem().equals(destino.getSelectedItem())){
			JOptionPane.showMessageDialog(null,"Destino e Origem nao podem ser iguais!");
			return false;
		}
		
		if(		data.getText() == null || 
				data.getText().equals("  /  /    ")||
				Integer.parseInt((data.getText().substring(0,2))) > 31||
				Integer.parseInt((data.getText().substring(0,2))) < 1 ||
				Integer.parseInt((data.getText().substring(3,5))) > 12||
				Integer.parseInt((data.getText().substring(3,5))) < 1
				){
			JOptionPane.showMessageDialog(null,"Data Invalida!!");
			return false;
		}	
		return true;
	}
	
	public MaskFormatter mascara(String Mascara){          
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask(Mascara); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	    	   excecao.printStackTrace();  
	       }   
	       return F_Mascara;  
	}
	
	public DefaultComboBoxModel modelComboCidades(){
		DefaultComboBoxModel model = new DefaultComboBoxModel(
				new String[] {
						bundle.getString("telaVooCadastra.comboBox.selecione"),
						"São Paulo",
						"Rio de Janeiro",
						"Minas Gerais",
						"Mato Grosso"
					}
		);
		return model;		
	}		
	
	public DefaultComboBoxModel modelComboStatus(){
		DefaultComboBoxModel model = new DefaultComboBoxModel(
				new String[] {
						bundle.getString("telaVooCadastra.comboBox.selecione"),
						bundle.getString("telaVooCadastra.comboBox.emEspera"),
						bundle.getString("telaVooCadastra.comboBox.confirmado"),
						bundle.getString("telaVooCadastra.comboBox.concluido"),
						bundle.getString("telaVooCadastra.comboBox.cancelado")
				}
				);
		return model;		
	}
}
