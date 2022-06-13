public interface Operacoes {
    
    public void sacar(int valor);
    public void depositar(int valor);
    public void transferência(int valor, Conta conta);
    public void investir(int valor);
    public int consultarSaldo();

}
