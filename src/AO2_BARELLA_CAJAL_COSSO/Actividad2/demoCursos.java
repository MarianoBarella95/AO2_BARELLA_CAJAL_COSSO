package AO2_BARELLA_CAJAL_COSSO.Actividad2;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.*;
import AO2_BARELLA_CAJAL_COSSO.Actividad2.Tipo_Cursos;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Collections;

public class demoCursos {
    public static void main(String[] args) {


        /*
         * ÍCONO PERSONALIZADO QUE NO FUNCIONÓ 😢
         */

        Icon icono = new ImageIcon("pregunta.png");

        /*
         * DECIDIMOS UTILIZAR ARRAYLIST
         * PARA QUE SEA MÁS FÁCIL MANEJAR 
         * EL TAMAÑO DEL ARRAY DE CURSOS
         */

        List <Curso> listaCursos = new ArrayList <Curso> ();
        
        boolean condition = true;
        
        /*
         * BUCLE PARA MOSTRAR EL MENÚ	
         */

        do {
            
            String[] opciones = {
                "Registrar Nuevo Curso",
                "Listar Curso", 
                "Calcular Costo Final del Curso",
                "Mostrar Cursos (Matrícula)",
                "Buscar Cursos (Nombre)",
                "Mostrar Total Recaudado",
                "Conteo por Tipo",
                "Salir"
                };

            /*
            * ACÁ CON UN ARRAY DE STRING
            * SE PASAN LAS OPCIONES A APARECER
            * EN EL MENÚ
            */               

            int opcion = JOptionPane.showOptionDialog(null, "Elija una opción", "Menú de Selección",0, JOptionPane.QUESTION_MESSAGE, icono, opciones, opciones[0]);
            
            switch (opcion) {
                case 0:
                    regCurso(listaCursos);
                    break;
                case 1:
                    if (listaCursos.size() == 0) {
                        JOptionPane.showMessageDialog(null, "No hay cursos registrados.", null, 1);
                    } else {
                        listarCursosIndividualmente(listaCursos);
                    }
                    break;
                case 2: 
                    calcularCosto(listaCursos);
                    break;
                case 3:
                    ordenarMatricula(listaCursos);
                    break;
                case 4:
                    buscarCursoPorNombre(listaCursos);
                    break;
                case 5:
                    mostrarTotalesPorCurso(listaCursos);
                    break;
                case 6:
                    contarCursosTipo(listaCursos);
                    break;
                case 7:
                    String saludoFinal = "Gracias por usar nuestro programa.\nAtte. Naza, Flor y Mariano";
                    JOptionPane.showMessageDialog(null, saludoFinal, null, 1);
                    condition = false;
                    break;
                default:
                    break;
            }


        } while (condition);
    }
    
    /*
     * MÉTODO PARA REGISTRAR CURSOS Y CARGARLOS AL ARRAYLIST 
     */

