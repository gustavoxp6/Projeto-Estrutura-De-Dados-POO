package LendoArquivo;

public class Regpro {
    private int codigo;
    private String data;
    private String cidade;
    
    public Regpro(int codigo, String data, String cidade) {
        this.codigo = codigo;
        this.data = data;
        this.cidade = cidade;
        
        
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getData() {
        return data;
    }
    public void setdata(String data) {
        this.data = data;
    }
   @Override
   public String toString(){
    return String.format("Codigo: %d\nData: %s\nCidade: %s\n",codigo,data,cidade);
   }

    
}
