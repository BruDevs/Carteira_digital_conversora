package Cofre;

import java.util.ArrayList;

public class Cofrinho {
    private ArrayList<Moeda> moedas = new ArrayList<>();

    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
    }

    public boolean removerMoeda(Moeda moeda) {
        return moedas.remove(moeda); // Remove a moeda específica se estiver presente
    }

    public double calcularTotalConvertidoParaReal() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.converterParaReal();
        }
        return total;
    }

    public void exibirQuantidadePorTipo() {
        ArrayList<Moeda> reais = new ArrayList<>();
        ArrayList<Moeda> euros = new ArrayList<>();
        ArrayList<Moeda> dolares = new ArrayList<>();

        // Separar as moedas por tipo
        for (Moeda moeda : moedas) {
            if (moeda instanceof Real) {
                reais.add(moeda);
            } else if (moeda instanceof Euro) {
                euros.add(moeda);
            } else if (moeda instanceof Dolar) {
                dolares.add(moeda);
            }
        }

        // Exibir a quantidade e os valores das moedas
        System.out.println("Reais: " + reais.size() + " " + exibirValoresMoedas(reais));
        System.out.println("Euros: " + euros.size() + " " + exibirValoresMoedas(euros));
        System.out.println("Dólares: " + dolares.size() + " " + exibirValoresMoedas(dolares));
    }

    private String exibirValoresMoedas(ArrayList<Moeda> moedas) {
        StringBuilder valores = new StringBuilder();
        valores.append("(");

        for (int i = 0; i < moedas.size(); i++) {
            valores.append(moedas.get(i).getValor());
            if (i < moedas.size() - 1) {
                valores.append(") (");
            }
        }

        valores.append(")");
        return valores.toString();
    }
}
