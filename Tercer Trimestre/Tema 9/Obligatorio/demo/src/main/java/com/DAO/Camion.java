package com.DAO;

public class Camion extends VehiculoCarga {
    private final static float PRECIO_FIJO=40;
    
    private int ruedas;


    public Camion(float pma, String matricula) {
        super(pma, matricula);
        }
    
    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
    //métodos
    @Override
    public String info() {
        String infocamion;
        infocamion="CAMION\n"+"===========================\n"+
        "Matricula: "+getMatricula()+
        "\nPeso: "+getPma();
        return infocamion;
    }

    @Override
    public float precioAlquilerVehiculo(int dias) {
        float precio;
        precio=(VehiculoCarga.getTASA_PMA()* getPma()) + (getPRECIOBASE()*(float)dias) + PRECIO_FIJO;
        return precio;
    }

}