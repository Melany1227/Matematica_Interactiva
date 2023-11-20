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
    private JLabel imagenLabel;
    private JTabbedPane tabbedPane;
    private JComboBox<String> listaDesplegable;
    private String id;

    public ContenidoG(String id) {
        super("Contenido General");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(824, 558);
        setResizable(false);
        this.id = id;
        setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());

        // Encabezado
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());

        

        add(headerPanel, BorderLayout.NORTH);

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

        headerPanel.add(devolverButton, BorderLayout.WEST);

        // Lista desplegable
        String[] opciones = {"Seleccione una opción:", "Funciones Lineales", "Límites", "Derivadas", "Inecuaciones Lineales", "Ecuaciones", "Ecuaciones Cuadráticas"};
        listaDesplegable = new JComboBox<>(opciones);
        listaDesplegable.setPreferredSize(new Dimension(150, 30));

        // Agregar ActionListener para la lista desplegable
        listaDesplegable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                actualizarTituloYDescripcion(opcionSeleccionada);
            }
        });

        // Panel de cuerpo
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.BLACK);
        bodyPanel.setLayout(new BorderLayout());
        add(bodyPanel, BorderLayout.CENTER);

        // Lista desplegable debajo del encabezado
        JPanel dropdownPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dropdownPanel.add(listaDesplegable);
        bodyPanel.add(dropdownPanel, BorderLayout.NORTH);

        imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bodyPanel.add(imagenLabel, BorderLayout.CENTER);

        // Crear un JTabbedPane para las pestañas
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.SOUTH);

        // Añadir pestañas y contenido desde el archivo contenido.txt
        cargarContenidoDesdeArchivo();
    }

    private ContenidoG() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cargarContenidoDesdeArchivo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("contenido.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String tema = parts[0].trim();
                    String imagenPath = parts[1].trim();

                    // Crear una etiqueta para la imagen
                    JLabel imagenLabel = new JLabel();
                    imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    // Crear una pestaña y agregar la etiqueta a la pestaña
                    JPanel tabPanel = new JPanel();
                    tabPanel.setLayout(new BorderLayout());
                    tabPanel.add(imagenLabel, BorderLayout.CENTER);

                    // Añadir la pestaña al JTabbedPane
                    tabbedPane.addTab(tema, tabPanel);

                    // Cargar la imagen y establecerla en la etiqueta
                    ImageIcon imagen = new ImageIcon(getClass().getResource("/img/" + imagenPath));
                    Icon iconContenido = setIcono("/img/" + imagenPath, 750, 390);
                    imagenLabel.setIcon(iconContenido);

                    // Agregar ActionListener para la lista desplegable
                    tabbedPane.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            actualizarTituloYDescripcion(tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));
                        }
                    });
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actualizarTituloYDescripcion(String tema) {
        titleLabel.setText(tema);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("contenido.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2 && parts[0].equals(tema)) {
                    String imagenPath = parts[1].trim();
                    ImageIcon imagen = new ImageIcon(getClass().getResource("/img/" + imagenPath));
                    imagenLabel.setIcon(imagen);
                    Icon iconContenido = setIcono("/img/" + imagenPath, 750, 390);
                    imagenLabel.setIcon(iconContenido);
                    reader.close();
                    return;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon imagenVacia = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        imagenLabel.setIcon(imagenVacia);
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
