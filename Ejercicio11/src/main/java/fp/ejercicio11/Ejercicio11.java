package fp.ejercicio11;

import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.println("Dame un numero entero positivo: ");
            int numero = Integer.parseInt(teclado.nextLine());
            if (numero <= 0) {
                throw new NumberFormatException("Debe ser positivo");
            }

            if (esPrimo(numero)) {
                System.out.println("Es primo");
            } else {
                System.out.println("No es primo");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean esPrimo(int n) {
        boolean primo = true;
        int index = 2;

        while (index < n && primo) {
            primo = (n % index != 0);
            index++;
        }
        return primo;

    }
}
