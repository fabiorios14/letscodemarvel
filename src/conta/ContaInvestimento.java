package conta;

import java.math.BigDecimal;
import cliente.Cliente;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Cliente titular, int numero){
        super(titular, numero);
    }

    @Override
    public String consultarSaldo(){
        BigDecimal taxaAplicada = this.getTitular().getTaxaInvestimento().add(new BigDecimal("1"));
        return this.getSaldo().multiply(taxaAplicada).toString();
    }

    public void investir(String valor) throws Exception{
        this.depositar(this.getSaldo().add(new BigDecimal(valor)).toString());
    }
    
}
