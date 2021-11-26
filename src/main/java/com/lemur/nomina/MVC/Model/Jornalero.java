package com.lemur.nomina.MVC.Model;

public class Jornalero extends Empleado {

    private double numHorasExtras;

   

    Jornalero(int id, String nombre, double numHorasTrabajadas, double tarifa) {
        super(id, nombre, numHorasTrabajadas);
        this.calcularSalario((int) numHorasTrabajadas, tarifa);
    }

    public double getNumHorasExtras() {
        return numHorasExtras;
    }

    public void setNumHorasExtras(double numHorasExtras) {
        this.numHorasExtras = numHorasExtras;
    }

    public double calcularSalario(int numHorasTrabajadas, double tarifa) {
        super.setNumHorasTrabajadas(numHorasTrabajadas);
        int numHorasExtras = 0;
        if (this.getNumHorasTrabajadas() > 80) {
            numHorasExtras = (int) this.getNumHorasTrabajadas() - 80;
        }
        this.numHorasExtras = numHorasExtras;
        return super.calcularSalario(numHorasTrabajadas + 2 * numHorasExtras, tarifa);
    }
    @Override
    public String toString() {
        return super.toString() + "\nHoras extra: " + this.numHorasExtras;
    }
}