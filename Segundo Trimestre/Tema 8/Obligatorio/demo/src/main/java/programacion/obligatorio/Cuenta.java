package programacion.obligatorio;

public class Cuenta {

    private int numeroCuenta;
    private double saldoDisponible;
    public Cuenta(int numeroCuenta, double saldoDisponible) {
        this.numeroCuenta = numeroCuenta;
        this.saldoDisponible = saldoDisponible;
    }
    
    public int getNumeroCuenta() {
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
    
