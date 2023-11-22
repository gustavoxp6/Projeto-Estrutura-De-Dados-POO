package VendasOnline;

public class Roupa extends Produto {
    private String tamanho;

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public void inserirRoupa(){
     setNome("Camisa"); setPreco(319); setQuantidadeEmEstoque(60); setTamanho("M");
    }
    
  
}
