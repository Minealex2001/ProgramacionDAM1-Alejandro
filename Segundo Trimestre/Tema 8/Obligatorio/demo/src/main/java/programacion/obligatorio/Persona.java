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
    
    public boolean agregarCuenta(String numeroCuenta, double saldoDisponible) {
        boolean fin = true;
        if (contadorCuentas < 3) {
            cuentas_bancarias[contadorCuentas] = new Cuenta(numeroCuenta, saldoDisponible);
            contadorCuentas++;
            fin = true;
        } else {
            fin = false;
        }
        return fin;
    }

    public void mostrarPersona(){
        System.out.println("El DNI del usuario es: " + getDNI());
        System.out.println("Tiene " + contadorCuentas + " asociadas a su cuenta.");
        for(int i=0; i < contadorCuentas; i++){
            System.out.println("La cuenta con el numero " + cuentas_bancarias[i].getNumeroCuenta() + " tiene " + cuentas_bancarias[i].getSaldoDisponible() + " de saldo disponible."); 
        }
    }

    public void recibirNomina(double dinero, String numeroCuenta){
        for(int i=0; i < contadorCuentas; i++){
        if(numeroCuenta.equals(cuentas_bancarias[i].getNumeroCuenta())){
            cuentas_bancarias[i].setSaldoDisponible(cuentas_bancarias[i].getSaldoDisponible() + dinero);
        }
        }
    }
    public void realizarPago(String numeroCuenta, double dinero){
        for(int i=0; i< contadorCuentas; i++){
            if(numeroCuenta.equals(cuentas_bancarias[i].getNumeroCuenta())){
                        if(cuentas_bancarias[i].getSaldoDisponible()<dinero){
                            System.err.println("[ERROR] La cuenta no dispone de los fondos suficientes");
                        }else{
                            cuentas_bancarias[i].pagar(dinero);
                        }
                    }
                }
            }
            
    public void transferenciaEntreCuentas(String numeroCuenta1, String numeroCuenta2, double dinero){
        for(int i=0; i< contadorCuentas; i++){
            if(numeroCuenta1.equals(cuentas_bancarias[i].getNumeroCuenta())){
                for(int j=0; j < contadorCuentas; j++){
                    if(numeroCuenta2.equals(cuentas_bancarias[j].getNumeroCuenta())){
                        if(cuentas_bancarias[i].getSaldoDisponible()<dinero){
                            System.err.println("[ERROR] La cuenta no dispone de los fondos suficientes");
                        }else{
                            cuentas_bancarias[i].pagar(dinero);
                            cuentas_bancarias[j].abonar(dinero);
                        }
                    }
                }
            }
        }
    }
    public void esMorosa() {
        for (int i = 0; i < contadorCuentas; i++) {
            if (cuentas_bancarias[i].getSaldoDisponible() < 0) {
                System.out.println("El usuario " + getDNI() + " tiene saldo negativo en cuenta.");
            }
        }
        }
    
    
}
