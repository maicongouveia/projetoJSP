package view;

import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;

public class TelaPassagemCompraDestino extends JDialog implements ActionListener{
	
	private JTextField txtDataPartida;
	private JTextField txtDataRetorno;
	private JCheckBox chIdaVolta;
	private JButton bSelecionar;
	private ResourceBundle bundle = null;
	private JComboBox cEstado;
	private JComboBox cCidade;
	private JComboBox cAeroporto;
	private JLabel lbEstado;
	private JLabel lbCidade;
	private JLabel lbAeroporto;
	private JPanel painelBorda;
	private JPanel painelTabela;
	private JTable tableDestino;
	private JLabel lbDataPartida;
	private JLabel lbDataRetorno;

	
	public TelaPassagemCompraDestino(final ResourceBundle bundle,JFrame p) {
		super(p,true);
		this.bundle = bundle;
		componentes();
		this.setLocationRelativeTo(null);
	}
	
	public void componentes(){
		setTitle("TelaPassagemCompraDestino");
		getContentPane().setLayout(null);
		setBounds(100,100,1000,560);
		
		lbEstado    = new JLabel("Estado:");
		lbCidade    = new JLabel("Cidade:");
		lbAeroporto = new JLabel("Aeroporto:");
		
		lbEstado.setBounds(23, 89, 82, 20);
		lbCidade.setBounds(23, 117, 82, 20);
		lbAeroporto.setBounds(23, 148, 82, 20);
		
		getContentPane().add(lbEstado);
		getContentPane().add(lbCidade);
		getContentPane().add(lbAeroporto);
		
		cEstado    = new JComboBox();
		cCidade    = new JComboBox();
		cAeroporto = new JComboBox();
		
		cEstado.setModel(new DefaultComboBoxModel(new String[] {"Acre (AC)", "Alagoas (AL)", "Amap\u00E1 (AP)", "Amazonas (AM)", "Bahia (BA)", "Cear\u00E1 (CE)", "Distrito Federal (DF)", "Esp\u00EDrito Santo (ES)", "Goi\u00E1s (GO)", "Maranh\u00E3o (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Par\u00E1 (PA) ", "Para\u00EDba (PB)", "Paran\u00E1 (PR)", "Pernambuco (PE)", "Piau\u00ED (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rond\u00F4nia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "S\u00E3o Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		cCidade.setModel(new DefaultComboBoxModel(new String[] {"S\u00E3o Paulo", "Rio de Janeiro", "Salvador", "Bras\u00EDlia", "Fortaleza", "Belo Horizonte", "Manaus", "Curitiba", "Recife", "Porto Alegre", "Bel\u00E9m", "Goi\u00E2nia", "Guarulhos", "Campinas", "S\u00E3o Lu\u00EDs", "S\u00E3o Gon\u00E7alo", "Macei\u00F3", "Duque de Caxias", "Teresina", "Natal", "Campo Grande", "Nova Igua\u00E7u", "S\u00E3o Bernardo do Campo", "Jo\u00E3o Pessoa", "Santo Andr\u00E9", "Osasco", "Jaboat\u00E3o dos Guararapes", "S\u00E3o Jos\u00E9 dos Campos", "Ribeir\u00E3o Preto", "Uberl\u00E2ndia", "Contagem", "Sorocaba", "Aracaju", "Feira de Santana", "Cuiab\u00E1", "Joinville", "Juiz de Fora", "Londrina", "Niter\u00F3i", "Ananindeua", "Belford Roxo", "Aparecida de Goi\u00E2nia", "Campos dos Goytacazes", "S\u00E3o Jo\u00E3o de Meriti", "Caxias do Sul", "Porto Velho", "Florian\u00F3polis", "Mau\u00E1", "Vila Velha", "Serra", "Santos", "S\u00E3o Jos\u00E9 do Rio Preto", "Macap\u00E1", "Mogi das Cruzes", "Diadema", "Campina Grande", "Betim", "Olinda", "Jundia\u00ED", "Carapicu\u00EDba", "Montes Claros", "Piracicaba", "Maring\u00E1", "Cariacica", "Rio Branco", "Bauru", "An\u00E1polis", "S\u00E3o Vicente", "Caucaia", "Vit\u00F3ria", "Pelotas", "Itaquaquecetuba", " Canoas", " Caruaru", " Franca", " Ponta Grossa", " Blumenau", " Vit\u00F3ria da Conquista", " Paulista", " Petrolina", " Ribeir\u00E3o das Neves", " Uberaba", " Santar\u00E9m", " Petr\u00F3polis", " Boa Vista", "Guaruj\u00E1", " Cascavel", " Taubat\u00E9", " Limeira", " S\u00E3o Jos\u00E9 dos Pinhais", " Praia Grande", " Suzano", " Mossor\u00F3", " Governador Valadares", " Santa Maria", " Volta Redonda", " Gravata\u00ED", " V\u00E1rzea Grande", " Foz do Igua\u00E7u", " Juazeiro do Norte", " Cama\u00E7ari", " Tabo\u00E3o da Serra", " Imperatriz", " Sumar\u00E9", " Barueri", " Embu das Artes", " Ipatinga", " Marab\u00E1", " Palmas", " Viam\u00E3o", " Novo Hamburgo", " Mag\u00E9", " S\u00E3o Carlos", " Itabora\u00ED", " Mar\u00EDlia", " Sete Lagoas", " Arapiraca", " Maca\u00E9", " Colombo", " Divin\u00F3polis", " S\u00E3o Leopoldo", " S\u00E3o Jos\u00E9", " Americana", " Jacare\u00ED", " Parnamirim", " Maracana\u00FA", " Araraquara", " Presidente Prudente", " Indaiatuba", " Cotia", " Itapevi", " Itabuna", " Santa Luzia", " Rondon\u00F3polis", " Juazeiro", " Dourados", " Rio Grande", " Hortol\u00E2ndia", " Alvorada", " Crici\u00FAma", " Cabo Frio", " Sobral", " Cachoeiro de Itapemirim", " Cabo de Santo Agostinho", " Chapec\u00F3", " Rio Claro", " Itaja\u00ED", " Ilh\u00E9us", " Passo Fundo", " Rio Verde", " Nova Friburgo", " Ara\u00E7atuba", " Santa B\u00E1rbara do Oeste", " Luzi\u00E2nia", " Castanhal", " Barra Mansa", " Angra dos Reis", " Ferraz de Vasconcelos", " Lauro de Freitas", " Mesquita", " Guarapuava", " S\u00E3o Jos\u00E9 de Ribamar", " Teres\u00F3polis", " \u00C1guas Lindas de Goi\u00E1s", "Parauapebas", "Nossa Senhora do Socorro", "Ibirit\u00E9", "Timon", " Nil\u00F3polis", "Caxias", " Francisco Morato", " Itu", "Lages", "Aragua\u00EDna", " Itapecerica da Serra", "Po\u00E7os de Caldas", "Jequi\u00E9", " S\u00E3o Caetano do Sul", " Pindamonhangaba", " Bragan\u00E7a Paulista", "Jaragu\u00E1 do Sul", "Parna\u00EDba", " Itapetininga", "Camaragibe", " Linhares", "Abaetetuba", "Alagoinhas", "Teixeira de Freitas", "Palho\u00E7a", "Paranagu\u00E1", "Barreiras", "Patos de Minas", " Queimados", " Mogi Gua\u00E7u", "Valpara\u00EDso de Goi\u00E1s", "Te\u00F3filo Otoni", " Franco da Rocha", " Maric\u00E1", "Pouso Alegre", " Ja\u00FA", "Sapucaia do Sul", "Porto Seguro", "Garanhuns", " Botucatu", "Vit\u00F3ria de Santo Ant\u00E3o", " Atibaia", "Barbacena", "Sabar\u00E1", "Uruguaiana", "Varginha", "Camet\u00E1", "Crato", "Apucarana", "Arauc\u00E1ria", "Toledo", " Resende", "Santa Rita", "Sim\u00F5es Filho", " Araras", " Cubat\u00E3o", "Santa Cruz do Sul", "Bag\u00E9", "Pinhais", "Itapipoca", "Cachoeirinha", "Cod\u00F3", " Ji-Paran\u00E1", "Conselheiro Lafaiete", "Maranguape", " Araruama", "Bragan\u00E7a", "Rio das Ostras", "Sinop", "Campo Largo", " Ribeir\u00E3o Pires", " Santana de Parna\u00EDba", " Catanduva", "Marituba", " Barretos", "Balne\u00E1rio Cambori\u00FA", " Guaratinguet\u00E1", " Itagua\u00ED", " Colatina", " Sert\u00E3ozinho", " S\u00E3o Mateus", "Itabira", "Araguari", " Birigui", " Jandira", " Votorantim", " Valinhos", "Pa\u00E7o do Lumiar", "Paulo Afonso", "Brusque", "Bento Gon\u00E7alves", "Tatu\u00ED", "V\u00E1rzea Paulista", "Vespasiano", "Trindade", "Guarapari", "Passos ", "Po\u00E1", "Salto", "Arapongas", "A\u00E7ail\u00E2ndia", "Almirante Tamandar\u00E9", "Barcarena", "Tr\u00EAs Lagoas", "Igarassu", "Corumb\u00E1", "S\u00E3o Louren\u00E7o da Mata", "Coronel Fabriciano", "Itatiba", "Ourinhos", "Santana", "Caraguatatuba", "Ub\u00E1", "Parintins", "Formosa", "Eun\u00E1polis", "Altamira", "Umuarama", "Muria\u00E9", "Patos", "Bacabal", "Paragominas", "Tucuru\u00ED", "Bayeux"}));
		cAeroporto.setModel(new DefaultComboBoxModel(new String[] {" Afonso Pena (Curitiba)", " Augusto Severo (Natal)", " Campo dos Palmares (Macei\u00F3)", " Catarata (Foz do Igua\u00E7uPR)", " Confins (Belo Horizonte)", " Congonhas (S\u00E3o Paulo)", " Cumbica (S\u00E3o Paulo)", " Cruzeiro do Sul (Acre)", " Dep. Luis Eduardo Magalh\u00E3es (Salvador)", " Eduardo Gomes (Manaus)", " Gale\u00E3o / Tom Jobim (Rio de Janeiro)", " Guararapes (Recife)", " Herc\u00EDlio Luz (Florian\u00F3polis)", " Juscelino Kubitschek (Bras\u00EDlia)", " Marechal Rondon (Cuiab\u00E1)", " Pampulha (Belo Horizonte)", " Pinto Martins (Fortaleza)", " Presidente Castro Pinto ( Jo\u00E3o Pessoa)", " Presidente M\u00E9dici (Rio Branco)", " Regional do Cariri (Juazeiro do NorteCE)", " Salgado Filho ( Porto Alegre)", " Santa Genoveva (Goi\u00E2nia)", " Santa Maria (Aracaju)", " Santos Dumont (Rio de Janeiro)", " VaideCans (Bel\u00E9m)", " Viracopos (Campinas SP)"}));
		
		cEstado.setBounds(115, 89, 123, 20);
		cCidade.setBounds(115, 117, 123, 20);
		cAeroporto.setBounds(115, 148, 123, 20);
		
		getContentPane().add(cEstado);
		getContentPane().add(cCidade);		
		getContentPane().add(cAeroporto);
		
		painelBorda  = new JPanel();
		painelTabela = new JPanel();
		
		painelBorda.setBorder(new TitledBorder(null, bundle.getString("telaPassagemCompraDestino.botao.proximo"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		painelBorda.setBounds(10, 38, 870, 340);
		painelTabela.setBounds(238, 50, 614, 237);
		
		getContentPane().add(painelBorda);
		painelBorda.add(painelTabela);
		
		painelBorda.setLayout(null);
		painelTabela.setLayout(new BorderLayout(0, 0));
		
		tableDestino = new JTable();
		
		TableModel model = new DefaultTableModel(
				new String[] { 
						bundle.getString("telaPassagemCompraDestino.tabela.dataPartida"), 
						bundle.getString("telaPassagemCompraDestino.tabela.dataRetorno"),
						bundle.getString("telaPassagemCompraDestino.tabela.destino"),
						bundle.getString("telaPassagemCompraDestino.tabela.preco")
						},13);
		
		tableDestino.setModel(model);
		
		// Largura das Colunas		
        tableDestino.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableDestino.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableDestino.getColumnModel().getColumn(2).setPreferredWidth(55);
        tableDestino.getColumnModel().getColumn(3).setPreferredWidth(55);
        
        // Sem o scroll pane o JTable fica zuado        
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tableDestino);
		painelTabela.add(scroll);
		
		txtDataPartida = new JTextField();
		txtDataPartida.setBounds(105, 186, 123, 17);
		painelBorda.add(txtDataPartida);
		txtDataPartida.setColumns(10);
		
		lbDataPartida = new JLabel(bundle.getString("telaPassagemCompraDestino.label.dataPartida"));
		lbDataRetorno = new JLabel(bundle.getString("telaPassagemCompraDestino.label.dataRetorno"));
		
		lbDataPartida.setBounds(13, 189, 92, 14);
		lbDataRetorno.setBounds(13, 214, 92, 14);
		
		painelBorda.add(lbDataPartida);
		painelBorda.add(lbDataRetorno);
		
		txtDataRetorno = new JTextField();
		txtDataRetorno.setBounds(105, 211, 123, 17);
		painelBorda.add(txtDataRetorno);
		txtDataRetorno.setEnabled(false);
		txtDataRetorno.setColumns(10);
		
		bSelecionar = new JButton(bundle.getString("telaPassagemCompraDestino.botao.selecionar"));
		bSelecionar.setBounds(105, 239, 99, 23);
		painelBorda.add(bSelecionar);
		bSelecionar.addActionListener(this);
		
		chIdaVolta = new JCheckBox(bundle.getString("telaPassagemCompraDestino.check.idaVolta"));
		chIdaVolta.setBounds(13, 153, 92, 23);
		painelBorda.add(chIdaVolta);
		chIdaVolta.addActionListener(this);	

	}
		
	public void actionPerformed(ActionEvent e) {
		if(chIdaVolta.isSelected())
			txtDataRetorno.setEnabled(true);
		else
			txtDataRetorno.setEnabled(false);
		
		if(e.getSource() == bSelecionar){
			dispose();
			TelaPassagemCompraPassageiros p = new TelaPassagemCompraPassageiros(bundle,null);
			p.setVisible(true);
		}
			
	}
}
