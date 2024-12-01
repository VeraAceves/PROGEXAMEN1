
package fp.ejercicio9;

import java.util.Scanner;


public class Ejercicio9 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int precision;
        try {
            System.out.println("Precision (1-20: : ");
            precision = Integer.parseInt(teclado.nextLine());
            if (precision<1 || precision>20) throw new NumberFormatException();

            double e = calcularE(precision);

            System.out.printf("El numero e con una precision de %d é %.8f\n", precision, e);
        } catch(NumberFormatException e) {
                System.out.println("Debes introducir un numero entero entre 1 y 10");
        }
    }
    
    static double calcularE(int precision) {
        double v = 1;
        
        for(int index = 1; index<=precision; index++) {
            v = v+1/factorial(index);
        }
        return v;
    }
    
    static double factorial(int n) {
        if (n == 0) return 1;
        else return n*factorial(n-1);
    }








}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    