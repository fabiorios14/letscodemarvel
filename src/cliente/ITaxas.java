package cliente;

import java.math.BigDecimal;

public interface ITaxas {

    default BigDecimal getTaxaSaque() {
        // TODO Auto-generated method stub
        return new BigDecimal("0.0");
    }

    default BigDecimal getTaxaInvestimento() {
        // TODO Auto-generated method stub
        return new BigDecimal("0.0");
    }

}
