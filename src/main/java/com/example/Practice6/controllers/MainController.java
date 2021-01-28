package com.example.Practice6.controllers;

import com.example.Practice6.entity.*;
import com.example.Practice6.DAO.*;
import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class MainController {

    private MySQLBuildingDAO mySQLBuildingDAO = new MySQLBuildingDAO();
    private MySQLHomeDAO mySQLHomeDAO = new MySQLHomeDAO();
    private MySQLHouseDAO mySQLHouseDAO = new MySQLHouseDAO();

    // works
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    //////////////////////////////////  Building

    // works
    @GetMapping("/add_building")
    public String Add_building(Model model){
        model.addAttribute("title", "Добавить Building");
        return "add_building";
    }

    // works
    @PostMapping("/add_building")
    public String Add_buildingPost(@RequestParam String amountOfFloors, @RequestParam String city, @RequestParam String price, Model model){
        Building building = new Building(amountOfFloors, city, price);
        try {
            mySQLBuildingDAO.add_building(building);
        } catch(SQLException sqlex){
            System.out.println("something went wrong" + sqlex.getSQLState());
        }
        return "redirect:/";
    }

    // works
    @GetMapping("/pring_all_buildings")
    public String Print_all_builings(Model model) {
        model.addAttribute("title", "Вывести все Building");
        model.addAttribute("buidlings_all", mySQLBuildingDAO.print_buildings());
        return "print_all_buildings";
    }

    // works
    @GetMapping("/search_building_by_city")
    public String search_building_by_city(Model model){
        model.addAttribute("title", "Поиск Building по City");
        return "search_building_by_city";
    }

    // works
    @PostMapping("/search_building_by_city")
    public String search_building_by_city_Post(@RequestParam String cityName, Model model){
        model.addAttribute("title", "Поиск Building по City");
        model.addAttribute("buidlings_all", mySQLBuildingDAO.search_building_by_city(cityName));
        return "search_building_by_city";
    }

    // works
    @GetMapping("/remove_building")
    public String remove_building(Model model) {
        model.addAttribute("title", "Удаление Building");
        return "remove_building";
    }

    // works
    @PostMapping("/remove_building")
    public String remove_buildingPost(@RequestParam String search_city, Model model){
        model.addAttribute("title", "Удалить Building");

        mySQLBuildingDAO.delete_building_by_city(search_city);

        return "redirect:/";
    }


    //////////////////////////////////  House


    // works
    @GetMapping("/add_house")
    public String Add_house(Model model){
        model.addAttribute("title", "Добавить House");
        return "add_house";
    }

    // works
    @PostMapping("/add_house")
    public String Add_housePost(@RequestParam String agency, @RequestParam int amountOfRooms, @RequestParam int Building_idBuilding, Model model){
        House house = new House(agency, amountOfRooms);
        mySQLHouseDAO.add_house(house, Building_idBuilding);
        return "redirect:/";
    }

    // works
    @GetMapping("/pring_all_houses")
    public String Print_all_houses(Model model) {
        model.addAttribute("title", "Вывести все Houses");
        model.addAttribute("houses_all", mySQLHouseDAO.print_houses());
        return "print_all_houses";
    }


    //////////////////////////////////  House


    // works
    @GetMapping("/add_home")
    public String Add_home(Model model){
        model.addAttribute("title", "Добавить Home");
        return "add_home";
    }

    // works
    @PostMapping("/add_home")
    public String Add_homePost(@RequestParam int amountOfMetres, @RequestParam int peaple, @RequestParam int House_idHouse, Model model){
        home home = new home(amountOfMetres, peaple);
        mySQLHomeDAO.add_home(home, House_idHouse);
        return "redirect:/";
    }

    // works
    @GetMapping("/pring_all_homes")
    public String Print_all_homes(Model model) {
        model.addAttribute("title", "Вывести все Homes");
        model.addAttribute("homes_all", mySQLHomeDAO.print_homes());
        return "print_all_homes";
    }

    // works
    @GetMapping("/update_home")
    public String update_home(Model model){
        model.addAttribute("title", "Update Home");
        return "update_home";
    }

    // works
    @PostMapping("/update_home")
    public String update_homePost(@RequestParam int amountOfMetres, @RequestParam int peaple, @RequestParam int home_id, Model model){
        home home = new home(amountOfMetres, peaple);
        mySQLHomeDAO.upgrade_home_people(home , home_id);
        return "redirect:/";
    }




}
