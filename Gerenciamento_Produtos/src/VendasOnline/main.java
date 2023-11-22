package VendasOnline;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    boolean nparar = true;
    Eletronico eletr = new Eletronico();
    Roupa rop = new Roupa();
    while (nparar) {
        System.out.println("****VENDAS ONLINE*****");
    System.out.println("Qual produto você deseja?\nRoupa [1]\nEletrônico [2] \nSair[3]\n*********************");
     int opcao = ler.nextInt();
    switch (opcao) {
        case 2:
        eletr.inserirEletronico();
        System.out.print("Nome: "+eletr.getNome()+"\nPreço: "+ eletr.getPreco()+"\nQuantidade no estoque: " +eletr.getQuantidadeEmEstoque()+"\nVoltagem: "+eletr.getVoltagem()+"\nCusto de envio: "+ eletr.calcularCustoEnvio());
        System.out.println("\nVALOR TOTAL: $"+(eletr.calcularCustoEnvio()+eletr.getPreco()));
       
        break;
        case 1:
        rop.inserirRoupa();
        System.out.print("Nome: "+rop.getNome()+"\nPreço: "+ rop.getPreco()+"\nQuantidade no estoque: " +rop.getQuantidadeEmEstoque()+"\nTamanho: "+rop.getTamanho()+"\nCusto de envio: "+ rop.calcularCustoEnvio());
        System.out.println("\nVALOR TOTAL: $"+(rop.calcularCustoEnvio()+rop.getPreco())); 
        break;
        case 3:
        nparar = false;
    }
    }
}
    
}
