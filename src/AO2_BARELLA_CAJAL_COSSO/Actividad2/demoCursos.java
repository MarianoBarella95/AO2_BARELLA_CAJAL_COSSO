package AO2_BARELLA_CAJAL_COSSO.Actividad2;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.*;
import AO2_BARELLA_CAJAL_COSSO.Actividad2.Tipo_Cursos;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class demoCursos {
    public static void main(String[] args) {

        Icon icono = new ImageIcon("pregunta.png");

        Object[] cantCursos = {};
        
        boolean condition = true;
        
        do {
            int cursosACrear = 0;
            
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
                    regCurso(cantCursos, cursosACrear);
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
                    JOptionPane.showMessageDialog(null,"La cantidad de cursos es: "+cantCursos.length, null, opcion);
                    break;
                case 6:
                    condition = false;
                    break;
                default:
                    break;
            }


        } while (condition);
    }
    
    public static void regCurso(Object[] cantCursos, int cursosACrear) {

        cursosACrear = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cursos a crear: "));
        
        cantCursos = new Object[cursosACrear];

        for (int i = 0; i < cantCursos.length; i++) {
            Tipo_Cursos.values();
    
            String[] opciones = {"Presencial", "Online", "Híbrido"};
            
            int selec = JOptionPane.showOptionDialog(null, "Elija el tipo de curso número: "+(i+1), "Elegir", 0, 2, null, opciones, opciones[0]);
            
            switch (selec) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Seleccionaste Presencial", null, 1);
                    CursoPresencial cursoPresencial = new CursoPresencial();
                    cursoPresencial.cargaPresencial();
                    cantCursos[i] = cursoPresencial;
                    break;
                case 1: 
                    JOptionPane.showMessageDialog(null, "Seleccionaste Online", null, 1);
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, "Seleccionaste Híbrido", null, 1);
                    break;    
                    default:
                    JOptionPane.showMessageDialog(null, "Error", null, 1);
                    break;
            }
            
        }

    }

}
