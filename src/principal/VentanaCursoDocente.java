

package principal;
import principal.Curso;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Melany Suarez
 */
public class VentanaCursoDocente extends JFrame {
    
private JLabel headerLabel;
    private String id;
    private JPanel coursesPanel;
    private JButton createCourseButton;
    private ArrayList<Curso> courseNames;
    private ArrayList<Curso> cursos;
    private JButton deleteCourseButton;
    private JButton backButton;
    
    //Curso curso = new Curso(String codigo, String nombreCurso, int cantidadEstudiantes);

    public VentanaCursoDocente(String id) {
        this.id = id;
   
    setTitle("Gestión de Cursos y Notas");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(700, 400);
    
    this.setResizable(false);
        this.setLocationRelativeTo(null);
   

    cursos = new ArrayList<>();  // Inicializa la lista de cursos

    headerLabel = new JLabel("Cursos Estudiantes");

        headerLabel = new JLabel("Cursos Estudiantes");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        createCourseButton = new JButton("Crear Curso");
        createCourseButton.setPreferredSize(new Dimension(120, 40));
        createCourseButton.setMargin(new Insets(10, 10, 10, 10));
        createCourseButton.setBackground(new Color(0, 128, 128));
        createCourseButton.setForeground(Color.WHITE);
       
        deleteCourseButton = new JButton("Eliminar Curso");
        deleteCourseButton.setPreferredSize(new Dimension(120, 40));
        deleteCourseButton.setMargin(new Insets(10, 10, 10, 10));
        deleteCourseButton.setBackground(new Color(255, 0, 0)); // Color rojo
        deleteCourseButton.setForeground(Color.WHITE);
        
        backButton = new JButton("Atrás");
        backButton.setPreferredSize(new Dimension(200, 40));
        backButton.setMargin(new Insets(10, 10, 10, 10));
        backButton.setBackground(new Color(0, 128, 128));
        backButton.setForeground(Color.WHITE);
       
        deleteCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarCurso();
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDocente frame = new PDocente(id);
                frame.setVisible(true);
                VentanaCursoDocente frame2 = new VentanaCursoDocente(id);
                frame2.setVisible(false);
            }
        });

   
        createCourseButton.addActionListener(new ActionListener() {
            
            
     private boolean contieneSoloLetras(String texto) {
        return texto.matches("^[a-zA-Z]+$");
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
           
    public void actionPerformed(ActionEvent e) {
        String newCourseCode = JOptionPane.showInputDialog(null, "Ingrese el código del nuevo curso:");
        String newNombreCurso = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo curso:");         

        
        
        if (newCourseCode.isEmpty() || newNombreCurso.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
        //}else if (!contieneSoloLetras(newNombreCurso)) {
           // JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras, intente de nuevo.");
        } else if (existeCurso(newCourseCode)){
                JOptionPane.showMessageDialog(null, "El curso ya existe.");
        }
        else {
            
                if (newCourseCode.matches("\\d+") && newCourseCode.length() == 4) {
                JOptionPane.showMessageDialog(null, "Curso registrado correctamente.");
                crearCurso (newCourseCode,newNombreCurso, 0);
               
                // Crea un nuevo curso con el código, nombre y número de estudiantes por defecto (0)
                Curso nuevoCurso = new Curso(newCourseCode, newNombreCurso, 0);
                cursos.add(nuevoCurso); // Agrega el nuevo curso a la lista
                actualizarVentana();
                } else{
                        JOptionPane.showMessageDialog(null, "El código debe ser un número de 4 dígitos.\nIntente de nuevo");
                }
  
        }
        
    }
   
    });

        coursesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        coursesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        coursesPanel.setBackground(Color.BLACK);
        add(new JScrollPane(coursesPanel), BorderLayout.CENTER);

        java.util.List<Curso> cursosLeidos = Metodos.leerArchivoCursos("curso.txt");
        cargarCursosDesdeArchivo();
        cursos.addAll(cursosLeidos);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(createCourseButton, BorderLayout.WEST);
        buttonPanel.add(deleteCourseButton, BorderLayout.CENTER);
        buttonPanel.add(backButton, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.NORTH);
    }

    private VentanaCursoDocente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    private void crearBotonesCursos() {
    for (Curso curso : cursos) {
        crearBotonCurso(curso.getNombreCurso());
        curso.getCodigo();
        curso.getCantidadEstudiantes();
    }
    }

    
   

    private void crearCurso(String courseCode, String nombreCurso,  int cantidadEstudiantes) {
        
            try{
            FileWriter fw = new FileWriter("curso.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(courseCode + ";");
            pw.print(nombreCurso + ";");
            pw.print(cantidadEstudiantes + "\n");
            pw.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
  
    


    private void crearBotonCurso(String courseName) {
        JButton courseButton = new JButton(courseName);
        courseButton.setPreferredSize(new Dimension(120, 40));
        courseButton.setMargin(new Insets(10, 10, 10, 10));
        courseButton.setBackground(new Color(0, 128, 128));
        courseButton.setForeground(Color.WHITE);

        courseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa aquí la lógica para mostrar los estudiantes del curso
                // Puedes abrir una nueva ventana o actualizar la información en esta misma ventana.
            }
        });

        coursesPanel.add(courseButton);
        coursesPanel.revalidate();
        coursesPanel.repaint();
    }
  
      
    private void eliminarCurso() {
        if (cursos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay cursos para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }else{
            Object[] options = cursos.stream()
                .map(curso -> curso.getNombreCurso()) // Obtener el nombre del curso
                .toArray();

        String nombreCursoAEliminar = (String) JOptionPane.showInputDialog(this,
                "Selecciona el curso que deseas eliminar:",
                "Eliminar Curso",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
        
        
         if (nombreCursoAEliminar != null) {
            // Buscar el curso a eliminar
            Curso cursoAEliminar = null;
            for (Curso curso : cursos) {
                if (curso.getNombreCurso().equals(nombreCursoAEliminar)) {
                    cursoAEliminar = curso;
                    break;
                }
            }

            if (cursoAEliminar != null) {
                cursos.remove(cursoAEliminar);
                // Eliminar el botón del curso del panel
                Component[] components = coursesPanel.getComponents();
                for (Component component : components) {
                    if (component instanceof JButton) {
                        JButton courseButton = (JButton) component;
                        if (courseButton.getText().equals(nombreCursoAEliminar)) {
                            coursesPanel.remove(courseButton);
                            String lineToRemove = nombreCursoAEliminar;
                            
                            

                            
                             try{  
                                 
                                File inputFile = new File("curso.txt");
                                File outputFile = new File("curso_act.txt");
                                   
                                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
      
                                
                            String currentLine;
                            while((currentLine = br.readLine()) != null) {
                                String[] datos = currentLine.split(";");
                                
                                String nombre = datos[1];
                                if(nombre.trim().equals(lineToRemove)){ 
                                        continue;
                                }
                                bw.write(currentLine + System.getProperty("line.separator"));
                   
                            }
                            JOptionPane.showMessageDialog(this, "Curso eliminado correctamente.");

                            bw.close();  
                            br.close();
                            actualizarVentana();
                            actualizarTxt();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        }
                    }
                }
                // Actualizar el panel
                coursesPanel.revalidate();
                coursesPanel.repaint();
                // También puedes eliminar los datos del curso del archivo si es necesario
                // (no se muestra cómo hacerlo en tu código actual)
            }
        }
      
    }   
}

            // Muestra un cuadro de diálogo para seleccionar el curso a eliminar
        /*Object[] options = cursos.toArray();
        Curso cursoAEliminar = (Curso) JOptionPane.showInputDialog(this,
                "Selecciona el curso que deseas eliminar:",
                "Eliminar Curso",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        if (cursoAEliminar != null) {
           
            cursos.remove(cursoAEliminar);
            actualizarVentana();
        }
        }

        
    }*/
    
   
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
            System.err.println("Hubo un error");
        }
    }

   
    private void actualizarVentana() {
        coursesPanel.removeAll();
        crearBotonesCursos();
        coursesPanel.revalidate();
        coursesPanel.repaint();
    }
   
    //private void cargarCursosDesdeArchivo() {
        //java.util.List<Curso> cursosLeidos = Metodos.leerArchivoCursos("curso.txt");
        //cursos.addAll(cursosLeidos);
        //crearBotonesCursos();  // Crea botones para los cursos existentes
    //}
   
    private void cargarCursosDesdeArchivo() {
    try (BufferedReader br = new BufferedReader(new FileReader("curso.txt"))) {
        
        String line;
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            if (datos.length >= 3) {
                String codigo = datos[0];
                String nombre = datos[1];
                
                int cantidadEstudiantes = Integer.parseInt(datos[2]);

                Curso curso = new Curso(codigo, nombre, cantidadEstudiantes);
                cursos.add(curso);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    crearBotonesCursos();
    }
   
    public static void main(String[] args) {
        
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new VentanaCursoDocente().setVisible(true);
            }
        });
    }
}

