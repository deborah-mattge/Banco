public class Corrente  extends Conta{
    private double limite;
    public Corrente(double limite, int numero, double saldo, int qtdTRansacoes,Pessoa titular,String senha){
        super(numero, saldo, qtdTRansacoes, titular, senha);
        this.limite=limite;

    }
    public  String menu(){
        return ("""
                Informe o que deseja realizar: 
                
                1-Realizar Pagamento
                2-Realizar Depósito
                3-Visualizar Saldo 
                4-Realizar Saque
                5- Realizar Transferência 
                """);
    }
    public void saque(double valorSaque){

        if(getSaldo()>=valorSaque){
            setQtdTRansacoes(getQtdTRansacoes()+1);
            setSaldo(getSaldo()-valorSaque);

        }



    }
    @Override
    public void pagamento(double valorPagamento){


       if(getSaldo()<valorPagamento && limite>getSaldo()-valorPagamento){
            this.limite-=(getSaldo()-valorPagamento);

        }
        this.setSaldo((this.getSaldo()-valorPagamento));


    }
    public boolean transferencia(double nContaTranferir, double valorTranferencia, Banco banco){
        for(Conta c : banco.getContas()){
            if(c.getNumero()==nContaTranferir && !(c instanceof Credito)){
                setQtdTRansacoes(getQtdTRansacoes()+1);
                c.setSaldo(getSaldo()+valorTranferencia);
                this.setSaldo(getSaldo()-valorTranferencia);
                verificaQtdTransacoes(banco);
                return true;
            }
        }


        return false;

    }
    public void verificaQtdTransacoes(Banco banco){
        if(this.getQtdTRansacoes()>5){
            double juros=banco.getTaxaDeServico();
            setSaldo(getSaldo()-juros);
        }
    }

}
