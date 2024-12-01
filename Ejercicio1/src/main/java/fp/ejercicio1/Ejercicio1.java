package fp.ejercicio1;

import java.util.Scanner;
import java.util.InputMismatchException;
import static java.lang.Math.PI;


public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        double radio;
        double area;
        double longitud;
        double superficie;
        double volumen;

        try {
            System.out.print("Introduce o radio en cm (debe ser positivo): ");
            radio = teclado.nextDouble();
            
            if (radio <= 0) {
                throw new InputMismatchException();
            }

            area = 2 * PI * radio;
            longitud = PI * radio * radio;
            volumen = 4 * PI * radio * radio * radio / 3;
            superficie = 4 * PI * radio * radio;

            System.out.printf("O Area do círculo é %.4f\n", area);
            System.out.printf("A Lonxitude da circunferencia é %.4f\n", longitud);
            System.out.printf("O Volume da esfera é %.4f\n", volumen);
            System.out.printf("A Superficie da esfera é %.4f\n", superficie);
            
        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un valor numérico > 0 usando a coma decimal");
        }

    }
}
