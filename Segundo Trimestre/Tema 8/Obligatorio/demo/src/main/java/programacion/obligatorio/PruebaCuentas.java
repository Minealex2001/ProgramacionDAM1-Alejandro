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
    int respuesta;
    do {
      System.out.print("¿Que quieres realizar?");
      System.out.print("1. Añadir una persona");
      System.out.print("2. Añadir una Cuenta y asociar una persona");
      System.out.print("3. Mostrar datos de una persona");
      System.out.print("4. Recibe la nomina mensual");
      System.out.print("5. Recibe un pago");
      System.out.print("6. Realizar una transferencia");
      System.out.print("7. Mostrar las personas morosas");

      respuesta = Integer.parseInt(entrada.readLine());

      switch (respuesta) {
        case 1:
        
          break;
        case 2:
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
