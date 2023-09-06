public class FIsica extends Pessoa {
    private long cpf;
    private String nomeCompleto;
    public FIsica(long cpf, String nomeCompleto, String endereco){
        super(endereco);
        this.cpf=cpf;
        this.nomeCompleto=nomeCompleto;
    }

}
