package model;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private double tamanhoTerreno;
    private String tipoterreno;

    public Terreno(int valorImovel, int prazoFinanciamento, int taxaJurosAnual, double tamanhoTerreno, String tipoterreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoTerreno = tamanhoTerreno;
        this.tipoterreno = tipoterreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        
        return 10;
    }

    @Override
    public void mostrarDetalhes(int id) {
        super.mostrarDetalhes(id);
        System.out.println("Tamanho do Terreno: " + tamanhoTerreno);
        System.out.println("-----------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return super.toString() + ", Área Construída: " + ", Tamanho do Terreno: " + tamanhoTerreno;
    }
}
