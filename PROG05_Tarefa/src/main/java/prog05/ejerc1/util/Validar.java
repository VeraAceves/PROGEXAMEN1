package prog05.ejerc1.util;

import java.time.LocalDate;

public class Validar {

    public static boolean compararFecha(LocalDate fechaMatricula) {
        return fechaMatricula.isBefore(LocalDate.now());
    }

    public static void validarDNI(String dni) throws Exception {
        Dni.validarNIF(dni);
    }

}
