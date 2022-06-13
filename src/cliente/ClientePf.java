package cliente;

import conta.Conta;
import conta.ContaPoupanca;

public class ClientePf extends Cliente{


    public ClientePf(String nome, String cadastroNacional){
        super(nome, cadastroNacional);
    }

    public Conta abrirContaPoupanca(Cliente titular, int numero){
        return new ContaPoupanca(titular, numero);
    }



}