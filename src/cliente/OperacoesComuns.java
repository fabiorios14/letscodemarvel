package cliente;

import conta.ContaCorrente;
import conta.ContaInvestimento;

public interface OperacoesComuns {
    
    public ContaCorrente abrirContaCorrente(int numero);
    public ContaInvestimento abrirContaInvestimento(int numero);

}
