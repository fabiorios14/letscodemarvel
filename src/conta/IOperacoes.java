package conta;

public interface IOperacoes {
    
    void depositar(String valor) throws Exception;
    void transferir(Conta conta, String valor) throws Exception;
    void sacar(String valor) throws Exception;
    String consultarSaldo();

}
