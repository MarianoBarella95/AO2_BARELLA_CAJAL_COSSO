package AO2_BARELLA_CAJAL_COSSO.Actividad2;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.*;
import AO2_BARELLA_CAJAL_COSSO.Actividad2.Tipo_Cursos;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class demoCursos {
    public static void main(String[] args) {

        Icon icono = new ImageIcon("pregunta.png");

        int cursosACrear = 0;
        Object[] aCursos = new Object[cursosACrear];
        
        boolean condition = true;
        
        do {
            
            String[] opciones = {
                "Registrar Nuevo Curso",
                "Listar Curso", 
                "Calcular Costo Final del Curso",
                "Mostrar Cursos (Matrícula)",
                "Buscar Cursos (Nombre)",
                "Mostrar Total Recaudado",
                "Salir"
                };


            int opcion = JOptionPane.showOptionDialog(null, "Elija una opción", "Menú de Selección",0, JOptionPane.QUESTION_MESSAGE, icono, opciones, opciones[0]);
            
            switch (opcion) {
                case 0:
                    regCurso(aCursos, cursosACrear);
                    // CursoPresencial[] cursoPres = new CursoPresencial[10]; //límite de cursos presenciales que podrán ingresarse al array
                    // cursoPres[0] = new CursoPresencial();
                    // cursoPres[1] = new CursoPresencial();
                    // cursoPres[2] = new CursoPresencial();

                    // CursoOnline[] cursoVirtual= new CursoOnline[10];
                    // cursoVirtual[3] = new CursoOnline();
                    // cursoVirtual[4] = new CursoOnline();
                    // cursoVirtual[5] = new CursoOnline();

                    // CursoHibrido[] cursoSemi= new CursoHibrido[10];
                    // cursoSemi[6] = new CursoHibrido();
                    // cursoSemi[7] = new CursoHibrido();
                    // cursoSemi[8] = new CursoHibrido();
                    break;
                case 1:
                    if (aCursos.length == 0) {
                        JOptionPane.showMessageDialog(null, "No hay cursos registrados.", null, 1);
                    } else {
                        for (Object curso : aCursos) {
                            JOptionPane.showMessageDialog(null, curso.toString(), "Cursos", 1);
                        }
                    }
                    break;
                case 6:
                    condition = false;
                    break;
                default:
                    break;
            }


        } while (condition);
    }
    
    public static Object[] regCurso(Object[] aCursos, int cursosACrear) {

        cursosACrear = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cursos a crear: "));
        aCursos = new Curso[cursosACrear];

        for (int i = 0; i < aCursos.length; i++) {
            Tipo_Cursos.values();
    
            String[] opciones = {"Presencial", "Online", "Híbrido"};
            
            int selec = JOptionPane.showOptionDialog(null, "Elija el tipo de curso número: "+(i+1), "Elegir", 0, 2, null, opciones, opciones[0]);
            
            switch (selec) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Seleccionaste Presencial", null, 1);
                    CursoPresencial cursoPresencial = new CursoPresencial();
                    cursoPresencial.cargaPresencial(i+1);
                    aCursos[i] = cursoPresencial;
                    break;
                case 1: 
                    JOptionPane.showMessageDialog(null, "Seleccionaste Online", null, 1);
                    CursoOnline cursoOnline = new CursoOnline();
                    cursoOnline.cargaOnline(i+1);  // Implementar cargaOnline para esta clase
                    aCursos[i] = cursoOnline;
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, "Seleccionaste Híbrido", null, 1);
                    CursoHibrido cursoHibrido = new CursoHibrido();
                    cursoHibrido.cargaHibrido(i+1);  // Implementar cargaHibrido para esta clase
                    aCursos[i] = cursoHibrido;
                    break;    
                default:
                    JOptionPane.showMessageDialog(null, "Error", null, 1);
                    break;
            }
            
        }
        return aCursos;
    }

}
