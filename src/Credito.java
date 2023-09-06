public class Credito extends  Conta {
    private int diaFatura;
    private double limite;
    public Credito(double limite, int numero, double saldo, int qtdTRansacoes,Pessoa titular,String senha,int diaFatura){
        super(numero,saldo, qtdTRansacoes,titular,senha);
        this.limite=limite;
        this.diaFatura=diaFatura;
    }

   @Override
    public void pagamento(double valorPagamento){
        if(this.limite>getSaldo()+valorPagamento){
            setSaldo(getSaldo()+valorPagamento);
        }

   }
   @Override
    public void credito(double valorDeposito){
        setSaldo(getSaldo()-valorDeposito);
   }
    public void novoDia(int diaAtual){
        this.setQtdTRansacoes(0);
        if(diaAtual>diaFatura){

        }
    }





}
