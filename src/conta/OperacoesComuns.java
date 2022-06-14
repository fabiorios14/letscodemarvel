package conta;

import java.math.BigDecimal;

public interface OperacoesComuns {
    
    public void sacar(String valor) throws Exception;
    public void transferir(Conta conta, String valor) throws Exception;
    public String consultarSaldo();

}
