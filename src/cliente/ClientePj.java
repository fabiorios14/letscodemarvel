package cliente;

import java.math.BigDecimal;

import conta.ContaCorrente;
import conta.ContaInvestimento;

public class ClientePj extends Cliente implements OperacoesComuns{

    public ClientePj(String nome, String cadastroNacional) {
        super(nome, cadastroNacional, new BigDecimal("0.005"), new BigDecimal("0.02"));
    }

    @Override
    public ContaCorrente abrirContaCorrente(int numero) {
        ContaCorrente conta = new ContaCorrente(this, numero);
        this.adcionarContas(conta);
        return conta;
    }

    @Override
    public ContaInvestimento abrirContaInvestimento(int numero) {
        ContaInvestimento conta = new ContaInvestimento(this, numero);
        this.adcionarContas(conta);
        return conta;
    }

}