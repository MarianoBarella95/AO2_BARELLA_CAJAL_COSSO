package AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases;

import java.util.Arrays;

import javax.swing.JOptionPane;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.Tipo_Cursos;
import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.Ingreso;
import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.Salida;

public class Curso implements Comparable<Curso> {
    protected String nombreCurso;
    protected int duracion;
    protected int matriculaAlumnos;
    protected Double costoPorEstudiante;
    protected Tipo_Cursos tipoCurso;
    protected Object[] cursosCreados;
    
    /*
     * GETTERS & SETTERS
     */
  
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getMatriculaAlumnos() {
        return matriculaAlumnos;
    }
    
    public void setMatriculaAlumnos(int matriculaAlumnos) {
        this.matriculaAlumnos = matriculaAlumnos;
    }

    public Double getCostoPorEstudiante() {
        return costoPorEstudiante;
    }

    public void setCostoPorEstudiante(Double costoPorEstudiante) {
        this.costoPorEstudiante = costoPorEstudiante;
    }

    public int compareTo(Curso otroCurso) {
        return Integer.compare(this.matriculaAlumnos, otroCurso.matriculaAlumnos); // Orden ascendente
    }
    
    
    @Override
    public String toString() {
        return "Curso [nombreCurso=" + nombreCurso + ", duracion=" + duracion + ", matriculaAlumnos=" + matriculaAlumnos
        + ", costoPorEstudiante=" + costoPorEstudiante + ", tipoCurso=" + tipoCurso + "]";
    }
    /*
     * MÉTODOS CONSTRUCTORES
     */
    
    public Curso() {
        this.nombreCurso = "";
        this.duracion = 0;
        this.matriculaAlumnos = 0;
        this.costoPorEstudiante = 0.0;
    }

    public Curso(String nombreCurso, int duracion, int matriculaAlumnos, Double costoPorEstudiante) {
        this.nombreCurso = nombreCurso;
        this.duracion = duracion;
        this.matriculaAlumnos = matriculaAlumnos;
        this.costoPorEstudiante = costoPorEstudiante;
    }

    /*
     * CARGA DE CURSO
     */

    public void cargaCurso() {
        
        this.nombreCurso = JOptionPane.showInputDialog("Ingrese el nombre del curso: ");

        boolean error=false;
        do{
            error=false;
            try {
                this.duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración: "));
                this.matriculaAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la matrícula de alumnos: "));
                this.costoPorEstudiante = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo por estudiante: "));
            } catch (Exception e) {
                error=true;
                JOptionPane.showMessageDialog(null,"Debe ingresesar un número válido", "ERROR",0);
            }
        } while(error);

    }   

    /*
     * MÉTODO MOSTRAR CURSO
     */

    public void mostrarCurso() {
        String mensaje = String.format("Nombre: %s\nDuración: %d años\nMatrícula: %d\nCosto: $%.2f", this.nombreCurso, this.duracion, this.matriculaAlumnos, this.costoPorEstudiante);
    
        JOptionPane.showMessageDialog(null, mensaje, "Información del Curso", 1);
    }

    /*
     * MÉTODO CALCULAR COSTO CURSO
     */

    public double calcularCostoFinal() {
        return this.costoPorEstudiante; // El costo básico en la clase base es simplemente el costo por estudiante
    }

    /*
     * MÉTODO CALCULAR RECAUDADO POR CURSO
     */

     public double calcularTotalRecaudado() {
        return this.matriculaAlumnos * this.costoPorEstudiante;
    }
    

}
