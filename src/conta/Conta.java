package conta;

import java.math.BigDecimal;

import cliente.Cliente;

public class Conta {

    private BigDecimal saldo;
    private int numero;
    private Cliente titular;

    public Conta(Cliente titular, int numero) {
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

    public void depositar(String valor) throws Exception {

        BigDecimal valorEmNumero = new BigDecimal(valor);
        if (valorEmNumero.doubleValue() < 0) {
            throw new Exception("Valor não pode ser negativo");
        }
        this.setSaldo(this.getSaldo().add(valorEmNumero));

    }

    public void sacar(String valor) throws Exception {
        BigDecimal taxaAplicada = this.titular.getTaxaTarifa().add(new BigDecimal("1"));
        BigDecimal novoValor = new BigDecimal(valor).multiply(taxaAplicada);

        if (novoValor.doubleValue() < 0) {
            throw new Exception("Valor não pode ser negativo");
        }

        if( this.getSaldo().doubleValue() < novoValor.doubleValue()){
            throw new Exception("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo().subtract(novoValor));
    }

    public String consultarSaldo() {
        return this.getSaldo().toString();
    }

    public void transferir(Conta conta, String valor) throws Exception {
        
        try {
            this.sacar(valor);
            conta.depositar(valor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
