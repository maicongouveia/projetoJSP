package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

public class TelaPrincipal extends JFrame implements ActionListener{
	
	private String nome;
	private String permissao;

	private JPanel contentPane;
	private ResourceBundle bundle = null;
	
	private JLabel lbFoto;
	private JLabel lbTipoUsuario;
	private JLabel lblNome;
	
	private JMenuBar menuBar;

	private JMenu  mVoo;
	private JMenu  mAeronave;
	private JMenu  mPassagem;
	private JMenu  mCheckin;
	private JMenu  mLogoff;
	private JMenu  mSair;
	
	private JMenuItem mICadastrar;
	private JMenuItem mIConsultar;
	private JMenuItem mIAlterar;
	private JMenuItem mIDeletar;
	private JMenuItem mICadastrarAero;
	private JMenuItem mIConsultarAero;
	private JMenuItem mIAlterarAero;
	private JMenuItem mIDeletarAero;
	private JMenuItem mICompra;
	private JMenuItem mICancelar;
	private JMenuItem mITransferir;
	private JMenuItem mIRealizarCheckin;
	private JMenuItem mITrocarUsuario;
	private JMenuItem mISair;
	private JLabel lTipoR;
	private JLabel lNomeR;
	
	
	
	public TelaPrincipal(final ResourceBundle bundle,String nome,String permissao) {
		this.bundle = bundle;
		this.nome   = nome;
		permissao(permissao);
		componentes();
		funcoesAtendente();
		this.setLocationRelativeTo(null);
	}
	
	public void permissao(String per){
		if(per.equals("1"))
			this.permissao = "Atendente";
		else
			this.permissao = "Supervisor";
	}
	
	public void funcoesAtendente(){
		if(permissao.equals("Atendente")){
			mICadastrar.setEnabled(false);
			mIAlterar.setEnabled(false);
			mIDeletar.setEnabled(false);
			
			mICadastrarAero.setEnabled(false);
			mIConsultarAero.setEnabled(false);
			mIAlterarAero.setEnabled(false);
			mIDeletarAero.setEnabled(false);
		}
	}

	public void componentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		contentPane = new JPanel();
		JPanel panel = new JPanel();

		contentPane.setLayout(new BorderLayout());
		panel.setLayout(null);

		setContentPane(contentPane);
		contentPane.add(panel);
		
		// Barra de menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Menus
		mVoo           = new JMenu(bundle.getString("telaPrincipal.menu.voo"));
		mAeronave      = new JMenu(bundle.getString("telaPrincipal.menu.aeronave"));
		mPassagem      = new JMenu(bundle.getString("telaPrincipal.menu.passagem"));
		mCheckin       = new JMenu(bundle.getString("telaPrincipal.menu.checkin"));
		mLogoff        = new JMenu(bundle.getString("telaPrincipal.menu.logoff"));
		mSair          = new JMenu(bundle.getString("telaPrincipal.menu.sair"));
		
		menuBar.add(mVoo);
		menuBar.add(mAeronave);
		menuBar.add(mPassagem);
		menuBar.add(mCheckin);
		menuBar.add(mLogoff);
		menuBar.add(mSair);
		
		// Items menus
		mICadastrar       = new JMenuItem(bundle.getString("telaPrincipal.menuItem.cadastrar"));
		mIConsultar       = new JMenuItem(bundle.getString("telaPrincipal.menuItem.consultar"));
		mIAlterar         = new JMenuItem(bundle.getString("telaPrincipal.menuItem.alterar"));
		mIDeletar         = new JMenuItem(bundle.getString("telaPrincipal.menuItem.deletar"));
		mICadastrarAero   = new JMenuItem(bundle.getString("telaPrincipal.menuItem.cadastrar"));
		mIConsultarAero   = new JMenuItem(bundle.getString("telaPrincipal.menuItem.consultar"));
		mIAlterarAero     = new JMenuItem(bundle.getString("telaPrincipal.menuItem.alterar"));
		mIDeletarAero     = new JMenuItem(bundle.getString("telaPrincipal.menuItem.deletar"));
		mICompra          = new JMenuItem(bundle.getString("telaPrincipal.menuItem.compra"));
		mICancelar        = new JMenuItem(bundle.getString("telaPrincipal.menuItem.cancelar"));
		mITransferir      = new JMenuItem(bundle.getString("telaPrincipal.menuItem.transferir"));
		mIRealizarCheckin = new JMenuItem(bundle.getString("telaPrincipal.menuItem.checkin"));
		mITrocarUsuario   = new JMenuItem(bundle.getString("telaPrincipal.menuItem.logoff"));
		mISair            = new JMenuItem(bundle.getString("telaPrincipal.menuItem.sair"));

