package fp.ejercicio5;

import static fp.ejercicio5.Ejercicio5.Factorial.factorial;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Vera
 */
public class Ejercicio5 {

    public class Factorial {
        public static long factorial(int numero) {
            if (numero == 0) {
                return 1;
            }
            return numero * factorial(numero - 1);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);

            System.out.print("Introduce un número para saber su factorial: ");

            int numero = teclado.nextInt();

            if (numero < 0) {
                throw new InputMismatchException();
            }

            long resultado = factorial(numero);

            System.out.println(numero + "! = " + resultado);

        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un entero >= 0. Os numeros grandes darán valores erróneos");
        }
    }
}
