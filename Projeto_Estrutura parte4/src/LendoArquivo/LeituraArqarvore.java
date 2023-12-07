package LendoArquivo;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraArqarvore {
    public static void main(String[] args) {
        // Criando uma árvore ordenada (TreeSet) de objetos do tipo Regpro
        TreeSet<Regpro> arvoreRegpro = new TreeSet<>((o1, o2) -> {
            // Personalizando a comparação para ordenar por código
            if (o1.getCodigo() < o2.getCodigo()) {
                return -1;
            } else if (o1.getCodigo() > o2.getCodigo()) {
                return 1;
            } else {
                return 0;
            }
        });
        String caminhoArquivo = "C:\\Users\\Admin\\Downloads\\Projeto-Estrutura-De-Dados-POO-main\\Pedido.txt";
        int codigo = 0;
        String data = "";
        String cidade = "";
        int cont = -1;
        try {
            // Crie um objeto File para representar o arquivo
            File arquivo = new File(caminhoArquivo);
            // Crie um objeto Scanner para ler o conteúdo do arquivo
            Scanner leitor = new Scanner(arquivo);
            // Use um loop para ler e imprimir cada linha do arquivo
            while (leitor.hasNextLine() && cont < 50) {
                cont += 1;
                String linha = leitor.nextLine();
                codigo = Integer.parseInt(linha.substring(0, Math.min(5, linha.length())));
                data = linha.length() >= 24 ? linha.substring(14, 24) : "";
                cidade = linha.length() >= 69 ? linha.substring(56, 69) : "";
                cont += 1;
                // Adicionando objetos à árvore
                arvoreRegpro.add(new Regpro(codigo, data, cidade));
            }
           

            // Exibindo detalhes dos produtos na árvore (ordenados por código)
            System.out.println("Detalhes dos produtos na árvore (ordenados por código):");
            for (Regpro produto : arvoreRegpro) {
                System.out.println("Código: " + produto.getCodigo() +
                        ", Data: " + produto.getData() +
                        ", Cidade: " + produto.getCidade());
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }
}
