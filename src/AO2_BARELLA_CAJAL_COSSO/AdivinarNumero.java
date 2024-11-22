package AO2_BARELLA_CAJAL_COSSO;

import java.time.Duration;
import java.time.Instant;
import javax.swing.JOptionPane;

public class AdivinarNumero {

    static Instant comienza;
    static Instant termina;

    static int nJugadores;
    static String[] nombres;
    static int[] intentos;
    static int[] errores;
    static long[] tiempos;

    public static void main(String[] args) {
        // Solicitar cantidad de jugadores con validación
        nJugadores = leerEntero("Ingrese la cantidad de jugadores", "Cantidad de Participantes");

        // Inicializar vectores
        nombres = new String[nJugadores];
        intentos = new int[nJugadores];
        errores = new int[nJugadores];
        tiempos = new long[nJugadores];

        // Ingresar nombres de los jugadores
        for (int i = 0; i < nJugadores; i++) {
            String nombre;
            do {
                nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del Jugador " + (i + 1), "Datos Jugador", 1);
                if (nombre == null || nombre.isEmpty() || !nombre.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre válido", "Error!!", 0);
                } else {
                    nombres[i] = nombre;
                }
            } while (nombres[i] == null);
        }

        // Juego principal
        for (int i = 0; i < nJugadores; i++) {
            JOptionPane.showMessageDialog(null, "Turno Jugador " + nombres[i], "Turnero", 1);
            comienza = Instant.now();

            int numAleatorio = (int) (Math.random() * 100);
            System.out.println("Número aleatorio: " + numAleatorio);
            int contaIntentos = 0;

            int numero;
            do {
                numero = leerEntero("Ingrese un número", "Elección Nro");
                contaIntentos++;

                if (numero == numAleatorio) {
                    JOptionPane.showMessageDialog(null, "Usted ha adivinado el número " + numAleatorio + " en " + contaIntentos + " intentos", "Felicitaciones!!", 1);
                    termina = Instant.now();
                } else if (numAleatorio > numero) {
                    JOptionPane.showMessageDialog(null, "Demasiado bajo... Ingrese un número mayor", "Nueva Elección", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Demasiado alto... Ingrese un número menor", "Nueva Elección", 1);
                }
            } while (numero != numAleatorio);

            intentos[i] = contaIntentos;
            errores[i] = contaIntentos - 1;
            Duration duracion = Duration.between(comienza, termina);
            tiempos[i] = duracion.getSeconds();
        }

        // Menú de estadísticas
        int opcion = -1;
        do {
            String[] opciones = {
                "Ganador del Premio",
                "Jugador más rápido",
                "Jugador más lento",
                "Jugador con menor performance",
                "Promedio de errores entre jugadores",
                "Informe Final",
                "Finalizar Estadísticas"
            };

            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione la Operación que desea realizar...", "Estadísticas",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (seleccion != null) {
                opcion = java.util.Arrays.asList(opciones).indexOf(seleccion);
            } else {
                opcion = 6;
            }

            switch (opcion) {
                case 0 -> JOptionPane.showMessageDialog(null, menosIntentos(), "Ganador!!", 1);
                case 1 -> JOptionPane.showMessageDialog(null, masRapido(), "Jugador más rápido", 1);
                case 2 -> JOptionPane.showMessageDialog(null, masLento(), "Jugador más lento", 1);
                case 3 -> JOptionPane.showMessageDialog(null, menorPerformance(), "Menor Performance", 1);
                case 4 -> JOptionPane.showMessageDialog(null, promErrores(), "Promedio Total Errores", 1);
                case 5 -> informeFinal();
                default -> JOptionPane.showMessageDialog(null, "Estadísticas Finalizadas");
            }
        } while (opcion != 6);
    }

    // Método para leer un número entero con validación
    public static int leerEntero(String mensaje, String titulo) {
        int numero = 0;
        boolean valido = false;
        do {
            try {
                String entrada = JOptionPane.showInputDialog(null, mensaje, titulo, 1);
                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada. Saliendo del programa.", "Cancelar", 0);
                    System.exit(0);
                }
                numero = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido", "Error!!", 0);
            }
        } while (!valido);
        return numero;
    }

    // Estadísticas
    public static String menosIntentos() {
        int menorIntentos = intentos[0];
        int pos = 0;

        for (int i = 1; i < intentos.length; i++) {
            if (intentos[i] < menorIntentos) {
                menorIntentos = intentos[i];
                pos = i;
            }
        }
        return "El jugador " + nombres[pos] + " ha ganado con " + menorIntentos + " intentos.";
    }

    public static String masRapido() {
        long menorTiempo = tiempos[0];
        int pos = 0;

        for (int i = 1; i < tiempos.length; i++) {
            if (tiempos[i] < menorTiempo) {
                menorTiempo = tiempos[i];
                pos = i;
            }
        }
        return "El jugador " + nombres[pos] + " ha sido el más rápido con " + menorTiempo + " segundos.";
    }

    public static String masLento() {
        long mayorTiempo = tiempos[0];
        int pos = 0;

        for (int i = 1; i < tiempos.length; i++) {
            if (tiempos[i] > mayorTiempo) {
                mayorTiempo = tiempos[i];
                pos = i;
            }
        }
        return "El jugador " + nombres[pos] + " ha sido el más lento con " + mayorTiempo + " segundos.";
    }

    public static String menorPerformance() {
        int peorIntentos = intentos[0];
        int mayorErrores = errores[0];
        int pos = 0;

        for (int i = 1; i < intentos.length; i++) {
            if (intentos[i] > peorIntentos && errores[i] > mayorErrores) {
                peorIntentos = intentos[i];
                mayorErrores = errores[i];
                pos = i;
            }
        }
        return "El jugador " + nombres[pos] + " tuvo la peor performance con " + peorIntentos + " intentos y " + mayorErrores + " errores.";
    }

    public static String promErrores() {
        int sumaErrores = 0;

        for (int error : errores) {
            sumaErrores += error;
        }
        double promedio = (double) sumaErrores / errores.length;
        return "El promedio de errores es " + promedio + ".";
    }

    public static void informeFinal() {
        String mensaje = menosIntentos() + "\n" + masRapido() + "\n" + promErrores();
        JOptionPane.showMessageDialog(null, mensaje, "Informe Final", 1);
    }
}
