public class Conta {
    private  int numero;
    private double saldo;

    private int qtdTRansacoes;
    private String senha;
    private Pessoa titular;
    public  Conta(int numero, double saldo, int qtdTRansacoes) {
    this.numero = numero;
    this.saldo = saldo;
    this.qtdTRansacoes=qtdTRansacoes;

    }
    public void pagamento(){}
    public void credito(){}
    public  void saldo(){}
}
