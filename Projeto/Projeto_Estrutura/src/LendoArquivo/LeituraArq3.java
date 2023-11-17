package LendoArquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import LendoArquivo.Regpro;
public class LeituraArq3 {
    public static void main(String[] args) {
        //Criando o Arrey para armazenar os dados
        ArrayList<Regpro> listaDeProdutos = new ArrayList<>();
        
        // Especifique o caminho para o arquivo de texto
        String caminhoArquivo = "C:\\Users\\Admin\\Documents\\temp\\produto.txt";
        int codigo=0;
        String nome="";
        String valors;
        double valor=0;
        int qtd = 0;
        int categoria =0;
        double total=0;
        
        try {
            //Primeiro declaro o objeto a partir da classe regpro
            Regpro Produto = new Regpro(codigo, nome, valor, qtd, total);
            // Crie um objeto File para representar o arquivo
            File arquivo = new File(caminhoArquivo);
            // Crie um objeto Scanner para ler o conteúdo do arquivo
            Scanner leitor = new Scanner(arquivo);
            Scanner leia = new Scanner(System.in);
            // Use um loop para ler e imprimir cada linha do arquivo
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                Produto.setCodigo(codigo = Integer.parseInt(linha.substring(0,2)));
                Produto.setDescricao(nome=linha.substring(3,34));
                valors=linha.substring(36,41);
                // transformando o dado contido em valors para Double
                valor=Double.parseDouble(valors);
                Produto.setPreco(valor = valor /100);
                Produto.setQtd(qtd=Integer.parseInt(linha.substring(43,45)));
                categoria=Integer.parseInt(linha.substring(46,47));
                Produto.setTotal(total = total+(valor*qtd));
                //abaixo adiciono os dados no Arrey 
                listaDeProdutos.add(new Regpro(Produto.getCodigo(), Produto.getDescricao(),Produto.getPreco(), Produto.getQtd(),Produto.getTotal()));
                total = 0;
                //System.out.println(codigo + " - "+ nome + " - "+ valor);
            }
             // Acesse os objetos na lista
            for(Regpro prod:listaDeProdutos){
            System.out.println("Código: " + prod.getCodigo());
            System.out.println("Descrição: " + prod.getDescricao());
            System.out.println("Preço: " + prod.getPreco());
            System.out.println("Quantidade: " + prod.getQtd());
            System.out.printf("O total foi: %.2f", prod.getTotal());
            System.out.println();
            System.out.println();
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }
}

