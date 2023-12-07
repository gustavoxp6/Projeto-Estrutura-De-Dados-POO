package LendoArquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;

public class leituraArqPilha {
    
    public static void main(String[] args) {
        //Criando o Array para armazenar os dados
        Stack pilha = new Stack();
        // Especifique o caminho para o arquivo produto.txt
        String caminhoArquivo = "C:\\Users\\01607962\\Documents\\temp\\Pedido.txt";
        String codigo="";
        String data="";
        String cidade="";        
        try {
            //Primeiro declaro o objeto a partir da classe regpro
            Regpro Produto = new Regpro(codigo, data, cidade);
            // Crie um objeto File para representar o arquivo
            File arquivo = new File(caminhoArquivo);
            // Crie um objeto Scanner para ler o conteúdo do arquivo
            Scanner leitor = new Scanner(arquivo);
            Scanner leia = new Scanner(System.in);
            // Use um loop para ler e imprimir cada linha do arquivo
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                codigo = linha.substring(0,5);
                data=linha.substring(14,24);
                cidade=linha.substring(56,69);
                //abaixo adiciono os dados no Array 
                pilha.add(new Regpro(codigo,data,cidade));
                // condição para chegar até o décimo produto
            }
            System.out.println("\u001B[32m-------------------Pilhas-------------------\u001B[0m");
            //Topo da pilha(Ultimo produto)
            System.out.println("\u001B[31m    Topo:\n"+ pilha.peek()+"\u001B[0m\n");
            for (int i = 0; i < pilha.size(); i++){
                System.out.println(pilha.get(i));
            }
            //removendo um elemento, e por ser uma pilha
            //ele removerá o elemento que foi inserido por ultimo
            int cont=0;
            while (cont<5) {
                pilha.pop();
                cont+=1;              
            }
            System.out.println("\u001B[32mDepois de remover 5 elementos:\u001B[0m");
            //percorrendo a pilha novamente
            for (int i = 0; i < pilha.size(); i++){
                System.out.println(pilha.get(i));
            }
            System.out.println("\u001B[31m    Topo:\n"+ pilha.peek()+"\u001B[0m\n");
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }

}
