package com.DAO;

public class Furgoneta extends VehiculoCarga {

    public Furgoneta(float pma, String matricula) {
        super(pma, matricula);
    }

    @Override
    public float precioAlquilerVehiculo (int dias){
        float precio;
        precio=(VehiculoCarga.getTASA_PMA()* getPma()) + (getPRECIOBASE()*(float)dias);
        return precio;
    }

    @Override
    public String info(){
        String infoFurgo;

        infoFurgo="FURGONETA\n"+"===========================\n"+
        "\nMatricula"+getMatricula() +
        "\nPMA: "+ getPma()+ " toneladas ";

        return infoFurgo;
    }
}