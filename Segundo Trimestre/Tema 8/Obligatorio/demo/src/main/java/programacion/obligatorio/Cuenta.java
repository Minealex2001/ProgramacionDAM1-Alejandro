package programacion.obligatorio;

public class Cuenta {

    private String numeroCuenta;
    private double saldoDisponible;
    public Cuenta(String numeroCuenta, double saldoDisponible) {
        this.numeroCuenta = numeroCuenta;
        this.saldoDisponible = saldoDisponible;
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public double getSaldoDisponible() {
        return saldoDisponible;
    }
    
    public void abonar(double cantidad) {
        saldoDisponible += cantidad;
    }
    
    public boolean pagar(double cantidad) {
        boolean fin = true;
        if (saldoDisponible >= cantidad) {
            saldoDisponible -= cantidad;
            fin = true;
        } else {
            fin = false;
        }
        return fin;
    }
}
    
