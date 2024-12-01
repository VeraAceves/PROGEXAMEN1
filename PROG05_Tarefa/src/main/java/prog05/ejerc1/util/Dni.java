package prog05.ejerc1.util;

public class Dni {

    private int numDNI;

    private static final String LETRASDNI = "ASDGSFDLJPOWUIETUWYEBVCNBV";

    private static char calcularLetraNIF(int dni) {
        char letra;
        letra = LETRASDNI.charAt(dni % 23);
        return letra;
    }

    private static char extraerLetraNIF(String nif) {
        char letra = nif.charAt(nif.length() - 1);
        return letra;
    }

    private static int extraerNumeroNIF(String nif) {
        
        int numero = Integer.parseInt(nif.substring(0, nif.length() -1));
        
        return numero;
    }

    public static boolean validarNIF(String nif) throws Exception {
        boolean valido = true;
        char letraCalculada, letraLeida;
        int dniLeido;

        if (nif == null) {
            valido = false;
        } else if (nif.length()< 8 || nif.length() > 9) {
            valido = false;
        } else {
            letraLeida = Dni.extraerLetraNIF(nif);
            dniLeido = Dni.extraerNumeroNIF(nif);
            letraCalculada = Dni.calcularLetraNIF(dniLeido);

            if (letraLeida != letraCalculada) {

                throw new Exception("dni invalido ");
            }

        }

        return valido;
    }
}
