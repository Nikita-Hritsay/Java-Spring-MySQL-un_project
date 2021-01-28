package com.example.Practice6.entity;


public class home {
    private int id_home;
    private int amountOfMetres;
    private int peaple;

    public int getAmountOfMetres(){
        return amountOfMetres;
    }

    public int getPeaple(){
        return peaple;
    }

    public String getId_home(){
        return Integer.toString(id_home);
    }

    public home( int amountOfMetres, int peaple){
        this.amountOfMetres = amountOfMetres;
        this.peaple = peaple;
    }
    public home( int id_home, int amountOfMetres, int peaple){
        this.id_home = id_home;
        this.amountOfMetres = amountOfMetres;
        this.peaple = peaple;
    }

    @Override
    public String toString(){
        return super.toString() + "\tAmount of metres = " + amountOfMetres +
                "\tPeaple = " + peaple;
    }


}
