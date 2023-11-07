/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author allil
 */
public class Perfil extends javax.swing.JFrame {
    private String id;
    /**
     * Creates new form Perfil
     */
     
    public Perfil(String id) {
        initComponents();
        this.setTitle("Perfil"); // Establece el título de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.id = id;  // Asigna el ID del usuario
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
        Icon iconVolver = setIcono("/img/devolver.png", 46, 41);
        btn_Volver.setIcon(iconVolver);
        Icon iconMPass = setIcono("/img/MPass.png", 27, 26);
        btn_MPass.setIcon(iconMPass);
        Icon iconCS = setIcono("/img/cerrar-sesion.png", 39, 39);
        btn_CS.setIcon(iconCS);
        Icon iconImg = setIcono("/img/foto.png", 140, 100);
        lbl_ImgUsuario.setIcon(iconImg);
        
        
        
       
           
        cargarDatosUsuario();  // Llama al método para cargar los datos del usuario

    }

    public void cargarDatosUsuario() {
    try {
        BufferedReader br = new BufferedReader(new FileReader("User.txt"));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length == 7 && datos[2].equals(id)) {  // Compara el ID del archivo con el ID del usuario
                String nom = datos[0];
                String ap = datos[1];
                txt_Nombre.setText(nom + " " + ap);
                txt_Correo.setText(datos[3]);
                txt_Id.setText(datos[2]);

                // Configura los campos de texto como no editables
                txt_Nombre.setEditable(false);
                txt_Id.setEditable(false);

                //configurar como editable
                txt_Correo.setText(datos[3]);
                txt_Contra.setText(datos[4]);
                
                break;  // Rompe el ciclo una vez que se encuentren los datos
            }
        }
        br.close(); // Cierra el archivo
    } catch (IOException e) {
        e.printStackTrace();
    }
}



    private Perfil() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_Correo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Contra = new javax.swing.JPasswordField();
        btn_CS = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_Volver = new javax.swing.JButton();
        btn_MPass = new javax.swing.JButton();
        lbl_ImgUsuario = new javax.swing.JLabel();
        btn_foto = new javax.swing.JButton();
        btn_EditarD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(55, 100, 121));
        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Correo:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Documento:");

        txt_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña:");

        btn_CS.setForeground(new java.awt.Color(255, 255, 255));
        btn_CS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CSActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("MIS DATOS");

        btn_Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/devolver.png"))); // NOI18N
        btn_Volver.setMaximumSize(new java.awt.Dimension(666, 628));
        btn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VolverActionPerformed(evt);
            }
        });

        btn_MPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MPass.png"))); // NOI18N
        btn_MPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MPassActionPerformed(evt);
            }
        });

        lbl_ImgUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/foto.png"))); // NOI18N
        lbl_ImgUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn_foto.setText("Actualizar foto");
        btn_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fotoActionPerformed(evt);
            }
        });

        btn_EditarD.setBackground(new java.awt.Color(55, 100, 121));
        btn_EditarD.setText("Editar datos");
        btn_EditarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txt_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_MPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_EditarD))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_CS, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_ImgUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_CS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addComponent(lbl_ImgUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_foto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_MPass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_EditarD)
                .addGap(49, 49, 49))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VolverActionPerformed
        String correo = txt_Correo.getText();
        String contra = new String(txt_Contra.getPassword());
        String tipoUsuario = obtenerTipoUsuario(correo, contra);
        String id = obtenerIdUsuarioDesdeArchivo(correo, contra);
        if (tipoUsuario != null) {
            if (tipoUsuario.equals("Docente")) {
                verificarDocente(correo, contra); 
                PDocente frame = new PDocente(id);
                frame.setVisible(true);
                this.setVisible(false);
                
            }else {
                if (tipoUsuario.equals("Estudiante")) {
                                verificarEstudiante(correo, contra);
                                PEstudiante frame = new PEstudiante(id);
                                frame.setVisible(true);
                                this.setVisible(false);
                            
                            }                 
            }
               
        }else{
            JOptionPane.showMessageDialog(this, "Inicio de sesión fallido. Verifique sus datos.");
        }
    }//GEN-LAST:event_btn_VolverActionPerformed

    private void btn_CSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CSActionPerformed
        Object[] options = {"Sí", "Cancelar"};
        int choice = JOptionPane.showOptionDialog(this, "¿Estás seguro de cerrar sesión?", "Confirmación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) { // El índice 0 corresponde a "Sí"
            Login newframe = new Login();
            newframe.setVisible(true);
            this.setVisible(false);
        } else if (choice == 1) { // El índice 1 corresponde a "Cancelar"
            // Realiza las acciones correspondientes si el usuario elige "Cancelar"
        }
    }//GEN-LAST:event_btn_CSActionPerformed

    private void txt_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdActionPerformed

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void btn_MPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MPassActionPerformed
         mostrarContrasena = !mostrarContrasena;
        mostrarOcultarContrasena();
    }//GEN-LAST:event_btn_MPassActionPerformed

    private void btn_EditarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarDActionPerformed
        EditarDatosDialog editarDialog = new EditarDatosDialog(Perfil.this, id);
        editarDialog.setVisible(true);
    }//GEN-LAST:event_btn_EditarDActionPerformed

    private void btn_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fotoActionPerformed
        String Ruta = "";
        JFileChooser jFileChooser = new JFileChooser();

        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
        jFileChooser.setFileFilter(filtrado);

        int respuesta = jFileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION){
            Ruta = jFileChooser.getSelectedFile().getPath();

            Image mImagen = new ImageIcon(Ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbl_ImgUsuario.getWidth(), lbl_ImgUsuario.getHeight(), Image.SCALE_SMOOTH));
            lbl_ImgUsuario.setText(null);
            lbl_ImgUsuario.setIcon(mIcono);
        }


    }//GEN-LAST:event_btn_fotoActionPerformed
    public String obtenerIdUsuarioDesdeArchivo(String correo, String contra) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                // Supongo que cada línea del archivo está en el formato "nombre;apellido;id;correo;contra;contra2;rol"
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[3].equals(correo) && datos[4].equals(contra)) {
                    br.close(); // Cierra el archivo
                    return datos[2]; // Retorna el ID del usuario
                }
            }
            br.close(); // Cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encuentra el usuario
    }
    private String obtenerTipoUsuario(String correo, String contra) {
    try {
        FileReader fr = new FileReader("User.txt");
        BufferedReader br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length == 7 && datos[3].equals(correo) && datos[4].equals(contra)) {
                
                br.close();
                return datos[6]; // Retorna el tipo de usuario   
            }
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null; // Si no se encuentra el usuario, retorna null
    }
    private boolean verificarDocente(String correo, String contra) {
        String tipoUsuario = obtenerTipoUsuario(correo, contra);

        try {
            if (tipoUsuario != null) {
                if (tipoUsuario.equals("Docente")) {
                    FileReader fr = new FileReader("Docente.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] datos = linea.split(";");
                        if (datos.length == 6 && datos[3].equals(correo) && datos[4].equals(contra)) {
                                JOptionPane.showMessageDialog(this, "Bienvenido(a), docente " + datos[0]);
                            br.close();
                            return true;
                        }
                    }
                    br.close();
                }
            }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        return false;
    }
    private boolean verificarEstudiante(String correo, String contra) {
        String tipoUsuario = obtenerTipoUsuario(correo, contra);
        try {
            if (tipoUsuario != null) {
                if (tipoUsuario.equals("Estudiante")) {
                
                FileReader fr = new FileReader("Estudiante.txt");
                BufferedReader br = new BufferedReader(fr);

                String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] datos = linea.split(";");
                        if (datos.length == 6 && datos[3].equals(correo) && datos[4].equals(contra)) {
                               JOptionPane.showMessageDialog(this, "Bienvenido(a), estudiante " + datos[0]);
                            br.close();
                            return true;

                        }
                    }
                br.close();
                }
            }
            } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Perfil Vframe = new Perfil();
                Vframe.setVisible(true);            }
        });
    }
    public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CS;
    private javax.swing.JButton btn_EditarD;
    private javax.swing.JButton btn_MPass;
    private javax.swing.JButton btn_Volver;
    private javax.swing.JButton btn_foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_ImgUsuario;
    private javax.swing.JPasswordField txt_Contra;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Nombre;
    // End of variables declaration//GEN-END:variables

private void labelcolor(JLabel label){
    label.setBackground(new java.awt.Color(53,162,107));
}

private void resetlabelcolor(JLabel label){
    label.setBackground(new java.awt.Color(54,70,78));

}

    private boolean mostrarContrasena = false;
    private void mostrarOcultarContrasena() {
        if (mostrarContrasena) {
                txt_Contra.setEchoChar((char) 0); // Mostrar contraseña
            } else {
                txt_Contra.setEchoChar('*'); // Ocultar contraseña (mostrar puntos)
                
            }    
    }

}
