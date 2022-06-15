package cliente;

import java.math.BigDecimal;

public interface ITaxas {
    BigDecimal getTaxaInvestimento();
    BigDecimal getTaxaSaque();
}
