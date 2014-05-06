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

import Control.Voo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVooAlterar extends JDialog implements ActionListener{
	
	private ResourceBundle bundle;
	private JComboBox origem;
	private JComboBox destino;
	private JTextField data;
	private JTextField hora;
	private JComboBox status;
	private JTextField valor;
	
	private Voo voo;
	
	public TelaVooAlterar(final ResourceBundle bundle,JFrame fr,Voo voo){
		
		super(fr, true);
		setBounds(100, 100, 278, 350);
		setResizable(false);
		getContentPane().setLayout(null);
		this.bundle = bundle;
		this.voo = voo;
		
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
		origem.setSelectedItem(voo.getOrigem());	
		//Destino
		JLabel lblDestino = new JLabel(bundle.getString("telaVooCadastra.label.destino")+ ":");
		lblDestino.setBounds(29, 51, 60, 20);
		
		//Campo de Destino
		destino = new JComboBox();
		destino.setModel(modelComboCidades());
		destino.setBounds(99, 51, 130, 20);
		destino.setSelectedItem(voo.getDestino());
		
		//Data
		JLabel lblData = new JLabel(bundle.getString("telaVooCadastra.label.data") + ":");
		lblData.setBounds(29, 81, 60, 20);
		
		//Campo de Data
		data = new JFormattedTextField(mascara("##/##/####"));
		data.setBounds(99, 81, 100, 20);
		data.setEnabled(true);
		data.setText(voo.data());
		//Hora
		JLabel lblHora = new JLabel(bundle.getString("telaVooCadastra.label.hora") + ":");
		lblHora.setBounds(29, 111, 60, 20);
		
		//Campo de Hora
		hora = new JFormattedTextField(mascara("##:##"));
		hora.setBounds(99, 111, 100, 20);
		hora.setEnabled(true);
		hora.setText(voo.hora());
		//Situação
		JLabel lblSituacao = new JLabel(bundle.getString("telaVooCadastra.label.situacao")+ ":");
		lblSituacao.setBounds(29, 141, 60, 20);
		
		//Campo de situacao
		status = new JComboBox<String>();
		status.setModel(modelComboStatus());
		status.setBounds(99, 141, 130, 20);
		status.setSelectedItem(voo.getStatus());
		//Valor
		JLabel lblValor = new JLabel(bundle.getString("telaVooCadastra.label.valor")+ ":");
		lblValor.setBounds(29, 172, 70, 20);
		
		valor = new JTextField();
		valor.setBounds(99, 172, 70, 20);
		valor.setEnabled(true);		
		valor.setText(voo.getValor());
		
		//Botão de Cadastrar
	      JButton cadastrar = new JButton(bundle.getString("telaVooCadastra.button.cadastrar"));
	      cadastrar.setBounds(160, 281, 100, 30);
	   	//AdicionarEvento
	      cadastrar.addActionListener(this);
		
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
	
	public void actionPerformed(ActionEvent e) {
	      try{
	         DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	         DateFormat formatHora = new SimpleDateFormat("HH:mm");
	         TelaAeronaveConsulta tAeronaveConsulta = new TelaAeronaveConsulta(bundle,null, "cadastrarVoo");
	         tAeronaveConsulta.setVisible(true);
	         int codAero = tAeronaveConsulta.aeronaveSelecionada().getCodigo();
	         int cod      = voo.getCodigo();
	         System.out.println(voo.getCodigo());
	         String orig  = ""+origem.getSelectedItem();
	         String dest  = ""+destino.getSelectedItem();
	         Date dataSQL = new Date(formatData.parse(data.getText()).getTime());
	         Time horaSQL = new Time(formatHora.parse(hora.getText()).getTime());
	         String stats = ""+status.getSelectedItem();
	         String val   = ""+valor.getText();
	      
	         Voo vAux = new Voo(cod,orig,dest,dataSQL,horaSQL,stats,val,codAero);
	         voo.alterar(vAux);
	      }
	      catch(ParseException ex){
	         JOptionPane.showMessageDialog(null,"Erro na conversão da Data ou da Hora!" );
	         ex.printStackTrace();
	      }
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
						"Selecione",
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
