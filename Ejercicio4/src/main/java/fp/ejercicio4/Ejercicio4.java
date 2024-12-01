package fp.ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

    //Metodo de entrada de datos enteros
    public static int inputInteger(String title, int min, int max) throws InterruptedException {

        boolean valido = false;
        Scanner teclado = new Scanner(System.in);
        String line = null;
        int num = 0;

        do {
            try {
                System.out.print(title + " (s para cancelar): ");
                line = teclado.nextLine();
                num = Integer.parseInt(line);
                if (num >= min && num <= max) {
                    valido = true;
                }

            } catch (NumberFormatException e) {
                if (line.equals("s")) {
                    throw new InterruptedException();
                }
            }
        } while (!valido);

        return num;
    }

    //Metodo principal
    public static void main(String[] args) {
        try {
            int base = inputInteger("Introduce la base", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int exponente = inputInteger("Introduce el exponente", Integer.MIN_VALUE, Integer.MAX_VALUE);

            System.out.printf("El resultado de %d^%d = ", base, exponente);

            double resultado = 1;

            if (exponente >= 0) {
                for (int i = 0; i < exponente; i++) {
                    resultado *= base;
                }
            } else {
                for (int i = 0; i < Math.abs(exponente); i++) {
                    resultado *= base;
                }
                resultado = 1 / resultado;
            }

            System.out.printf("%.8f\n", resultado);

        } catch (InterruptedException e) {
            System.out.println("Operación Cancelada. Ejecute el programa de nuevo.");
        }

    }
}
