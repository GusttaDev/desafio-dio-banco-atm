import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public void listarContas(){
        contas.forEach(IConta::imprimirExtrato);
    }
}
