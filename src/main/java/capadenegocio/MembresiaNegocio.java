/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadenegocio;

/**
 *
 * @author Joshue
 */
import capadedatos.MembresiaDAO;
import capadeentidades.Membresia;
import java.util.List;

public class MembresiaNegocio {
    private MembresiaDAO membresiaDAO = new MembresiaDAO();

    // Método para obtener todos los clientes con membresía
    public List<Membresia> obtenerClientesConMembresia() {
        return membresiaDAO.obtenerClientesConMembresia();
    }

   public boolean registrarMembresia(Membresia membresia) {
    if (membresiaDAO.existeMembresia(membresia.getIdCliente())) {
        // Si ya existe, actualizamos la membresía
        return membresiaDAO.actualizarMembresia(membresia);
    } else {
        // Si no existe, insertamos una nueva
        return membresiaDAO.registrarMembresia(membresia);
    }
}

    // Método para cancelar una membresía (puede poner estado 'Inactivo' o similar)
    public boolean cancelarMembresia(int idCliente) {
        return membresiaDAO.cancelarMembresia(idCliente);
    }

    // Método para cambiar el estado de una membresía
    public boolean cambiarEstadoMembresia(int id, String nuevoEstado) {
        return membresiaDAO.cambiarEstadoMembresia(id, nuevoEstado);
    }
public boolean registrarEstado(int idCliente, String estado) {
    return membresiaDAO.actualizarEstado(idCliente, estado); // Llama al método de la capa DAO
}

}
