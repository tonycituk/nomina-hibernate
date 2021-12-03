package com.lemur.nomina.MVC.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double salario;
    private double numHorasTrabajadas;
    private double porcentajeCompensacion;

    public Administrador() {

    }

    public Administrador(String nombre, double salario, double numHorasTrabajadas, double porcentajeCompensacion) {
        //this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.numHorasTrabajadas = numHorasTrabajadas;
        this.porcentajeCompensacion = porcentajeCompensacion;
    }

    public double getNumHorasTrabajadas() {
        return numHorasTrabajadas;
    }

    public Administrador(String nombre, double numHorasTrabajadas, double tarifa) {
        //this.id = id;
        this.nombre = nombre;
        this.calcularSalario(numHorasTrabajadas, tarifa);
    }

    public Administrador(String nombre, double numHorasTrabajadas) {
        //this.id = id;
        this.nombre = nombre;
        this.calcularSalario(numHorasTrabajadas, 0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getPorcentajeCompensacion() {
        return porcentajeCompensacion;
    }

    public void setPorcentajeCompensacion(double porcentajeCompensacion) {
        this.porcentajeCompensacion = porcentajeCompensacion;
    }

    public void setNumHorasTrabajadas(double numHorasTrabajadas) {
        this.numHorasTrabajadas = numHorasTrabajadas;
    }

    public double calcularSalario(double numHorasTrabajadas, double tarifa) {
        if (numHorasTrabajadas >= 80) {
            this.porcentajeCompensacion = 0.3;
        } else {
            this.porcentajeCompensacion = 0.2;
        }
        this.numHorasTrabajadas = numHorasTrabajadas;
        this.salario = numHorasTrabajadas * (tarifa * (1 + this.porcentajeCompensacion));
        return this.salario;
    }

}
