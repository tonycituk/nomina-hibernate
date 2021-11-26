package com.lemur.nomina.MVC.Model;

public class Administrador extends Empleado {
    private double porcentajeCompensacion;


    public Administrador(int id, String nombre, double numHorasTrabajadas, double tarifa) {
        super(id, nombre, numHorasTrabajadas);
        this.calcularSalario((int) numHorasTrabajadas, tarifa);
    }

    public double getPorcentajeCompensacion() {
        return porcentajeCompensacion;
    }

    public void setPorcentajeCompensacion(double porcentajeCompensacion) {
        this.porcentajeCompensacion = porcentajeCompensacion;
    }

    @Override
    public double calcularSalario(int numHorasTrabajadas, double tarifa) {
        if (numHorasTrabajadas >= 80) {
            this.porcentajeCompensacion = 0.3;
        } else {
            this.porcentajeCompensacion = 0.2;
        }
        super.setNumHorasTrabajadas(numHorasTrabajadas);
        return super.calcularSalario(numHorasTrabajadas, tarifa * (1 + this.porcentajeCompensacion));
    }

    @Override
    public String toString() {
        return super.toString() + "\nPorcentaje Compensación: " + this.porcentajeCompensacion;
    }
}