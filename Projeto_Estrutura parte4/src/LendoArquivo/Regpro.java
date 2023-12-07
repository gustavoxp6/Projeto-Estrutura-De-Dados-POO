package LendoArquivo;

public class Regpro {
    private String codigo;
    private String data;
    private String cidade;
    
    public Regpro(String codigo, String data, String cidade) {
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
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getData() {
        return data;
    }
    public void setdata(String data) {
        this.data = data;
    }
   

    
}
