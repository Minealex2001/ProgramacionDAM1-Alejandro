import java.util.Scanner;

public class EjercicioObligatorio {
    public static void main(String[] args) {
        //Inicializo el escaner.
        Scanner entrada = new Scanner(System.in);

        //Declaro la variable que utilizare para almacenar los nombres.
        String nombre[] = new String[8];

        /* Aqui utilizo un system.arraycopy para copiar el array que me dara como resultado el metodo que llamo
         * dentro de la misma linea "nomalu(entrada)" y lo almaceno en el array previamente declarado e instanciado "nombre".
         */
        System.arraycopy(nomalu(entrada), 0, nombre, 0, 8);
        //Aqui declaro una variable que me servira para saber el numero de preguntas y le doy el valor que da como resultado "numPregun(entrada)".
        int numpreguntas = numPregun(entrada);
        char respuestas[][] = new char[8][numpreguntas];

        /* Aqui utilizo un system.arraycopy para copiar el array que me dara como resultado el metodo que llamo
         * dentro de la misma linea "notas(entrada, numpreguntas, nombre)" y lo almaceno en el array 
         * previamente declarado e instanciado "respuestas".
         */
        System.arraycopy(notas(entrada, numpreguntas, nombre), 0, respuestas, 0, numpreguntas);

        
        //Muestro el menu
        System.out.println("Opción 1 Notas: Muestra la nota obtenida de cada estudiante. Esta nota corresponde al número de aciertos que tuvo el estudiante.");
        System.out.println("Opción 2 Media: Muestra la media de aciertos de los 8 alumnos.");
        System.out.println("Opción 3 Nota Alumno: dado un nombre de un alumno, muestra su nota.");
        System.out.println("Opción 4 Pregunta: Muestra el número de la pregunta más acertada");
        
        entrada.close();
    }

    public static String[] nomalu(Scanner entrada) {
            String alumno[] = new String[8];
            for(int i=0; i<alumno.length;i++){
                System.out.print("Introduce el nombre del alumno:");
                alumno[i]=entrada.nextLine();
            }
            return alumno;
    }

    public static int numPregun(Scanner entrada) {
        int numero = 0;
        while(numero<=0){
        System.out.print("¿Cuantas preguntas tiene el examen?");
        numero = entrada.nextInt();
        }
        return numero;
    }

    public static char[][] notas(Scanner entrada, int numero, String nombre[]) {

        char respuestas[][] = new char[8][numero];

        for(int i=0; i < 8; i++){

            System.out.print("Introduce las respuestas para el alumno "+ nombre[i]);

            for(int j=0;j<numero;j++){

                System.out.print("Introduce la respuesta para la pregunta " + j);
                String resultado = entrada.nextLine();

                //while(resultado.equalsIgnoreCase("A")||resultado.equalsIgnoreCase("B")||resultado.equalsIgnoreCase("C")||resultado.equalsIgnoreCase("D")||resultado.equalsIgnoreCase("E")){
                while(!resultado.matches("[a-e]")){
                    System.out.print("Introduce la respuesta para la pregunta " + j);
                    resultado = entrada.nextLine();
                }
                respuestas[i][j] = resultado.charAt(0);
            }
        }
        return respuestas;
    }
}