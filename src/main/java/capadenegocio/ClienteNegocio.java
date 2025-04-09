/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadenegocio;

import capadedatos.ClienteDAO;
import capadeentidades.Cliente;
import java.util.List;
/**
 *
 * @author Joshue
 */
public class ClienteNegocio {
    
    private ClienteDAO clienteDAO = new ClienteDAO();

    public boolean registrarCliente(Cliente cliente) {
        if (cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty()) {
            System.out.println("El nombre y apellido son obligatorios.");
            return false;
        }
        return clienteDAO.agregarCliente(cliente);
    }

    public boolean actualizarCliente(Cliente cliente) {
        return clienteDAO.editarCliente(cliente);
    }
    public Cliente obtenerClientePorId(int id) {
    return clienteDAO.obtenerClientePorId(id);
}

    public boolean eliminarCliente(int id) {
        return clienteDAO.eliminarCliente(id);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.obtenerClientes();
    }
    
}
