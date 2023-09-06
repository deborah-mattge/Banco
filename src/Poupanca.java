public class Poupanca extends Conta {
   int dia;
   public Poupanca(int numero, double saldo, int qtdTRansacoes,Pessoa titular, String senha, int dia ){
      super(numero,saldo,qtdTRansacoes,titular,senha);
      this.dia=dia;
   }
   public  String menu(){
      return ("""
                Informe o que deseja realizar: 
                
                1-Realizar Pagamento
                2-Realizar Depósito
                3-Visualizar Saldo 
                4-Realizar Saque
                """);
   }

   public void saque(double valorSaque){
      setQtdTRansacoes(getQtdTRansacoes()+1);
      if(getSaldo()>=valorSaque){
         setSaldo(getSaldo()-valorSaque);

      }

   }
   public void verificaQtdTransacoes(Banco banco){
      if(this.getQtdTRansacoes()>5){
         double juros=banco.getTaxaDeServico();
         setSaldo(getSaldo()-juros);
      }
   }

   public void novoDia(Banco banco){
      this.setQtdTRansacoes(0);
      this.dia+=1;
      setSaldo(getSaldo()+banco.getJuros()*dia);
   }
}
