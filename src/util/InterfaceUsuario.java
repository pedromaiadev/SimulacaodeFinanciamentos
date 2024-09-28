package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    public double lerValorDouble(String mensagem, Scanner scanner) {
        double valor = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // limpa o scanner
            }
        } while (!entradaValida);
        return valor;
    }

    public int lerValorInt(String mensagem, Scanner scanner) {
        int valor = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // limpa o scanner
            }
        } while (!entradaValida);
        return valor;
    }
}
