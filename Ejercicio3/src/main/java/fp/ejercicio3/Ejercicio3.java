package fp.ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    //Metodo de entrada de datos enteros
    public static int inputInteger(String title, int min, int max) throws InterruptedException {

        //Definimos e inicializamos las variables
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

    //Metodo principal, llama a la entrada y saca la salida formateada con los calculos
    public static void main(String[] args) {

        try {
            
            int numero = inputInteger("Introduce un numero entre 1 e 9", 1, 9);
            System.out.printf("Tabla del %d\n-----------\n", numero);
            
            for (int valor = 1; valor <= 10; valor = valor + 1) {
                System.out.printf("%d * %d = %d\n", numero, valor, numero * valor);
            }
            
        } catch (InterruptedException e) {
            System.out.println("Operación cancelada. Ejecute el programa de nuevo");
        }

    }
}
