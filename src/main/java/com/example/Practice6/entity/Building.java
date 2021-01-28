package com.example.Practice6.entity;

public class Building implements Comparable<Building>{
    int id_building;
    private int amountOfFloors;
    private String city;
    private int price;

    public String getAmountOfFloors(){
        return Integer.toString(amountOfFloors);
    }

    public String getPrice(){
        return Integer.toString(price);
    }

    public String getCity(){
        return city;
    }

    public String getId_buidling(){
        return Integer.toString(id_building);
    }

    public Building( String amountOfFloors, String city, String price){

        this.amountOfFloors = Integer.valueOf(amountOfFloors);
        this.city = city;
        this.price =  Integer.valueOf(price);
    }
    public Building(int id_building, String amountOfFloors, String city, String price){
        this.id_building = id_building;
        this.amountOfFloors = Integer.valueOf(amountOfFloors);
        this.city = city;
        this.price =  Integer.valueOf(price);
    }

    public String toString(){
        return "Amount of floors = " + amountOfFloors +
                "\tCity = " + city +
                "\tPrice = " + price;
    }

    @Override
    public int compareTo(Building other){
        if (this.price == other.price)
            return 0;
        else if (this.price > other.price)
            return 1;
        return -1;
    }

}
