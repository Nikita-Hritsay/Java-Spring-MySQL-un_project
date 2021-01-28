package com.example.Practice6.DAO;

import com.example.Practice6.entity.Building;
import com.example.Practice6.entity.House;

import java.sql.*;
import java.util.ArrayList;

public class MySQLHouseDAO implements IHouseDAO{

    private DaoFactory daoFactory;

    private final String ADD_HOUSE_SQL = "insert into mydb.house(agency, amount_of_rooms, Building_idBuilding) values( ?, ?, ?)";
    private final String DELETE_HOUSE_BY_AGENCY_SQL = "delete from mydb.house where agency = ?";
    private final String PRINT_HOUSES_SQL = "select * from mydb.house";

    public MySQLHouseDAO() {
        daoFactory = new DaoFactory();
    }

    // works
    @Override
    public void add_house(House obj, int building_id){
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            conn = daoFactory.getConnection();
            preparedStatement = conn.prepareStatement(ADD_HOUSE_SQL);
            preparedStatement.setString(1, obj.getAgency());
            preparedStatement.setString(2, Integer.toString(obj.getAmountOfRooms()));
            preparedStatement.setString(3, Integer.toString(building_id));

            int rows = preparedStatement.executeUpdate();

            System.out.println("rows added");

        } catch (SQLException throwables) {
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
    public void delete_house_agency(String agency){
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            conn = daoFactory.getConnection();
            preparedStatement = conn.prepareStatement(DELETE_HOUSE_BY_AGENCY_SQL);
            preparedStatement.setString(1, agency);


            int rows = preparedStatement.executeUpdate();

            System.out.println("rows added");

        } catch (SQLException throwables) {
            System.out.println("something went wrong...");
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (Exception ex){
                    System.out.println("Something wet wrong!");
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
    public ArrayList<House> print_houses(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(PRINT_HOUSES_SQL);
            ArrayList<House> res = new ArrayList<House>();

            while(resultSet.next())
            {
                House house = new House(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                res.add(house);
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