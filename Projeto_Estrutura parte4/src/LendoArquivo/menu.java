package LendoArquivo;

import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("### MENU ###");
            System.out.println("1. Chamar Lista");
            System.out.println("2. Chamar Fila ");
            System.out.println("3. Chamar Pilha ");
            System.out.println("0. Sair do programa");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("\nChamando Lista ...");
                    LeituraArqLista.main(args);
                    
                    break;
                case 2:
                    System.out.println("\nChamando Fila ...");
                    LeituraArqFila.main(args);
                    break;
                case 3:
                    System.out.println("\nChamando Pilha ...");
                    leituraArqPilha.main(args);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}