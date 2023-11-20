/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author allil
 */
public class PDocente extends javax.swing.JFrame {
    private String id;
    private JLabel mensajeLabel;
    private Timer timer;
    private String[] mensajes = {
       "Un buen maestro puede inspirar esperanza, despertar la imaginación e inculcar el amor por el aprendizaje.\" - Brad Henry",
        "La enseñanza es la profesión que crea todas las demás profesiones.\" - Desconocido",
        "El objetivo de la educación es reemplazar una mente vacía por una mente abierta.\" - Malcolm Forbes",
        "Un maestro afecta la eternidad; nunca se puede decir dónde termina su influencia.\" - Henry Adams",
        "La educación no es llenar un cubo, sino encender un fuego.\" - William Butler Yeats",
        "El mayor signo de éxito para un maestro es poder decir: 'Los niños están trabajando como si yo no existiera'.\" - Maria Montessori",
        "La paciencia y la perseverancia tienen un efecto mágico antes el cual las dificultades desaparecen y los obstáculos se desvanecen.\" - John Quincy Adams",
        "El aula debe ser un escenario donde los sueños cobran vida.\" - Oprah Winfrey",
        "La educación es el pasaporte hacia el futuro, el mañana pertenece a aquellos que se preparan para él hoy.\" - Malcolm X",
        "Enseñar no es transferir conocimiento, sino crear las posibilidades para su propia producción o construcción.\" - Paulo Freire",
        "El educador no es el que provee la información, sino el que despierta la inteligencia en el estudiante.\" - Albert Einstein",
        "Ser un docente significa ser el arquitecto del futuro.\" - Sócrates" 
    };
    private int mensajeActual;
    /**
     * Creates new form PDocente
     */
    public PDocente(String id) {
        initComponents();
        this.setResizable(false); // Hace que la ventana no sea redimensionable
        this.setLocationRelativeTo(null);//para que la interfaz aparezca en el centro
        this.setTitle("Ventana Docente"); // Establece el título de la ventana
        this.id = id;  // Asigna el ID del usuario
        
        // Crea un JLabel para mostrar los mensajes
        mensajeLabel = new JLabel();
        jPanel4.add(mensajeLabel); // Agrega el JLabel al jPanel2

          // Para el botón lblPerfil2
        Icon iconPerfil = setIcono("/img/usuario.png", 39, 39);
        btnPerfil1.setIcon(iconPerfil);

        // Para el botón lblCurso
        Icon iconCurso = setIcono("/img/curso2.png", 41, 41);
        btn_Curso.setIcon(iconCurso);
        
        
         // Para el botón lblCG
        Icon iconContenido = setIcono("/img/cg.png", 39, 39);
        btnCD.setIcon(iconContenido);
        
        Icon iconTarea = setIcono("/img/ok.png", 39, 39);
        btn_TA.setIcon(iconTarea);
        
        
        
        // Configura un temporizador para cambiar los mensajes cada 5 segundos
        timer = new Timer(6000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarMensaje();
            }
        });
        timer.start();
         // Cargar una imagen como icono desde el paquete "img" y establecerla en la ventana
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
    }

    private PDocente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void cambiarMensaje() {
    jLabel1.setText(StrToHtml(mensajes[mensajeActual]));
    mensajeActual = (mensajeActual + 1) % mensajes.length;
    
    }
    public String StrToHtml(String mensajes){
        return "<html><p>" + mensajes + "</p><html>";
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btn_Curso = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblmenu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPerfil1 = new javax.swing.JButton();
        btnCD = new javax.swing.JButton();
        btn_TA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        btn_Curso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/curso2.png"))); // NOI18N
        btn_Curso.setText("Cursos");
        btn_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CursoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        lblmenu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblmenu.setForeground(new java.awt.Color(255, 255, 255));
        lblmenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmenu.setText("Matemática Interactiva");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 100, 121));
        jLabel1.setText("Bienvenidos a Funny Math");
        jLabel1.setMaximumSize(new java.awt.Dimension(564, 16));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPerfil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        btnPerfil1.setText("Perfil ");
        btnPerfil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfil1ActionPerformed(evt);
            }
        });

        btnCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cg.png"))); // NOI18N
        btnCD.setText("Contenido");
        btnCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCDActionPerformed(evt);
            }
        });

        btn_TA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        btn_TA.setText("Tareas");
        btn_TA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TA, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(btnPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_TA, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CursoActionPerformed
        VentanaCursoDocente frame = new VentanaCursoDocente(id);
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_CursoActionPerformed

    private void btnPerfil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfil1ActionPerformed
        Perfil frame = new Perfil(id);
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPerfil1ActionPerformed

    private void btnCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCDActionPerformed

    private void btn_TAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TAActionPerformed
        TareaDocente frame = new TareaDocente(id);
        frame.setVisible(true);
        this.setVisible(false);
        

    }//GEN-LAST:event_btn_TAActionPerformed

    /**
     * @param args the command line arguments
     */
    public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDocente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCD;
    private javax.swing.JButton btnPerfil1;
    private javax.swing.JButton btn_Curso;
    private javax.swing.JButton btn_TA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblmenu;
    // End of variables declaration//GEN-END:variables
}
