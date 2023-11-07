import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class VentanaAlumnos extends JFrame {
    private JLabel headerLabel;
    private JPanel cardsPanel;
    private JButton[] buttons;

    public VentanaAlumnos() {
        // Configuración de la ventana principal
        setTitle("Cantidad de cursos: 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);

        // Panel de encabezado
        headerLabel = new JLabel("Cantidad de cursos: 2");
        headerLabel.setBackground(new Color(0, 128, 128));
        headerLabel.setOpaque(true);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        cardsPanel = new JPanel(new GridLayout(1, 2, 15, 0)); // Agregar espacio de 20 píxeles horizontal entre tarjetas
        cardsPanel.setBorder(new EmptyBorder(20, 15, 15, 15));
        cardsPanel.setBackground(Color.BLACK);
        add(cardsPanel, BorderLayout.CENTER);

        // Crear tarjetas
        buttons = new JButton[8];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Persona " + (i + 1));
            buttons[i].setPreferredSize(new Dimension(40, 12));
            buttons[i].setBackground(new Color(0, 128, 128));
            buttons[i].setForeground(Color.WHITE);
            // Agregar ActionListener para abrir VentanaNotas
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton sourceButton = (JButton) e.getSource();
                    String nombreBoton = sourceButton.getText();

                    // Abrir VentanaNotas con el nombre del botón como título
                    VentanaNotas ventanaNotas = new VentanaNotas(nombreBoton);
                    ventanaNotas.setVisible(true);
                }
            });
        }

        // Agregar tarjetas al panel
        cardsPanel.add(createCardPanel("Grupo 1", buttons, 0, 4));
        cardsPanel.add(createCardPanel("Grupo 2", buttons, 4, 8));
        setLocationRelativeTo(null);
    }

    // Método para crear una tarjeta con los botones
    private JPanel createCardPanel(String title, JButton[] buttons, int start, int end) {
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        cardPanel.setBackground(Color.WHITE);
        JPanel buttonPanel = new JPanel(new GridLayout(end - start, 1, 0, 12)); // Agregar separación vertical de 12 píxeles
        buttonPanel.setBackground(Color.WHITE);
        cardPanel.setPreferredSize(new Dimension(200, 80));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        cardPanel.add(titleLabel, BorderLayout.NORTH);

        for (int i = start; i < end; i++) {
            buttonPanel.add(buttons[i]);
        }

        cardPanel.add(buttonPanel, BorderLayout.CENTER);

        return cardPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaAlumnos ventana = new VentanaAlumnos();
                ventana.setVisible(true);
            }
        });
    }
}
