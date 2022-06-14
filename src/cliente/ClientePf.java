package cliente;

import java.math.BigDecimal;

import conta.ContaCorrente;
import conta.ContaInvestimento;
import conta.ContaPoupanca;

public class ClientePf extends Cliente implements OperacoesComuns ,OperacoesPF{


    public ClientePf(String nome, String cadastroNacional){
        super(nome, cadastroNacional, new BigDecimal("0"), new BigDecimal("0"));
    }

    @Override
    public ContaPoupanca abrirContaPoupanca(int numero){
        ContaPoupanca conta = new ContaPoupanca(this, numero);
        this.adcionarContas(conta);
        return conta;
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