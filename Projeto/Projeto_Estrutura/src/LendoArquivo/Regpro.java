package LendoArquivo;

public class Regpro {
     private int codigo;
    private String descricao;
    private double preco;
    private int qtd;
    private double total;

    public Regpro(int codigo, String descricao, double preco, int qtd, double total) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd = qtd;
        this.total= total;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
