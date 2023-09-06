import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    static Banco banco = new Banco("NullBanco", "rua x", 150,0.5, 3.0);
    static Conta contaLogada;
    public static void main(String[] args) {


        banco.cadastrarConta();
        entrarConta();
    }
    public static void entrarConta(){
        System.out.println("Informe o numero da sua conta: ");
        int nConta=sc.nextInt();
        for(Conta c : banco.getContas()){
            if(c.getNumero()==nConta){
                System.out.println("Informe a senha: ");
                String senhaConta =sc.next();
                if(c.getSenha().equals(senhaConta)){
                    contaLogada=c;
                    menuInicial();
                    break;
                }else{
                    System.out.println("Senha incorreta");
                }

            }else{
                System.out.println("esse numero de conta não existe");
            }
        }
    }
    public static void  menuInicial(){
        int escolha=0;
        do {
            System.out.println(contaLogada.menu());
             escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Informe o valor do pagamento: ");
                    double valorPagamento = sc.nextInt();
                    contaLogada.pagamento(valorPagamento);
                    break;
                case 2:
                    System.out.println("Informe o valor do depósito: ");
                    double valorDeposito = sc.nextInt();
                    contaLogada.credito(valorDeposito);
                    break;
                case 3:
                    System.out.println("Seu saldo atual é de: " + contaLogada.getSaldo());
                    break;
                case 4:
                    if(!(contaLogada instanceof Credito)){
                    System.out.println("Informe o valor do saque: ");
                    int valorSaque =sc.nextInt();
                    if(contaLogada instanceof Corrente){
                        ((Corrente) contaLogada).saque(valorSaque);
                        ((Corrente) contaLogada).verificaQtdTransacoes(banco);
                    }else if(contaLogada instanceof Poupanca){
                        ((Poupanca) contaLogada).saque(valorSaque);
                        ((Poupanca) contaLogada).verificaQtdTransacoes(banco);
                    }
                    }else{
                        System.out.println("Número inserido inválido");
                    }

                    break;
                case 5:
                    if(contaLogada instanceof Corrente) {
                        System.out.println("Informe o numero da conta para transferencia: ");
                        int nContaTransferencia = sc.nextInt();
                        System.out.println("Informe o valor da transferencia: ");
                        int valorTransferencia=sc.nextInt();
                        ((Corrente) contaLogada).transferencia(nContaTransferencia,valorTransferencia, banco);
                    }else{
                        System.out.println("Número inserido inválido");
                    }
                    break;
                case 10:
                    for(int i=1; i<=30; i++){

                        if(contaLogada instanceof Poupanca){
                            ((Poupanca) contaLogada).novoDia(banco);
                        }else if(contaLogada instanceof Credito){
                           ((Credito) contaLogada).novoDia(i);
                        }
                    }



            }
        }while (escolha!=0);

    }



}
