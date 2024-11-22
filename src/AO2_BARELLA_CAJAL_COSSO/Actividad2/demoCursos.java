package AO2_BARELLA_CAJAL_COSSO.Actividad2;

import AO2_BARELLA_CAJAL_COSSO.Actividad2.Clases.*;
import javax.swing.JOptionPane;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class demoCursos {
    public static void main(String[] args) {


        /*
         * ÍCONO PERSONALIZADO QUE NO FUNCIONÓ 😢
         */

        Icon icono = new ImageIcon("pregunta.png");

        /*
         * DEFINO UN ARRAY DE TAMAÑO FIJO MÁXIMO
         */

        int maxCursos = 10;
        Curso[] listaCursos = new Curso[maxCursos];
        int cantidadCursos = 0;
        
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
                    cantidadCursos = Curso.registrarCursos(listaCursos, maxCursos, cantidadCursos);
                    break;
                case 1:
                    if (cantidadCursos == 0) {
                        JOptionPane.showMessageDialog(null, "No hay cursos registrados.", null, 1);
                    } else {
                        Curso.listarCursos(listaCursos, cantidadCursos);
                    }
                    break;
                case 2: 
                    calcularCosto(listaCursos, cantidadCursos);
                    break;
                case 3:
                    ordenarMatricula(listaCursos, cantidadCursos);
                    break;
                case 4:
                    buscarCursoPorNombre(listaCursos, cantidadCursos);
                    break;
                case 5:
                    mostrarTotalesPorCurso(listaCursos, cantidadCursos);
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
    
    // /*
    //  * MÉTODO PARA REGISTRAR CURSOS Y CARGARLOS AL ARRAY
    //  */

    //  public static void regCurso(Curso[] listaCursos, int maxCursos, int cantidadCursos) {
    //     if (cantidadCursos >= maxCursos) {
    //         JOptionPane.showMessageDialog(null, "Se ha alcanzado el límite de cursos.", "Error", JOptionPane.ERROR_MESSAGE);
    //         return; // No permite registrar más cursos
    //     }
    
    //     int cursosACrear = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cursos a crear: "));
    
    //     for (int i = 0; i < cursosACrear; i++) {
    //         if (cantidadCursos >= maxCursos) {
    //             JOptionPane.showMessageDialog(null, "No hay más espacio para cursos.", "Error", JOptionPane.ERROR_MESSAGE);
    //             break; // Termina el ciclo si no hay espacio
    //         }
    
    //         String[] opciones = {"Presencial", "Online", "Híbrido"};
    //         int selec = JOptionPane.showOptionDialog(null, "Elija el tipo de curso número: " + (cantidadCursos + 1), "Elegir", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
    
    //         switch (selec) {
    //             case 0:
    //                 JOptionPane.showMessageDialog(null, "Seleccionaste Presencial", null, JOptionPane.INFORMATION_MESSAGE);
    //                 CursoPresencial cursoPresencial = new CursoPresencial();
    //                 cursoPresencial.cargaPresencial(cantidadCursos + 1); // Configura los datos del curso presencial
    //                 listaCursos[cantidadCursos] = cursoPresencial; // Agrega el curso al arreglo
    //                 cantidadCursos++; // Incrementa el contador de cursos
    //                 break;
    //             case 1:
    //                 JOptionPane.showMessageDialog(null, "Seleccionaste Online", null, JOptionPane.INFORMATION_MESSAGE);
    //                 CursoOnline cursoOnline = new CursoOnline();
    //                 cursoOnline.cargaOnline(cantidadCursos + 1); // Configura los datos del curso online
    //                 listaCursos[cantidadCursos] = cursoOnline; // Agrega el curso al arreglo
    //                 cantidadCursos++; // Incrementa el contador de cursos
    //                 break;
    //             case 2:
    //                 JOptionPane.showMessageDialog(null, "Seleccionaste Híbrido", null, JOptionPane.INFORMATION_MESSAGE);
    //                 CursoHibrido cursoHibrido = new CursoHibrido();
    //                 cursoHibrido.cargaHibrido(cantidadCursos + 1); // Configura los datos del curso híbrido
    //                 listaCursos[cantidadCursos] = cursoHibrido; // Agrega el curso al arreglo
    //                 cantidadCursos++; // Incrementa el contador de cursos
    //                 break;
    //             default:
    //                 JOptionPane.showMessageDialog(null, "No se seleccionó ningún tipo de curso.", "Error", JOptionPane.ERROR_MESSAGE);
    //                 break;
    //         }
    //     }
    // }
    
    /*
     * MÉTODO PARA LISTAR LOS CURSOS CREADOS
     */

    //  private static void listarCursosIndividualmente(Curso[] listaCursos, int cantidadCursos) {
    //     if (cantidadCursos == 0) {
    //         JOptionPane.showMessageDialog(null, "No hay cursos registrados.");
    //         return;
    //     }
    
    //     for (int i = 0; i < cantidadCursos; i++) {
    //         Curso curso = listaCursos[i];
    
    //         if (curso instanceof CursoPresencial) {
    //             ((CursoPresencial) curso).mostrarCursoPresencial();
    //         } else if (curso instanceof CursoOnline) {
    //             ((CursoOnline) curso).mostrarCursoOnline();
    //         } else if (curso instanceof CursoHibrido) {
    //             ((CursoHibrido) curso).mostrarCursoHibrido();
    //         }
    
    //         if (i < cantidadCursos - 1) { // Mostrar opción para continuar si hay más cursos
    //             int opcion = JOptionPane.showConfirmDialog(null, "Ver siguiente curso", "Listado de Cursos",
    //                     JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
    
    //             if (opcion == JOptionPane.NO_OPTION) {
    //                 break;
    //             }
    //         }
    //     }
    // }
    
    

    /*
     * MÉTODO PARA CALCULAR COSTO DE CADA CURSO
     */

    public static void calcularCosto(Curso[] listaCursos, int cantidadCursos) {
        for (int i = 0; i < cantidadCursos; i++) {
            Curso curso = listaCursos[i];
            Double costoFinal = curso.calcularCostoFinal();
            String mensaje = String.format("El costo final del curso %s es: %.2f", curso.getNombreCurso(), costoFinal);
            JOptionPane.showMessageDialog(null, mensaje, "Costo Final del Curso", JOptionPane.INFORMATION_MESSAGE);
        }   
    }

    /*
     * MÉTODO PARA ORDENAR MATRÍCULA
     */

     public static void ordenarMatricula(Curso[] listaCursos, int cantidadCursos) {
        if (cantidadCursos == 0) {
            JOptionPane.showMessageDialog(null, "No hay cursos.", "Ordenar por Matrícula - Error", JOptionPane.INFORMATION_MESSAGE);
            return; 
        }
    

        for (int i = 0; i < cantidadCursos - 1; i++) {
            int indiceMin = i; 
            for (int j = i + 1; j < cantidadCursos; j++) { 
                if (listaCursos[j].getMatriculaAlumnos() < listaCursos[indiceMin].getMatriculaAlumnos()) {
                    indiceMin = j;
                }
            }
    
 
            Curso temp = listaCursos[indiceMin];
            listaCursos[indiceMin] = listaCursos[i];
            listaCursos[i] = temp;
        }
    

        /*
         * MUESTRA CURSOS ORDENADOS
         */

        StringBuilder mensaje = new StringBuilder("Cursos ordenados por matrícula:\n");
        for (int i = 0; i < cantidadCursos; i++) {
            mensaje.append(listaCursos[i].getNombreCurso())
                   .append(" - Matrícula: ")
                   .append(listaCursos[i].getMatriculaAlumnos())
                   .append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Ordenar por Matrícula", JOptionPane.INFORMATION_MESSAGE);
    }
    

    /*
     * MÉTODO PARA BUSCAR CURSOS POR NOMBRE 
     * MEDIANTE BÚSQUEDA LINEAL
     */

    public static void buscarCursoPorNombre(Curso[] listaCursos, int cantidadCursos) {
    
        if (cantidadCursos == 0) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.", "Buscar Curso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    
        String nombreBuscado = JOptionPane.showInputDialog(null, "Ingrese el nombre del curso a buscar:", "Buscar Curso", JOptionPane.QUESTION_MESSAGE);
        if (nombreBuscado == null || nombreBuscado.isBlank()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        boolean encontrado = false;
        for (int i = 0; i < cantidadCursos; i++) {
            if (listaCursos[i].getNombreCurso().equalsIgnoreCase(nombreBuscado)) {
                listaCursos[i].mostrarCurso();
                encontrado = true;
            }
        }
    
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún curso con ese nombre.", "Resultado de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    

    /*
     * MÉTODO PARA MOSTRAR EL TOTAL RECAUDADO POR CURSO
     */

    public static void mostrarTotalesPorCurso(Curso[] listaCursos, int cantidadCursos) {
        if (cantidadCursos == 0) {
            JOptionPane.showMessageDialog(null, "No hay cursos registrados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        /*
         * VARIABLES PARA CALCULAR LOS TOTALES
         */
        String[] totales = new String[cantidadCursos];
        double totalGeneral = 0;
    
        for (int i = 0; i < cantidadCursos; i++) {
            double totalCurso = listaCursos[i].calcularTotalRecaudado();
            totalGeneral += totalCurso;
    
            totales[i] = String.format("Curso: %s - Total Recaudado: %.2f", listaCursos[i].getNombreCurso(), totalCurso);
        }
    
        /*
         * ORDENAMIENTO ALFABÉTICO (Selection Sort)
         */
        for (int i = 0; i < cantidadCursos - 1; i++) {
            int indiceMin = i;
            for (int j = i + 1; j < cantidadCursos; j++) {
                if (totales[j].compareTo(totales[indiceMin]) < 0) {
                    indiceMin = j;
                }
            }
    
            // Intercambio
            String temp = totales[indiceMin];
            totales[indiceMin] = totales[i];
            totales[i] = temp;
        }
    
        /*
         * CREACIÓN DEL MENSAJE FINAL
         */
        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < cantidadCursos; i++) {
            mensaje.append(totales[i]).append("\n");
        }
        mensaje.append(String.format("\nTotal General Recaudado: %.2f", totalGeneral));
    
        /*
         * MOSTRAR LOS TOTALES
         */
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Totales Recaudados", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /*
     * COMO FUNCIONALIDAD ADICIONAL
     * DECIDÍ AGREGAR UN MÉTODO 
     * QUE CUENTE LOS CURSOS SEGÚN SU TIPO (PRESENCIAL, ONLINE E HÍBRIDO)
     */

    public static void contarCursosTipo(Curso[] listaCursos) {
    
        if (listaCursos.length == 0) {
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
