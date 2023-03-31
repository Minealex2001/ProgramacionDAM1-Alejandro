package com.principal;

/*
 * Ejercicio obligatorio
 * Made by Alejandro Sánchez Pinto
 * Github: https://github.com/Minealex2001
 */

//Imports necesarios
import java.util.Scanner;
import com.DAO.Alquiler;
import com.DAO.Coche;
import com.DAO.Furgoneta;
import com.DAO.MicroBus;

public class principal 
{
    public static void main( String[] args )
    {

        //Declaracion de las varibales necesarias asi como el scanner.
        Scanner entrada = new Scanner(System.in);
        int respuesta;
        String tipoVehiculo;

        //Menu.
        do{
        System.out.println("Menu: ");
        System.out.println("1. Añadir Vehiculo.");
        System.out.println("2. Obten el precio del alquiler.");
        System.out.println("3. Mostrar todos los precios.");
        System.out.println("4. Salir.");

        respuesta = entrada.nextInt();

        //Una vez leemos el numero introduccido entramos en un caso diferente del Switch.
        switch (respuesta) {
            case 1:

                //Preguntamos que tipo de vehiculo que quiere añadir.
                System.out.println("¿Que tipo de vehiculo quieres añadir?");
                tipoVehiculo = entrada.nextLine();

                //Dependiendo del vehiculo entrara en un caso diferente, ya que he decidido que cada vehiculo tenga
                //un metodo diferente para que el main no tenga una gran cantidad de codigo.
                switch (tipoVehiculo) {
                    case "Coche":
                        añadirCoche(entrada);
                        break;
                    
                    case "Furgoneta":
                        añadirFurgoneta(entrada);
                        break;

                    case "MicroBus":
                        añadirMicroBus(entrada);
                        break;

                    case "Camion":

                    break;

                    case "VeiculoCarga":

                    break;


                    default:
                        break;
                }
                
                break;
        
            case 2:

                break;

            case 3:

                break;
            default:
                break;
        }

        }while(respuesta != 4);

        entrada.close();
    }



    //Metodo que utilizamos para añadir los coches.
    public static void añadirCoche(Scanner entrada){
        String matricula;
        int plazas;        
        do{
            System.out.println("¿Cual es la matricula del coche a añadir?");
            matricula = entrada.nextLine();
        }while(!comprobarMatricula(matricula));

        do{
            System.out.println("¿Cuantas plazas tiene el coche?");
            plazas = entrada.nextInt();
        }while(comporbarPlazas(plazas));


        Alquiler.añadirvehiculo(new Coche(matricula, plazas));
    }

    //Metodo con el que añadimos las furgonetas.
    public static void añadirFurgoneta(Scanner entrada){
        String matricula;
        int pma;        
        do{
            System.out.println("¿Cual es la matricula de la furgoneta a añadir?");
            matricula = entrada.nextLine();
        }while(!comprobarMatricula(matricula));

        do{
            System.out.println("¿Cual es la PMA de la furgoneta en Toneladas?");
            pma = entrada.nextInt();
        }while(!comprobarPMA(pma));

        Alquiler.añadirvehiculo(new Furgoneta(pma, matricula));
    }

    public static void añadirMicroBus(Scanner entrada){
        String matricula;
        int plazas;        
        do{
            System.out.println("¿Cual es la matricula del MicroBus a añadir?");
            matricula = entrada.nextLine();
        }while(!comprobarMatricula(matricula));

        do{
            System.out.println("¿Cuantas plazas tiene el MicroBus?");
            plazas = entrada.nextInt();
        }while(comporbarPlazas(plazas));


        Alquiler.añadirvehiculo(new MicroBus(matricula, plazas));
    }

    //Metodo con el que devolvemos un booleano al comprobar si el formato de la matricula es correcta.
    public static boolean comprobarMatricula(String matricula){
        return matricula.matches("^\\d{4}[a-zA-Z]{3}$");
    }

    //Metodo en el que devolvemos un booleano al comprobar si el numero de plazas es correcto.
    public static boolean comporbarPlazas(int plazas){
        boolean correcto;

        if(plazas<=0){
            correcto = false;
        }else{
            correcto = true;
        }
        return correcto;
    }

    //Metodo en el cual devolvemos un booleano al comprobar si la PMA es correcta.
    public static boolean comprobarPMA(int pma){
        boolean correcto;

        if(pma<=0){
            correcto = false;
        }else{
            correcto = true;
        }
        return correcto;
        
    }
}
