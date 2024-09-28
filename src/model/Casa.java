package model;

import util.DescontoMaiorDoQueJurosException;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L; // Adicionando serialVersionUID
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa() {
        super(0.0, 0, 0.0); // Chama o construtor da classe Financiamento com valores padrão ou adequados ao seu contexto
    }    

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100;
        int prazoMeses = getPrazoFinanciamento() * 12;
        double pagamentoMensalBase = (getValorImovel() / prazoMeses) * (1 + taxaMensal);
        return pagamentoMensalBase + 80; // Adiciona o valor do seguro obrigatório
    }

    public double aplicarDesconto(double desconto) throws DescontoMaiorDoQueJurosException {
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100;
        double jurosMensal = (getValorImovel() * taxaMensal) / getPrazoFinanciamento();
        if (desconto > jurosMensal) {
            throw new DescontoMaiorDoQueJurosException("Desconto maior do que os juros mensais.");
        }
        return calcularPagamentoMensal() - desconto;
    }

    @Override
    public void mostrarDetalhes(int id) {
        super.mostrarDetalhes(id);
        System.out.println("Área Construída: " + areaConstruida);
        System.out.println("Tamanho do Terreno: " + tamanhoTerreno);
        System.out.println("-----------------------------------------------------------------");
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Área Construída: " + areaConstruida + ", Tamanho do Terreno: " + tamanhoTerreno;
    }
}
