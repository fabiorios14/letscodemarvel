package conta;

import java.math.BigDecimal;

import cliente.Cliente;

public class Conta{

    private BigDecimal saldo;
    private int numero;
    private Cliente titular;


    public Conta(Cliente titular, int numero){
        this.saldo = new BigDecimal("0.0");
        this.numero = numero;
        this.titular = titular;
    }
    
    public Cliente getTitular() {
        return titular;
    }
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        // verificar se o número não é negativo
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }


    public void depositar(String valor){
        this.setSaldo(this.getSaldo().add(new BigDecimal(valor)));
    }

    public boolean sacar(String valor){
        this.setSaldo(this.getSaldo().subtract(new BigDecimal(valor)));
        return true;
    }

    public String consultarSaldo(){
        return this.getSaldo().toString();
    }

    public boolean transferir(Conta conta, String valor){
        this.sacar(valor);
        conta.depositar(valor);
        return true;
    }

}
