
package Vista;

import BaseDatos.BaseDatos;
import Estructuras.Regata;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JFrame {
  DefaultTableModel modelo;
  BaseDatos BD;
  public boolean opcion = false;
    public Menu() {
        initComponents();
        setDefaultLookAndFeelDecorated(true);
        cargarCliente();
    }

    public final void cargarCliente(){
        String [] titulos ={"Id", "Class", "Race", "Scheduled Date", "Real Date", "Entries", "Area"};
        modelo = new DefaultTableModel(null, titulos);
        
        String [] fila = new String[titulos.length];
        BD = new BaseDatos();
        BD.initBD();
        
        int size = BD.getBD().size();
        
        for(int i = 0; i < size; ++i){
            Regata r = BD.getBD().get(i);
            fila[0] = ((Integer)r.getId()).toString();
            fila[1] = r.getClas();
            fila[2] = ((Integer)r.getRace()).toString();
            fila[3] = r.getScheduledDate().toString();
            fila[4] = r.getRealDate().toString();
            fila[5] = ((Integer)r.getEntries()).toString();
            fila[6] = r.getArea();
            modelo.addRow(fila);
            System.out.println(r.getId() + " " + r.getClas() + " " + r.getRace() + " " + r.getScheduledDate() + " " + r.getRealDate() + " " + r.getEntries() + " " + r.getArea());
        }
        /*for(Cliente c:lista){
            fila[0] = String.valueOf(c.getIdcliente());
            fila[1] = c.getNombre();
            fila[2] = c.getApellidos();
            fila[3] = c.getDni();
            fila[4] = c.getDireccion();
            modelo.addRow(fila);
     }*/
    jTable1.setModel(modelo);
    //jTable1.setPreferredScrollableViewportSize(new Dimension(500, 70));
}
    
    /*public void asignarEntradas(){
      cliente= new Cliente();
      cliente.setIdcliente(Integer.parseInt(lblIdCliente.getText()));
        cliente.setNombre(txtNombre.getText());
        cliente.setApellidos(txtApellidos.getText());
        cliente.setDni(txtDni.getText());
        cliente.setDireccion(txtDireccion.getText());
    }

    public void insertarCliente(){
        String rpta;
        asignarEntradas();
        rpta= clienteNE.insertarCliente(cliente);
        if(rpta == null){
            JOptionPane.showMessageDialog(null, "Cliente agregado con éxito");
        }else{
            JOptionPane.showMessageDialog(null, "Error en Ingreso" + rpta);
        }
    }
    public void codCliente(){
        Integer id = clienteNE.idCliente();
        lblIdCliente.setText(String.valueOf(id));
    }
    
    public void buscarCliente(Integer id){
        cliente = clienteNE.get(id);
        if(cliente.getIdcliente()!=null){
            lblIdCliente.setText(String.valueOf(cliente.getIdcliente()));
            txtNombre.setText(cliente.getNombre());
            txtApellidos.setText(cliente.getApellidos());
            txtDni.setText(cliente.getDni());
            txtDireccion.setText(cliente.getDireccion());
        }else{
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    }
    
    public void eliminarCliente(){
        Integer id= Integer.parseInt(lblIdCliente.getText());
        String rpta = clienteNE.detele(id);
        if(rpta==null){
            JOptionPane.showMessageDialog(null, "Cliente eliminado Ok");
        }else{
           JOptionPane.showMessageDialog(null, "Error al eliminar Cliente" + rpta); 
        }
    }
    
    public void actualizarCliente(){
        asignarEntradas();
        String rpta= clienteNE.update(cliente);
        if(null !=rpta){
           JOptionPane.showMessageDialog(null, "Error al Actualizar Cliente" + rpta); 
        }else{
            JOptionPane.showMessageDialog(null, "Cliente Actualizado Ok");
        }
    }*/
    
    /*public void limpiarEntradas(){
        lblIdCliente.setText(null);
        txtNombre.setText(null);
        txtApellidos.setText(null);
        txtDni.setText(null);
        txtDireccion.setText(null);
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso a Base de datos con Mysql");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1020, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Menu().setVisible(true);
            }
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
