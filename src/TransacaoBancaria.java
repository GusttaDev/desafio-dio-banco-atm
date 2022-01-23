import enums.TipoOperacao;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TransacaoBancaria {
    private LocalDate dataOperacao;
    private TipoOperacao tipoOperacao;
    private double valor;

    public TransacaoBancaria(LocalDate dataOperacao, TipoOperacao tipoOperacao, double valor) {
        this.dataOperacao = dataOperacao;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }
}
