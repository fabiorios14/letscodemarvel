import cliente.ClientePf;
import cliente.ClientePj;
import conta.Conta;

public class App {
    public static void main(String[] args) throws Exception {
        
       ClientePf cpf1 = new ClientePf("João", "000");
       ClientePf cpf2 = new ClientePf("Fabio", "001");
       
       cpf1.abrirContaCorrente(1);
       cpf2.abrirContaCorrente(2);
       Conta conta1 = cpf1.buscarConta(1);
       Conta conta2 = cpf2.buscarConta(2);

       conta1.depositar("10");
       conta1.sacar("1");
       conta1.transferir(conta2, "4");




       ClientePj cpj1 = new ClientePj("João", "000");
       ClientePj cpj2 = new ClientePj("Fabio", "001");

       cpj1.abrirContaCorrente(3);
       cpj2.abrirContaCorrente(4);
       Conta conta3 = cpj1.buscarConta(3);
       Conta conta4 = cpj2.buscarConta(4);

       conta3.depositar("1000");
       conta3.sacar("100");
       conta3.transferir(conta4, "100");


       cpf1.abrirContaInvestimento(5);
       cpj1.abrirContaInvestimento(6);
       Conta conta5 = cpf1.buscarConta(5);
       Conta conta6 = cpj1.buscarConta(6);

       conta5.depositar("1000");
       conta6.depositar("1000");

       
       
       System.out.println("Conta Corrente PF: "+conta1.getNumero() + " Saldo: " + conta1.consultarSaldo());
       System.out.println("Conta Corrente PF: "+conta2.getNumero() + " Saldo: " + conta2.consultarSaldo());
       System.out.println("Conta Corrente PJ: "+conta3.getNumero() + " Saldo: " + conta3.consultarSaldo());
       System.out.println("Conta Corrente PJ: "+conta4.getNumero() + " Saldo: " + conta4.consultarSaldo());
       System.out.println("Conta Investimento PF: "+conta5.getNumero() + " Saldo: " + conta5.consultarSaldo());
       System.out.println("Conta Investimento PJ: "+conta6.getNumero() + " Saldo: " + conta6.consultarSaldo());
       
    }
}
