package conta;

import java.math.BigDecimal;

import cliente.Cliente;

public class ContaInvestimento extends Conta implements OperacoesComuns, OperacoesInvestimento {

    public ContaInvestimento(Cliente titular, int numero){
        super(titular, numero);
    }

    @Override
    public String consultarSaldo(){
        BigDecimal taxaAplicada = this.getTitular().getTaxaInvestimento().add(new BigDecimal("1"));
        return this.getSaldo().multiply(taxaAplicada).toString();
    }

    @Override
    public void investir(String valor){
        this.setSaldo(this.getSaldo().add(new BigDecimal(valor)));
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
    
}
