package prog05.ejerc1;

import java.time.LocalDate;
import java.time.Period;

public class Vehiculo {

    String marca, matricula, descripcion, nombrePropietario, dniPropietario;
    int numKms, precio;
    LocalDate fechaMatricula;

    public Vehiculo(String marca, String matricula, String descripcion, String nombrePropietario, String dniPropietario, int numKms, int precio, LocalDate fechaMatricula) {
        this.marca = marca;
        this.matricula = matricula;
        this.descripcion = descripcion;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
        this.numKms = numKms;
        this.precio = precio;
        this.fechaMatricula = fechaMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public int getNumKms() {
        return numKms;
    }

    public void setNumKms(int numKms) {
        this.numKms = numKms;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public int getAnhos() {
        LocalDate hoy = LocalDate.now();
        return (Period.between(this.fechaMatricula, hoy).getYears());
    }

    public void actualizarKms(int nuevosKms) {
        this.numKms = this.numKms + nuevosKms;
    }

}
