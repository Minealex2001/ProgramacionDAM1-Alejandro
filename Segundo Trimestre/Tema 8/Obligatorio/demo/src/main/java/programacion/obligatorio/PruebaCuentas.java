package programacion.obligatorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Integer.parseInt(entrada.readLine());
 *
 */

public class PruebaCuentas {

  public static void main(String[] args)
    throws NumberFormatException, IOException {BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    int respuesta, numeropersona = 0;
    double saldoDisponible;
    Boolean correcto;
    String DNI, numeroCuenta, numeroCuenta2;
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
          DNI = entrada.readLine();
          personas[numeropersona] = new Persona(DNI);
          numeropersona++;
          break;

        case 2:
        correcto = false;
          if (numeropersona != 0) {
            System.out.println("¿A que persona quieres asociar la cuenta?");
            DNI = entrada.readLine();
              for (int i = 0; i < numeropersona; i++) {
                if (personas[i].getDNI().equals(DNI)) {
                  System.out.println("¿Cual es el numero de cuenta?");
                  numeroCuenta = entrada.readLine();
                  System.out.println("¿Cual es el saldo disponible?");
                  saldoDisponible = Double.parseDouble(entrada.readLine());
                  if (personas[i].agregarCuenta(numeroCuenta, saldoDisponible)) {
                    System.out.println("La cuenta se ha añadido correctamente.");
                    correcto = true;
                  }else{
                    System.err.println("[ERROR] Has llegado al limite de cuentas.");
                    correcto = true;
                  }
                }
              }
            if(!correcto){
              System.err.println("[ERROR] No se ha podido encontrar al usuario. Intentelo de nuevo");
            }
          } else {
            System.err.println(
              "[ERROR] Primero tienes que añadir una persona"
            );
          }
          break;
        case 3:
        correcto = false;
        if (numeropersona != 0) {
          System.out.println("¿Que persona quieres mostrar?");
          DNI = entrada.readLine();
          for (int i = 0; i < numeropersona; i++) {
            if (personas[i].getDNI().equals(DNI)) {
              personas[i].mostrarPersona();
              correcto = true;
            }
          }
          if(!correcto){
            System.err.println("[ERROR] No se ha podido encontrar al usuario. Intentelo de nuevo");
          }
        }else {
          System.err.println(
            "[ERROR] Primero tienes que añadir una persona"
          );
        }
          break;
        case 4:
        correcto = false;
        if (numeropersona != 0) {
          System.out.println("¿Que persona tiene que recibir la nomina?");
          DNI = entrada.readLine();
          for (int i = 0; i < numeropersona; i++) {
            System.out.println("¿A que cuenta quieres recibir la nomina?");
            numeroCuenta = entrada.readLine();
            System.out.println("¿Cuanto dinero vas a recibir?");
            saldoDisponible = Double.parseDouble(entrada.readLine());
            personas[i].recibirNomina(saldoDisponible, numeroCuenta);
            correcto = true;
          }
          if(!correcto){
            System.err.println("[ERROR] No se ha podido encontrar al usuario. Intentelo de nuevo");
          }
        }else {
          System.err.println("[ERROR] Primero tienes que añadir una persona");
        }
          break;

        case 5:
        correcto = false;
        if (numeropersona != 0) {
          System.out.println("¿Que persona tiene que realizar el pago?");
          DNI = entrada.readLine();
          for (int i = 0; i < numeropersona; i++) {
            System.out.println("¿Que cuenta tiene que realizar el pago?");
            numeroCuenta = entrada.readLine();
            System.out.println("¿Cuanto dinero vas a pagar?");
            saldoDisponible = Double.parseDouble(entrada.readLine());
            personas[i].realizarPago(numeroCuenta, saldoDisponible);
            correcto = true;
          }
          if(!correcto){
            System.err.println("[ERROR] No se ha podido encontrar al usuario. Intentelo de nuevo");
          }
        }else {
          System.err.println("[ERROR] Primero tienes que añadir una persona");
        }
          break;
        case 6:
        correcto = false;
        if (numeropersona != 0) {
          System.out.println("¿Que persona quieres elegir?");
          DNI = entrada.readLine();
          for (int i = 0; i < numeropersona; i++) {
            System.out.println("¿De que cuenta quieres realizar la transferencia?");
            numeroCuenta = entrada.readLine();
            System.out.println("¿A que cuenta quieres realizar la transferencia?");
            numeroCuenta2 = entrada.readLine();
            System.out.println("¿Cuanto dinero quieres transferir?");
            saldoDisponible = Double.parseDouble(entrada.readLine());
            personas[i].transferenciaEntreCuentas(numeroCuenta, numeroCuenta2, saldoDisponible);
            correcto = true;
          }
          if(!correcto){
            System.err.println("[ERROR] No se ha podido encontrar al usuario. Intentelo de nuevo");
          }
        }else {
          System.err.println("[ERROR] Primero tienes que añadir una persona");
        }
          break;

        case 7:
        for(int i=0; i<numeropersona; i++){
          personas[i].esMorosa();
        }
          break;

        default:
          break;
      }
    } while (respuesta != 0);
  }
}
