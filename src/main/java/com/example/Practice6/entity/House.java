package com.example.Practice6.entity;


public class House {
    private int id_house;
    private String agency;
    private int amountOfRooms;

    public String getAgency(){
        return agency;
    }

    public int getAmountOfRooms(){
        return amountOfRooms;
    }

    public int getId_house(){
        return id_house;
    }

    public House( String agency, int amountOfRooms){
        this.agency = agency;
        this.amountOfRooms = amountOfRooms;
    }
    public House(int id_house, String agency, int amountOfRooms){
        this.id_house = id_house;
        this.agency = agency;
        this.amountOfRooms = amountOfRooms;
    }

    @Override
    public String toString(){
        return super.toString() + "\tAgency = " + agency +
                "\tAmount of rooms = " + amountOfRooms;
    }
}
