/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Melany Suarez
 */
public class Cursos {
    
    private List<Curso> cursos;

    public Cursos() {
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }


    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null; // Si no se encuentra el curso
       
       
   
    }

    public List<Curso> obtenerTodosLosCursos() {
        return new ArrayList<>(cursos);
    }
}
