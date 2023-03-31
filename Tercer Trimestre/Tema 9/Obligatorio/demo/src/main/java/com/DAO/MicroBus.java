package com.DAO;


public class MicroBus extends Vehiculo {

    private final static int PRECIO_PLAZA=2;
    private int plazas;

    //constructores
    public MicroBus(String matricula, int plazas) {
        super(matricula);
        this.plazas = plazas;
    }

    public static int getPrecioPlaza() {
        return PRECIO_PLAZA;
    }
 
    public int getPlazas() {
        return plazas;
    }
    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    //métodos
    @Override
    public float precioAlquilerVehiculo (int dias){
        float precio;
        precio = (getPRECIOBASE()* (float)dias);
        precio = precio + ((float)getPlazas() * 1.5f * (float)dias);
        precio = precio + ((float)getPlazas() * PRECIO_PLAZA);
        return precio;
    }
    @Override
    public String info(){
        String infomicroB;

        infomicroB="MICROBUS\n"+"===========================\n"+
        "\nPlazas: "+getPlazas();
        return infomicroB;
    }
}
