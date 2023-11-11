/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;


/**
 *
 * @author allil
 */
public class PEstudiante extends javax.swing.JFrame {
    private String id;
    private final JLabel mensajeLabel;
    private final JLabel mensaj;
    private final Timer timer;
    private final String[] mensajes = {
       "El conocimiento es el tesoro más grande que puedes adquirir. "
            + "Invirtiendo en tu educación, estás invirtiendo en tu futuro.",
        "El conocimiento es poder, y tú tienes el poder de aprender y crecer cada día.",
        "Los desafíos académicos son oportunidades disfrazadas. Supéralos y te convertirás en una persona más fuerte y sabia.",
        "No te compares con otros. Tu viaje académico es único y a tu propio ritmo. ¡Concéntrate en superarte a ti mismo!",
        "La educación es el pasaporte hacia el futuro; el mañana pertenece a aquellos que se preparan para él hoy.\" - Malcolm X",
        "Cada día es una oportunidad para aprender algo nuevo y acercarte un paso más a tus metas académicas.",
        "El éxito no es el final, el fracaso no es fatal: lo que cuenta es el coraje de seguir adelante.\" - Winston Churchill",
        "La excelencia no es un acto, es un hábito.\" - Aristóteles",
        "Tus sueños son el combustible que te impulsa a lograr grandes cosas. ¡Sigue soñando y trabajando!",
        "La disciplina es el puente entre metas y logros.",
        "La educación es la llave que abre la puerta a un mundo de posibilidades.",
        "Nunca subestimes el poder de tus sueños y tu capacidad para hacerlos realidad.",
        "La actitud determina la altitud. Mantén una actitud positiva y llegarás lejos.",
        "La educación no es preparación para la vida; la educación es la vida en sí misma.\" - John Dewey",
        "El conocimiento es el recurso más valioso que puedes poseer. Nadie puede quitártelo.",
    };
    
    private int mensajeActual;
    /**
     * Creates new form PEstudiante
     */
    public PEstudiante(String id) {
        initComponents();
        this.setResizable(false); // Hace que la ventana no sea redimensionable
        this.setLocationRelativeTo(null);//para que la interfaz aparezca en el centro
        this.setTitle("Ventana Estudiante"); // Establece el título de la ventana
        this.id = id;  // Asigna el ID del usuario
        // lblPerfil2.setIcon(setIcono("/img/icono_perfil.jpg", lblPerfil2));
        // Para el botón lblPerfil2
        Icon iconPerfil = setIcono("/img/usuario.png", 39, 39);
        lblPerfil2.setIcon(iconPerfil);

        // Para el botón lblCurso
        Icon iconCurso = setIcono("/img/c.png", 41, 41);
        lblCurso.setIcon(iconCurso);
        
         // Para el botón lblPractica
        Icon iconPractica = setIcono("/img/practica.png", 41, 41);
        lblPractica.setIcon(iconPractica);
        
         // Para el botón lblCG
        Icon iconContenido = setIcono("/img/cg.png", 39, 39);
        lblCG.setIcon(iconContenido);
        
         // Para el botón lblNota1
        Icon iconNotas = setIcono("/img/calificaciones.png", 39, 39);
        lblNota1.setIcon(iconNotas);

        
       // Cargar una imagen como icono desde el paquete "img" y establecerla en la ventana
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
        // Crea un JLabel para mostrar los mensajes
        mensajeLabel = new JLabel();
        jPanel3.add(mensajeLabel); // Agrega el JLabel al jPanel2
        mensaj = new JLabel();
        jPanel4.add(mensaj); // Agrega el JLabel al jPanel2
        
        
        // Configura un temporizador para cambiar los mensajes cada 6 segundos
        timer = new Timer(6000, (ActionEvent e) -> {
            cambiarMensaje();
        });
        timer.start();
    }

    private PEstudiante() {
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
        jPanel1 = new javax.swing.JPanel();
        lblmenu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCurso = new javax.swing.JButton();
        lblCG = new javax.swing.JButton();
        lblPerfil2 = new javax.swing.JButton();
        lblNota1 = new javax.swing.JButton();
        lblPractica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(lblmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblmenu, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 130, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/c.png"))); // NOI18N
        lblCurso.setText("Curso");
        lblCurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 100, 121), 3));
        lblCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCursoActionPerformed(evt);
            }
        });

        lblCG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cg.png"))); // NOI18N
        lblCG.setText("Contenido");
        lblCG.setToolTipText("");
        lblCG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 100, 121), 3));
        lblCG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCGActionPerformed(evt);
            }
        });

        lblPerfil2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        lblPerfil2.setText("Perfil");
        lblPerfil2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 100, 121), 3));
        lblPerfil2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPerfil2ActionPerformed(evt);
            }
        });

        lblNota1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calificaciones.png"))); // NOI18N
        lblNota1.setText("Notas");
        lblNota1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 100, 121), 3));
        lblNota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblNota1ActionPerformed(evt);
            }
        });

        lblPractica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/practica.png"))); // NOI18N
        lblPractica.setText("Práctica");
        lblPractica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 100, 121), 3));
        lblPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPracticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPerfil2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCG, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPractica, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPerfil2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPractica, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCG, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCursoActionPerformed

    private void lblCGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCGActionPerformed
        ContenidoG frame = new ContenidoG();
        frame.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_lblCGActionPerformed

    private void lblPerfil2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblPerfil2ActionPerformed
        Perfil frame = new Perfil(id);
        frame.setVisible(true);
        this.setVisible(false);
    
         
    }//GEN-LAST:event_lblPerfil2ActionPerformed

    private void lblNota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblNota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNota1ActionPerformed

    private void lblPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblPracticaActionPerformed
        Temario frame = new Temario();
        frame.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_lblPracticaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(() -> {
            new PEstudiante().setVisible(true);
        });
    }
    
    public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
    
    
    
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton lblCG;
    private javax.swing.JButton lblCurso;
    private javax.swing.JButton lblNota1;
    private javax.swing.JButton lblPerfil2;
    private javax.swing.JButton lblPractica;
    private javax.swing.JLabel lblmenu;
    // End of variables declaration//GEN-END:variables

   
}
