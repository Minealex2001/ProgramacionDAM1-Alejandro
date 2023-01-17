import java.util.Scanner;

public class ejercicioObligatorio {
    public static void main(String[] args) {

        //Declaramos el scanner
        Scanner entrada = new Scanner(System.in);
        double precio = 0;
        do{
        //Declaramos la variable donde almacenaremos el numero de contrato.
        //El numero de contrato lo pedimos desde el metodo.
        String numeroContrato = numContrato(entrada);
        double potenciaContratada = potenciaContratada(entrada);
        double kwUtilizada = kwUtilizada(entrada);
        precio = precio + precio(potenciaContratada, kwUtilizada);
        }while
    }

    //Metodo que devuelve un String con el numero de contrato.
    public static String numContrato(Scanner entrada) {
        System.out.print("Hola, para comenzar, introduce tu numero de contrato con el formato 'ddd-dddd': ");
        String numero = entrada.nextLine();
        while(numero.matches("-\\d[7]")){
            System.err.println("[ERROR] El formato introducido no es valido.");
            System.out.print("Introduce tu numero de contrato con el formato 'ddd-dddd': ");
            numero = entrada.nextLine();
        }
    return numero;
    }

    public static double potenciaContratada(Scanner entrada) {
        System.out.println("Ahora, introduce la potencia contratada:");
        double numero = entrada.nextDouble();
        while(numero!=3.45&&numero!=4.60&&numero!=5.75&&numero!=6.90&&numero!=8.05){
            System.err.println("[ERROR] La potencia contratada no es valida.");
            System.out.println("Introduce la potencia contratada:");
            numero = entrada.nextDouble();
        }
        return numero;
    }

    public static double kwUtilizada(Scanner entrada) {
        System.out.println("Ahora, introduce los kW utilizada en el utlimo mes:");
        double numero = entrada.nextDouble();
        while(numero<=0){
            System.err.println("[ERROR] El formato introducido no es valido.");
            System.out.println("Introduce los kW utilizada en el utlimo mes:");
            numero = entrada.nextDouble();
        }
        return numero;
    }

    public static double precio(double potenciaContratada, double kwUtilizada) {
        double numero=0;
        switch(potenciaContratada){
            case 3.45:
            numero = 10.23;
            break;

            case 4.60:
            numero = 14.45;
            break;

            case 5.75:
            numero = 15.69;
            break;

            case 6.90:
            numero = 21.34;
            break;

            case 8.05:
            numero = 25.99;
            break;

            default:
            break;
        }

        if(kwUtilizada>=0&&kwUtilizada<=150){
            numero = numero + (kwUtilizada * 0.1684);
        }else if(kwUtilizada>150&&kwUtilizada<=300){
            numero =  numero + ((kwUtilizada * 0.1684)*1.05);
        }else if(kwUtilizada>300&&kwUtilizada<=400){
            numero =  numero + ((kwUtilizada * 0.1684)*1.08);
        }else{
            numero =  numero + ((kwUtilizada * 0.1684)*1.12);
        }

        return numero;
    }
}
