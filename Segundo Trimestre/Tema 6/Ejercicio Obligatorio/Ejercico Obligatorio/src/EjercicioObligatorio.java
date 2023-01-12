import java.util.Arrays;
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
        System.arraycopy(respuestaalumno(entrada, numpreguntas, nombre), 0, respuestas, 0, numpreguntas);

        char respuestascorrectas[] = new char[numpreguntas];
        System.arraycopy(respuestacorrecta(entrada, numpreguntas), 0, respuestascorrectas, 0, numpreguntas);


        menu(numpreguntas, nombre, respuestascorrectas, respuestas, entrada, numpreguntas);
        entrada.close();
    }

    //Metodo para pedir y almacenar los nombres de los alumnos.
    //String[] declaro que el resultado del metodo es un Array de String.
    public static String[] nomalu(Scanner entrada) {

            //Inicializo el array que almacenara los nombres dentro del metodo.
            String alumno[] = new String[8];

            //Realizo el bucle que me permitira dar vueltas por el array y almacenar los nombres.
            for(int i=0; i<alumno.length;i++){
                System.out.print("Introduce el nombre del alumno:");
                alumno[i]=entrada.nextLine();
            }

            //Devuelve como resultado el array con los nombres.
            return alumno;
    }

    //Metodo para pedir y almacenar el numero de preguntas que tendra el examen.
    public static int numPregun(Scanner entrada) {

        //Declaro la variable que almacenara dentro del metodo el numero de preguntas.
        //Lo inicializo con 0 para que siempre entre la primera vez, se podria hacer con un do-while.
        int numero = 0;

        /*Como metodo de control, realizo un while que estara siempre dando vueltas mientras el valor de numero
         * sea menor o igual a 0, ya que no puede haber un numero de preguntas negativas o nulas.
         */
        while(numero<=0){
            System.out.print("¿Cuantas preguntas tiene el examen?");
            numero = entrada.nextInt();

            //Este if solo es para mostrar un mensaje de error cuando el numero no cumpla con lo requerido.
            if(numero<=0){
                System.err.println("[ERROR] El numero de preguntas no puede ser menor o igual a 0.");
            }
        }
        
        //Devuelve como resultado el numero de preguntas despues de pasar por el control de datos.
        return numero;
    }

    /*Metodo para pedir y almacenar las respuestas de los alumnos.
     * char[] declaro que el resultado del metodo es un Array de char.
     * Importo Scanner entrada para poder utilizar el escaner dentro del metodo
     * Importo int numpreguntas para utilizar el numero de preguntas y creear el array bidimensional igual al de main
     * Importo String nombre[] para poder mostrar el nombre de los alumnos y asi sea más entendible para el usuario
     */
    public static char[][] respuestaalumno(Scanner entrada, int numpreguntas, String nombre[]) {

        //Inicializo el array bidimensional que almacenara las respuestas y a que alumno refieren dentro del metodo.
        char respuestas[][] = new char[8][numpreguntas];

        //Hago un bucle para ir cambiando el alumno del cual se quieren almacenar las respuestas.
        for(int i=0; i < 8; i++){

            System.out.println("Introduce las respuestas para el alumno "+ nombre[i]);

            //Hago un bucle para ir cambiando las preguntas del cual se quieren almacenar las respuestas.
            for(int j=0;j<numpreguntas;j++){

                System.out.print("Introduce la respuesta para la pregunta " + j + ": ");
                String resultado = entrada.nextLine();
                entrada.nextLine();
//while(resultado.equalsIgnoreCase("A")||resultado.equalsIgnoreCase("B")||resultado.equalsIgnoreCase("C")||resultado.equalsIgnoreCase("D")||resultado.equalsIgnoreCase("E")){

                /*Como metodo de control, realizo un while que estara siempre dando vueltas mientras el valor de resultado
                * sea distinto de A, B, C, D o E, ya que no hay más respuestas aceptables.
                */
                while(!resultado.matches("[A-E]")){
                    System.err.println("[ERROR] La respuesta tiene que estar entre la A y la E");
                    System.out.print("Introduce la respuesta para la pregunta " + j + ": ");
                    resultado = entrada.nextLine();
                }
                /*Al haber leido un array en el escaner anterior, uso esta linea para sacar el primer
                * caracter para añadirlo en el array de char para las respuestas de los alumnos.
                */
                respuestas[i][j] = resultado.charAt(0);
            }
        }
        return respuestas;
    }

    public static char[] respuestacorrecta(Scanner entrada, int numpreguntas) {
        char respuestas[] = new char[numpreguntas];

        for(int i=0; i < numpreguntas;i++){
            System.out.print("Escribe la respuesta para la pregunta " + i + " ");
            String resultado = entrada.nextLine();

//while(resultado.equalsIgnoreCase("A")||resultado.equalsIgnoreCase("B")||resultado.equalsIgnoreCase("C")||resultado.equalsIgnoreCase("D")||resultado.equalsIgnoreCase("E")){

            /*Como metodo de control, realizo un while que estara siempre dando vueltas mientras el valor de resultado
            * sea distinto de A, B, C, D o E, ya que no hay más respuestas aceptables.
            */
            while(!resultado.matches("[A-E]")){
                System.err.println("[ERROR] La respuesta tiene que estar entre la A y la E");
                System.out.print("Escribe la respuesta para la pregunta " + i + " ");
                resultado = entrada.nextLine();
            }
            /*Al haber leido un array en el escaner anterior, uso esta linea para sacar el primer
            * caracter para añadirlo en el array de char para las respuestas correctas.
            */
            respuestas[i] = resultado.charAt(0);
        }
        return respuestas;
    }

    public static void menu( String nombre[], char respuestascorrectas[], char respuestaalumno[][], Scanner entrada, int numpreguntas ) {
            //Muestro el menu.
            System.out.println("Opción 1 Notas: Muestra la nota obtenida de cada estudiante. Esta nota corresponde al número de aciertos que tuvo el estudiante.");
            System.out.println("Opción 2 Media: Muestra la media de aciertos de los 8 alumnos.");
            System.out.println("Opción 3 Nota Alumno: dado un nombre de un alumno, muestra su nota.");
            System.out.println("Opción 4 Pregunta: Muestra el número de la pregunta más acertada");
            
            String res = entrada.nextLine();
            switch(res){
                case "1":
                    notastotales(nombre, respuestascorrectas, respuestaalumno, numpreguntas);
            }
    }

    public static void notastotales(String nombre[], char respuestascorrectas[], char respuestaalumno[][], int numpreguntas) {

        int nota[] = new int[8];

        Arrays.fill(nota, 0);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < numpreguntas ; j++){
                if(respuestaalumno[i][j] == respuestascorrectas[i]){
                    nota[i] = nota[i] + 1;
                }
            }
        System.out.println("La nota del alumno " + nombre[i] + " es: " + nota[i]);
        }
    }
    public static void media(char respuestascorrectas[], char respuestaalumno[][], int numpreguntas) {
        int nota = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < numpreguntas ; j++){
                if(respuestaalumno[i][j] == respuestascorrectas[i]){
                    nota = nota + 1;
                }
            }
        }
        System.out.println("La nota media de la clase es: " + (nota/8));
        
        menu(null, respuestascorrectas, respuestaalumno, null, numpreguntas);
    }
}