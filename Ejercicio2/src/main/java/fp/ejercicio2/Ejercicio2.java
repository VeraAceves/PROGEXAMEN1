package fp.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    
    //Metodos de entrada para enteros, double y tiempo entero con excepciones

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

    public static double inputDouble(String title, double min, double max) throws InterruptedException {
        
        //Definimos las variables
        boolean valido = false;
        Scanner teclado = new Scanner(System.in);
        String line = null;
        double num = 0.0;

        do {
            try {
                System.out.print(title + " (s para cancelar): ");
                line = teclado.nextLine();
                num = Double.parseDouble(line);
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

    public static int inputTiempo(String title) throws InterruptedException {
        System.out.println(title);
        int horas = inputInteger("\tHoras: ", 0, 23);
        int minutos = inputInteger("\tMinutos: ", 0, 59);
        return horas * 60 + minutos;
    }

    //Metodo princilpal (llama a los metodos de entrada, hace los calculos y saca la salida
    public static void main(String[] args) {

        try {
            
            //Entrada de datos
            int totalKm = inputInteger("Introduce Total Km: ", 0, Integer.MAX_VALUE);
            double precioLitro = inputDouble("Introduce prezo en € por litro: ", 0, Double.MAX_VALUE);
            double dineroGastado = inputDouble("Introduce o gasto total en combustible en €: ", 0, Double.MAX_VALUE);
            int totalMinutos = inputTiempo("Introduce o tempo empregado: ");

            // Cálculos
            double consumoPorKm = dineroGastado / totalKm;
            double consumoLitrosPorKm = (dineroGastado / precioLitro) / totalKm;
            double consumoPor100Km = consumoPorKm * 100;
            double consumoLitrosPor100Km = consumoLitrosPorKm * 100;
            double velocidadKmPorMinuto = (float) totalKm / totalMinutos;
            double velocidadMPorSegundo = velocidadKmPorMinuto * 1000 / 60;
            double velocidadKmPorHora = velocidadKmPorMinuto * 60;

            //Salida formateada de datos
            System.out.printf("Consumo por Km: %.4f l/km\n", consumoLitrosPorKm);
            System.out.printf("Consumo cada 100 km %.4f l aos 100 km\n", consumoLitrosPor100Km);
            System.out.printf("O gasto por Km foi de %.4f, e por 100 km de %.4f\n", consumoPorKm, consumoPor100Km);
            System.out.printf("A velocidade media foi de %.4f km/h (%.4f m/s)\n", velocidadKmPorHora, velocidadMPorSegundo);

        } catch (InterruptedException e) {
            System.out.println("Operación Cancelada. Ejecute el programa de nuevo.");
        }

    }

}
