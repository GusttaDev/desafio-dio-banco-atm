import enums.TipoConta;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente, String cidade, String estado) {
        super(cliente, cidade, estado);
    }

    @Override
    public void imprimirExtrato() {
        super.imprimirInfosComplementares(TipoConta.POUPANCA);
    }
}
