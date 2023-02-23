package programacion.obligatorio;

public class Persona  {
    private String DNI;
    private Cuenta[] cuentas_bancarias = new Cuenta[3];
    private int contadorCuentas;

    public Persona(String DNI) {
        this.DNI = DNI;
        contadorCuentas = 0;
    }
    
    public String getDNI() {
        return DNI;
    }
    
    public boolean agregarCuenta(Cuenta cuenta) {
        boolean fin = true;
        if (contadorCuentas < 3) {
            cuentas_bancarias[contadorCuentas] = cuenta;
            contadorCuentas++;
            fin = true;
        } else {
            fin = false;
        }
        return fin;
    }
    
    public boolean esMorosa() {
        boolean fin = true;
        for (int i = 0; i < contadorCuentas; i++) {
            if (cuentas_bancarias[i].getSaldoDisponible() < 0) {
                fin = true;
            }
        }
        fin = false;
        return fin;
    }
    
    
}
