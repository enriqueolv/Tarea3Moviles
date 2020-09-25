package com.example.myapplication;

public class Taco {
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

}
