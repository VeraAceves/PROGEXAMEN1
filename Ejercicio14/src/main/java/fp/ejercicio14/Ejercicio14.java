package fp.ejercicio14;

import java.util.Scanner;

public class Ejercicio14 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int contador = 0;
        int dividendo = 0;
        int divisor = 0;
        do {
            try {
                System.out.println("Dividendo: ");
                dividendo = Integer.parseInt(teclado.nextLine());
                
                System.out.println("Divisor; ");
                divisor = Integer.parseInt(teclado.nextLine());
                
                System.out.printf("La division entera de %d / %d tiene como cociente %d y como resto %s\n", dividendo, divisor, dividendo/divisor, dividendo%divisor);
                contador++;
           
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
            } catch (ArithmeticException e){
                System.out.println("No se puede dividir entre 0");
            }
        }while(dividendo != -1 || divisor != -1);
        System.out.println("Se realizaron " + contador + " divisiones");
    }
}


