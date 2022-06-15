package conta;

public interface IOperacoes {

    String consultarSaldo();
    void depositar(String valor) throws Exception;
    void transferir(Conta conta, String valor) throws Exception;
    void sacar(String valor) throws Exception;
    
}
