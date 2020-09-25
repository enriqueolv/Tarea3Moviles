package com.example.myapplication;

import java.io.Serializable;

public class Taco implements Serializable {
    private String carne;
    private int tipo_salsa;
    private boolean limon;
    private boolean cilantro;
    private boolean cebolla;

    public Taco (){}

    public Taco (String carne, int tipo_salsa, boolean limon, boolean cilantro, boolean cebolla){
        this.carne = carne;
        this.tipo_salsa = tipo_salsa;
        this.limon = limon;
        this.cilantro = cilantro;
        this.cebolla = cebolla;
    }


    ///GETTERS
    public String getCarne(){
        return this.carne;
    }
    public int getTipo_salsa(){
        return this.tipo_salsa;
    }
    public boolean getLimon(){
        return this.limon;
    }
    public boolean getCilantro(){
        return this.cilantro;
    }
    public boolean getCebolla(){
        return this.cebolla;
    }


    //SETTERS
    public void setCarne(String carne){
        this.carne = carne;
    }
    public void setTipo_salsa(int tipo_salsa){
        this.tipo_salsa = tipo_salsa;
    }
    public void setLimon(boolean limon){
        this.limon = limon;
    }
    public void setCilantro(boolean cilantro){
        this.cilantro = cilantro;
    }
    public void setCebolla(boolean cebolla){
        this.cebolla = cebolla;
    }
}
