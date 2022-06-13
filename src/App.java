import cliente.ClientePf;
import conta.ContaCorrente;

public class App {
    public static void main(String[] args) throws Exception {
        
       ClientePf cpf = new ClientePf("João", "000");
       ClientePf cpf2 = new ClientePf("Fabio", "001");
       

       cpf.abrirContaCorrente(1);
       cpf2.abrirContaCorrente(2);

       ContaCorrente conta1 = (ContaCorrente) cpf.buscarConta(1);
       ContaCorrente conta2 = (ContaCorrente) cpf2.buscarConta(2);
       conta1.depositar("10");
       conta1.sacar("1");
        
       
       
       conta1.transferir(conta2, "4");

       System.out.println(conta1.consultarSaldo());
       System.out.println(conta2.consultarSaldo());

       
    }
}
