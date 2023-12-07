package LendoArquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeituraArqFila {
    public static void main(String[] args) {
        // Criando o Array para armazenar os dados
        Queue fila = new LinkedList();
        // Especifique o caminho para o arquivo produto.txt
        String caminhoArquivo = "C:\\Users\\Admin\\Downloads\\Projeto-Estrutura-De-Dados-POO-main\\Pedido.txt";
        int codigo = 0;
        String data = "";
        String cidade = "";
        int cont = -1;
        try {
            // Primeiro declaro o objeto a partir da classe regpro
            Regpro Produto = new Regpro(codigo, data, cidade);
            // Crie um objeto File para representar o arquivo
            File arquivo = new File(caminhoArquivo);
            // Crie um objeto Scanner para ler o conteúdo do arquivo
            Scanner leitor = new Scanner(arquivo);
            Scanner leia = new Scanner(System.in);
            // Use um loop para ler e imprimir cada linha do arquivo
            while (leitor.hasNextLine() && cont <50) {
                cont+=1;
                String linha = leitor.nextLine();
                codigo = Integer.parseInt(linha.substring(0, Math.min(5, linha.length())));
                data = linha.length() >= 24 ? linha.substring(14, 24) : "";
                cidade = linha.length() >= 69 ? linha.substring(56, 69) : "";
                cont += 1;
                fila.add(new Regpro(codigo, data, cidade));
            }

            System.out.println("\u001B[32m -------------------Filas-------------------\u001B[0m");
            // criando a fila, Queue é apenas uma interface,
            // então utilizaremos a implentação LinkedList
            // pegando o topo da fila(Primeiro produto)
            System.out.println("\u001B[31m    Topo: \n" + fila.peek() + "\u001B[0m\n");
            // percorrendo a fila, este é outra forma de percorrer uma lista
            // o Object é o tipo do elemento, o obj é o elemento e a fila é nossa lista
            // o obj corresponderia ao get(i) da pilha
            for (Object obj : fila) {
                System.out.println(obj);
            }
            // removendo um elemento, e por ser uma fila
            // ele removerá o elemento que foi inserido por primeiro
            fila.remove();
            System.out.println("\u001B[32mDepois de remover 1 elementos:\u001B[0m ");
            // percorrendo a fila novamente

            for (Object obj : fila) {
                System.out.println(obj);
            }
            System.out.println("\u001B[31m    Topo: \n" + fila.peek() + "\u001B[0m\n");
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }

}
