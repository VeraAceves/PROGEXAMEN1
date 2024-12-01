package fp.tarefa2;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
He necesitado mucha ayuda para este ejercicio, por eso tiene tantas anotaciones.
La clase Tarefa2 se encarga de la interacción con el usuario y utiliza la clase Complex para los calculos.
Consta de dos metodos; main (que contiene el menu) y leerComplejo (para la entrada de datos).

*/
public class Tarefa2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Complex complejo1, complejo2, resultado;/*
            Son instancias de la clase Complex, tipo de dato personalizado (complejo)
            La var resultado contendrá un objeto Complex, y su método toString se llamará automáticamente para mostrarlo de forma legible
            */
        while (true) {
            int opcion = 0;// Se inicializa para almacenar la opción seleccionada por el usuario en el menú

            // Control de excepciones para la selección del menú con try-catch
            while (true) {
                try {
                    System.out.print("\nSeleccione operación \n(Sumar: 1, Restar: 2, Multiplicar: 3, Dividir: 4, Salir: 5): ");
                    opcion = scanner.nextInt();
                    if (opcion < 1 || opcion > 5) {
                        System.out.println("Opción no válida. Intente de nuevo.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Introduzca un número entre 1 y 5.");
                    scanner.next();
                }
            }

            if (opcion == 5) break;//salir del bucle

            // Leer números complejos con control de excepciones
            complejo1 = leerComplejo(scanner, "primero");
            complejo2 = leerComplejo(scanner, "segundo");

            try {
                resultado = switch (opcion) {//Dependiendo de la opción seleccionada, llama al método correspondiente de la clase Complex
                    case 1 -> complejo1.sumar(complejo2);
                    case 2 -> complejo1.restar(complejo2);
                    case 3 -> complejo1.multiplicar(complejo2);
                    case 4 -> complejo1.dividir(complejo2);
                    default -> throw new IllegalStateException("Opción no válida");
                };
                System.out.println("Resultado: " + resultado);
            } catch (ArithmeticException e) {
                System.out.println("Error en la operación: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // Método para leer números complejos con control de excepciones
    private static Complex leerComplejo(Scanner scanner, String orden) {
        double real = 0, imaginario = 0;
        boolean inputCorrecto;

        // Control de excepciones para capturar parte real
        //El bucle do-while nos asegura que se ejecute al menos una vez y seguirá repitiéndose hasta que inputCorrecto sea true
        do {
            inputCorrecto = true;
            try {
                System.out.print("Ingrese parte real del " + orden + " número complejo: ");//orden es un parametro que indica la var primero o segundo
                real = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Introduzca un número.");
                scanner.next();
                inputCorrecto = false;
            }
        } while (!inputCorrecto);

        // Control de excepciones para capturar parte imaginaria
        do {
            inputCorrecto = true;
            try {
                System.out.print("Ingrese parte imaginaria del " + orden + " número complejo: ");
                imaginario = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Introduzca un número.");
                scanner.next();
                inputCorrecto = false;
            }
        } while (!inputCorrecto);

        return new Complex(real, imaginario);//Nueva instancia de la clase Complex (nuevo objeto) utilizando las partes real e imaginaria que se han leído correctamente
    }
}
