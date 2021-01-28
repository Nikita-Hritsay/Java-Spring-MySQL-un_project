package com.example.Practice6.DAO;

import com.example.Practice6.entity.Building;
import com.example.Practice6.entity.House;

import java.util.ArrayList;

public interface IHouseDAO {
    public void add_house(House obj, int building_id);
    public void delete_house_agency(String agency);
    public ArrayList<House> print_houses();
}
