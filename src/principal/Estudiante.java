/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author Melany Suarez
 */
public class Estudiante {
     private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String confirmacion;
    private String documento;

    public Estudiante(String nombre, String apellido, String correo, String contraseña, String confirmacion, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.confirmacion = confirmacion;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    // Otros métodos relacionados con Estudiante
    // ...
}
