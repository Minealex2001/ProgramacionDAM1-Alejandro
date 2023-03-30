/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

public abstract class VehiculoCarga extends Vehiculo {
    
    //Atributos miembro
    private static final float TASA_PMA = 20;
    private float pma;
   

    //Constructores
    public VehiculoCarga(float pma, String matricula) {
        super(matricula);
        this.pma = pma;
    }


    //set y get
    public float getPma() {
        return pma;
    }
    public void setPma(float pma) {
        this.pma = pma;
    }
    public static float getTASA_PMA() {
        return TASA_PMA;
    }

    //Métodos
    @Override
    public abstract float precioAlquilerVehiculo(int dias);
     
}
