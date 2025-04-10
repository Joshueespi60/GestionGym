/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadedatos;

import capadeentidades.Asistencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO {
    // Agregar una asistencia a la base de datos
    public boolean agregarAsistencia(Asistencia asistencia) {
        Connection con = Conexion.conectar();
        if (con != null) {
            String sql = "INSERT INTO asistencias (nombre, telefono, pago_diario) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, asistencia.getNombre());
                stmt.setString(2, asistencia.getTelefono());
                stmt.setDouble(3, asistencia.getPagoDiario());
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Obtener todas las asistencias desde la base de datos
    public List<Asistencia> obtenerAsistencias() {
        List<Asistencia> listaAsistencias = new ArrayList<>();
        Connection con = Conexion.conectar();
        if (con != null) {
            String sql = "SELECT * FROM asistencias";
            try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Asistencia asistencia = new Asistencia(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getDouble("pago_diario")
                    );
                    listaAsistencias.add(asistencia);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaAsistencias;
    }
}

