package TELA_PRODUTOS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import LendoArquivo.LeituraArq3;
import LendoArquivo.Regpro;

import java.io.File;
import java.io.FileNotFoundException;
public class ConsultaProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProduto frame = new ConsultaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 690);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		LeituraArq3 ler = new LeituraArq3();
		JLabel lblNewLabel = new JLabel("Consulta de produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(274, 11, 226, 25);
		contentPane.add(lblNewLabel);
		
	
		
		
		JLabel lblNewLabel_3 = new JLabel("Preço(Maior que:)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(200, 78, 130, 19);
		contentPane.add(lblNewLabel_3);
		
		JTextField tf_preco = new JTextField();
		tf_preco.setBounds(330, 76, 133, 22);
		contentPane.add(tf_preco);
		tf_preco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Categoria");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(40, 78, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextField tf_categoria = new JTextField();
		tf_categoria.setBounds(120, 77, 67, 20);
		contentPane.add(tf_categoria);
		tf_categoria.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        JTable table_consultaproduto = new JTable();
		table_consultaproduto.setBackground(new Color(255,255,255)); // define a cor de fundo do JTable
		table_consultaproduto.setBounds(25, 150, 670, 490);
		DefaultTableModel model = (DefaultTableModel) table_consultaproduto.getModel(); //
		model.addColumn("Codigo"); // adiciona a coluna 0
		model.addColumn("Descrição"); // adiciona a coluna 1
		model.addColumn("Preço"); // adiciona a coluna 2
		model.addColumn("Quantidade"); // adiciona a coluna 3
		model.addColumn("Categoria"); // adiciona a coluna 4
		model.addColumn("Total"); // adiciona a coluna 5
		table_consultaproduto.getColumnModel().getColumn(0).setPreferredWidth(75); // define a largura da coluna 0
		table_consultaproduto.getColumnModel().getColumn(1).setPreferredWidth(190); // define a largura da coluna 1
		table_consultaproduto.getColumnModel().getColumn(2).setPreferredWidth(80); // define a largura da coluna 2
		table_consultaproduto.getColumnModel().getColumn(3).setPreferredWidth(100); // define a largura da coluna 3
		table_consultaproduto.getColumnModel().getColumn(4).setPreferredWidth(80); // define a largura da coluna 4
		table_consultaproduto.getColumnModel().getColumn(5).setPreferredWidth(100); // define a largura da coluna 5
		
		
		JScrollPane scrollPaneCliente = new JScrollPane(table_consultaproduto);
		scrollPaneCliente.setLocation(25, 150);
		scrollPaneCliente.setSize(670, 490);
		scrollPaneCliente.setPreferredSize(new Dimension(670, 490)); // define a largura e altura do ScrollPane
		javax.swing.JViewport viewport = scrollPaneCliente.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); // define a cor de fundo do ScrollPane
		contentPane.add(scrollPaneCliente);
        ArrayList<Regpro> listaDeProdutos = new ArrayList<>();
        String caminhoArquivo = "C:\\Users\\01607962\\Downloads\\Projeto-Estrutura-De-Dados-main\\produto.txt";
        int codigo =0;
        String nome="";
        String valors;
        double valor=0;
        int qtd = 0;
        int categoria =0;
        double total=0;
		int cont=-1;
        
		try {
            //Primeiro declaro o objeto a partir da classe regpro
            Regpro Produto = new Regpro(codigo, nome, valor, qtd, total, categoria);
            // Crie um objeto File para representar o arquivo
              File arquivo = new File(caminhoArquivo);
              // Crie um objeto Scanner para ler o conteúdo do arquivo
              Scanner leitor = new Scanner(arquivo);
              Scanner leia = new Scanner(System.in);
              // Use um loop para ler e imprimir cada linha do arquivo
              while (leitor.hasNextLine()) {
                  String linha = leitor.nextLine();
                  Produto.setCodigo(codigo = Integer.parseInt(linha.substring(0,2)));
                  Produto.setDescricao(nome =linha.substring(3,34));
                  valors=linha.substring(36,41);
                  // transformando o dado contido em valors para Double
                  valor=Double.parseDouble(valors);
                  Produto.setPreco(valor = valor /100);
                  Produto.setQtd(qtd=Integer.parseInt(linha.substring(43,45)));
                  Produto.setCategoria(categoria=Integer.parseInt(linha.substring(46,47)));
                  total = total+(valor*qtd);
				  DecimalFormat df = new DecimalFormat("00000");
        		  String totalFormatado = df.format(total);
				  Produto.setTotal(Double.parseDouble(totalFormatado));
                  //abaixo Grava os dados no Array 
                  listaDeProdutos.add(new Regpro(Produto.getCodigo(), Produto.getDescricao(),Produto.getPreco(), Produto.getQtd(),Produto.getTotal(), Produto.getCategoria()));
                  total = 0;
				  cont+=1;
                  //System.out.println(codigo + " - "+ nome + " - "+ valor);       
                }
				
				
				String val= tf_preco.getText();
				String cat =tf_categoria.getText();
            
                if (cat.equals("") &&  val.equals("") ) {
					for(Regpro prod:listaDeProdutos){
						model.addRow(new Object[]{prod.getCodigo(), prod.getDescricao(), prod.getPreco(), prod.getQtd(), prod.getCategoria(),prod.getTotal()});
					} 
							
        	}
			else if (!cat.equals("") &&  val.equals("") ) {
				for(Regpro prod:listaDeProdutos){
					if(prod.getCategoria()==Integer.parseInt(cat)){
					model.addRow(new Object[]{prod.getCodigo(), prod.getDescricao(), prod.getPreco(), prod.getQtd(), prod.getCategoria(),prod.getTotal()});
					}
				}
				
			}else if(cat.equals("") &&  !val.equals("") ){
				for(Regpro prod:listaDeProdutos){
					if(prod.getPreco()>=Double.parseDouble(val)){
					model.addRow(new Object[]{prod.getCodigo(), prod.getDescricao(), prod.getPreco(), prod.getQtd(), prod.getCategoria(),prod.getTotal()});
					}
				}
			}
			else if(!cat.equals("") &&  !val.equals("") ){
				for(Regpro prod:listaDeProdutos){
					if(prod.getCategoria()==Integer.parseInt(cat) && prod.getPreco()>=Double.parseDouble(val)){
					model.addRow(new Object[]{prod.getCodigo(), prod.getDescricao(), prod.getPreco(), prod.getQtd(), prod.getCategoria(),prod.getTotal()});
				}
			}
		}
		tf_categoria.setText("");
		tf_preco.setText(""); 
			
            leitor.close();
			}catch (FileNotFoundException re) {
                System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(486, 97, 133, 23);
		contentPane.add(btnNewButton);
		
		
	}
}