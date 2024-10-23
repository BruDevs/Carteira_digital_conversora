package Cofre;

//A classe Euro herda da classe abstrata Moeda
public class Euro extends Moeda {

 // Construtor da classe Euro que recebe um valor e chama o construtor da classe pai (Moeda)
 public Euro(double valor) {
     // O método super() invoca o construtor da classe pai, passando o valor recebido como argumento
     super(valor);
 }

 // Sobrescreve o método abstrato converterParaReal() definido na classe Moeda
 @Override
 public double converterParaReal() {
     // Converte o valor de Euro para Real. Neste exemplo, assume-se que 1 Euro = 5.50 Reais
     return valor * 5.50;
 }
}