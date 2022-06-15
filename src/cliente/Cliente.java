package cliente;
import java.util.ArrayList;
import java.util.List;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaInvestimento;


public abstract class Cliente implements ITaxas{
    
    private String nome;
    private String cadastroNacional;
    private List<Conta> contas = new ArrayList<Conta>();

    public Cliente(String nome, String cadastroNacional){
        this.nome = nome;
        this.cadastroNacional = cadastroNacional;
    }

    public String getNome() {
        return nome;
    }
    
    public Conta abrirContaCorrente(int numero) {
        Conta conta = new ContaCorrente(this, numero);
        this.adcionarContas(conta);
        return conta;
    }

    public Conta abrirContaInvestimento(int numero) {
        Conta conta = new ContaInvestimento(this, numero);
        this.adcionarContas(conta);
        return conta;
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