import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCursos extends JFrame {
    private JLabel titleLabel;
    private JTextArea descripcionTextArea;

    public VentanaCursos() {
        // Configuración de la ventana principal
        setTitle("Temario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400); // Tamaño de la ventana 700x400 píxeles

        // Panel de encabezado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 128));
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar margen alrededor del encabezado
        headerPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("Temario");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);

        // Panel de cuerpo
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.BLACK);
        bodyPanel.setLayout(new BorderLayout());
        add(bodyPanel, BorderLayout.CENTER);

        // Lista desplegable
        String[] opciones = {"Funciones", "Límites", "Derivadas", "Inecuaciones", "Ecuaciones", "Ecuaciones Cua", "Integrales"};
        JComboBox<String> listaDesplegable = new JComboBox<>(opciones);
        listaDesplegable.setPreferredSize(new Dimension(150, 30)); // Tamaño de la lista desplegable
        listaDesplegable.setMaximumRowCount(7); // Mostrar todas las opciones a la vez
        bodyPanel.add(listaDesplegable, BorderLayout.NORTH);

        // Área de texto para la descripción
        descripcionTextArea = new JTextArea();
        descripcionTextArea.setFont(new Font("Arial", Font.PLAIN, 20)); // Fuente Arial, tamaño 15
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
                // Obtener la opción seleccionada
                String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                // Actualizar el título en el cuerpo y la descripción
                actualizarTituloYDescripcion(opcionSeleccionada);
            }
        });

        // Panel de botones en la parte inferior izquierda con distribución horizontal
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(new EmptyBorder(0, 20, 20, 0)); // Márgenes en la parte inferior y izquierda

        JButton enlacesExternosButton = new JButton("Enlaces Externos");
        JButton talleresButton = new JButton("Talleres");
        JButton examenesButton = new JButton("Exámenes");
        JButton ejerciciosButton = new JButton("Ejercicios");

        buttonPanel.add(enlacesExternosButton);
        buttonPanel.add(talleresButton);
        buttonPanel.add(examenesButton);
        buttonPanel.add(ejerciciosButton);

        bodyPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar ActionListener para el botón "Enlaces Externos"
        enlacesExternosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el tema seleccionado en la lista desplegable
                String temaSeleccionado = (String) listaDesplegable.getSelectedItem();
                // Mostrar ventana emergente con enlaces externos
                mostrarEnlacesExternos(temaSeleccionado);
            }
        });

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    // Método para actualizar el título en el cuerpo y la descripción
        private void actualizarTituloYDescripcion(String tema) {
        // Actualizar el título en el cuerpo
        titleLabel.setText(tema);

        // Actualizar la descripción
        String descripcion = "";
        switch (tema) {
            case "Funciones":
                descripcion = "Las funciones matemáticas describen cómo una cantidad depende de otra. En este tema, se estudiarán conceptos fundamentales como dominio, rango y gráficas de funciones.";
                break;
            case "Límites":
                descripcion = "El cálculo de límites es esencial en el análisis de funciones. Los límites determinan el comportamiento de una función en puntos críticos. Se explorarán técnicas para calcular límites.";
                break;
            case "Derivadas":
                descripcion = "Las derivadas son un concepto fundamental en cálculo. Representan la tasa de cambio instantáneo de una función en un punto dado. Este tema explorará cómo calcular derivadas, sus aplicaciones en física, economía y otros campos, así como reglas y técnicas para simplificar el proceso.";
                break;
            case "Inecuaciones":
                descripcion = "Las inecuaciones son desigualdades matemáticas que expresan relaciones entre números o variables. En este tema, se estudiarán las inecuaciones lineales y cuadráticas, así como cómo resolverlas y representar sus soluciones en la recta numérica.";
                break;
            case "Ecuaciones":
                descripcion = "Las ecuaciones son igualdades matemáticas que contienen una o más incógnitas. Este tema se enfocará en la resolución de ecuaciones lineales y cuadráticas, así como en la interpretación de sus soluciones y su aplicación en problemas del mundo real.";
                break;
            case "Ecuaciones Cua":
                descripcion = "Las ecuaciones cuadráticas son un tipo importante de ecuaciones en la que la variable desconocida está elevada al cuadrado. Se estudiarán métodos para resolver ecuaciones cuadráticas, como la factorización y la fórmula cuadrática, y se explorarán sus aplicaciones en geometría y física.";
                break;
            case "Integrales":
                descripcion = "Las integrales son conceptos fundamentales en cálculo que representan la acumulación de cantidades a lo largo de una curva o superficie. En este tema, se aprenderá a calcular integrales definidas e indefinidas, así como a aplicarlas en el cálculo de áreas, volúmenes y otras aplicaciones matemáticas y científicas.";
                break;
        }
        descripcionTextArea.setText(descripcion);
    }

    // Método para mostrar una ventana emergente con enlaces externos
    private void mostrarEnlacesExternos(String tema) {
        // Aquí puedes definir los enlaces externos para cada tema
        String enlaces = "";
        switch (tema) {
            case "Funciones":
                enlaces = "Enlaces Externos para Funciones:\n1. Enlace 1\n2. Enlace 2\n3. Enlace 3";
                break;
            case "Límites":
                enlaces = "Enlaces Externos para Límites:\n1. https://www.youtube.com/watch?v=Ll7xfe3HoZE\n2. Enlace 2\n3. Enlace 3";
                break;
            // Agrega enlaces para los demás temas aquí
        }

        JOptionPane.showMessageDialog(this, enlaces, "Enlaces Externos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaCursos ventana = new VentanaCursos();
                ventana.setVisible(true);
            }
        });
    }
}
