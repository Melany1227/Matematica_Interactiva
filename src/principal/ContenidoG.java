package principal;

/**
 *
 * @author allil
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;


public class ContenidoG extends JFrame {
    private JPanel panel;
    private JLabel titleLabel;
    private JLabel jimagen;
    private JLabel imagenLabel;


    public ContenidoG() {
        super("Contenido General");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        setSize(824, 558);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana de ejercicios al presionar el botón Cerrar
        // Agrega aquí los componentes de la ventana de ejercicios, como etiquetas, botones, etc.
        setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
        
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 128));
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar margen alrededor del encabezado
        headerPanel.setLayout(new BorderLayout());  
        titleLabel = new JLabel("Temario");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Establecer un borde más grande alrededor del titleLabel
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Valores más pequeños

        // Cambiar el tamaño de la fuente
        Font font = titleLabel.getFont();
        Font nuevaFuente = new Font(font.getName(), Font.PLAIN, 30); // Puedes ajustar el tamaño de la fuente (28 en este caso)
        titleLabel.setFont(nuevaFuente);

        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Panel de cuerpo
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.BLACK);
        bodyPanel.setLayout(new BorderLayout());
        add(bodyPanel, BorderLayout.CENTER);
        
        imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bodyPanel.add(imagenLabel, BorderLayout.CENTER);


        // Lista desplegable
        String[] opciones = {"Seleccione una opción:","Funciones Lineales", "Límites", "Derivadas", "Inecuaciones Lineales", "Ecuaciones", "Ecuaciones Cuadráticas", "Integrales"};
        JComboBox<String> listaDesplegable = new JComboBox<>(opciones);
        listaDesplegable.setPreferredSize(new Dimension(150, 30)); // Tamaño de la lista desplegable
        listaDesplegable.setMaximumRowCount(8); // Mostrar todas las opciones a la vez
        bodyPanel.add(listaDesplegable, BorderLayout.NORTH);
        
       
        // Agregar ActionListener para la lista desplegable
        listaDesplegable.addActionListener(new ActionListener() {
       
            public void actionPerformed(ActionEvent e) {
               
                    String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                    actualizarTituloYDescripcion(opcionSeleccionada);   
            }
        });        
    }//Fin método constructor
    
    // Método para actualizar el título en el cuerpo y la imagen
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
                    Icon iconContenido = setIcono("/img/" + imagenPath , 750, 390);
                    imagenLabel.setIcon(iconContenido);
                    reader.close();
                    return; 
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Si no se encuentra la ruta de la imagen, puedes mostrar una imagen vacía o predeterminada
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
