package Cofre;

//Declaração da classe Real, que herda da classe abstrata Moeda
public class Real extends Moeda {

 // Construtor da classe Real que recebe um valor e chama o construtor da classe pai (Moeda)
 public Real(double valor) {
     // O método super() invoca o construtor da classe pai, passando o valor recebido como argumento
     super(valor);
 }

 // Sobrescreve o método abstrato converterParaReal() da classe Moeda
 @Override
 public double converterParaReal() {
     // Como a moeda já está em reais, não é necessária nenhuma conversão
     // O método simplesmente retorna o valor armazenado
     return valor;
 }
}