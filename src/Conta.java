public class Conta {
    private  int numero;
    private double saldo;

    private int qtdTRansacoes;
    private String senha;
    private Pessoa titular;
    public  Conta(int numero, double saldo, int qtdTRansacoes,Pessoa titular,String senha) {
    this.numero = numero;
    this.saldo = saldo;
    this.qtdTRansacoes=qtdTRansacoes;
    this.titular=titular;
    this.senha=senha;

    }
    public  String menu(){
        return ("""
                Informe o que deseja realizar: 
                
                1-Realizar Pagamento
                2-Realizar Depósito
                3-Visualizar Saldo 
                0-encerrar
                10-trocou o dia 
                
                """);
    }

    public void pagamento(double valorPagamento){
        if(this.saldo>valorPagamento){
            this.saldo-=valorPagamento;
        }


    }
    public void credito(double valorDeposito){
        this.saldo+=valorDeposito;
    }

    public void novoDia(){
        this.qtdTRansacoes=0;

    }

    public int getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getQtdTRansacoes() {
        return qtdTRansacoes;
    }

    public void setQtdTRansacoes(int qtdTRansacoes) {
        this.qtdTRansacoes = qtdTRansacoes;
    }
}
