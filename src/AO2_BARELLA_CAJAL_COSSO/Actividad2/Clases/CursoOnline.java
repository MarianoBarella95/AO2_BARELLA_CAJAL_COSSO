package AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.*;
import javax.swing.JOptionPane;

public class CursoOnline extends Curso {
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
    
    public CursoOnline() {
        super();
        this.ubicacion = "";
        this.plataforma = "";
        this.horario = Horario.TURNO_MAÑANA;
    }

    public CursoOnline(String nombreCurso, int duracion, int matriculaAlumno, Double costoPorEstudiante, String ubicacion, String plataforma, Double horario) {
        super(nombreCurso, duracion, matriculaAlumno, costoPorEstudiante);
        this.ubicacion = ubicacion; 
        this.plataforma = plataforma;

       
    }

    /*
     * MÉTODO CARGA
     */

    public void cargaOnline(int nCurso) {
        super.cargaCurso();

        Double costoBase = Curso.getCostoBasePresencial();
        this.setCostoPorEstudiante(costoBase*0.85);

        this.ubicacion = JOptionPane.showInputDialog("Ingrese la ubicación: ");
        this.plataforma = JOptionPane.showInputDialog("Ingrese la plataforma: ");
        
        Horario[] tipos=Horario.values();

        Horario seleccionTipo=(Horario) JOptionPane.showInputDialog(null, "Seleccione el Horario",
        "Turnos Horarios",JOptionPane.QUESTION_MESSAGE,null, tipos, tipos[0]);

        if (seleccionTipo!=null){
            this.horario=seleccionTipo;
        } else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de Colectivo válido","Advertencia", 2);
        }
    }

    /*
     * MÉTODO MOSTRAR CURSO ONLINE
     */

     @Override
     public String toString() {
         return super.toString() + " [ubicacion=" + ubicacion + ", plataforma=" + plataforma + ", horario=" + horario + "]";
     }
     

    public void mostrarCursoOnline() {
        super.mostrarCurso();    
        String mensaje = String.format("\nUbicación: %s\nPlataforma: %s\nHorario: %s", this.ubicacion, this.plataforma, this.horario);
        
        JOptionPane.showMessageDialog(null, mensaje, "Información del Curso", 1);

    }

    /*
     * MÉTODO CALCULAR COSTO ONLINE
     */


    public double calcularCostoFinal() {
        return Curso.costoBasePresencial * 0.85; 
    }


}
