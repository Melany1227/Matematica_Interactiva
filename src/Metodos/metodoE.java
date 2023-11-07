package Metodos;

import java.io.BufferedReader;
import User.Ejercicio;
import java.io.FileReader;
import java.io.IOException;


public class metodoE {
    private String nombreArchivo;

    public metodoE(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void leerArchivo() {
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader lector = new BufferedReader(archivo);

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 8) {
                    String identificador = datos[0];
                    String url = datos[1];
                    String pregunta = datos[2];
                    String resp1 = datos[3];
                    String resp2 = datos[4];
                    String resp3 = datos[5];
                    String resp4 = datos[6];
                    String respC5 = datos[7];

                    // Crear un objeto Ejercicio con los datos
                    Ejercicio ejercicio = new Ejercicio(identificador, url, pregunta, resp1, resp2, resp3, resp4, respC5);
                    
                    // Imprimir el identificador del ejercicio
                    System.out.println("Identificador: "  + identificador + "\nPregunta: " +pregunta );
                }
            }

            lector.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void mostrarDatos() {
        leerArchivo(); // Llama al método leerArchivo para leer el archivo y mostrar los datos
    }

    public static void main(String[] args) {
        String nombreArchivo = "ejercicios.txt";
        metodoE miMetodo = new metodoE(nombreArchivo);
        miMetodo.mostrarDatos();
    }
}
