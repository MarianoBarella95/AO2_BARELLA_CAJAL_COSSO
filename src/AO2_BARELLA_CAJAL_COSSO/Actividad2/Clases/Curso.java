package AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases;



import javax.swing.JOptionPane;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.Tipo_Cursos;


public class Curso {
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
     * MÉTODO REGISTRAR CURSO
     */

     public static int registrarCursos(Curso[] listaCursos, int maxCursos, int cantidadCursos) {
        if (cantidadCursos >= maxCursos) {
            JOptionPane.showMessageDialog(null, "Se alcanzó el límite máximo de cursos.");
            return cantidadCursos;
        }
    
        int cursosACrear = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos cursos desea crear?"));
    
        for (int i = 0; i < cursosACrear; i++) {
            if (cantidadCursos >= maxCursos) {
                JOptionPane.showMessageDialog(null, "No hay más espacio para cursos.");
                break;
            }
    
            String[] opciones = {"Presencial", "Online", "Híbrido"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de curso:", "Registrar Curso",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    
            // Curso nuevoCurso;
    
            switch (seleccion) {
                case 0:
                    CursoPresencial nuevoCursoPresencial = new CursoPresencial();
                    nuevoCursoPresencial.cargaPresencial(i);
                    listaCursos[cantidadCursos] = nuevoCursoPresencial;
                    cantidadCursos++;
                    break;
                    case 1:
                    CursoOnline nuevoCursoOnline = new CursoOnline();
                    nuevoCursoOnline.cargaOnline(i);
                    listaCursos[cantidadCursos] = nuevoCursoOnline;
                    cantidadCursos++;
                    break;
                    case 2:
                    CursoHibrido nuevoCursoHibrido = new CursoHibrido();
                    nuevoCursoHibrido.cargaHibrido(i);
                    listaCursos[cantidadCursos] = nuevoCursoHibrido;
                    cantidadCursos++;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Selección no válida.");
                    continue;
            }
    
            // nuevoCurso.cargaCurso(); 
        }
    
        return cantidadCursos;
    }

    /*
     * LISTAR CURSOS
     */
    
     public static void listarCursos(Curso[] listaCursos, int cantidadCursos) {
        if (cantidadCursos == 0) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.");
            return;
        }
    
        StringBuilder listado = new StringBuilder("Lista de Cursos:\n");
    
        for (int i = 0; i < cantidadCursos; i++) {
            listado.append((i + 1)).append(". ").append(listaCursos[i].toString()).append("\n");
        }
    
        JOptionPane.showMessageDialog(null, listado.toString(), "Cursos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }
     


    /*
     * MÉTODO CALCULAR COSTO CURSO
     */

    public double calcularCostoFinal() {
        return this.costoPorEstudiante;
    }

    /*
     * MÉTODO CALCULAR RECAUDADO POR CURSO
     */

     public double calcularTotalRecaudado() {
        return this.matriculaAlumnos * this.costoPorEstudiante;
    }
    

}
