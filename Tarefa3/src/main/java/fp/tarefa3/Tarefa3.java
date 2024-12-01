package fp.tarefa3;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Este ejercicio las matemáticas no son tan complejas, para mi esta es la solucion mas sencilla.
Aparte del main que llama a la funcion, tenemos un metodo de obtencion de coeficientes con control de entrada.
El metodo que resuelve la ecuacion, que llama los metodos dependiendo del resultado del discriminante, y el metodo del calculo del mimsmo.
y 3 metodos de salida de resultados, dependiendo del tipo de solucion.

*/

public class Tarefa3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cálculo de ecuaciones de segundo grado. Ingrese los coeficientes:");

        double a = obtenerCoeficiente(scanner, "a");
        double b = obtenerCoeficiente(scanner, "b");
        double c = obtenerCoeficiente(scanner, "c");

        resolverEcuacion(a, b, c);
        
        scanner.close();
    }

    private static double obtenerCoeficiente(Scanner scanner, String coeficiente) {
        double valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Ingrese el coeficiente " + coeficiente + ": ");
            try {
                valor = scanner.nextDouble();
                entradaValida = true; // Si se lee un valor sin excepción, se considera válida la entrada
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduzca un número.");
                scanner.next();
            }
        }
        return valor;
    }

    private static void resolverEcuacion(double a, double b, double c) {
        double discriminante = calcularDiscriminante(a, b, c);

        if (discriminante > 0) {
            mostrarSolucionesReales(a, b, discriminante);
        } else if (discriminante == 0) {
            mostrarSolucionDoble(a, b);
        } else {
            mostrarSolucionesComplejas(a, b, discriminante);
        }
    }

    private static double calcularDiscriminante(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    private static void mostrarSolucionesReales(double a, double b, double discriminante) {
        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        System.out.println("Las soluciones son reales y diferentes:");
        System.out.printf("Solución 1 = %.2f%n", x1);
        System.out.printf("Solución 2 = %.2f%n", x2);
    }

    private static void mostrarSolucionDoble(double a, double b) {
        double x = -b / (2 * a);
        System.out.println("La solución es real y doble:");
        System.out.printf("x = %.2f%n", x);
    }

    private static void mostrarSolucionesComplejas(double a, double b, double discriminante) {
        double parteReal = -b / (2 * a);
        double parteImaginaria = Math.sqrt(-discriminante) / (2 * a);
        System.out.println("Las soluciones son complejas:");
        System.out.printf("Solución 1 = %.2f + %.2fi%n", parteReal, parteImaginaria);
        System.out.printf("Solución 2 = %.2f - %.2fi%n", parteReal, parteImaginaria);
    }
}
