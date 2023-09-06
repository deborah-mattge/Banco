import java.util.ArrayList;

public class Banco {
    private String nome;
    private String endereco;
    private int agencia;
    private ArrayList<Conta>contas = new ArrayList<Conta>();
    private double juros;
    private double taxaDeServico;

    public Banco(String nome, String endereco, int agencia,double juros, double taxaDeServico ){
    this.nome=nome;
    this.endereco=endereco;
    this.agencia=agencia;
    this.juros=juros;
    this.taxaDeServico=taxaDeServico;
    }
    public void cadastrarConta(){
        Pessoa pessoa1 = new FIsica(1990873354, "Joao Silva","rua tal");
        Pessoa pessoa2 = new Juridica(46564656, "Tim","rua tal");
        Conta conta = new Corrente(100.0,1,100,0,pessoa2,"123");
        Conta conta2 = new Poupanca(2,100,0,pessoa1,"321",0);
        Conta conta3 = new Credito(1000,3,100,0,pessoa1,"234",30);
        adicionarConta(conta);
        adicionarConta(conta3);
        adicionarConta(conta2);
    }
    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public double getJuros() {
        return juros;
    }

    public double getTaxaDeServico() {
        return taxaDeServico;
    }


}
