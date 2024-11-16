package AO2_BARELLA_CAJAL_COSSO;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

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
        int numero=0;
        int numAleatorio;
        int contaErrores;
        boolean validacion=false;

        do{
            try {
                nJugadores=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de jugadores", "Cantidad de Participantes", 1));
                validacion=true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero entero", "Error!!", 0);
            }
        }while(!validacion); 

        int participantes=1;
        nombres=new String[nJugadores];
        intentos=new int[nJugadores];
        errores=new int[nJugadores];
        tiempos=new long[nJugadores];
        
        nombreJugador(nombres); 

            do{
                JOptionPane.showMessageDialog(null, "Turno Jugador "+nombres[participantes-1], "Turnero", 1);
                comienza=Instant.now();

                numAleatorio=(int)(Math.random()*100);
                System.out.println("numero aleatorio "+numAleatorio);
                int contaIntentos=0;

                do {
                    try {
                        numero=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número", "Elección Nro", 1));
                        contaIntentos++;
                        
                        if(numero==numAleatorio){
                            JOptionPane.showMessageDialog(null, "Usted ha adivinado el número "+numAleatorio+" en "+contaIntentos+" intentos", "Felicitaciones!!", 1);
                            termina=Instant.now();
                        }
                        else if (numAleatorio>numero) {
                            JOptionPane.showMessageDialog(null, "Demasiado bajo...Ingrese un número mayor", "Nueva Elección", 1);
                        
                        } else{
                            JOptionPane.showMessageDialog(null, "Demasiado alto...Ingrese un número menor", "Nueva Elección", 1);
                            
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un numero entero", "Error!!", 0);
                    }
                     
                } while (numero!=numAleatorio);
                
                intentos[participantes-1]=contaIntentos;

                contaErrores=contaIntentos-1;

                errores[participantes-1]=contaErrores;

                Duration duracion=Duration.between(comienza, termina); 
                tiempos[participantes-1]=duracion.getSeconds(); 
                
                participantes++;
            
            }while(participantes<=nJugadores);
    
           
        /*
         * MENÚ CON ESTADÍSTICAS
         */
        int opcion=-1;

        do {
                String[] opcionNro = {
                "Ganador del Premio", 
                "Jugador más rápido", 
                "Jugador más lento", 
                "Jugador con menor performance", 
                "Promedio de errores entre jugadores",
                "Informe Final", 
                "Finalizar Estadísticas"
                };
                
                String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione la Operación que desea realizar...", "Estadísticas",
                JOptionPane.QUESTION_MESSAGE, null, opcionNro, opcionNro[0]); 
                if (seleccion != null) {
                opcion=Arrays.asList(opcionNro).indexOf(seleccion); 
                } else {
                    opcion=6; 
                }    

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, menosIntentos(nombres, intentos), "Ganador!!",1);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, masRapido(nombres, tiempos),"Jugador más rápido", 1);
                    break;
                case 2:
                    masLento(nombres, tiempos);
                    break;
                case 3:
                    menorPerformance(nombres, intentos, errores);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, promErrores(nombres, errores), "Promedio Total Errores",1);
                    break;
                case 5:
                    informe();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Estadísticas Finalizada");
                    System.exit(0);
                    break;
            }
        } while (opcion!=6); 
    }

   


    /*
     * INGRESAMOS EL NOMBRE DEL JUGADOR 
    */
    public static void nombreJugador(String[] nombres){
        String nombre;

        for (int i=0; i<nombres.length; i++) {
            do{
                nombre=JOptionPane.showInputDialog(null, "Ingrese nombre del Jugador "+(i+1), "Datos Jugador", 1);
                
                if (nombre==null||nombre.isEmpty()||!nombre.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre válido", "Error!!", 0);
                } else {
                    nombres[i]=nombre;
                }
            }while(nombre==null||nombre.isEmpty()||!nombre.matches("[a-zA-Z]+"));
        }
    }


    /*
     * JUGADOR CON MENOS INTENTOS
     */
    public static String menosIntentos(String[] nombres, int[] intentos){
        int menosInt=intentos[0];
        int pos=0;

        for(int i=0; i<intentos.length; i++){
            if(intentos[i]<menosInt){
                menosInt=intentos[i];
                pos=i;
            }
        }
        return "El jugador "+nombres[pos]+" ha ganado el premio!!"+" con en el menor número de intentos>>> "+menosInt+" total";
    }


    /*
     * JUGADOR MÁS RÁPIDO
     */
    public static String masRapido(String[] nombres, long[] tiempos){
        long menosTiempo=tiempos[0];
        int pos=0;

        for(int i=0; i<tiempos.length; i++){
            if(tiempos[i]<menosTiempo){
                menosTiempo=tiempos[i];
                pos=i;
            }
        }
        return "El jugador "+nombres[pos]+" ha tardado "+menosTiempo+" segundos en adivinar el número, siendo el que menor tiempo ha hecho de todos los jugadores";
    }


    /*
     * JUGADOR MÁS LENTO
     */
    public static void masLento(String[] nombres, long[] tiempos){
        long masTiempo=tiempos[0];
        int pos=0;

        for(int i=0; i<tiempos.length; i++){
            if(tiempos[i]>masTiempo){
                masTiempo=tiempos[i];
                pos=i;
            }
        }
        JOptionPane.showMessageDialog(null, "El jugador "+nombres[pos]+" ha tardado "+masTiempo+" segundos en adivinar el número, siendo el que mayor tiempo ha hecho de todos los jugadores","Jugador más lento", 1);
    }


    /*
     * ACÁ MUESTRA EL JUGADOR CON MEJOR PERFORMANCE
     */
    public static void menorPerformance(String[] nombres, int[] intentos, int[] errores){
        int masInt=intentos[0];
        int masError=errores[0];
        int pos=0;

        for(int i=0; i<intentos.length&&i<errores.length; i++){
            if(intentos[i]>masInt&&errores[i]>masError){
                masInt=intentos[i];
                masError=errores[i];
                pos=i;
            }
        }
        JOptionPane.showMessageDialog(null, "El jugador "+nombres[pos]+" es el que menor performance ha tenido con "+masInt+" intentos y "+masError+" errores totales", "Menor Performance",1);
    }


    /*
     * PROMEDIO DE ERRORES
     */
    public static String promErrores(String[] nombres, int[] errores){
        int sumaError=errores[0];
        double promErrores;

        for(int i=0; i<errores.length; i++){
            sumaError+=errores[i];
        }
        promErrores=(sumaError/nombres.length);
        return "El promedio de errores entre todos los jugadores es de "+promErrores+" errores";
    }


   /*
    * ACÁ MUESTRA EL INFORME INFORME FINAL
    */
    public static void informe() {
        String mensaje="";
        mensaje+="\n"+menosIntentos(nombres, intentos);
        mensaje+="\n"+masRapido(nombres, tiempos);
        mensaje+="\n"+promErrores(nombres, errores);
        JOptionPane.showMessageDialog(null, mensaje, "Informe Final", 1);
    }
}
