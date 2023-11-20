/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 *
 * @author Melany Suarez
 */
public class VentanaAlumnos2 extends JFrame {
    private String id;
    private JLabel courseLabel;
    private JPanel studentsPanel;
    private JButton tallerButton;

    public VentanaAlumnos2(String courseName) {
        
        
        // Configuración de la ventana
        setTitle("Detalles del Curso: " + courseName);
        setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Cargar una imagen como icono desde el paquete "img" y establecerla en la ventana
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());

        // Etiqueta con el nombre del curso
        courseLabel = new JLabel("Curso: " + courseName);
        courseLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        courseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(courseLabel, BorderLayout.NORTH);
   

        // Panel para mostrar los botones de estudiantes
        studentsPanel = new JPanel();
        studentsPanel.setLayout(new BoxLayout(studentsPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(studentsPanel), BorderLayout.CENTER);

        // Leer y cargar los estudiantes desde el archivo
        cargarEstudiantes(courseName);
    }

    private VentanaAlumnos2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void crearBotonTaller(String courseName) {
        JButton tallerButton = new JButton(courseName);
        tallerButton.setPreferredSize(new Dimension(120, 40));
        tallerButton.setMargin(new Insets(10, 10, 10, 10));
        tallerButton.setBackground(new Color(55, 100, 121));
        tallerButton.setForeground(Color.WHITE);

        tallerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAlumnos2 ventanaAlumnos2 = new VentanaAlumnos2(courseName); // Cambiar por el curso seleccionado
                ventanaAlumnos2.setVisible(true);
                // Implementa aquí la lógica para mostrar los estudiantes del curso
            }
        });

        studentsPanel.add(tallerButton);
        studentsPanel.revalidate();
        studentsPanel.repaint();
    }

   

    private void cargarEstudiantes(String courseName) {
        // Lee el archivo Cursos.txt y carga los estudiantes del curso seleccionado
        try (BufferedReader br = new BufferedReader(new FileReader("curso.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2 && parts[0].equals(courseName)) {
                    for (int i = 3; i < parts.length; i++) {
                        String studentName = parts[i];
                        JButton studentButton = new JButton(studentName);
                        studentsPanel.add(studentButton);
                    }
                    break; // Detener la búsqueda una vez que se encuentra el curso
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                 new VentanaAlumnos2().setVisible(true);
            }
        });
    }
  

   
}

