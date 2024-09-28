package model;

public abstract class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void mostrarDetalhes(int id) {
        System.out.println("Financiamento " + id);
        System.out.println("Valor do Imóvel: " + valorImovel);
        System.out.println("Prazo do Financiamento (anos): " + prazoFinanciamento);
        System.out.println("Taxa de Juros Anual: " + taxaJurosAnual);
        System.out.println("Pagamento Mensal: " + calcularPagamentoMensal());
        System.out.println("Total do Pagamento: " + calcularTotalPagamento());
        System.out.println("-----------------------------------------------------------------");
    }
    
    @Override
    public String toString() {
        return "Valor do Imóvel: " + valorImovel +
                ", Prazo do Financiamento (anos): " + prazoFinanciamento +
                ", Taxa de Juros Anual: " + taxaJurosAnual +
                ", Pagamento Mensal: " + calcularPagamentoMensal() +
                ", Total do Pagamento: " + calcularTotalPagamento();
    }
}
