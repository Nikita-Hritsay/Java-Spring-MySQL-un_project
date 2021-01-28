package com.example.Practice6.DAO;

import com.example.Practice6.entity.Building;
import com.example.Practice6.entity.home;

import java.util.ArrayList;

public interface IHomeDAO {
    public void add_home(home obj, int house_id);
    public void delete_home_people(int people);
    public ArrayList<home> print_homes();
    public void upgrade_home_people(home upd, int home_id);
}
