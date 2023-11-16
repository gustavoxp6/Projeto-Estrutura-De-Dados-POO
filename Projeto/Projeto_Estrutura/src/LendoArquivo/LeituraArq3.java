package LendoArquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import LendoArquivo.Regpro;
public class LeituraArq3 {
    public static void main(String[] args) {
        Regpro produto = new Regpro(0, null, 0, 0,0);
        // Especifique o caminho para o arquivo de texto
        String caminhoArquivo = "C:\\Users\\Admin\\Documents\\temp\\produto.txt";
        int codigo=0;
        String nome;
        String valors;
        double valor=0;
        int qtd = 0;
        int categoria =0;
        Double total;
      //  double total=0;
      //  int qtd1 = 0;
        try {
             ArrayList<Regpro> listaDeProdutos = new ArrayList<>();
            // Crie um objeto File para representar o arquivo
            File arquivo = new File(caminhoArquivo);
            // Crie um objeto Scanner para ler o conteúdo do arquivo
            Scanner leitor = new Scanner(arquivo);
            Scanner leia = new Scanner(System.in);
            // Use um loop para ler e imprimir cada linha do arquivo
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                produto.setCodigo(codigo = Integer.parseInt(linha.substring(0,2)));
                produto.setDescricao(nome=linha.substring(3,34));
                valors=linha.substring(36,41);
                valor=Double.parseDouble(valors);
                produto.setPreco(valor = valor /100);
                produto.setQtd(qtd=Integer.parseInt(linha.substring(43,45)));
                categoria=Integer.parseInt(linha.substring(46,47));
                produto.setTotal(total =+ (valor * qtd));
                //System.out.println(codigo + " - "+ nome + " - "+ valor);
                System.out.println("Código: " + produto.getCodigo());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("Preço: " + produto.getPreco());
                System.out.println("Quantidade: " + produto.getQtd());
                System.out.printf("O total foi: %.2f", produto.getTotal());
                System.out.println();
                System.out.println();
                total = 0.0;
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }
}

