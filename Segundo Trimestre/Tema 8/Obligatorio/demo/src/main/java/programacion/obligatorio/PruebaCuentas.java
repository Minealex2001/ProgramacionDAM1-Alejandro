package programacion.obligatorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Integer.parseInt(entrada.readLine());
 *
 */
public class PruebaCuentas {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader entrada = new BufferedReader(
      new InputStreamReader(System.in)
    );
    int respuesta, numeropersona = 0, persona, saldoDisponible;
    String numeroCuenta;
    Persona personas[] = new Persona[50];
    do {
      System.out.println("¿Que quieres realizar?");
      System.out.println("1. Añadir una persona");
      System.out.println("2. Añadir una Cuenta y asociar una persona");
      System.out.println("3. Mostrar datos de una persona");
      System.out.println("4. Recibe la nomina mensual");
      System.out.println("5. Recibe un pago");
      System.out.println("6. Realizar una transferencia");
      System.out.println("7. Mostrar las personas morosas");

      respuesta = Integer.parseInt(entrada.readLine());

      switch (respuesta) {
        case 1:
          System.out.println("¿Cual es el DNI?");
          String DNI = entrada.readLine();
          personas[numeropersona] = new Persona(DNI);
          numeropersona++;
          break;
        case 2:
          if(numeropersona != 0){
          System.out.println("¿A que persona quieres asociar la cuenta?");
          persona = Integer.parseInt(entrada.readLine());
          while(persona<numeropersona){
            System.err.println("La persona indicada no existe");
            System.out.println("¿A que persona quieres asociar la cuenta?");
            persona = Integer.parseInt(entrada.readLine());
          }
          System.out.println("¿Cual es el numero de cuenta?");
          numeroCuenta = entrada.readLine();
          System.out.println("¿Cual es el saldo disponible?");
          saldoDisponible = Integer.parseInt(entrada.readLine());
          personas[persona].agregarCuenta(numeroCuenta, saldoDisponible);
        }else{
          System.err.println("Primero tienes que añadir una persona");
        }
        break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        default:
          break;
      }
    } while (respuesta != 0);
  }
}
