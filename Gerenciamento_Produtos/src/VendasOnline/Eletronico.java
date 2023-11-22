package VendasOnline;

public class Eletronico extends Produto {
    private String voltagem;

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }
    public void inserirEletronico(){
        setNome("TCL"); setPreco(2000.00); setQuantidadeEmEstoque(10); setVoltagem("220v");
    }
    
   
}
