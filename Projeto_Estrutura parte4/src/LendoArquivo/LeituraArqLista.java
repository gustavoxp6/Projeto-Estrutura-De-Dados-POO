package LendoArquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import LendoArquivo.Regpro;

public class LeituraArqLista {
    public static void main(String[] args) {
        // Criando o Array para armazenar os dados
        ArrayList<Regpro> listaDeProdutos = new ArrayList<>();

        // Especifique o caminho para o arquivo de texto
        String caminhoArquivo = "C:\\Users\\Admin\\Downloads\\Projeto-Estrutura-De-Dados-POO-main\\Pedido.txt";
        int codigo = 0;
        String data = "";
        String cidade = "";
        int cont = 0;

        try {
            // Primeiro declaro o objeto a partir da classe regpro
            Regpro Produto = new Regpro(codigo, data, cidade);
            // Crie um objeto File para representar o arquivo
            File arquivo = new File(caminhoArquivo);
            // Crie um objeto Scanner para ler o conteúdo do arquivo
            Scanner leitor = new Scanner(arquivo);
            // Use um loop para ler e imprimir cada linha do arquivo
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                codigo = Integer.parseInt(linha.substring(0, Math.min(5, linha.length())));
                data = linha.length() >= 24 ? linha.substring(14, 24) : "";
                cidade = linha.length() >= 69 ? linha.substring(56, 69) : "";
                // abaixo adiciono os dados no Array
                listaDeProdutos.add(new Regpro(codigo, data, cidade));
                // cont+=1;
                // System.out.println(codigo + " - "+ nome + " - "+ valor);
            }
            // Acesse os objetos na lista
            for (Regpro prod : listaDeProdutos) {
                System.out.println("Código: " + prod.getCodigo());
                System.out.println("Data: " + prod.getData());
                System.out.println("Cidade: " + prod.getCidade());
                System.out.println();
                System.out.println();
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }
}
