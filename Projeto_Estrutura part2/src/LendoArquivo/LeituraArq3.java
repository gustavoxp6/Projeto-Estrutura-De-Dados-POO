package LendoArquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class LeituraArq3 {
    public static void main(String[] args) {
        //Criando o Array para armazenar os dados
        Queue fila = new LinkedList();
        // Especifique o caminho para o arquivo produto.txt
        String caminhoArquivo = "C:\\Users\\Admin\\Documents\\temp\\produto.txt";
        int codigo=0;
        String nome="";
        String valors;
        double valor=0;
        int qtd = 0;
        int categoria =0;
        double total=0;
        int cont = -1;
        try {
            //Primeiro declaro o objeto a partir da classe regpro
            Regpro Produto = new Regpro(codigo, nome, valor, qtd,categoria, total);
            // Crie um objeto File para representar o arquivo
            File arquivo = new File(caminhoArquivo);
            // Crie um objeto Scanner para ler o conteúdo do arquivo
            Scanner leitor = new Scanner(arquivo);
            Scanner leia = new Scanner(System.in);
            // Use um loop para ler e imprimir cada linha do arquivo
            while (leitor.hasNextLine()) {
                cont +=1;
                String linha = leitor.nextLine();
                codigo = Integer.parseInt(linha.substring(0,2));
                nome=linha.substring(3,34);
                valors=linha.substring(36,41);
                // transformando o dado contido em valors para Double
                valor=Double.parseDouble(valors);
                valor = valor /100;
                qtd=Integer.parseInt(linha.substring(43,45));
                categoria=Integer.parseInt(linha.substring(46,47));
                total = total+(valor*qtd);
                //inserindo elementos na fila
                fila.add(new Regpro(codigo ,nome, valor, qtd,categoria,total));
                total = 0;
                // condição para chegar até o décimo produto
                if (cont==10) {
                    break;
                }
            }
        System.out.println("-------------------Filas-------------------");
        //criando a fila, Queue é apenas uma interface,
        //então utilizaremos a implentação LinkedList
        //pegando o topo da fila(Primeiro produto)
        System.out.println("\u001B[31m    Topo: \n" + fila.peek()+"\u001B[0m \n");
        //percorrendo a fila, este é outra forma de percorrer uma lista
        //o Object é o tipo do elemento, o obj é o elemento e a fila é nossa lista
        // o obj corresponderia ao get(i) da pilha
        for (Object obj : fila){
            System.out.println(obj);
        }
        //removendo um elemento, e por ser uma fila
        //ele removerá o elemento que foi inserido por primeiro
        fila.remove();
        System.out.println("\u001B[32mDepois de remover um elemento:\u001B[0m ");
        //percorrendo a fila novamente
        for (Object obj : fila) {
            System.out.println(obj);
        }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }

    
}

