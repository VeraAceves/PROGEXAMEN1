package fp.ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {

      Scanner teclado = new Scanner(System.in);
      
      double a;
      double b;
      double c;
   
      try {
         System.out.print("Valor de A: ");
         a = Double.parseDouble(teclado.nextLine());
      
         System.out.print("Valor de B: ");
         b = Double.parseDouble(teclado.nextLine());

         System.out.print("Valor de C: ");
         c = Double.parseDouble(teclado.nextLine());
 
         double[] solucion = resolverSegundoGrado(a, b, c);
         
         if (solucion == null)
            System.out.println("Sen solucións");
         else {
            for(int index = 0; index < solucion.length; index++) {
               System.out.printf("Solucion %d: %.4f\n",(index +1),solucion[index]);
            }
         }
      
      } catch(NumberFormatException e) {
         System.out.println("Debes introducir valores numéricos");
         
      } catch(Exception e) {
         System.out.println("Calquera valor de x e solución");
      }
   }
   
   public static double[] resolverSegundoGrado(double a, double b, double c) throws Exception {
      double[] solucion = null;
      
      if (a == 0) {
         if (b == 0) {
            if (c == 0) throw new Exception("Infinitas Soluciones");
         } else {
            solucion = new double[] {-c / b};
         }
      } else {
         double discriminante = b * b - 4 * a * c;
         if (discriminante >= 0) {
            if (discriminante == 0)
                solucion = new double[] {-b / 2 * a };
            else {
               discriminante = Math.sqrt(discriminante);
               solucion = new double[] {(-b + discriminante) / 2.0 * a, (-b - discriminante) / 2 * a};
            }
         }
      }
      return solucion;
    }
}

