package Cofre;

//Declaração da classe Dolar, que herda da classe abstrata Moeda
public class Dolar extends Moeda {

 // Construtor da classe Dolar que recebe um valor e chama o construtor da classe pai (Moeda)
 public Dolar(double valor) {
     // O método super() invoca o construtor da classe pai, passando o valor recebido como argumento
     super(valor);
 }

 // Sobrescreve o método abstrato converterParaReal() da classe Moeda
 @Override
 public double converterParaReal() {
     // Converte o valor de Dólar para Real. Neste exemplo, assume-se que 1 Dólar = 5.00 Reais
     return valor * 5.00;
 }
}