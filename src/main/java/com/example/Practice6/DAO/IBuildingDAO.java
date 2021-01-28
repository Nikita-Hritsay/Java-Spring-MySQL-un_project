package com.example.Practice6.DAO;

import com.example.Practice6.entity.Building;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBuildingDAO {
    public void add_building(Building obj) throws SQLException;
    public void delete_building_by_city(String search_city);
    public ArrayList<Building> search_building_by_city(String city_name);
    public ArrayList<Building> print_buildings();
}
