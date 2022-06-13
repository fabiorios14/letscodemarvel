package cliente;

import java.math.BigDecimal;

public class ClientePj extends Cliente {

    public ClientePj(String nome, String cadastroNacional) {
        super(nome, cadastroNacional, new BigDecimal("0.005"), new BigDecimal("0.02"));
    }

}