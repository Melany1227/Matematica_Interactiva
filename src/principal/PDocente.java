/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        Icon iconCurso = setIcono("/img/c.png", 41, 41);
        btn_Curso.setIcon(iconCurso);
        
        
         // Para el botón lblCG
        Icon iconContenido = setIcono("/img/cg.png", 39, 39);
        btnContenido.setIcon(iconContenido);
        
        // Configura un temporizador para cambiar los mensajes cada 5 segundos
        timer = new Timer(6000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarMensaje();
            }
        });
        timer.start();
         // Cargar una imagen como icono desde el paquete "img" y establecerla en la ventana
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/IconoMA.png"));
        this.setIconImage(icono.getImage());
    }

    private PDocente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void cambiarMensaje() {
    jLabel1.setText(StrToHtml(mensajes[mensajeActual]));
    mensajeActual = (mensajeActual + 1) % mensajes.length;
    jLabel2.setText(StrToHtml("El propósito es mejorar el aprendizaje de cálculo diferencial en estudiantes universitarios del Politécnico Jaime Isaza Cadavid en 2023 a través de una aplicación interactiva que motive, refuerce la comprensión de conceptos matemáticos y desarrolle habilidades esenciales en matemáticas."));
    jLabel3.setText(StrToHtml("<html><p>"+"Juan Manuel Cuartas Escobar(Full Stack)." + "<html><p>"
            + "Correo Electrónico: juan_cuartas23231@elpoli.edu.com"  
    ));
    jLabel4.setText(StrToHtml("Melany Julieth Suarez Rivera(Full Stack)" + "<html><p>"
            + "Correo Electrónico: melanyjsuarez@gmail.com" ));
    jLabel5.setText(StrToHtml("Allison Serna Lopera(Full Stack)" + "<html><p>"
            + "Correo Electrónico: allisonsernalopera@gmail.com" ));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPerfil1 = new javax.swing.JButton();
        btnContenido = new javax.swing.JButton();
        btn_Nose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        btn_Curso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/c.png"))); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Sobre Nosotros...");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        btnPerfil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        btnPerfil1.setText("Perfil ");
        btnPerfil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfil1ActionPerformed(evt);
            }
        });

        btnContenido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cg.png"))); // NOI18N
        btnContenido.setText("Contenido");
        btnContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContenidoActionPerformed(evt);
            }
        });

        btn_Nose.setText("no sé");
        btn_Nose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NoseActionPerformed(evt);
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
                    .addComponent(btnContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Nose, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Nose, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
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

    private void btnContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContenidoActionPerformed
        Tareas frame = new Tareas();
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnContenidoActionPerformed

    private void btn_NoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NoseActionPerformed
        // TODO add your handling code here:
        /*
        VentanaCursoDocente frame = new VentanaCursoDocente();
        frame.setVisible(true);
        this.setVisible(false);*/
    }//GEN-LAST:event_btn_NoseActionPerformed

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
    private javax.swing.JButton btnContenido;
    private javax.swing.JButton btnPerfil1;
    private javax.swing.JButton btn_Curso;
    private javax.swing.JButton btn_Nose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblmenu;
    // End of variables declaration//GEN-END:variables
}
