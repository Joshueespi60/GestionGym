package capadenegocio;

import capadedatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase de la capa de negocio para validar usuarios
 */
public class UsuarioNegocio {

    public boolean validarUsuario(String usuario, String password) {
        boolean esValido = false;

        try (Connection con = Conexion.conectar()) {
            String query = "SELECT password FROM usuarios WHERE usuario = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String passwordEncriptada = rs.getString("password");
                if (passwordEncriptada.equals(encriptarSHA256(password))) {
                    esValido = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en validación: " + e.getMessage());
        }
        
        return esValido;
    }

    // Método para encriptar la contraseña con SHA-256
    private String encriptarSHA256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

