package AO2_BARELLA_CAJAL_COSSO.Actividad2;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.*;
import AO2_BARELLA_CAJAL_COSSO.Actividad2.Tipo_Cursos;
import javax.swing.JOptionPane;

public class demoCursos {
    public static void main(String[] args) {

        Object[] cantCursos;

        boolean condition = true;

        do {
            
            String[] opciones = {
                "Registrar Nuevo Curso",
                "Listar Curso", 
                "Calcular Costo Final del Curso",
                "Mostrar Cursos (Por matrícula)",
                "Buscar Cursos (Nombre)",
                "Mostrar Total Recaudado",
                "Salir"
                };


            int opcion = JOptionPane.showOptionDialog(null, "Elija una opción", "Menú de Selección",0, 1, null, opciones, opciones[0]);
            
            switch (opcion) {
                case 0:
                    regCurso();
                    break;
                case 6:
                    condition = false;
                    break;
                default:
                    break;
            }


        } while (condition);
    }
    
    public static void regCurso() {

        Tipo_Cursos.values();

        String[] opciones = {"Presencial", "Online", "Híbrido"};
        
        int selec = JOptionPane.showOptionDialog(null, "Elija el tipo de curso: ", "Elegir", 0, 2, null, opciones, opciones[0]);
        
        switch (selec) {
            case 0:
                JOptionPane.showMessageDialog(null, "Seleccionaste Presencial", null, 1);
                CursoPresencial cP1 = new CursoPresencial();
                cP1.cargaPresencial();
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
