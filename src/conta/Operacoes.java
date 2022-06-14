package conta;

public interface Operacoes {
    
    public void depositar(String valor) throws Exception;
    public void transferir(Conta conta, String valor) throws Exception;
    public void sacar(String valor) throws Exception;
    public String consultarSaldo();

}
