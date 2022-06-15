package cliente;

import java.math.BigDecimal;

public class ClientePj extends Cliente {

    public ClientePj(String nome, String cadastroNacional) {
        super(nome, cadastroNacional);
    }

    @Override
    public BigDecimal getTaxaSaque() {
        // TODO Auto-generated method stub
        return new BigDecimal("0.005");
    }

    @Override
    public BigDecimal getTaxaInvestimento() {
        // TODO Auto-generated method stub
        return new BigDecimal("0.02");
    }

}