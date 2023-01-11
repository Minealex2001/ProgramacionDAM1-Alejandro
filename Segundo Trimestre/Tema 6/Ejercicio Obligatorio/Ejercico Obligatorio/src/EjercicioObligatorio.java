import java.util.Scanner;

public class EjercicioObligatorio {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String nombre[] = new String[8];
        System.arraycopy(nomalu(entrada), 0, nombre, 0, 8);

        char respuestas[][] = new char[8][numpregun(entrada)];
        System.arraycopy(notas(entrada), 0, respuestas, 0, respuestas[].length);

        
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

    public static int numpregun(Scanner entrada) {
        int numero = 0;
        while(numero<=0){
        System.out.print("¿Cuantas preguntas tiene el examen?");
        numero = entrada.nextInt();
        }
        return numero;
    }
}