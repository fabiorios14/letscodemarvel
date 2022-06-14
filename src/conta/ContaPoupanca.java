package conta;

import java.math.BigDecimal;

import cliente.Cliente;

public class ContaPoupanca extends Conta implements OperacoesComuns, OperacoesCorrentePoupanca{

    public ContaPoupanca(Cliente titular, int numero) {
        super(titular, numero);
    }

    @Override
    public void depositar(String valor) throws Exception {

        BigDecimal valorEmNumero = new BigDecimal(valor);
        if (valorEmNumero.doubleValue() < 0) {
            throw new Exception("Valor não pode ser negativo");
        }
        this.setSaldo(this.getSaldo().add(valorEmNumero));

    }

    @Override
    public void sacar(String valor) throws Exception {
        BigDecimal taxaAplicada = this.getTitular().getTaxaTarifa().add(new BigDecimal("1"));
        BigDecimal novoValor = new BigDecimal(valor).multiply(taxaAplicada);

        if (novoValor.doubleValue() < 0) {
            throw new Exception("Valor não pode ser negativo");
        }

        if( this.getSaldo().doubleValue() < novoValor.doubleValue()){
            throw new Exception("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo().subtract(novoValor));
    }

    @Override
    public void transferir(Conta conta, String valor) throws Exception {
        
        try {
            this.sacar(valor);
            if(conta instanceof ContaCorrente){
                ContaCorrente contaCorrente = (ContaCorrente) conta;
                contaCorrente.depositar(valor);
            }
            if(conta instanceof ContaPoupanca){
                ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
                contaPoupanca.depositar(valor);
            }
            if(conta instanceof ContaInvestimento){
                ContaInvestimento contaInvestimento = (ContaInvestimento) conta;
                contaInvestimento.investir(valor);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String consultarSaldo() {
        return this.getSaldo().toString();
    }
    
}
