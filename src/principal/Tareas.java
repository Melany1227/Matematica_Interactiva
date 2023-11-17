/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Tareas extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtFechaEntrega;
    private JTextField txtFechaInicio;
    private JTextField txtBonificacion;

    public Tareas() {
        super("Tareas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(824, 558);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());

        // Crear modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Archivo");
        table = new JTable(tableModel);

        // Campos de texto para la fecha de entrega, fecha de inicio y bonificación
        txtFechaEntrega = new JTextField(10);
        txtFechaInicio = new JTextField(10);
        txtBonificacion = new JTextField(10);

        JLabel lblFechaEntrega = new JLabel("Fecha de Entrega:");
        JLabel lblFechaInicio = new JLabel("Fecha de Inicio:");
        JLabel lblBonificacion = new JLabel("Bonificación:");

        // Botón para cargar archivos
        JButton btnCargarArchivo = new JButton("Cargar Archivo");
        btnCargarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarArchivo();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        JPanel panelCampos = new JPanel(new FlowLayout());
        panelCampos.add(lblFechaEntrega);
        panelCampos.add(txtFechaEntrega);
        panelCampos.add(lblFechaInicio);
        panelCampos.add(txtFechaInicio);
        panelCampos.add(lblBonificacion);
        panelCampos.add(txtBonificacion);

        add(btnCargarArchivo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelCampos, BorderLayout.SOUTH);
    }

    private void cargarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF y Word", "pdf", "doc", "docx");
        fileChooser.setFileFilter(filter);

        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            String fechaEntrega = txtFechaEntrega.getText();
            String fechaInicio = txtFechaInicio.getText();
            String bonificacion = txtBonificacion.getText();

            tableModel.addRow(new Object[]{archivoSeleccionado.getName()});

            // Guardar la información en el archivo Tareas.txt
            guardarInformacionEnArchivo(fechaEntrega, fechaInicio, bonificacion, archivoSeleccionado.getName());
        }
    }

    private void guardarInformacionEnArchivo(String fechaEntrega, String fechaInicio, String bonificacion, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Tareas.txt", true))) {
            writer.write(fechaEntrega + ";" + fechaInicio + ";" + bonificacion + ";" + nombreArchivo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tareas frame = new Tareas();
                frame.setVisible(true);
            }
        });
    }
}

