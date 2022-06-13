package cliente;

import conta.Conta;
import conta.ContaCorrentePj;

public class ClientePj extends Cliente {

    public ClientePj(String nome, String cadastroNacional) {
        super(nome, cadastroNacional);
    }


    public Conta abrirContaCorrentePj(int numero) {
        Conta contaCorrentePj = new ContaCorrentePj(this, numero);
        this.adcionarContas(contaCorrentePj);
        return contaCorrentePj;
    }


    
}