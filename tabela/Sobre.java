package tabela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sobre extends JDialog implements ActionListener {
	JLabel imagem;
	JButton Voltarmenu= new JButton("Voltar à Página Principal");
	JPanel painel = new JPanel();
		public Sobre() {
			ImageIcon imagemicone = new ImageIcon(getClass().getResource("sobre.jpg"));
			this.setTitle("Sobre ");
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			imagem = new JLabel(imagemicone);
			this.add(imagem, BorderLayout.PAGE_START);
			this.add(painel, BorderLayout.PAGE_END);
			painel.add(Voltarmenu);
			Voltarmenu.addActionListener(this);
			Voltarmenu.setBackground(new Color(255,0,0));
			this.pack();
			this.setLocationRelativeTo(null);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==Voltarmenu) {
				this.dispose();
			}

	}
}
