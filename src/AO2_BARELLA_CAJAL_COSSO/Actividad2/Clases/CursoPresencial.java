package AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases;

import javax.swing.JOptionPane;


import AO2_BARELLA_CAJAL_COSSO.Actividad2.*;

public class CursoPresencial extends Curso {
    protected String ubicacion;
    protected String plataforma;
    protected Horario horario;

    /*
     * GETTERS & SETTERS
     */

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /*
     * MÉTODOS CONSTRUCTORES
     */

    public CursoPresencial() {
        super();
        this.ubicacion = "";
        this.plataforma = "";
        this.horario = Horario.TURNO_MAÑANA;
    }

    public CursoPresencial(String nombreCurso, int duracion, int matriculaAlumno, Double costoPorEstudiante, String ubicacion, String plataforma, Horario horario) {
        super(nombreCurso, duracion, matriculaAlumno, costoPorEstudiante);
        this.ubicacion = ubicacion; 
        this.plataforma = plataforma;
        this.horario = horario; 
    }

    
    @Override
    public String toString() {
        return super.toString() + "CursoPresencial [ubicacion=" + ubicacion + ", plataforma=" + plataforma + ", horario=" + horario + "]";
    
    }
    /*
     * MÉTODO CARGA
     */
    
    public void cargaPresencial(int nCurso) {
        JOptionPane.showMessageDialog(null, "Carga del curso: "+(nCurso), null, 1);
        super.cargaCurso();
        this.ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación: ");
        this.plataforma = JOptionPane.showInputDialog("Ingrese la plataforma: ");
        
        Horario[] tipos=Horario.values();// convierte las constantes del enum en un arreglo de strings

        Horario seleccionTipo=(Horario) JOptionPane.showInputDialog(null, "Seleccione el Horario",
        "Turnos Horarios",JOptionPane.QUESTION_MESSAGE,null, tipos, tipos[0]);

        if (seleccionTipo!=null){
            this.horario=seleccionTipo;
        } else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de Colectivo válido","Advertencia", 2);
        }
    }

    /*
     * MÉTODO MOSTRAR CURSO PRESENCIAL
     */

    public void mostrarCursoPresencial() {
        super.mostrarCurso();    
        String mensaje = String.format("\nUbicación: %s\nPlataforma: %s\nHorario: %s", this.ubicacion, this.plataforma, this.horario);
        
        JOptionPane.showMessageDialog(null, mensaje, "Información del Curso Presencial", 1);

    }
}
