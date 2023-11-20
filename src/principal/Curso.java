/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.ArrayList;

/**
 *
 * @author Melany Suarez
 */
class Curso {
    
    private String codigo;
    private int cantidadEstudiantes;
    private String nombreCurso;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public Curso(String codigo, String nombreCurso, int cantidadEstudiantes) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.cantidadEstudiantes = 0;
    }

    // Getters y setters para los atributos
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    public void incrementarCantidadEstudiantes() {
        cantidadEstudiantes++;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
}
