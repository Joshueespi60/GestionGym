/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadeentidades;

import java.util.Date;

/**
 *
 * @author Joshue
 */
public class Membresia {
    private int idCliente;  // El id del cliente
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoMembresia;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private String estado; // Agregar el estado

    // Constructor con estado
    public Membresia(int idCliente, String nombre, String apellido, String telefono, String tipoMembresia, Date fechaInicio, Date fechaVencimiento, String estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipoMembresia = tipoMembresia;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado; // Inicializar estado
    }

    // Constructor sin estado (para cuando el estado se agrega después)
    public Membresia(int idCliente, String tipoMembresia, Date fechaInicio, Date fechaVencimiento, String estado) {
        this.idCliente = idCliente;
        this.tipoMembresia = tipoMembresia;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    // Getters y setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // Agregamos el método getId() que retorna el idCliente
    public int getId() {
        return idCliente;  // Devolvemos el idCliente como el identificador
    }

    // Otros getters y setters
    public int getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getTipoMembresia() { return tipoMembresia; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaVencimiento() { return fechaVencimiento; }
}


