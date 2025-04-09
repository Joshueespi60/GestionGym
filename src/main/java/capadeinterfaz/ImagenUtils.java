/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadeinterfaz;

import java.awt.Image;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImagenUtils {

    // Método estático para cargar imagen en un JLabel con coordenadas y tamaño
    public static void cargarImagenEnJLabel(String rutaRecurso, JLabel label, int ancho, int alto, int x, int y) {
        try {
            // Cargar la imagen desde el recurso
            InputStream inputStream = ImagenUtils.class.getClassLoader().getResourceAsStream(rutaRecurso);

            if (inputStream != null) {
                // Cargar la imagen desde el InputStream
                ImageIcon icono = new ImageIcon(ImageIO.read(inputStream));

                // Ajustar la imagen al tamaño deseado
                Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

                // Asignar la imagen al JLabel
                label.setIcon(new ImageIcon(imagen));

                // Establecer las coordenadas y tamaño del JLabel
                label.setBounds(x, y, ancho, alto);  // Esto establece tanto la posición como el tamaño de la imagen en el JLabel

                System.out.println("✅ Imagen cargada con éxito en " + label.getText());
            } else {
                System.out.println("❌ Error: No se encontró el recurso " + rutaRecurso);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error al cargar la imagen.");
        }
    }
}




