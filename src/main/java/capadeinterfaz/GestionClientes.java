/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package capadeinterfaz;

import capadeentidades.Cliente;
import capadenegocio.ClienteNegocio;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Joshue
 */
public class GestionClientes extends javax.swing.JFrame {
    
    private ClienteNegocio clienteNegocio = new ClienteNegocio();
    private MenuPrincipal menuPrincipal;
    
    /**
     * Creates new form GestionClientes
     */
    public GestionClientes(MenuPrincipal menu) {
        
        initComponents();
         this.menuPrincipal = menu;
        cargarClientes();
    }
    private void cargarClientes() {
        List<Cliente> clientes = clienteNegocio.listarClientes();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getCorreo()});
        }
    }

    private void agregarCliente() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();

        Cliente cliente = new Cliente(0, nombre, apellido, telefono, correo);
        if (clienteNegocio.registrarCliente(cliente)) {
            JOptionPane.showMessageDialog(this, "Cliente agregado correctamente");
            cargarClientes();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar cliente");
        }
    }

    private void editarCliente() {
       int fila = jTable1.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente para editar");
        return;
    }

    // Obtener el ID del cliente seleccionado
    int id = (int) jTable1.getValueAt(fila, 0);

    // Obtener los datos actuales del cliente desde la base de datos
    Cliente clienteActual = clienteNegocio.obtenerClientePorId(id); // Nueva función para obtener el cliente por ID

    // Si los campos están vacíos, conservar los valores actuales
    String nombre = txtNombre.getText().isEmpty() ? clienteActual.getNombre() : txtNombre.getText();
    String apellido = txtApellido.getText().isEmpty() ? clienteActual.getApellido() : txtApellido.getText();
    String telefono = txtTelefono.getText().isEmpty() ? clienteActual.getTelefono() : txtTelefono.getText();
    String correo = txtCorreo.getText().isEmpty() ? clienteActual.getCorreo() : txtCorreo.getText();

    Cliente cliente = new Cliente(id, nombre, apellido, telefono, correo);

    if (clienteNegocio.actualizarCliente(cliente)) {
        JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente");
        cargarClientes();
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar cliente");
    }
    }

    private void eliminarCliente() {
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente para eliminar");
            return;
        }

        int id = (int) jTable1.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (clienteNegocio.eliminarCliente(id)) {
                JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
                cargarClientes();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar cliente");
            }
        }
    }

    private void buscarCliente() {
        String input = JOptionPane.showInputDialog(this, "Ingrese ID, Nombre o 'todos':");
    
         if (input == null || input.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un criterio de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
         model.setRowCount(0); // Limpiar la tabla antes de mostrar resultados

         List<Cliente> clientes = clienteNegocio.listarClientes();
    
         if (input.equalsIgnoreCase("todos")) { 
        // Mostrar todos los clientes
        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{
                cliente.getId(), cliente.getNombre(), cliente.getApellido(), 
                cliente.getTelefono(), cliente.getCorreo()
            });
        }
        } else if (input.matches("\\d+")) { 
        // Buscar por ID (si el input es un número)
        int idBuscado = Integer.parseInt(input);
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idBuscado) {
                model.addRow(new Object[]{
                    cliente.getId(), cliente.getNombre(), cliente.getApellido(), 
                    cliente.getTelefono(), cliente.getCorreo()
                });
                return; // Si encuentra el cliente, se detiene
            }
        }
        JOptionPane.showMessageDialog(this, "No se encontró un cliente con ese ID.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
        } else { 
        // Buscar por Nombre
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().toLowerCase().contains(input.toLowerCase())) {
                model.addRow(new Object[]{
                    cliente.getId(), cliente.getNombre(), cliente.getApellido(), 
                    cliente.getTelefono(), cliente.getCorreo()
                });
                encontrado = true;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontraron clientes con ese nombre.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
        }
         }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        tblClientes = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setText("GESTION DE CLIENTES");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setText("APELLIDO:");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setText("CELULAR:");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setText("CORREO:");

        btnAgregar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "TELEFONO", "CORREO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(tblClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2)
                        .addGap(383, 383, 383)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel3)
                        .addGap(374, 374, 374)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnAgregar)
                        .addGap(45, 45, 45)
                        .addComponent(btnEditar)
                        .addGap(45, 45, 45)
                        .addComponent(btnEliminar)
                        .addGap(36, 36, 36)
                        .addComponent(btnBuscar)
                        .addGap(74, 74, 74)
                        .addComponent(btnVolver)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tblClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnBuscar)
                    .addComponent(btnVolver))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregarCliente();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        editarCliente();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarCliente();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarCliente();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
         this.dispose(); // Cierra GestionMembresias
         if (menuPrincipal != null) {
        menuPrincipal.setVisible(true); // Vuelve al menú original
    }//GEN-LAST:event_btnVolverActionPerformed
} 
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane tblClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
