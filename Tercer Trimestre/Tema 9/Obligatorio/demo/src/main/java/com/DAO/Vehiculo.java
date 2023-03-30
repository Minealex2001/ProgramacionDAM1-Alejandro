package com.DAO;

public abstract class Vehiculo {
    
    private static float PRECIOBASE=50; 
    // atributos miembro
    private String matricula;

     //constructores
    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

   //métodos abstractos
    public abstract float precioAlquilerVehiculo(int dias);
    public abstract String info();

    /**
     * @return the pRECIOBASE
     */
    public static float getPRECIOBASE() {
        return PRECIOBASE;
    }

    /**
     * @param pRECIOBASE the pRECIOBASE to set
     */
    public static void setPRECIOBASE(float pRECIOBASE) {
        PRECIOBASE = pRECIOBASE;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }



}