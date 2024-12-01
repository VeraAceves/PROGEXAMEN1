package fp.ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        
        final int TOTALDENUMEROS = 7;
        int[] listaNumeros = new int[TOTALDENUMEROS];
        Scanner teclado = new Scanner(System.in);

        try {
            
            for (int index = 0; index < listaNumeros.length; index++) {
                System.out.printf("Numero %d de la lista?: ", (index + 1));
                listaNumeros[index] = Integer.parseInt(teclado.nextLine());
            }

            sort(listaNumeros);

            System.out.println("Secuencia Ordenada: ");
            for (int index = 0; index < listaNumeros.length; index++) {
                System.out.printf("%d ", listaNumeros[index]);
            }

        } catch (NumberFormatException e) {
            System.out.println("Debes introducir números enteros");
        }
    }

    static void sort(int[] numeros) {
        
        boolean ordenado = false;
        int fin_index =numeros.length - 2;
        
        for (int index = 0; (index <= fin_index) && (!ordenado); index++) {
            
            int fin_contador = numeros.length - 2 - index;
            ordenado = true;
            
            for (int contador = 0; contador <= fin_contador; contador++) {
                if (numeros[contador] > numeros[contador + 1]) {
                    int swap = numeros[contador];
                    numeros[contador] = numeros[contador + 1];
                    numeros[contador + 1] = swap;
                    ordenado = false;
                }
            }
        }
    }
}