		mVoo.add(mICadastrar);
		mVoo.add(mIConsultar);
		mVoo.add(mIAlterar);
		mVoo.add(mIDeletar);
		mAeronave.add(mICadastrarAero);
		mAeronave.add(mIConsultarAero);
		mAeronave.add(mIAlterarAero);
		mAeronave.add(mIDeletarAero);
		mPassagem.add(mICompra);
		mPassagem.add(mICancelar);
		mPassagem.add(mITransferir);
		mCheckin.add(mIRealizarCheckin);
		mLogoff.add(mITrocarUsuario);
		mSair.add(mISair);
		
		lbFoto         = new JLabel("");
		lbTipoUsuario  = new JLabel(bundle.getString("telaPrincipal.label.tipo")+":");
		lblNome        = new JLabel(bundle.getString("telaPrincipal.label.nome")+":");
		lTipoR         = new JLabel(permissao);
		lNomeR         = new JLabel(nome);

		lbTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lTipoR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lNomeR.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lbFoto.setBounds(10, 10, 223, 256);
		lbTipoUsuario.setBounds(243, 52, 120, 14);
		lTipoR.setBounds(360, 52, 233, 14);
		lblNome.setBounds(243, 77, 120, 14);
		lNomeR.setBounds(300, 77, 233, 14);

		String arquivoImg = "/imagens/"+nome+".png";
		
		ImageIcon imagem = new ImageIcon(TelaPrincipal.class.getResource(arquivoImg));            
		Image img = imagem.getImage().getScaledInstance(223,256,Image.SCALE_DEFAULT);

		lbFoto.setIcon(new ImageIcon(img));
		
		panel.add(lbFoto);
		panel.add(lbTipoUsuario);
		panel.add(lTipoR);
		panel.add(lblNome);
		panel.add(lNomeR);
		
		mICadastrar.addActionListener(this);    
		mIConsultar.addActionListener(this);    
		mIAlterar.addActionListener(this);      
		mIDeletar.addActionListener(this);      
		mICadastrarAero.addActionListener(this);
		mIConsultarAero.addActionListener(this);
		mIAlterarAero.addActionListener(this);  
		mIDeletarAero.addActionListener(this);  
		mISair.addActionListener(this);
		mICompra.addActionListener(this);
		mICancelar.addActionListener(this);
		mITransferir.addActionListener(this);
		mITrocarUsuario.addActionListener(this);
		mIRealizarCheckin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == mISair)
			System.exit(0);

		if (e.getSource() == mICompra) {
			TelaPassagemCompraIda tCompra = new TelaPassagemCompraIda(bundle,this);
			tCompra.setVisible(true);
		}
		
		if (e.getSource() == mICancelar) {
			TelaPassagemCancelarNumero tCancela = new TelaPassagemCancelarNumero(bundle,this);
			tCancela.setVisible(true);
		}
		
		if (e.getSource() == mITrocarUsuario) {
			TelaLogin login = new TelaLogin(bundle);
			login.setVisible(true);
			dispose();
		}
		
		if(e.getSource()==   mICadastrar){
			TelaVooCadastra tVooCadastra = new TelaVooCadastra(bundle,null);
			tVooCadastra.setVisible(true);
		}
                 
		if(e.getSource()== mIConsultar){
			TelaVooConsulta tVooConsulta = new TelaVooConsulta(bundle,null, "consulta");
			tVooConsulta.setVisible(true);
		}
                 
		if(e.getSource()== mIAlterar){
			TelaVooConsulta tVooConsulta = new TelaVooConsulta(bundle,null, "alterar");
			tVooConsulta.setVisible(true);
		}
               
		if(e.getSource()== mIDeletar){
			TelaVooConsulta tVooConsulta = new TelaVooConsulta(bundle,null, "deletar");
			tVooConsulta.setVisible(true);
		}
      
        if(e.getSource() == mICadastrarAero){
        	TelaAeronaveCadastra tAeronaveCadastra = new TelaAeronaveCadastra(bundle,null);
        	tAeronaveCadastra.setVisible(true);
        }
       
        if(e.getSource() ==  mIConsultarAero){
        	TelaAeronaveConsulta tAeronaveConsulta = new TelaAeronaveConsulta(bundle,null, "consulta");
        	tAeronaveConsulta.setVisible(true);
        }
      
        if(e.getSource() == mIAlterarAero){
    	  TelaAeronaveConsulta tAeronaveConsulta = new TelaAeronaveConsulta(bundle,null,"alterar");
    	  tAeronaveConsulta.setVisible(true);
        }

      
        if(e.getSource() == mIDeletarAero){
        	TelaAeronaveConsulta tAeronaveConsulta = new TelaAeronaveConsulta(bundle,null,"deletar");
        	tAeronaveConsulta.setVisible(true);
        }
        if(e.getSource()== mIRealizarCheckin){
			TelaCheckIn tCheckIn = new TelaCheckIn(bundle,null);
			tCheckIn.setVisible(true);
		}

	}
}
