package fp.ejercicio6;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio6 {

    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            int signo = 1;

            System.out.print("Dividendo: ");
            int dividendo = teclado.nextInt();
            
            System.out.print("Divisor: ");
            int divisor = teclado.nextInt();
            
            if (divisor == 0) {
                throw new InputMismatchException("Non se pode dividir por 0");
            }

            System.out.print(dividendo + "/" + divisor + "=");

            if (dividendo < 0) {
                signo = -1;
                dividendo = -dividendo;
            }

            if (divisor < 0) {
                signo = signo * -1;
                divisor = -divisor;
            }

            int cociente = 0;
            while (dividendo >= divisor) {
                dividendo -= divisor;
                cociente = cociente + 1;
            }
            cociente = cociente * signo;

            System.out.println(cociente);

        } catch (InputMismatchException e) {
            System.out.println("Entrada de datos errónea");
            String message = e.getMessage();
            if (message != null) {
                System.out.println(message);
            }
        }
    }
}
