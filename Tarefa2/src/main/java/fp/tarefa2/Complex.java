package fp.tarefa2;
/* 
Clase integramente creada por IA, estudiada después, matemáticas (desde 0) y la implementación en codigo.
Consta de un constructor (public Complex), con dos variables.
Los metodos sumar, restar, multiplicar y dividir(con excepcion en caso de que el denominador de 0)
Y el método toString que reescribe para personalizarlo.
*/
public class Complex {
    private double real, imaginario;

    public Complex(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public Complex sumar(Complex otro) {
        return new Complex(real + otro.real, imaginario + otro.imaginario);
    }

    public Complex restar(Complex otro) {
        return new Complex(real - otro.real, imaginario - otro.imaginario);
    }

    public Complex multiplicar(Complex otro) {
        return new Complex(real * otro.real - imaginario * otro.imaginario,
                           real * otro.imaginario + imaginario * otro.real);
    }

    public Complex dividir(Complex otro) {
        double denominador = otro.real * otro.real + otro.imaginario * otro.imaginario;
        if (denominador == 0) throw new ArithmeticException("División por cero");
        return new Complex((real * otro.real + imaginario * otro.imaginario) / denominador,
                           (imaginario * otro.real - real * otro.imaginario) / denominador);
    }

    //La funcion matematica saca el absoluto del imaginario y se le asigna el signo adecuado
    @Override
    public String toString() {
        return real + (imaginario >= 0 ? " + " : " - ") + Math.abs(imaginario) + "i";
    }
}
