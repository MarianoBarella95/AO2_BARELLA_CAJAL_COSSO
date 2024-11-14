package AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases;

import javax.swing.JOptionPane;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.Tipo_Cursos;
import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.Ingreso;
import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.Salida;

public class Curso {
    protected String nombreCurso;
    protected int duracion;
    protected Double matriculaAlumnos;
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

    public Double getMatriculaAlumnos() {
        return matriculaAlumnos;
    }
    
    public void setMatriculaAlumnos(Double matriculaAlumnos) {
        this.matriculaAlumnos = matriculaAlumnos;
    }

    public Double getCostoPorEstudiante() {
        return costoPorEstudiante;
    }

    public void setCostoPorEstudiante(Double costoPorEstudiante) {
        this.costoPorEstudiante = costoPorEstudiante;
    }
    
    /*
     * MÉTODOS CONSTRUCTORES
     */

    public Curso() {
        this.nombreCurso = "";
        this.duracion = 0;
        this.matriculaAlumnos = 0.0;
        this.costoPorEstudiante = 0.0;
    }

    public Curso(String nombreCurso, int duracion, Double matriculaAlumnos, Double costoPorEstudiante) {
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
                this.matriculaAlumnos = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la matrícula de alumnos: "));
                this.costoPorEstudiante = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo por estudiante: "));
            } catch (Exception e) {
                error=true;
                JOptionPane.showMessageDialog(null,"Debe ingresesar un número válido", "ERROR",0);
            }
        } while(error);

    }   




}
