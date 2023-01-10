import java.util.Arrays;

public class Ejercicio16 {
    public static void main(String[] args) {
        int[] arr = new int[55]; // array de tamaño 55 para almacenar la secuencia
        int currentNumber = 1; // variable para almacenar el número actual
        int contador = 0;

        for (int i = 0; contador < arr.length; i++) {
            if (contador + currentNumber * currentNumber <= arr.length) {
                Arrays.fill(arr, contador, contador + currentNumber * currentNumber, currentNumber);
                contador += currentNumber;
                currentNumber++;
            } else {
                Arrays.fill(arr, contador, arr.length, currentNumber);
            }
        }

        // imprimir el array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
