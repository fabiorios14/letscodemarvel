import cliente.ClientePf;
import cliente.ClientePj;
import conta.ContaCorrente;

public class App {
    public static void main(String[] args) throws Exception {
        
       ClientePf cpf1 = new ClientePf("João", "000");
       ClientePf cpf2 = new ClientePf("Fabio", "001");
       
       cpf1.abrirContaCorrente(1);
       cpf2.abrirContaCorrente(2);
       ContaCorrente conta1 = (ContaCorrente) cpf1.buscarConta(1);
       ContaCorrente conta2 = (ContaCorrente) cpf2.buscarConta(2);

       conta1.depositar("10");
       conta1.sacar("1");
       conta1.transferir(conta2, "4");




       ClientePj cpj1 = new ClientePj("João", "000");
       ClientePj cpj2 = new ClientePj("Fabio", "001");

       cpj1.abrirContaCorrente(3);
       cpj2.abrirContaCorrente(4);
       ContaCorrente conta3 = (ContaCorrente) cpj1.buscarConta(3);
       ContaCorrente conta4 = (ContaCorrente) cpj2.buscarConta(4);

       conta3.depositar("100");
       conta3.sacar("11");
       conta3.transferir(conta4, "10");


       System.out.println("Conta: "+conta1.getNumero() + " Saldo: " + conta1.consultarSaldo());
       System.out.println("Conta: "+conta2.getNumero() + " Saldo: " + conta2.consultarSaldo());
       System.out.println("Conta: "+conta3.getNumero() + " Saldo: " + conta3.consultarSaldo());
       System.out.println("Conta: "+conta4.getNumero() + " Saldo: " + conta4.consultarSaldo());
       
    }
}
