/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadeentidades;

public class Asistencia {
    private int id;
    private String nombre;
    private String telefono;
    private double pagoDiario;

    // Constructor
    public Asistencia(String nombre, String telefono, double pagoDiario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.pagoDiario = pagoDiario;
    }

    public Asistencia(int id, String nombre, String telefono, double pagoDiario) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pagoDiario = pagoDiario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getPagoDiario() {
        return pagoDiario;
    }

    public void setPagoDiario(double pagoDiario) {
        this.pagoDiario = pagoDiario;
    }
}
