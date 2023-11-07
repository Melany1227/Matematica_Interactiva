package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class EditarDatosDialog extends JDialog {
    private JTextField txtNuevoCorreo;
    private JPasswordField txtNuevaContra;
    private JPasswordField txtConfirmarContra;
    private String id;

    public EditarDatosDialog(JFrame parent, String id) {
        super(parent, "Editar Datos", true);
        this.id = id;
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel lblNuevoCorreo = new JLabel("Nuevo Correo:");
        JLabel lblNuevaContra = new JLabel("Nueva Contraseña:");
        JLabel lblConfirmarContra = new JLabel("Confirmar Contraseña:");

        txtNuevoCorreo = new JTextField(20);
        txtNuevaContra = new JPasswordField(20);
        txtConfirmarContra = new JPasswordField(20);

        JButton btnGuardar = new JButton("Guardar");

        panel.add(lblNuevoCorreo);
        panel.add(txtNuevoCorreo);
        panel.add(lblNuevaContra);
        panel.add(txtNuevaContra);
        panel.add(lblConfirmarContra);
        panel.add(txtConfirmarContra);
        panel.add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    private void guardarCambios() {
        // Obtener los datos ingresados
        String nuevoCorreo = txtNuevoCorreo.getText();
        char[] nuevaContra = txtNuevaContra.getPassword();
        char[] confirmarContra = txtConfirmarContra.getPassword();

        // Comprobar si las contraseñas coinciden
        if (!Arrays.equals(nuevaContra, confirmarContra)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Leer el archivo User.txt y guardar los datos actualizados
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));
            String linea;
            StringBuilder newFileData = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[2].equals(id)) {
                    // Reemplazar el correo y contraseña en la línea
                    datos[3] = nuevoCorreo;
                    datos[4] = new String(nuevaContra);
                }
                newFileData.append(String.join(";", datos)).append("\n");
            }
            br.close();

            // Guardar los datos actualizados en el archivo
            FileWriter writer = new FileWriter("User.txt");
            writer.write(newFileData.toString());
            writer.close();

            JOptionPane.showMessageDialog(this, "Datos actualizados con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cerrar la ventana emergente
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
