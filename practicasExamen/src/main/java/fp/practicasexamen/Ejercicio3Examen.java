/*
Dibuja el numero 155 y debe tener la altura que el usuario introduzca por teclado.
 */
package fp.practicasexamen;

import java.util.Scanner;

class Ejercicio3Examen {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce al altura(minimo 5):");
        int altura = Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce los espacios entre numeros");
        int espacio = Integer.parseInt(teclado.nextLine());
        
        int i = 0;
        int j = 0;
        
        for (i = 1; i <= altura; i++) {
            System.out.print("*");
            for (j = 1; j <= espacio; j++) {
                System.out.print(" ");
            }
            if ((i == 1) || (i == 3) || (i == altura)) {
                System.out.print("****");
            } else if (i == 2) {
                System.out.print("*   ");
            } else {
                System.out.print("   *");
            }
            for (j = 1; j <= espacio; j++) {
                System.out.print(" ");
            }
            if ((i == 1) || (i == 3) || (i == altura)) {
                System.out.print("****");
            } else if (i == 2) {
                System.out.print("*   ");
            } else {
                System.out.print("   *");
            }
            System.out.println();
        }

    }

}
