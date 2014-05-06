package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class TelaCheckIn extends JDialog implements ActionListener {
	
	private ResourceBundle bundle;
	private JPanel painelCheckIn;
	private JLabel titulo;
	
	public TelaCheckIn(ResourceBundle bundle,JFrame jf){
		super(jf,true);
		this.bundle = bundle;
		
		setBounds(100, 100, 699, 488);
		getContentPane().setLayout(null);
		
		painelCheckIn = new JPanel();
		painelCheckIn.setLayout(null);
		painelCheckIn.setBorder(new TitledBorder(null,bundle.getString("telaCheckIn.borda.titulo"),TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelCheckIn.setBounds(10, 73, 666, 338);
		getContentPane().add(painelCheckIn);
		
		titulo =  new JLabel(bundle.getString("telaCheckIn.titulo"));
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));		
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}