package LendoArquivo;

public class Regpro {
     private int codigo;
    private String descricao;
    private double preco;
    private int qtd;
    private double total;
    private int categoria;

    public Regpro(int codigo, String descricao, double preco, int qtd, int categoria, double total) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd = qtd;
        this.total = total;
        this.categoria = categoria;
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
 
    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return String.format("Código: %d\nDescrição: %s\nPreço: %.2f\nQuantidade: %d\nTotal: %.2f\n",
                             codigo, descricao, preco, qtd, total);
    }
}
