import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class VentanaNotas extends JFrame {
    public VentanaNotas(String titulo) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al hacer clic en "Cerrar"
        setSize(700, 400);

        // Panel de encabezado
        JLabel headerLabel = new JLabel(titulo);
        headerLabel.setBackground(new Color(0, 128, 128));
        headerLabel.setOpaque(true);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        // Resto del contenido de la ventana "VentanaNotas"
        // ...

        setLocationRelativeTo(null); // Centrar la ventana en pantalla
    }

    // Agrega cualquier otro contenido necesario para la ventana "VentanaNotas" aquí

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaNotas ventanaNotas = new VentanaNotas("Título de VentanaNotas"); // Cambia el título según sea necesario
                ventanaNotas.setVisible(true);
            }
        });
    }
}
