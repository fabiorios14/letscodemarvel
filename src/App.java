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

        cpf1.abrirContaPoupanca(3);
        Conta conta3 = cpf1.buscarConta(3);
        conta3.depositar("200.00");

        ClientePj cpj1 = new ClientePj("João LTDA", "002");
        ClientePj cpj2 = new ClientePj("Fabio LTDA", "003");

        cpj1.abrirContaCorrente(4);
        cpj2.abrirContaCorrente(5);
        Conta conta4 = cpj1.buscarConta(4);
        Conta conta5 = cpj2.buscarConta(5);

        conta4.depositar("1000");
        conta4.sacar("100");
        conta4.transferir(conta5, "100");

        cpf1.abrirContaInvestimento(6);
        cpj1.abrirContaInvestimento(7);
        Conta conta6 = cpf1.buscarConta(6);
        Conta conta7 = cpj1.buscarConta(7);

        conta6.depositar("1000");
        conta7.depositar("1000");

        System.out.println("Conta Corrente PF do(a) " + conta1.getTitular().getNome() + ": " + conta1.getNumero() + " Saldo: " + conta1.consultarSaldo());
        System.out.println("Conta Corrente PF do(a) " + conta2.getTitular().getNome() + ": " + conta2.getNumero() + " Saldo: " + conta2.consultarSaldo());
        System.out.println("Conta Poupança PF do(a) " + conta3.getTitular().getNome() + ": " + conta3.getNumero() + " Saldo: " + conta3.consultarSaldo());
        System.out.println("Conta Corrente PJ do(a) " + conta4.getTitular().getNome() + ": " + conta4.getNumero() + " Saldo: " + conta4.consultarSaldo());
        System.out.println("Conta Corrente PJ do(a) " + conta5.getTitular().getNome() + ": " + conta5.getNumero() + " Saldo: " + conta5.consultarSaldo());
        System.out.println("Conta Investimento PF do(a) " + conta6.getTitular().getNome() + ": " + conta6.getNumero() + " Saldo: " + conta6.consultarSaldo());
        System.out.println("Conta Investimento PJ do(a) " + conta7.getTitular().getNome() + ": " + conta7.getNumero() + " Saldo: " + conta7.consultarSaldo());

    }
}
