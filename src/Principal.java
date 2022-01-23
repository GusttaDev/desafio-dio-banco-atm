public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Tadeu Almeida");
        Banco banco = new Banco("Bradesco");

        Conta cc = new ContaCorrente(cliente, "Brasilia", "DF");
        Conta poupanca = new ContaPoupanca(cliente, "Brasilia", "DF");

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(1000);
        cc.sacar(205);
        cc.transferir(200, poupanca);
        cc.imprimirExtrato();

    }
}
