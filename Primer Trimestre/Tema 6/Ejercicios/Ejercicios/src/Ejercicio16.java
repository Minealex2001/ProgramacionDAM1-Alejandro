import java.util.Arrays;

public class Ejercicio16 {
    
    public static void main(String[] args) {

        int array[] = new int[55], control=0;
        for(int i=1; i<=10; i++){
            for(int u=0; u <=i;u++){
                Arrays.fill(array, i, control, u+1);
                control++;
            }
        }

        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
