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
    protected static double costoBasePresencial = 1000.0;

    
    /*
     * GETTERS & SETTERS
     */
  
    public String getNombreCurso() {
        return nombreCurso;
    }

    public static double getCostoBasePresencial() {
        return costoBasePresencial;
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
    
    
            switch (seleccion) {
                case 0:
                    CursoPresencial nuevoCursoPresencial = new CursoPresencial();
                    nuevoCursoPresencial.cargaPresencial(i);
                    listaCursos[cantidadCursos] = nuevoCursoPresencial;
                    cantidadCursos++;
                    Curso.setCostoBasePresencial(nuevoCursoPresencial.getCostoPorEstudiante());
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

        
        for (int i = 0; i < cantidadCursos; i++) {
            Curso curso = listaCursos[i];
            if (curso instanceof CursoPresencial) {
                ((CursoPresencial)curso).mostrarCursoPresencial();
            } else if (curso instanceof CursoOnline) {
                ((CursoOnline)curso).mostrarCursoOnline();
            } else if (curso instanceof CursoHibrido) {
                ((CursoHibrido)curso).mostrarCursoHibrido();
            }
            
            if (cantidadCursos > 1) {
                int opcion = JOptionPane.showConfirmDialog(null, "Ver siguiente curso", "Listado de Cursos",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                
                if (opcion == JOptionPane.NO_OPTION) {
                           
                            }
            } else if (cantidadCursos == listaCursos.length-1) {
                JOptionPane.showMessageDialog(null, "No hay más cursos por mostrar.", null, JOptionPane.INFORMATION_MESSAGE);
            }
        }
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

    /*
     * MÉTODO PARA SETEAR EL COSTO DEL CURSO PRESENCIAL
     * (PARA CALCULAR EL COSTO DEL ONLINE)
     */

    public static void setCostoBasePresencial(double costo) {
        costoBasePresencial = costo;
    }
    
    

}
