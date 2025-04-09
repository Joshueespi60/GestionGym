/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadeinterfaz;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
/**
 *
 * @author Joshue
 */
public class BotonUtils {
    // Método para cargar la imagen en un botón
    public static void cargarImagenEnBoton(String rutaRecurso, JButton boton, int ancho, int alto) {
        try {
            // Cargar la imagen desde el recurso
            InputStream inputStream = BotonUtils.class.getClassLoader().getResourceAsStream(rutaRecurso);
            
            if (inputStream != null) {
                // Cargar la imagen desde el InputStream
                ImageIcon icono = new ImageIcon(ImageIO.read(inputStream));
                
                // Ajustar la imagen al tamaño deseado
                Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    
                // Asignar la imagen al botón
                boton.setIcon(new ImageIcon(imagen));
    
                System.out.println("✅ Imagen cargada con éxito en el botón " + boton.getText());
            } else {
                System.out.println("❌ Error: No se encontró el recurso " + rutaRecurso);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error al cargar la imagen en el botón.");
        }
    }
    
    // Método para eliminar borde, fondo y enfoque del botón
    public static void configurarBotonSinBorde(JButton boton) {
        boton.setBorderPainted(false); // Elimina el borde
        boton.setContentAreaFilled(false); // Elimina el fondo
        boton.setFocusPainted(false); // Elimina el borde de enfoque
    }
    
    // Método para ajustar la posición y tamaño del botón
    public static void configurarBoton(JButton boton, int x, int y, int ancho, int alto) {
        boton.setBounds(x, y, ancho, alto);
    }
}