    public static void regCurso(List<Curso> listaCursos) {

        int cursosACrear = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cursos a crear: "));
        
        for (int i = 0; i < cursosACrear; i++) {
            Tipo_Cursos.values();
    
            String[] opciones = {"Presencial", "Online", "Híbrido"};
            
            int selec = JOptionPane.showOptionDialog(null, "Elija el tipo de curso número: "+(i+1), "Elegir", 0, 2, null, opciones, opciones[0]);
            
            switch (selec) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Seleccionaste Presencial", null, 1);
                    CursoPresencial cursoPresencial = new CursoPresencial();
                    cursoPresencial.cargaPresencial(i+1);
                    listaCursos.add(cursoPresencial);
                    break;
                case 1: 
                    JOptionPane.showMessageDialog(null, "Seleccionaste Online", null, 1);
                    CursoOnline cursoOnline = new CursoOnline();
                    cursoOnline.cargaOnline(i+1);  // Implementar cargaOnline para esta clase
                    listaCursos.add(cursoOnline);
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, "Seleccionaste Híbrido", null, 1);
                    CursoHibrido cursoHibrido = new CursoHibrido();
                    cursoHibrido.cargaHibrido(i+1);  // Implementar cargaHibrido para esta clase
                    listaCursos.add(cursoHibrido);
                    break;    
                default:
                    JOptionPane.showMessageDialog(null, "Error", null, 1);
                    break;
            }
            
        }
    }

    /*
     * MÉTODO PARA LISTAR LOS CURSOS CREADOS
     */

    private static void listarCursosIndividualmente(List<Curso> listaCursos) {
        if (listaCursos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.");
            return;
        }
    
        for (int i = 0; i < listaCursos.size(); i++) {
            Curso curso = listaCursos.get(i);
            
            if (curso instanceof CursoPresencial) {
                ((CursoPresencial) curso).mostrarCursoPresencial();
            } else if (curso instanceof CursoOnline) {
                ((CursoOnline) curso).mostrarCursoOnline();
                
            } else if (curso instanceof CursoHibrido) {
                ((CursoHibrido) curso).mostrarCursoHibrido();
                
            }       

            if (listaCursos.size() > 1) {
                int opcion = JOptionPane.showConfirmDialog(null, "Ver siguiente curso", "Listado de Cursos",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
                if (opcion == JOptionPane.NO_OPTION) {
                    break; 
                }
            }
        }
    }

    /*
     * MÉTODO PARA CALCULAR COSTO DE CADA CURSO
     */

    public static void calcularCosto(List<Curso> listaCursos) {
        for (Curso curso : listaCursos) {
            double costoFinal = curso.calcularCostoFinal();
            String mensaje = String.format("El costo final del curso %s es: %.2f", curso.getNombreCurso(), costoFinal);
            JOptionPane.showMessageDialog(null, mensaje, "Costo Final del Curso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*
     * MÉTODO PARA BUSCAR CURSOS POR NOMBRE
     */

    public static void ordenarMatricula(List<Curso> listaCursos) {
        if (listaCursos.size() == 0) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.", null, 1);
        } else{

            ArrayList<Curso> copiaCursos = new ArrayList<>(listaCursos);

            Collections.sort(copiaCursos);
            for (Curso curso : copiaCursos) {
                curso.mostrarCurso();
            }
        }
    }

    /*
     * MÉTODO PARA BUSCAR CURSOS POR NOMBRE
     */

    public static void buscarCursoPorNombre(List<Curso> listaCursos) {
        
        /*
         * ME FIJO SI LA LISTA ESTÁ VACIA
         */
        
        if (listaCursos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.", "Buscar Curso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        /*
         * INGRESA EL NOMBRE DEL CURSO A BUSCAR
         * SE ASEGURA QUE SEA VÁLIDO EL DATO INGRESADO
         */

        String nombreBuscado = JOptionPane.showInputDialog(null, "Ingrese el nombre del curso a buscar:", "Buscar Curso", JOptionPane.QUESTION_MESSAGE);
        if (nombreBuscado == null || nombreBuscado.isBlank()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /*
         * RECORRO EL ARRAYLIST PARA ENCONTRARLO
         */

        boolean encontrado = false;
        for (Curso curso : listaCursos) {
            if (curso.getNombreCurso().equalsIgnoreCase(nombreBuscado)) {
                curso.mostrarCurso();
                encontrado = true;
            }
        }

        /*
         * MUESTRA MENSAJE EN CASO DE NO ENCONTRARLO
         */

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún curso con ese nombre.", "Resultado de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

    /*
     * MÉTODO PARA MOSTRAR EL TOTAL RECAUDADO POR CURSO
     */

    public static void mostrarTotalesPorCurso(List<Curso> listaCursos) {
        if (listaCursos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        /*
         * LISTA PARA ALMACENAR TOTALES
         */
        List<String> totales = new ArrayList<>();
        double totalGeneral = 0;
    
        for (Curso curso : listaCursos) {
            double totalCurso = curso.calcularTotalRecaudado();
            totalGeneral += totalCurso;
    
            // Agregar la información del curso a la lista de totales
            String detalle = String.format("Curso: %s - Total Recaudado: %.2f", curso.getNombreCurso(), totalCurso);
            totales.add(detalle);
        }
    
        /*
         * ORDENO ALFABETICAMENTE
         */
        totales.sort(String::compareTo);
    
        /*
         * MENSAJE PARA EL USUARIO
         */
        StringBuilder mensaje = new StringBuilder();
        for (String detalle : totales) {
            mensaje.append(detalle).append("\n");
        }
        mensaje.append(String.format("\nTotal General Recaudado: %.2f", totalGeneral));
    
        /*
         * MUESTRO TOTALES  
         */
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Totales Recaudados", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /*
     * COMO FUNCIONALIDAD ADICIONAL
     * DECIDIMOS AGREGAR UN MÉTODO 
     * QUE CUENTE LOS CURSOS SEGÚN SU TIPO (PRESENCIAL, ONLINE E HÍBRIDO)
     */

    public static void contarCursosTipo(List<Curso> listaCursos) {
    
        if (listaCursos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int cursosPresenciales = 0;
        int cursosOnline = 0;
        int cursosHibridos = 0;

        for (Curso curso : listaCursos) {
            if (curso instanceof CursoPresencial) {
                cursosPresenciales++;
            } else if (curso instanceof CursoOnline) {
                cursosOnline++;
            } else if (curso instanceof CursoHibrido) {
                cursosHibridos++;
            }
        }

        int totalCursos = cursosPresenciales + cursosOnline + cursosHibridos;


        String mensaje = String.format("Total de Cursos: %d\nCursos Presenciales: %d\nCursos Online: %d\nCursos Hibridos: %d", totalCursos, cursosPresenciales, cursosOnline, cursosHibridos);

        JOptionPane.showMessageDialog(null, mensaje, "Conteo de Cursos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
