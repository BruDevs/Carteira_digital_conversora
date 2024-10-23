package Cofre;

//Declaração de uma classe abstrata chamada Moeda
public abstract class Moeda {
 // Atributo protegido que armazena o valor da moeda
 protected double valor;

 // Construtor da classe Moeda que recebe um valor e inicializa o atributo 'valor'
 public Moeda(double valor) {
     this.valor = valor;
 }

 // Método abstrato que será implementado pelas subclasses para converter a moeda em Reais
 public abstract double converterParaReal();

 // Método que retorna o valor da moeda
 public double getValor() {
     return valor;
 }

 // Sobrescreve o método equals() para comparar objetos de Moeda
 @Override
 public boolean equals(Object obj) {
     // Verifica se o objeto a ser comparado é o próprio objeto atual
     if (this == obj) return true;

     // Verifica se o objeto é nulo ou se pertence a uma classe diferente
     if (obj == null || getClass() != obj.getClass()) return false;

     // Faz o casting do objeto para o tipo Moeda e compara os valores
     Moeda moeda = (Moeda) obj;
     // Compara os valores de ambas as moedas usando Double.compare()
     return Double.compare(moeda.valor, valor) == 0;
 }
}