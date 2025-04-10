/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadedatos;

/**
 *
 * @author Joshue
 */
import capadeentidades.Membresia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*gola*/

public class MembresiaDAO {
   // Método para obtener los clientes con su membresía
   public List<Membresia> obtenerClientesConMembresia() {
    List<Membresia> lista = new ArrayList<>();
    String sql = "SELECT c.id, c.nombre, c.apellido, c.telefono, m.tipo, m.fecha_inicio, m.fecha_fin, m.estado " +
                 "FROM clientes c " +
                 "LEFT JOIN membresias m ON c.id = m.id_cliente";

    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Membresia m = new Membresia(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("telefono"),
                rs.getString("tipo"),
                rs.getDate("fecha_inicio"),
                rs.getDate("fecha_fin"),
                rs.getString("estado") // Aquí obtenemos el estado
            );
            lista.add(m);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener clientes con membresía: " + e.getMessage());
    }
    return lista;
}

    // Método para registrar una nueva membresía
    public boolean registrarMembresia(Membresia membresia) {
      String sql = "INSERT INTO membresias (id_cliente, tipo, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, membresia.getIdCliente());
        stmt.setString(2, membresia.getTipoMembresia());
        stmt.setDate(3, new java.sql.Date(membresia.getFechaInicio().getTime()));
        stmt.setDate(4, new java.sql.Date(membresia.getFechaVencimiento().getTime()));
        stmt.setString(5, membresia.getEstado());  // Aquí añadimos el estado

        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar membresía: " + e.getMessage());
        return false;
    }
    }
    public boolean existeMembresia(int idCliente) {
    String sql = "SELECT COUNT(*) FROM membresias WHERE id_cliente = ?";
    
    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, idCliente);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; // Si hay al menos una fila, significa que el cliente tiene una membresía
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar membresía: " + e.getMessage());
    }
    
    return false; // Si no existe membresía
}
    public boolean actualizarMembresia(Membresia membresia) {
    String sql = "UPDATE membresias SET tipo = ?, fecha_inicio = ?, fecha_fin = ?, estado = ? WHERE id_cliente = ?";
    
    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, membresia.getTipoMembresia());
        stmt.setDate(2, new java.sql.Date(membresia.getFechaInicio().getTime()));
        stmt.setDate(3, new java.sql.Date(membresia.getFechaVencimiento().getTime()));
        stmt.setString(4, membresia.getEstado());
        stmt.setInt(5, membresia.getIdCliente());
        
        return stmt.executeUpdate() > 0; // Devuelve true si se actualizó correctamente
    } catch (SQLException e) {
        System.out.println("Error al actualizar membresía: " + e.getMessage());
        return false;
    }
}

    // Método para registrar solo el estado de la membresía
    public boolean registrarEstado(int idCliente, String estado) {
         String sql = "UPDATE membresias SET estado = ? WHERE id_cliente = ?";

    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, estado);
        stmt.setInt(2, idCliente);

        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar estado: " + e.getMessage());
        return false;
    }
    }
    public boolean actualizarEstado(int idCliente, String estado) {
    String sql = "UPDATE membresias SET estado = ? WHERE id_cliente = ?";
    
    try (Connection conn = Conexion.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, estado);  // Asignar el estado (Activo/Inactivo)
        stmt.setInt(2, idCliente);   // Asignar el ID del cliente
        
        return stmt.executeUpdate() > 0; // Retorna true si la actualización fue exitosa
    } catch (SQLException e) {
        System.out.println("Error al actualizar estado: " + e.getMessage());
        return false;
    }
}


    // Método para cancelar una membresía (actualiza el estado a 'Inactivo')
    public boolean cancelarMembresia(int idCliente) {
        String sql = "UPDATE membresias SET estado = 'Inactivo' WHERE id_cliente = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al cancelar membresía: " + e.getMessage());
            return false;
        }
    }

    // Método para cambiar el estado de una membresía
    public boolean cambiarEstadoMembresia(int id, String nuevoEstado) {
        String sql = "UPDATE membresias SET estado = ? WHERE id = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al cambiar el estado de la membresía: " + e.getMessage());
            return false;
        }
    }
     // Método para obtener membresía por teléfono
    public Membresia buscarPorTelefono(String telefono) {
        Membresia membresia = null;

        String query = "SELECT m.id_cliente, c.nombre, c.apellido, c.telefono, m.tipo, m.fecha_inicio, m.fecha_fin, m.estado " +
                       "FROM membresias m " +
                       "INNER JOIN clientes c ON c.id = m.id_cliente " +
                       "WHERE c.telefono = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, telefono); // Se establece el teléfono como parámetro
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Si se encuentra el cliente, mapeamos los resultados a un objeto Membresia
                membresia = new Membresia(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("tipo"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin"),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return membresia;
    }
}