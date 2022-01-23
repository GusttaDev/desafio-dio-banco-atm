import enums.TipoConta;

public class ContaCorrente extends Conta{


    public ContaCorrente(Cliente cliente, String cidade, String estado) {
        super(cliente, cidade, estado);
    }

    @Override
    public void imprimirExtrato() {
        super.imprimirInfosComplementares(TipoConta.CORRENTE);
    }
}
