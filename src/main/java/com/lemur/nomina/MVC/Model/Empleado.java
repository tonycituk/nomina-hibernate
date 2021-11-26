package com.lemur.nomina.MVC.Model;

public class Empleado implements Comparable<Empleado>{
    private int id;
    private String nombre;
    private double salario;
    private double numHorasTrabajadas;

    public Empleado(int id, String nombre, double numHorasTrabajadas) {
        this.id = id;
        this.nombre = nombre;
        this.numHorasTrabajadas = numHorasTrabajadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;

    }

    public void setNumHorasTrabajadas(double numHorasTrabajadas) {
        this.numHorasTrabajadas = numHorasTrabajadas;
    }

    public double getNumHorasTrabajadas() {
        return this.numHorasTrabajadas;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nSalario: " + this.salario;
    }

    public double calcularSalario(int numHorasTrabajadas, double tarifa) {
        this.salario = numHorasTrabajadas * tarifa;
        return this.salario;
    }
    public int compareTo(Empleado aEmpleado){
        if(this.getClass() == Administrador.class){
            if(aEmpleado instanceof Administrador){
                return Double.compare(aEmpleado.getSalario(), this.getSalario());
            }
            else {
                return -1;
            }
        }
        else{
            if(aEmpleado instanceof Jornalero){
                return Double.compare(aEmpleado.getSalario(), this.getSalario());
            }
            else {
                return 1;
            }
        }
    }
}