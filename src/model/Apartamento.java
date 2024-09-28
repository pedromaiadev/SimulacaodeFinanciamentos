package model;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L; // Adicione um número de versão serial único

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100;
        int prazoMeses = getPrazoFinanciamento() * 12;
        return (getValorImovel() * taxaMensal * Math.pow((1 + taxaMensal), prazoMeses)) / (Math.pow((1 + taxaMensal), prazoMeses) - 1);
    }

    @Override
    public void mostrarDetalhes(int id) {
        super.mostrarDetalhes(id);
        System.out.println("Número de Vagas na Garagem: " + vagasGaragem);
        System.out.println("Número do Andar: " + numeroAndar);
        System.out.println("-----------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de Vagas na Garagem: " + vagasGaragem + ", Número do Andar: " + numeroAndar;
    }
}
