/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import javax.swing.*;
import java.awt.*;
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
     private JLabel courseLabel;
    private JPanel studentsPanel;

    public VentanaAlumnos2(String courseName) {
        // Configuración de la ventana
        setTitle("Detalles del Curso: " + courseName);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

    private void cargarEstudiantes(String courseName) {
        // Lee el archivo Cursos.txt y carga los estudiantes del curso seleccionado
        try (BufferedReader br = new BufferedReader(new FileReader("Cursos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 1 && parts[0].equals(courseName)) {
                    for (int i = 1; i < parts.length; i++) {
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
                VentanaAlumnos2 ventanaAlumnos2 = new VentanaAlumnos2("0102"); // Cambiar por el curso seleccionado
                ventanaAlumnos2.setVisible(true);
            }
        });
    }
}

