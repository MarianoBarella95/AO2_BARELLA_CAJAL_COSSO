package AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.*;
import javax.swing.JOptionPane;

public class CursoHibrido extends Curso {
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
    
    public CursoHibrido() {
        super();
        this.ubicacion = "";
        this.plataforma = "";
        this.horario = horario.TURNO_MAÑANA;
    }

    public CursoHibrido(String nombreCurso, int duracion, Double matriculaAlumno, Double costoPorEstudiante, String ubicacion, String plataforma, Horario horario) {
        super(nombreCurso, duracion, matriculaAlumno, costoPorEstudiante);
        this.ubicacion = ubicacion; 
        this.plataforma = plataforma;
        this.horario = horario; 
    }

    public void cargaHibrido(int nCurso) {
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
}
