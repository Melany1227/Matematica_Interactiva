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
import principal.Perfil;

public class EditarDatosDialog extends JDialog {
    private JTextField txtNuevoCorreo;
    private JPasswordField txtNuevaContra;
    private JPasswordField txtConfirmarContra;
    private String id;
   
    public EditarDatosDialog(JFrame parent, String id) {
        super(parent, "Editar Datos", true);
        this.id = id;
        JPanel panel = new JPanel(new BorderLayout());

        JLabel lblNuevoCorreo = new JLabel("Nuevo Correo:");
        JLabel lblNuevaContra = new JLabel("Nueva Contraseña:");
        JLabel lblConfirmarContra = new JLabel("Confirmar Contraseña:");

        txtNuevoCorreo = new JTextField(20);
        txtNuevaContra = new JPasswordField(20);
        txtConfirmarContra = new JPasswordField(20);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(lblNuevoCorreo);
        inputPanel.add(txtNuevoCorreo);
        inputPanel.add(lblNuevaContra);
        inputPanel.add(txtNuevaContra);
        inputPanel.add(lblConfirmarContra);
        inputPanel.add(txtConfirmarContra);

        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(55, 100, 121));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(Box.createHorizontalGlue()); 
        bottomPanel.add(btnGuardar);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH); // Agregar el panel del botón en la parte inferior


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
        String nuevaContra = new String(txtNuevaContra.getPassword());
        String confirmarContra = new String(txtConfirmarContra.getPassword());

        if (nuevoCorreo.isEmpty() || nuevaContra.isEmpty() || confirmarContra.isEmpty()) {
            JOptionPane.showMessageDialog(EditarDatosDialog.this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!nuevaContra.equals(confirmarContra)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Actualizar el archivo User.txt
            actualizarArchivo("User.txt", id, nuevoCorreo, nuevaContra, confirmarContra);

            // Actualizar el archivo Estudiante.txt
            actualizarArchivo("Estudiante.txt", id, nuevoCorreo, nuevaContra, confirmarContra);

            // Actualizar el archivo Docente.txt
            actualizarArchivo("Docente.txt", id, nuevoCorreo, nuevaContra, confirmarContra);

            JOptionPane.showMessageDialog(this, "Datos actualizados exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cerrar la ventana emergente

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void actualizarArchivo(String nombreArchivo, String id, String nuevoCorreo, String nuevaContra, String confirmarContra) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        StringBuilder newFileData = new StringBuilder();
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length >= 4 && datos[2].equals(id)) {
                // Reemplazar el correo y contraseñas en la línea
                datos[3] = nuevoCorreo;
                datos[4] = nuevaContra;
                datos[5] = confirmarContra; 
            }
            newFileData.append(String.join(";", datos)).append("\n");
        }
        br.close();

        FileWriter writer = new FileWriter(nombreArchivo);
        writer.write(newFileData.toString());
        writer.close();
    }






}