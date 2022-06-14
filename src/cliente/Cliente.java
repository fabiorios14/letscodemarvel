package cliente;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaInvestimento;


public abstract class Cliente {
    
    private String nome;
    private String cadastroNacional;
    private BigDecimal taxaTarifa;
    private BigDecimal taxaInvestimento;
    private List<Conta> contas = new ArrayList<Conta>();

    public Cliente(String nome, String cadastroNacional, BigDecimal taxaTarifa, BigDecimal taxaInvestimento){
        this.nome = nome;
        this.cadastroNacional = cadastroNacional;
        this.taxaTarifa = taxaTarifa;
        this.taxaInvestimento = taxaInvestimento;
    }

    public String getNome() {
        return nome;
    }
    
    public BigDecimal getTaxaTarifa() {
        return this.taxaTarifa;
    }

    public BigDecimal getTaxaInvestimento() {
        return this.taxaInvestimento;
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