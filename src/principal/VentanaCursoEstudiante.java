/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import principal.Cursos;
import principal.Curso;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VentanaCursoEstudiante extends JFrame  {
    
    private JLabel headerLabel;
    private JTextField codigoCursoField;
    private JButton ingresarCursoButton;
    private JButton backButton;
    private String id;
    private String nombre;
    private ArrayList<Curso> cursos;
    
    
    public VentanaCursoEstudiante(String id) {
        this.id = id;
        this.nombre = nombre;
        

        setTitle("Cursos y Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        
        // Cargar una imagen como icono desde el paquete "img" y establecerla en la ventana
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/IconoMA.png"));
        this.setIconImage(icono.getImage());

        this.setResizable(false);
        this.setLocationRelativeTo(null);
    
   

    cursos = new ArrayList<>();  // Inicializa la lista de cursos

    headerLabel = new JLabel("Curso Estudiante");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel);
        /*
        codigoCursoField = new JTextField();
        codigoCursoField.setPreferredSize(new Dimension(200, 30));
        codigoCursoField.setHorizontalAlignment(SwingConstants.CENTER);
        
        ingresarCursoButton = new JButton("Ingresar a Curso");
        ingresarCursoButton.setPreferredSize(new Dimension(160, 40));
        ingresarCursoButton.setBackground(new Color(0, 128, 128));
        ingresarCursoButton.setForeground(Color.WHITE);
        */
        backButton = new JButton("Atrás");
        backButton.setPreferredSize(new Dimension(120, 30));
        backButton.setBackground(new Color(0, 128, 128));
        backButton.setForeground(Color.WHITE);
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PEstudiante frame = new PEstudiante(id);
                frame.setVisible(true);
                dispose();
               }
        });

        JPanel panel = new JPanel();
        //panel.add(codigoCursoField);
        //panel.add(ingresarCursoButton);
        panel.add(backButton);
        add(panel);
        
         java.util.List<Curso> cursosLeidos = Metodos.leerArchivoCursos("curso.txt");
        
        
    
    
    ingresarACurso(id);
    }

    private VentanaCursoEstudiante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean existeCurso(String courseCode) {
    try {
        BufferedReader br = new BufferedReader(new FileReader("curso.txt"));
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            if (datos.length == 3) {
                String code = datos[0];
              
                    if (courseCode.equals(code)) {
                    br.close();
                    return true; // El usuario ya existe en el archivo
                }
            }
        }
        
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    return false; // El usuario no existe en el archivo 
    }
    
    public void ingresarACurso(String id) {
        
        String codigoCurso = JOptionPane.showInputDialog(null, "Ingrese el código del curso:").trim();
         boolean mat = codigoCurso.matches("\\d+");
         
         
        if (codigoCurso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un código de curso.");
        } else {
            if (mat == true && codigoCurso.length() == 4) {
                if (existeCurso(codigoCurso)) {
                
                    if (!existeEstudiante(codigoCurso, id)){
                        registrarEstudiante(codigoCurso, nombre, id);
                        actualizarCantidadEstudiantes(codigoCurso);
                    JOptionPane.showMessageDialog(this, "Ingreso al curso exitoso.");
                    
                    }else{
                        JOptionPane.showMessageDialog(this, "Aquí le abre el curso.");

                    }
                
                } 
                
                else {
                    JOptionPane.showMessageDialog(this, "El curso no existe.");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Código de curso no es válido.");

            }
           
        }
    }
    
    
    private void registrarEstudiante(String courseCode, String nombre, String id) {
            try{
            FileWriter fw = new FileWriter("Estudiante_Curso.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(courseCode + ";");
            pw.print(courseCode + ";");
            pw.print(id + "\n");
            //pw.print(nombreEstudiante + "\n");
            pw.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean existeEstudiante(String courseCode, String id) {
    try {
        BufferedReader br = new BufferedReader(new FileReader("Estudiante_Curso.txt"));
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            if (datos.length == 2) {
                String code = datos[0];
                String doc = datos[1];
                
                     if(id.equals(doc) && courseCode.equals(code)){
                            br.close();
                            return true;  
                    }
            }
        }
        
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    return false; // El usuario no existe en el archivo 
    }
    
    
    private void actualizarCantidadEstudiantes(String codigoCurso) {
        // Nombre del archivo
        String nombreArchivo = "curso.txt";

        try {
            File archivo = new File(nombreArchivo);
            
            // Crear una referencia al archivo temporal
            File archivoTemporal = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                   if (campos.length == 3 && campos[0].equals(codigoCurso)) {
                    int cantidadEstudiantes = Integer.parseInt(campos[2]);
                    cantidadEstudiantes++;
                    
                    linea = campos[0] + ";" + campos[1] + ";" + cantidadEstudiantes;
                }
                
                bw.write(linea);
                bw.newLine();
            }

            br.close();
            bw.close();

            archivo.delete();
            archivoTemporal.renameTo(archivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void actualizarTxt(){
        try {
            File inFile = new File("curso_act.txt");
            File outFile = new File("curso.txt");

            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);

            int c;
            while( (c = in.read() ) != -1)
                out.write(c);

            in.close();
            out.close();
        } catch(IOException e) {
            System.err.println("Hubo un error!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaCursoEstudiante().setVisible(true);
                
            }
        });
    }

    
}
