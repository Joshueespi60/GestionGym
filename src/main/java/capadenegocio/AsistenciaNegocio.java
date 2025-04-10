/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadenegocio;

import capadeentidades.Asistencia;
import capadedatos.AsistenciaDAO;
import java.util.List;

public class AsistenciaNegocio {
    private AsistenciaDAO asistenciaDAO = new AsistenciaDAO();

    // Agregar una nueva asistencia
    public boolean agregarAsistencia(Asistencia asistencia) {
        return asistenciaDAO.agregarAsistencia(asistencia);
    }

    // Obtener todas las asistencias
    public List<Asistencia> obtenerAsistencias() {
        return asistenciaDAO.obtenerAsistencias();
    }
}
