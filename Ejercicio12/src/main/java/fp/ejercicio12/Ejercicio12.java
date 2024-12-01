package fp.ejercicio12;

import java.util.Scanner;

public class Ejercicio12 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num1, num2;

        try {
            System.out.println("Introduce el primer numero: ");
            num1 = Integer.parseInt(teclado.nextLine());

            System.out.println("Introduce el segundo numero: ");
            num2 = Integer.parseInt(teclado.nextLine());

            System.out.printf("El MCM de %d y %d es %d\n", num1, num2, mcm(num1, num2));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int mcm(int a, int b) {
        int mcm, min, max;

        if (a == 0 || b == 0) {
            throw new IllegalStateException("No se puede calcular si un ode los valores es 0");
        }

        a = Math.abs(a);
        b = Math.abs(b);

        max = a;
        min = b;

        if (b > a) {
            max = b;
            min = a;
        }

        mcm = max;

        while (mcm % min != 0) {
            mcm = mcm + max;
        }
        
        return mcm;
    }
}
