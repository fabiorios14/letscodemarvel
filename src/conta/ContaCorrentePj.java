package conta;

import java.math.BigDecimal;

import cliente.Cliente;

public class ContaCorrentePj extends Conta {

    public ContaCorrentePj(Cliente titular, int numero){
        super(titular, numero);
    }

    @Override
    public void depositar(String valor){

        BigDecimal novoValor = new BigDecimal(valor).multiply(new BigDecimal("0.995"));
        System.out.println(novoValor.toString());
        this.setSaldo(this.getSaldo().add(novoValor));

    }

    @Override
    public boolean sacar(String valor){

        BigDecimal novoValor = new BigDecimal(valor).multiply(new BigDecimal("1.005"));
        this.setSaldo(this.getSaldo().subtract(novoValor));

        return true;
    }

    @Override
    public boolean transferir(Conta conta, String valor){
        this.sacar(valor);
        conta.depositar(valor);
        return true;
    }

}
