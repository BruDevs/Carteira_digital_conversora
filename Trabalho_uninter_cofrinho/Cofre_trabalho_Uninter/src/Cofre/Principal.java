package Cofre;

//Importa a classe Scanner para capturar entrada do usuário
import java.util.Scanner;

public class Principal {
 public static void main(String[] args) {
     // Cria um objeto Scanner para ler entradas do usuário
     Scanner scanner = new Scanner(System.in);
     
     // Cria uma instância da classe Cofrinho para gerenciar as moedas
     Cofrinho cofrinho = new Cofrinho();
     
     // Variável para armazenar a opção do menu
     int opcao;

     // Laço do-while para exibir o menu até que o usuário escolha encerrar
     do {
         // Exibe o menu de opções
         System.out.println("\nCofrinho:");
         System.out.println("1 - Adicionar moeda");
         System.out.println("2 - Remover moeda");
         System.out.println("3 - Listar moedas");
         System.out.println("4 - Calcular total convertido em real");
         System.out.println("0 - Encerrar");
         System.out.print("Escolha uma opção: ");
         
         // Lê a opção escolhida pelo usuário
         opcao = scanner.nextInt();

         // Verifica a opção escolhida e executa a ação correspondente
         switch (opcao) {
             case 1:
                 // Chama o método para adicionar uma moeda ao cofrinho
                 adicionarMoeda(cofrinho, scanner);
                 break;
             case 2:
                 // Chama o método para remover uma moeda do cofrinho
                 removerMoeda(cofrinho, scanner);
                 break;
             case 3:
                 // Exibe a quantidade de moedas por tipo no cofrinho
                 cofrinho.exibirQuantidadePorTipo();
                 break;
             case 4:
                 // Calcula e exibe o valor total convertido em reais
                 double totalConvertido = cofrinho.calcularTotalConvertidoParaReal();
                 System.out.printf("Total convertido em reais: R$ %.2f\n", totalConvertido);
                 break;
             case 0:
                 // Encerra o programa
                 System.out.println("Encerrando...");
                 break;
             default:
                 // Exibe uma mensagem de erro se o usuário escolher uma opção inválida
                 System.out.println("Opção inválida. Tente novamente.");
         }
     } while (opcao != 0); // O laço continua até que o usuário escolha encerrar (opção 0)

     // Fecha o Scanner após o uso
     scanner.close();
 }

 // Método para adicionar uma moeda ao cofrinho
 private static void adicionarMoeda(Cofrinho cofrinho, Scanner scanner) {
     // Solicita ao usuário que escolha o tipo de moeda
     System.out.println("Escolha a moeda:");
     System.out.println("1 - Real");
     System.out.println("2 - Dólar");
     System.out.println("3 - Euro");
     int tipoMoeda = scanner.nextInt();

     // Solicita ao usuário que insira o valor da moeda
     System.out.print("Digite o valor: ");
     // Aceita tanto vírgula quanto ponto como separador decimal
     String valorInput = scanner.next().replace(",", ".");
     // Converte o valor inserido para double
     double valor = Double.parseDouble(valorInput);

     // Verifica o tipo de moeda e adiciona ao cofrinho
     switch (tipoMoeda) {
         case 1:
             cofrinho.adicionarMoeda(new Real(valor)); // Adiciona uma moeda Real
             System.out.println("Moeda Real adicionada.");
             break;
         case 2:
             cofrinho.adicionarMoeda(new Dolar(valor)); // Adiciona uma moeda Dólar
             System.out.println("Moeda Dólar adicionada.");
             break;
         case 3:
             cofrinho.adicionarMoeda(new Euro(valor)); // Adiciona uma moeda Euro
             System.out.println("Moeda Euro adicionada.");
             break;
         default:
             // Caso o tipo de moeda seja inválido
             System.out.println("Tipo de moeda inválido.");
     }
 }

 // Método para remover uma moeda do cofrinho
 private static void removerMoeda(Cofrinho cofrinho, Scanner scanner) {
     // Solicita ao usuário que escolha o tipo de moeda a ser removida
     System.out.println("Escolha a moeda para remover:");
     System.out.println("1 - Real");
     System.out.println("2 - Dólar");
     System.out.println("3 - Euro");
     int tipoMoeda = scanner.nextInt();

     // Solicita ao usuário que insira o valor da moeda a ser removida
     System.out.print("Digite o valor da moeda a ser removida: ");
     // Aceita vírgula e ponto como separador decimal
     String valorInput = scanner.next().replace(",", ".");
     // Converte o valor inserido para double
     double valor = Double.parseDouble(valorInput);

     // Cria um objeto Moeda correspondente ao tipo escolhido
     Moeda moedaRemover = null;
     switch (tipoMoeda) {
         case 1:
             moedaRemover = new Real(valor); // Cria uma moeda Real para remover
             break;
         case 2:
             moedaRemover = new Dolar(valor); // Cria uma moeda Dólar para remover
             break;
         case 3:
             moedaRemover = new Euro(valor); // Cria uma moeda Euro para remover
             break;
         default:
             // Se o tipo de moeda for inválido, sai do método
             System.out.println("Tipo de moeda inválido.");
             return;
     }

     // Tenta remover a moeda do cofrinho e informa se a remoção foi bem-sucedida
     boolean removido = cofrinho.removerMoeda(moedaRemover);
     if (removido) {
         System.out.println("Moeda removida com sucesso.");
     } else {
         System.out.println("Moeda não encontrada no cofrinho.");
     }
 }
}

