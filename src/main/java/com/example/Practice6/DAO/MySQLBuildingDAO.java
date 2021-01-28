package com.example.Practice6.DAO;

import com.example.Practice6.entity.Building;


import java.sql.*;
import java.util.ArrayList;

public class MySQLBuildingDAO implements IBuildingDAO{
    private DaoFactory daoFactory;

    private final String ADD_BUILDING_SQL = "insert into mydb.building(amount_of_floors, city, price) values (?, ?, ?)";
    private final String DELETE_BUILDING_CITY_SQL = "delete from mydb.building where city = ?";
    private final String SEARCH_BUILDING_CITY_SQL = "select * from mydb.building where city = ?";
    private final String PRINT_BUILDINGS_SQL = "select * from mydb.building";

    public MySQLBuildingDAO() {
        daoFactory = new DaoFactory();
    }

    // works
    @Override
    public void add_building(Building obj) throws SQLException{
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            conn = daoFactory.getConnection();
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(ADD_BUILDING_SQL);
            preparedStatement.setString(1, obj.getAmountOfFloors());
            preparedStatement.setString(2,obj.getCity());
            preparedStatement.setString(3, obj.getPrice());

            int rows = preparedStatement.executeUpdate();

            conn.commit();
            System.out.println(rows + " rows added");

        } catch (SQLException throwables) {
            conn.rollback();
            System.out.println("something went wrong...");
        } finally {
            if(preparedStatement != null){
                try{
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("something went wrong");
                }
            }if(conn != null){
                try{
                    conn.close();
                } catch(Exception e){
                    e.printStackTrace();
                    System.out.println("something went wrong");
                }
            }
        }

    }

    // works
    @Override
    public void delete_building_by_city(String city){
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            conn = daoFactory.getConnection();
            preparedStatement = conn.prepareStatement(DELETE_BUILDING_CITY_SQL);
            preparedStatement.setString(1, city);


            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " rows added");

        } catch (SQLException throwables) {
            System.out.println("something went wrong...1");
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (Exception ex){
                    System.out.println("Something wet wrong");
                    System.out.println(ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (Exception ex){
                    System.out.println("Something wet wrong!");
                    System.out.println(ex);
                }
            }
        }

    }

    // works
    @Override
    public ArrayList<Building> search_building_by_city(String city_name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(SEARCH_BUILDING_CITY_SQL);
            preparedStatement.setString(1, city_name);
            resultSet = preparedStatement.executeQuery();

            ArrayList<Building> res = new ArrayList<Building>();
            while(resultSet.next())
            {
                Building building = new Building(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4)) ;
                res.add(building);
            }
            return res;
        }catch (Exception ex){
            System.out.println("Something wet wrong!");
            System.out.println(ex);
        }finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (Exception ex){
                    System.out.println("Something wet wrong!");
                    System.out.println(ex);
                }
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (Exception ex){
                    System.out.println("Something wet wrong!");
                    System.out.println(ex);
                }
            }
            if(resultSet != null){
                try {
                    resultSet.close();
                }catch (Exception ex){
                    System.out.println("Something wet wrong!");
                    System.out.println(ex);
                }
            }
        }
        return null;
    }

    // works
    @Override
    public ArrayList<Building> print_buildings(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(PRINT_BUILDINGS_SQL);

            ArrayList<Building> res = new ArrayList<Building>();

            while(resultSet.next())
            {
                Building building = new Building(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4)) ;
                res.add(building);
            }
            return res;
        }catch (Exception ex){
            System.out.println("Something wet wrong!");
            System.out.println(ex);
        }finally {
            if (statement != null){
                try {
                    statement.close();
                }catch (Exception ex){
                    System.out.println("Something wet wrong!");
                    System.out.println(ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                }catch (Exception ex){
                    System.out.println("Something wet wrong!");
                    System.out.println(ex);
                }
            }
            if(resultSet != null){
                try {
                    resultSet.close();
                }catch (Exception ex){
                    System.out.println("Something wet wrong!");
                    System.out.println(ex);
                }
            }
        }
        return null;
    }

}
