import enums.TipoConta;
import enums.TipoOperacao;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Conta implements IConta{

    private String agencia;
    private int numero;
    private String cidade;
    private String estado;
    private double saldo;
    private int qtdSaques;
    private Cliente cliente;
    private boolean ehTransferencia = false;
    private List<TransacaoBancaria> transacoes = new ArrayList<>();

    public static int SEQUENCIAL = 1;
    public static String AGENCIA_PADRAO = "0001";

    public Conta(Cliente cliente, String cidade, String estado) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public void sacar(double valor) {
        if(this.saldo >= valor){
            this.saldo -= valor;

            if(!this.ehTransferencia){
                this.qtdSaques++;
                TransacaoBancaria transacao = new TransacaoBancaria(LocalDate.now(), TipoOperacao.SAQUE, valor);
                this.transacoes.add(transacao);
            }

        } else {
            System.out.println("Saldo insuficiente para saque. Favor realizar um depósito.\n");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;

        TransacaoBancaria transacao = new TransacaoBancaria(LocalDate.now(), TipoOperacao.DEPOSITO, valor);
        this.transacoes.add(transacao);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.ehTransferencia = true;

        this.sacar(valor);
        contaDestino.depositar(valor);

        TransacaoBancaria transacao = new TransacaoBancaria(LocalDate.now(), TipoOperacao.TRANSFERENCIA, valor);
        this.transacoes.add(transacao);

    }

    public void imprimirInfosComplementares(TipoConta tipoConta) {

        System.out.println("-------------------------------------");
        System.out.println("            Extrato Bancário         ");
        System.out.println("-------------------------------------");
        System.out.printf("Cliente: %s \n", this.cliente.getNome());
        System.out.printf("Agencia: %s - %s-%s \n", this.agencia, this.cidade, this.estado);
        System.out.printf("Conta: %d\n", this.numero);
        System.out.printf("Tipo: %s\n", tipoConta);
        System.out.println("-------------------------------------");
        System.out.println("DATA            HISTORICO       VALOR");
        System.out.println("-------------------------------------");

        this.transacoes.forEach(t -> System.out.printf("%5s %15s %10.2f \n", t.getDataOperacao(), t.getTipoOperacao(), t.getValor()));

        System.out.println("-------------------------------------");
        System.out.printf("Saldo Atual: %.2f \n", this.saldo);
        System.out.printf("Quantidade de saques realizados hoje: %d \n", this.qtdSaques);
        System.out.println("-------------------------------------");
    }
}
