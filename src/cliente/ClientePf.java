package cliente;

import java.math.BigDecimal;

import conta.Conta;
import conta.ContaPoupanca;

public class ClientePf extends Cliente{


    public ClientePf(String nome, String cadastroNacional){
        super(nome, cadastroNacional, new BigDecimal("0"), new BigDecimal("0"));
    }

    public Conta abrirContaPoupanca(int numero){

        Conta conta = new ContaPoupanca(this, numero);
        this.adcionarContas(conta);
        return conta;
    }



}