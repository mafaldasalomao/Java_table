package tabela;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	JLabel lbNome=new JLabel("Nome:");
	JLabel lbLogin=new JLabel("Senha:");
	JTextField tfNome=new JTextField(10);
	JPasswordField tfSenha=new JPasswordField(10);
	JButton btEntrar=new JButton("Entrar");
	
	JButton btSair=new JButton("Sair");
	public Login(){
		this.setTitle("Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 2));
		this.add(lbNome);
		this.add(tfNome);
		this.add(lbLogin);
		this.add(tfSenha);
		this.add(btEntrar);
		btEntrar.setBackground(new Color(50,153,204));
		btEntrar.addActionListener(this);
		getRootPane().setDefaultButton(btEntrar);
		this.add(btSair);
		btSair.setBackground(new Color(255,0,0));
		btSair.addActionListener(this);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Login login=new Login();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btEntrar) {
			if(tfSenha.getText().equals("") && tfNome.getText().equals("")) {
                Principal p = new Principal();
                p.execute();
				this.dispose();
			}
		}
		if(arg0.getSource()==btSair) {
			System.exit(0);
		}
	}

}
