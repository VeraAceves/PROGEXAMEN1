package prog05.ejerc1;

import java.util.Scanner;
import java.time.LocalDate;
import prog05.ejerc1.util.Validar;

public class Principal {

    static Scanner teclado = new Scanner(System.in);

    public static int mostrarMenu() {
        System.out.println("Gestión de vehículo");
        System.out.println("1. Nuevo vehículo");
        System.out.println("2. Ver matrícula");
        System.out.println("3. Ver km");
        System.out.println("4. Actualizar km");
        System.out.println("5. Ver antigüedad");
        System.out.println("6. Mostrar propietario");
        System.out.println("7. Mostrar descripción");
        System.out.println("8. Mostrar el precio");
        System.out.println("9. Salir");

        int opcion = teclado.nextInt();
        teclado.nextLine();
        return opcion;
    }

    public static void main(String[] args) {
        int opcion;
        String marca, matricula, descripcion, propietario, dniPropietario;
        int numKms, precio;
        int diaMatricula, mesMatricula, anhoMatricula;
        LocalDate fechaMatricula;
        boolean valido = true;

        Vehiculo objVehiculo = null;
        do {
            opcion = mostrarMenu();

            switch (opcion) {

                //Nuevo vehiculo
                case 1:
                    System.out.println("Introduce la marca del vehículo");
                    marca = teclado.nextLine();

                    System.out.println("Introduce la matrícula del vehículo");
                    matricula = teclado.nextLine();

                    System.out.println("Introduce la descripción del vehículo");
                    descripcion = teclado.nextLine();

                    System.out.println("Introduce el número de kilómetros del vehículo");
                    numKms = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Introduce el precio del vehículo");
                    precio = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Introduce el propietario del vehículo");
                    propietario = teclado.nextLine();

                    System.out.println("Introduce el dni propietario del vehículo");
                    dniPropietario = teclado.nextLine();

                    System.out.println("Introduce el dia de matriculacion");
                    diaMatricula = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Introduce el mes de matriculacion");
                    mesMatricula = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Introduce el año de matriculacion");
                    anhoMatricula = teclado.nextInt();
                    teclado.nextLine();

                    fechaMatricula = LocalDate.of(anhoMatricula, mesMatricula, diaMatricula);

                    if (!Validar.compararFecha(fechaMatricula)) {
                        valido = false;
                        System.out.println("Los datos de la fecha de la matricula no son correctos");
                    }

                    if (numKms <= 0) {
                        valido = false;
                        System.out.println("El numero de km es incorrecto");
                    }

                    try {
                        Validar.validarDNI(dniPropietario);
                    } catch (Exception e) {
                        valido = false;
                        System.out.println("El formato del DNI no es correcto");
                    }

                    if (valido) {
                        objVehiculo = new Vehiculo(marca, matricula, descripcion, nombrePropietario, dniPropietario, numKms, precio, fechaMatricula);
                        System.out.println("El vehiculo ha sido creado");
                    }

                    break;

                //Ver matricula    
                case 2:
                    if (objVehiculo != null) {
                        System.out.println("La matrícula del vehículo es: " + objVehiculo.getMatricula());
                    } else {
                        System.out.println("El vehículo no existe");
                    }
                    break;

                //Ver Km
                case 3:
                    if (objVehiculo != null) {
                        System.out.println("El vehiculo tiene: " + objVehiculo.getNumKms() + "Km");
                    } else {
                        System.out.println("El vehículo no existe");
                    }
                    break;

                //Actualizar km
                case 4:
                    if (objVehiculo != null) {
                        System.out.println("El vehiculo tiene: " + objVehiculo.getAnhos() + "años");
                    } else {
                        System.out.println("El vehículo no existe");
                    }
                    break;

                //Antigüedad
                case 5:
                    if (objVehiculo != null) {
                        System.out.println("El vehiculo tiene: " + objVehiculo.getAnhos() + "años");
                    } else {
                        System.out.println("El vehículo no existe");
                    }

                //Propietario
                case 6:
                    if (objVehiculo != null) {
                        System.out.println("La propietario del vehiculo es: " + objVehiculo.getNombrePropietario() + ", con DNI " + objVehiculo.getDniPropietario());
                    } else {
                        System.out.println("El vehículo no existe");
                    }

                //Descripcion
                case 7:
                    if (objVehiculo != null) {
                        System.out.println("La descripcion del vehiculo es: " + objVehiculo.getDescripcion() + ", con DNI " + objVehiculo.getDniPropietario());
                    } else {
                        System.out.println("El vehículo no existe");
                    }

                //Precio
                case 8:
                    if (objVehiculo != null) {
                        System.out.println("El precio del vehículo es: " + objVehiculo.getPrecio() + "€");
                    } else {
                        System.out.println("El vehículo no existe");
                    }

                //Salir
                case 9:
                     {
                        System.out.println("See you later, alligator");
                        break;
                    }

            }

        } while (opcion != 9);
    }
}
