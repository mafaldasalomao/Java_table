package tabela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
 
 
public class Principal extends JFrame {
       
        private JTextField tfnome;
        private JTextField tfemail;
        private JTextField tfcelular;
        private JButton incluir;
        private JButton limpar;
       
        private JTable table;
        private JScrollPane jsp;
       
        private JPanel main;
        private JPanel dados;
        private JPanel tableDados;
       
        private ArrayList<Contato> p;
        JMenuBar barra = new JMenuBar();
        JMenu mnSistema=new JMenu("Sistema");
    	JMenuItem miSair=new JMenuItem("Sair");
    	JMenu mnSobre= new JMenu("Sobre");
    	JMenuItem miSobre= new JMenuItem("Mais Informações");
    	JMenu mnTutorial= new JMenu("Tutorial");
    	JMenuItem mnPasso= new JMenuItem("Passo a Passo");
        public Principal(){
                this.setTitle("Principal");
                this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                
                tfnome = new JTextField(15);
                tfemail = new JTextField(15);
                tfcelular = new JTextField(15);
                incluir = new JButton("Incluir");
                incluir.setBackground(new Color(50,153,204));
                limpar = new JButton("Limpar");
                limpar.setBackground(new Color(255,0,0));
                main = new JPanel();
                dados = new JPanel(new GridLayout(4, 2));
                tableDados = new JPanel();
                jsp = new JScrollPane();
                p = new ArrayList<Contato>();
                table= new JTable();
             
        }
       
        void execute(){
                adicionarListeners();
                modelaTela();
        }
       
        private void adicionarListeners() {
                incluir.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if(tfnome!=null && tfnome.getText().equals("")==true){
                                        JOptionPane.showMessageDialog(null, "Digite o nome");
                                }
                                else if(tfcelular!=null && tfcelular.getText().equals("")==true){
                                        JOptionPane.showMessageDialog(null, "Digite o email");
                                }
                                else if(tfemail!=null && tfemail.getText().equals("")==true){
                                        JOptionPane.showMessageDialog(null, "Digite o email");
                                }
                                else{
                                        p.add(new Contato(tfnome.getText(), tfcelular.getText(), tfemail.getText()));
                                        limpar();
                                        listar();
                                }
                        }
 
                       
                });
                limpar.addActionListener(new ActionListener() {
                       
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                                limpar();
                        }
                });
                miSair.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
            			System.exit(0);
                }
                });
                mnPasso.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
            			Tutorial1 t= new Tutorial1();
            			t.setModal(true);
            			t.setVisible(true);
                }
                });
                miSobre.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
            			Sobre s= new Sobre();
            			s.setModal(true);
            			s.setVisible(true);
                }
                });
        }
       
        private void limpar() {
               tfnome.setText("");
               tfcelular.setText("");
               tfemail.setText("");
               
        }
       
        private void listar() {
                table.setModel(new MinhaTableModel(new String[]{"Nome", "Celular", "Email"}, p.size(), 3));
                for(int i=0; i<p.size(); i++){
                        table.setValueAt(p.get(i).getNome(), i, 0);
                        table.setValueAt(p.get(i).getCelular(), i, 1);
                        table.setValueAt(p.get(i).getEmail(), i, 2);
                }
               
                jsp.setViewportView(table);
                jsp.setAutoscrolls(true);
                table.setAutoCreateRowSorter(true);
               
        }
       
        private void modelaTela(){
                dados.add(new JLabel("Nome:"));
                dados.add(tfnome);
                dados.add(new JLabel("Celular:"));
                dados.add(tfemail);
                dados.add(new JLabel("Email:"));
                dados.add(tfcelular);
                dados.add(incluir);
                dados.add(limpar);
                table.setModel(new MinhaTableModel(new String[]{"Nome", "Celular", "Email"}, 0, 3));
                jsp.setViewportView(table);
                tableDados.add(jsp);
                this.add(barra,BorderLayout.PAGE_START);
                BoxLayout box = new BoxLayout(main,BoxLayout.Y_AXIS);
                this.add(main, BorderLayout.PAGE_END);
                barra.add(mnSistema);
                barra.add(mnTutorial);
                mnTutorial.add(mnPasso);
                barra.add(mnSobre);
                mnSobre.add(miSobre);
                mnSistema.add(miSair);
                main.setLayout(box);
        		dados.setBorder(new TitledBorder("Dados Pessoais:"));
                main.add(dados);
                main.add(tableDados,BorderLayout.PAGE_END);
                this.setLocationRelativeTo(null);
                this.setSize(600,600);
                this.setVisible(true);
        }
       

} 
