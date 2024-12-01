package fp.ejercicio10;

import java.util.Scanner;



public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String palabra;
        String sustituir;
        String sustituta;
        
        System.out.println("Escribe una palabra: ");
        palabra = teclado.nextLine();
        System.out.println(mayuscula(palabra));
        
        System.out.println("Escribe una palabra; ");
        palabra = teclado.nextLine();
        System.out.println("Escribe la palabra a sustituir ");
        sustituir = teclado.nextLine();
        System.out.println("Escribe el valor a poner");
        sustituta = teclado.nextLine();
        
        System.out.println(sustituye(palabra, sustituir, sustituta));
    }
    
    public static String mayuscula(String palabra){
        if(!palabra.isEmpty()) {
            char[] letras = palabra.toCharArray();
            letras[0] = Character.toUpperCase(letras[0]);
            palabra = new String(letras);
        }
        return palabra;
    }
    public static String sustituye (String palabra, String sustituir, String sustituta){
        if (sustituir.isEmpty()) return palabra;
        
        String resultado = "";
        int start = 0;
        int fidx = palabra.indexOf(sustituir);
        
        while(fidx!= -1) {
            resultado = resultado + palabra.substring(start, fidx) + sustituta;
            start = fidx + sustituir.length();
            fidx = palabra.indexOf(sustituir, start);
        }
        
        resultado = resultado + palabra.substring(start);
        return resultado;
    }
}