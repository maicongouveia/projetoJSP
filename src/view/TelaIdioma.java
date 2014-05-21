package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

public class TelaIdioma extends JFrame implements ActionListener{


   private JPanel container;
   private JPanel painelMeio;
   private JButton btEntrar;
   private JLabel lbIdioma;
   private JComboBox<String> comboBox;
   private TelaLogin login;

   public TelaIdioma() {
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 583, 405);
   
   	// Painel Fundo
      container = new JPanel();
      container.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(container);
      container.setLayout(null);
   
   	// Painel meio com Borda
      painelMeio = new JPanel();
      painelMeio.setBorder(
         	new TitledBorder(null, "Idioma",TitledBorder.LEADING, 
         			TitledBorder.TOP, null, Color.RED)
         	);
   	
      painelMeio.setBounds(131, 97, 305, 171);
      painelMeio.setLayout(null);
   
      lbIdioma = new JLabel("Idioma | language");
      lbIdioma.setBounds(88, 34, 128, 14);
   
      btEntrar = new JButton("Entrar");
   
      btEntrar.setBounds(108, 95, 89, 23);
   
   	// Configuração do combobox
      comboBox = new JComboBox<String>();
      comboBox.setBounds(88, 59, 128, 25);
      comboBox.setModel(new DefaultComboBoxModel<String>(
         	new String[] {
         				"--------------", 
         				"Portugues", 
         				"Inglês", 
         				"Espanhol" 
            }));
      comboBox.setSelectedIndex(1);
   
   	// Adiciona Componentes ao painel
      container.add(painelMeio);
      painelMeio.add(lbIdioma);
      painelMeio.add(btEntrar);
      painelMeio.add(comboBox);
   
   	// Faz a Pagina abrir no meio da tela.
      this.setLocationRelativeTo(null);
   	
   	// ActionListener do botao para abrir tela de login
      btEntrar.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == btEntrar){
         if (comboBox.getSelectedIndex() == 0)
            JOptionPane.showMessageDialog(null, "Português - Escolha um idioma "
            									+ "\n-------------------------\n"
            									+ "English - Choose a language "
            									+ "\n-------------------------\n"
            									+ "Español - Elija un idioma");           
         
         if (comboBox.getSelectedIndex() == 1){
            login = new TelaLogin(ResourceBundle.getBundle("idiomas/lingua", new Locale("pt", "BR")));
            login.setVisible(true);
            dispose();
         }
      	
         if (comboBox.getSelectedIndex() == 2){
            login = new TelaLogin(ResourceBundle.getBundle("idiomas/lingua", Locale.US));
            login.setVisible(true);
            dispose();
         }
      
         if (comboBox.getSelectedIndex() == 3){
            login = new TelaLogin(ResourceBundle.getBundle("idiomas/lingua", new Locale("es", "ES")));
            login.setVisible(true);
            dispose();
         }
      	
      	
      	
      }
   }
	
}
