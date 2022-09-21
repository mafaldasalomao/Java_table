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

public class Tutorial4 extends JDialog implements ActionListener {
	JLabel imagem;
	JButton voltar= new JButton("Voltar");
	JButton sair= new JButton("Sair");
	JButton Voltarmenu= new JButton("Voltar à Página Principal");
	JPanel painel = new JPanel();
		public Tutorial4() {
			ImageIcon imagemicone = new ImageIcon(getClass().getResource("passo4.jpg"));
			this.setTitle("Passo 1 ");
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			imagem = new JLabel(imagemicone);
			this.add(imagem, BorderLayout.PAGE_START);
			this.add(painel, BorderLayout.PAGE_END);
			painel.add(Voltarmenu);
			Voltarmenu.addActionListener(this);
			Voltarmenu.setBackground(new Color(255,0,0));
			painel.add(voltar);
			voltar.addActionListener(this);
			voltar.setBackground(new Color(255,0,0));
			sair.setBackground(new Color(50,153,204));
			painel.add(sair);
			sair.addActionListener(this);
			this.pack();
			this.setLocationRelativeTo(null);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==Voltarmenu) {
				this.dispose();
			}
			if(e.getSource()==voltar) {
				this.dispose();
				Tutorial3 tt= new Tutorial3();
				tt.setModal(true);
				tt.setVisible(true);
			}
			if(e.getSource()==sair) {
				this.dispose();
			}
		}
}