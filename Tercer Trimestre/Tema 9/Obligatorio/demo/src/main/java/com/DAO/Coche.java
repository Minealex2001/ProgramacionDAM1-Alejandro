package com.DAO;

public class Coche extends Vehiculo {
    //atributos
    private int plazas;  
   
    //constructor   
    public Coche(String matricula, int plazas){
        super(matricula);
        this.plazas=plazas;
    }

    //get y set
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
        precio = (getPRECIOBASE()* (float)dias) + ((float)getPlazas() * 1.5f * (float)dias);
        return precio;
    }            
       
    public String info(){ 
        String infococh;
       
        infococh="COCHE\n"+"===========================\n"+
                "\nPlazas: "+getPlazas();    
       
        return infococh;
    }
  
    
}