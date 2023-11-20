/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author allil
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Temario extends JFrame {
    private JLabel titleLabel;
    private JTextArea descripcionTextArea;
    private String id;


    public Temario(String id) {
        // Configuración de la ventana principal
        setTitle("Práctica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(824, 558); // Tamaño de la ventana 700x400 píxeles
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
        // Panel de encabezado
        this.id = id;  
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(55,100,121));
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

        // Lista desplegable
        String[] opciones = {"Seleccione una opción:","Funciones Lineales", "Límites", "Derivadas", "Inecuaciones Lineales", "Ecuaciones Lineales", "Ecuaciones Cuadráticas"};
        JComboBox<String> listaDesplegable = new JComboBox<>(opciones);
        listaDesplegable.setPreferredSize(new Dimension(150, 30)); // Tamaño de la lista desplegable
        listaDesplegable.setMaximumRowCount(7); // Mostrar todas las opciones a la vez
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

        JButton enlacesExternosButton = new JButton("Enlaces Externos");
        enlacesExternosButton.setBackground(new Color(55,100,121));
        enlacesExternosButton.setForeground(Color.WHITE);
        JButton talleresButton = new JButton("Talleres");
        talleresButton.setBackground(new Color(55,100,121));
        talleresButton.setForeground(Color.WHITE);
        JButton examenesButton = new JButton("Exámenes");
        examenesButton.setBackground(new Color(55,100,121));
        examenesButton.setForeground(Color.WHITE);
        JButton ejerciciosButton = new JButton("Ejercicios");
        ejerciciosButton.setBackground(new Color(55,100,121));
        ejerciciosButton.setForeground(Color.WHITE);


        buttonPanel.add(enlacesExternosButton);
        buttonPanel.add(examenesButton);
        buttonPanel.add(talleresButton);
        buttonPanel.add(ejerciciosButton);
        
        JButton devolverButton = new JButton();
        ImageIcon iconoRegresar = new ImageIcon(getClass().getResource("/img/devolver.png"));
        Icon iconDevolver = setIcono("/img/devolver.png", 40, 40);
        devolverButton.setIcon(iconDevolver);
        devolverButton.setPreferredSize(new Dimension(46, 41)); 
        
        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PEstudiante principal = new PEstudiante(id);
                principal.setVisible(true);
                dispose();

            }
        });
        
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        headerPanel.add(devolverButton, BorderLayout.WEST);


        bodyPanel.add(buttonPanel, BorderLayout.SOUTH);
        
       

        // Agregar ActionListener para el botón "Enlaces Externos"
        enlacesExternosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (listaDesplegable.getSelectedItem() == "Seleccione una opción:")
                {
                    JOptionPane.showMessageDialog(null, "Debes escoger un tema válido para ver los enlaces externos");
                }
                else{
                    String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                    mostrarEnlacesExternos(opcionSeleccionada);
                    //link();
                }
                
            }
        });
        
        // Agrega el ActionListener para el botón "Ejercicios"
        talleresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaDesplegable.getSelectedItem() == "Seleccione una opción:")
                {
                    JOptionPane.showMessageDialog(null, "Debes escoger un tema válido para ver los talleres");
                }
                 else{
                    String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                    Taller frame = new Taller(opcionSeleccionada);
                    frame.setVisible(true);

                 }
            }
        });
        
        // Agrega el ActionListener para el botón "Ejercicios"
        ejerciciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaDesplegable.getSelectedItem() == "Seleccione una opción:")
                {
                    JOptionPane.showMessageDialog(null, "Debes escoger un tema válido para ver los ejercicios");
                }
                 else{
                    String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                    Ejercicio ventanaEjercicios = new Ejercicio(opcionSeleccionada);
                    ventanaEjercicios.setVisible(true);

                 }
            }
        });
        // Agrega el ActionListener para el botón "Examen"
        examenesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaDesplegable.getSelectedItem() == "Seleccione una opción:")
                {
                    JOptionPane.showMessageDialog(null, "Debes escoger un tema válido para ver el examen");
                }
                 else{
                    String opcionSeleccionada = (String) listaDesplegable.getSelectedItem();
                    Examen frame = new Examen(opcionSeleccionada);
                    frame.setVisible(true);

                 }
            }
        });
        

        setLocationRelativeTo(null); 
    }

    private Temario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
        }
        descripcionTextArea.setText(descripcion);
    }

    
    private void mostrarEnlacesExternos(String opcionSeleccionada) {
        // Aquí puedes definir los enlaces externos para cada tema
        String[] enlaces = new String[3];

        switch (opcionSeleccionada) {
            case "Funciones Lineales":
                enlaces[0] = "https://youtu.be/AoZpzAoC1Qg?si=4N6QCY4Ps-wuNdSm";
                enlaces[1] = "https://youtu.be/PnATAsxu_oo?si=csVGKgNw2iMAP_TO";
                enlaces[2] = "https://youtu.be/AM6Y--Jc4Fw?si=Itra3Ccu7kO45cvJ";
                break;
            case "Límites":
                enlaces[0] = "https://youtu.be/o2UTk8bsLS0?si=SIF4EWRitfH_GQrp";
                enlaces[1] = "https://youtu.be/pYVVPqphPS0?si=n-FEXkAfLDOM5V_B";
                enlaces[2] = "https://youtu.be/lwnbjwk21Lc?si=m7XimG4SNYwX-8TJ";
                break;
            case "Derivadas":
                enlaces[0] = "https://youtu.be/aVNa-J8iB5I?si=QK2RUZGi8HPt6myE";
                enlaces[1] = "https://youtu.be/_6-zwdrqD3U?si=NyCCdsPFmrekexny";
                enlaces[2] = "https://youtu.be/U7onW7mMzLM?si=5E8mBNqE-D8L5Q3X";
                break;
            case "Inecuaciones Lineales":
                enlaces[0] = "https://youtu.be/CkVXbU-PNRs?si=T0FWvtmXaxBl_URM";
                enlaces[1] = "https://youtu.be/wfVvOQEhXd0?si=H1-fAoxugMeUzMT8";
                enlaces[2] = "https://youtu.be/hnXLKqeDEU8?si=bvk9c_I-EYoFX_dN";
                break;   
            case "Ecuaciones Lineales":
                enlaces[0] = "https://youtu.be/6Y2_dstRTfQ?si=cq3iviUfeOz5pdHH";
                enlaces[1] = "https://youtu.be/T4ZY3GHBAME?si=jfhoCzFkviFLTyXW";
                enlaces[2] = "https://youtu.be/qeKEA066OSs?si=TztcLz6V4bNxrnUK";
                break;
            case "Ecuaciones Cuadráticas":
                enlaces[0] = "https://youtu.be/_bP6NowsO-Y?si=qK9Dipm8XtY6aDae";
                enlaces[1] = "https://youtu.be/ZC67c5ar9mA?si=4wca0Nuz9YJJ_fW8";
                enlaces[2] = "https://youtu.be/6JQw45YO3Fs?si=uP0rsLrLgvABb-3Y";
                break;
        }

        JPanel enlacesPanel = new JPanel();
        enlacesPanel.setLayout(new GridLayout(3, 1)); // 3 filas, 1 columna

        for (String enlace : enlaces) {
            JButton enlaceButton = new JButton(enlace);
            enlaceButton.setBackground(new Color(0,0,0));
            enlaceButton.setForeground(Color.WHITE);
            enlaceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (enlace.startsWith("http")) {
                        // Si el enlace comienza con "http", abrir el enlace en el navegador
                        abrirEnlace(enlace);
                    } else {
                        // Si no, mostrar un mensaje o realizar otra acción
                        JOptionPane.showMessageDialog(Temario.this, "Enlace no válido: " + enlace);
                    }
                }

                private void abrirEnlace(String enlace) {
                    try {
                        java.awt.Desktop.getDesktop().browse(new java.net.URI(enlace));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            enlacesPanel.add(enlaceButton);
        }
        JOptionPane.showMessageDialog(this, enlacesPanel, "Enlaces Externos", JOptionPane.PLAIN_MESSAGE);
    }




    
    //método para ir a un link desde un boton
    private void link(){
        if(java.awt.Desktop.isDesktopSupported()){
            java.awt.Desktop computadora = java.awt.Desktop.getDesktop();
            if (computadora.isSupported(java.awt.Desktop.Action.BROWSE)){
                try{
                java.net.URI link = new java.net.URI("https://www.youtube.com/watch?v=Ll7xfe3HoZE");
                computadora.browse(link);
                }catch(IOException  | URISyntaxException e){
                    e.printStackTrace(); 
                }
            }
        }else{
            System.out.println("La computadora no soporta la clase");
            System.exit(0);
        }  
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Temario ventana = new Temario();
                ventana.setVisible(true);
                
             
            }
        });
    }
    
    public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
}