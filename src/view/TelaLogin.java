package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

		
import Controller.Validacao;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

public class TelaLogin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField pSenha;
	private JTextField tUsuario;
	private JButton btnEntrar;
	private ResourceBundle bundle;
	
	public TelaLogin(final ResourceBundle bundle) {
		this.bundle = bundle;
		
		setTitle(bundle.getString("telaLogin.titulo"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 892, 554);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(236, 152, 419, 239);
		panel_1.setBorder(new TitledBorder(null, bundle.getString("telaLogin.borda"), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(75, 66, 269, 107);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUsuario = new JLabel(bundle.getString("telaLogin.label.usuario"));
		lblUsuario.setBounds(0, 3, 96, 14);
		panel_2.add(lblUsuario);
		
		JLabel lblSenha = new JLabel(bundle.getString("telaLogin.label.senha"));
		lblSenha.setBounds(0, 39, 96, 14);
		panel_2.add(lblSenha);
		
		pSenha = new JPasswordField();
		pSenha.setBounds(98, 34, 147, 22);
		panel_2.add(pSenha);
		
		tUsuario = new JTextField();
		tUsuario.setBounds(98, 3, 147, 20);
		panel_2.add(tUsuario);
		tUsuario.setColumns(10);
		
		btnEntrar = new JButton(bundle.getString("telaLogin.botao"));
		btnEntrar.setBounds(98, 67, 89, 23);
		panel_2.add(btnEntrar);
		btnEntrar.addActionListener(this);
		
		JLabel lblSistemaDeCompra = new JLabel(bundle.getString("telaLogin.label.sistema"),JLabel.CENTER);
		lblSistemaDeCompra.setBounds(236, 49, 419, 29);
		lblSistemaDeCompra.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblSistemaDeCompra);
		this.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		String user = tUsuario.getText();
		String pass = new String(pSenha.getPassword()).trim();				
			
		Validacao v = new Validacao(user, pass);
		try {
			v.buscaUsuario(v.lerRegistro());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if(!v.resposta()){					
			JOptionPane.showMessageDialog(null, "Usuario e/ou Senha errado");					
		}
		else{
			dispose();
			TelaPrincipal p = new TelaPrincipal(bundle, v.getNome(), v.nivelPermissao());
			p.setVisible(true);
		}
		
	}
}
	

