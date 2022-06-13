package cliente;
import java.util.ArrayList;
import java.util.List;

import conta.Conta;
import conta.ContaCorrente;


public abstract class Cliente {
    
    private String nome;
    private String cadastroNacional;
    private List<Conta> contas = new ArrayList<Conta>();

    public Cliente(String nome, String cadastroNacional){
        this.nome = nome;
        this.cadastroNacional = cadastroNacional;
    }


    public Conta abrirContaCorrente(int numero) {
        Conta contaCorrente = new ContaCorrente(this, numero);
        this.adcionarContas(contaCorrente);
        return contaCorrente;
    }

    public Conta abrirContaInvestimento() {
        // TODO Auto-generated method stub
        return null;
    }

    public void adcionarContas(Conta conta){
        this.contas.add(conta);
    } 
    
    public Conta buscarConta(int numero) throws Exception{
        for (Conta conta : contas) {
            if (conta.getNumero() == numero){
                return conta;
            }
        }
        throw new Exception("Conta não encontrada");
    }
    


}