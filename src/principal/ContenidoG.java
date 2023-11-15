package principal;

/**
 *
 * @author allil
 */
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ContenidoG extends JFrame {
    private JLabel titleLabel;
    private JTextArea descripcionTextArea;

    public ContenidoG() {
        super("Contenido General");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(824, 558);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());

        // Encabezado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 128));
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        headerPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("Temario");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        Font font = titleLabel.getFont();
        Font nuevaFuente = new Font(font.getName(), Font.PLAIN, 30);
        titleLabel.setFont(nuevaFuente);

        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);
        
        // Panel de cuerpo
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.BLACK);
        bodyPanel.setLayout(new BorderLayout());
        add(bodyPanel, BorderLayout.CENTER);

        // Lista desplegable
        String[] opciones = {"Seleccione una opción:","Funciones Lineales", "Límites", "Derivadas", "Inecuaciones Lineales", "Ecuaciones Lineales", "Ecuaciones Cuadráticas", "Integrales"};
        JComboBox<String> listaDesplegable = new JComboBox<>(opciones);
        listaDesplegable.setPreferredSize(new Dimension(150, 30)); // Tamaño de la lista desplegable
        listaDesplegable.setMaximumRowCount(8); // Mostrar todas las opciones a la vez
        bodyPanel.add(listaDesplegable, BorderLayout.NORTH);

        // Área de texto para la descripción
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setFont(new Font("Arial", Font.PLAIN, 20)); 
        descripcionTextArea.setForeground(Color.WHITE);
        descripcionTextArea.setBackground(Color.BLACK);
        descripcionTextArea.setWrapStyleWord(true);
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setEditable(false);

        // Agregar un margen de 20 píxeles a los lados y 50 píxeles en la parte superior
        descripcionTextArea.setBorder(BorderFactory.createEmptyBorder(50, 20, 0, 20));

        bodyPanel.add(new JScrollPane(descripcionTextArea), BorderLayout.CENTER);

        // Agregar ActionListener para la lista desplegable
        listaDesplegable.addActionListener(new ActionListener() {
       
            public void actionPerformed(ActionEvent e) {
               
                    String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                    actualizarTituloYDescripcion(opcionSeleccionada);   
            }
        });

        // Panel de botones en la parte inferior izquierda con distribución horizontal
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(new EmptyBorder(0, 20, 20, 0)); // Márgenes en la parte inferior y izquierda

        JButton definicionButton = new JButton("Definición");
        definicionButton.setBackground(new Color(0, 128, 128));
        definicionButton.setForeground(Color.WHITE);
        JButton problemasrButton = new JButton("Prblemas Resueltos");
        problemasrButton.setBackground(new Color(0, 128, 128));
        problemasrButton.setForeground(Color.WHITE);
        JButton examenesButton = new JButton("Exámenes");
        examenesButton.setBackground(new Color(0, 128, 128));
        examenesButton.setForeground(Color.WHITE);
        JButton ejerciciosButton = new JButton("Ejercicios");
        ejerciciosButton.setBackground(new Color(0, 128, 128));
        ejerciciosButton.setForeground(Color.WHITE);


        buttonPanel.add(definicionButton);
        buttonPanel.add(problemasrButton);
        buttonPanel.add(examenesButton);
        buttonPanel.add(ejerciciosButton);
        

        // Botón "Devolver"
        JButton devolverButton = new JButton();
        ImageIcon iconoRegresar = new ImageIcon(getClass().getResource("/img/devolver.png"));
        Icon iconDevolver = setIcono("/img/devolver.png", 40, 40);
        devolverButton.setIcon(iconDevolver);
        devolverButton.setPreferredSize(new Dimension(46, 41));

        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                String id = null;
                PEstudiante frame = new PEstudiante(id);
                frame.setVisible(true);
            }
        });

         headerPanel.add(titleLabel, BorderLayout.CENTER);
        headerPanel.add(devolverButton, BorderLayout.EAST);


        bodyPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Agregar ActionListener para el botón "Enlaces Externos"
        definicionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (listaDesplegable.getSelectedItem() == "Seleccione una opción:")
                {
                    JOptionPane.showMessageDialog(null, "Debes escoger un tema válido");
                }
                else{
                    String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                    mostrarEnlacesExternos(opcionSeleccionada);
                }
                
            }
        });
        // Agrega el ActionListener para el botón "Ejercicios"
        problemasrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaDesplegable.getSelectedItem() == "Seleccione una opción:")
                {
                    JOptionPane.showMessageDialog(null, "Debes escoger un tema válido");
                }
                 else{
                    String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                    // Crea una instancia de la ventana de ejercicios y pasa opcionSeleccionada
                    Taller frame = new Taller(opcionSeleccionada);
                    frame.setVisible(true);

                 }
            }
        });
        
        setLocationRelativeTo(null); 
    }//Fin método constructor
    
    // Método para actualizar el título en el cuerpo y la descripción
        private void actualizarTituloYDescripcion(String tema) {
        // Actualizar el título en el cuerpo
        titleLabel.setText(tema);

        // Actualizar la descripción
        String descripcion = "";
        switch (tema) {
            case "Seleccione una opción:":
                descripcion = "Seleccione un tema, por favor.";
                break;
            case "Funciones Lineales":
                descripcion = "Las funciones matemáticas describen cómo una cantidad depende de otra. En este tema, se estudiarán conceptos fundamentales como dominio, rango y gráficas de funciones.";
                break;
            case "Límites":
                descripcion = "El cálculo de límites es esencial en el análisis de funciones. Los límites determinan el comportamiento de una función en puntos críticos. Se explorarán técnicas para calcular límites.";
                break;
            case "Derivadas":
                descripcion = "Las derivadas son un concepto fundamental en cálculo. Representan la tasa de cambio instantáneo de una función en un punto dado. Este tema explorará cómo calcular derivadas, sus aplicaciones en física, economía y otros campos, así como reglas y técnicas para simplificar el proceso.";
                break;
            case "Inecuaciones Lineales":
                descripcion = "Las inecuaciones son desigualdades matemáticas que expresan relaciones entre números o variables. En este tema, se estudiarán las inecuaciones lineales y cuadráticas, así como cómo resolverlas y representar sus soluciones en la recta numérica.";
                break;
            case "Ecuaciones Lineales":
                descripcion = "Las ecuaciones son igualdades matemáticas que contienen una o más incógnitas. Este tema se enfocará en la resolución de ecuaciones lineales y cuadráticas, así como en la interpretación de sus soluciones y su aplicación en problemas del mundo real.";
                break;
            case "Ecuaciones Cuadráticas":
                descripcion = "Las ecuaciones cuadráticas son un tipo importante de ecuaciones en la que la variable desconocida está elevada al cuadrado. Se estudiarán métodos para resolver ecuaciones cuadráticas, como la factorización y la fórmula cuadrática, y se explorarán sus aplicaciones en geometría y física.";
                break;
            case "Integrales":
                descripcion = "Las integrales son conceptos fundamentales en cálculo que representan la acumulación de cantidades a lo largo de una curva o superficie. En este tema, se aprenderá a calcular integrales definidas e indefinidas, así como a aplicarlas en el cálculo de áreas, volúmenes y otras aplicaciones matemáticas y científicas.";
                break;
        }
        descripcionTextArea.setText(descripcion);
    }
    // Método para mostrar una ventana emergente con enlaces externos
    private void mostrarEnlacesExternos(String opcionSeleccionada) {
        // Aquí puedes definir los enlaces externos para cada tema
        String enlaces = "";
        switch (opcionSeleccionada) {
            case "Funciones Lineales":
                enlaces = "Videos recomendados; Funciones:\n1. Enlace 1\n2. Enlace 2\n3. Enlace 3";
                break;
            case "Limites":
                enlaces = "Videos recomendados; Derivadas\n1. https://www.youtube.com/watch?v=Ll7xfe3HoZE\n2. Enlace 2\n3. Enlace 3";
                break;
            case "Derivadas":
                enlaces = "Videos recomendados; Derivadas\n1. Enlace 1\n2. Enlace 2\n3. Enlace 3";
                break;
            case "Inecuaciones":
                enlaces = "Videos recomendados; Inecuaciones:\n1. https://www.youtube.com/watch?v=Ll7xfe3HoZE \n2. Enlace 2\n3. Enlace 3";
                break;
            case "Ecuaciones":
                enlaces = "Videos recomendados; Ecuaciones:\n1. Enlace 1\n2. Enlace 2\n3. Enlace 3";
                break;
            case "Ecuaciones Cua":
                enlaces = "Videos recomendados; Ecuaciones Cua:\n1. https://www.youtube.com/watch?v=Ll7xfe3HoZE\n2. Enlace 2\n3. Enlace 3";
                break;
            case "Integrales":
                enlaces = "Videos recomendados; Integrales \n1. Enlace 1\n2. Enlace 2\n3. Enlace 3";
                break;
        }

        JOptionPane.showMessageDialog(this, enlaces, "Enlaces Externos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContenidoG frame = new ContenidoG();
                frame.setVisible(true);
            }
        });
    }

    public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
}

