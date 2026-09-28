//"Você foi contratado para ajustar o módulo de pagamentos do SafeBank. O sistema atual fecha inesperadamente quando o usuário digita um valor inválido ou tenta sacar mais do que possui. Sua tarefa é envolver a lógica de saque em uma estrutura de tratamento de erros que:

// Capture erros de digitação (ex: `InputMismatchException`).
//Previna divisões por zero ou valores negativos.
//Utilize o bloco `finally` para exibir a mensagem `'Operação encerrada'` independente do que aconteça."
package Try;

import java.util.InputMismatchException;
import java.util.Scanner;

public class tryEx {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        double saldo = 1000.00;

        System.out.println("=== SafeBank - Módulo de Saque ===");
        System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
        System.out.print("Informe o valor do saque: ");

        try{
            double valorSaque = sc.nextDouble();

            if (valorSaque <= 0) {
                throw new IllegalArgumentException("O valor do saque deve ser maior doque 0!");
            }

            if (valorSaque>saldo) {
                throw new IllegalArgumentException("Saldo insuficiente!");
            }

            int quantidadeNotas = 0;
            if (quantidadeNotas == 0){

            }

            saldo -= valorSaque;
            System.out.printf("Saque efetuado com sucesso! Saldo atual: R$ %.2f%n", saldo);

        }catch(InputMismatchException e){
            System.out.println("Erro de digitação: por favor insira apenas valores numéricos válidos");
        }catch (ArithmeticException e){
            System.out.println("Erro matemático: Divisão por zero não é permitida.");
        }catch (IllegalArgumentException e){
            System.out.println("Erro na operação: "+ e.getMessage());
        }catch (Exception e){
            System.out.println("Erro inesperado: "+ e.getMessage());
        } 
        finally {
            System.out.println("Operação encerrada");
            sc.close();
        }

        sc.close();
    }
}
