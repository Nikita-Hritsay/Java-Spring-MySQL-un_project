package com.example.Practice6.DAO;

import com.example.Practice6.entity.Building;
import com.example.Practice6.entity.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLHomeDAO implements IHomeDAO{

    private DaoFactory daoFactory;

    private final String ADD_HOME_SQL = "insert into mydb.home(amount_of_metres, people, House_idHouse) values( ?, ?, ?)";
    private final String DELETE_HOME_PEOPLE_SQL = "delete from mydb.home where people = ?";
    private final String PRINT_HOMES_SQL = "select * from mydb.home";
    public final String UPDATE_HOME_PEOPLE_SQL = "update home set amount_of_metres = ?, people = ? where idHome = ?";

    public MySQLHomeDAO() {
        daoFactory = new DaoFactory();
    }

    @Override
    public void add_home(home obj, int house_id){
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try{
            conn = daoFactory.getConnection();
            preparedStatement = conn.prepareStatement(ADD_HOME_SQL);
            preparedStatement.setString(1, Integer.toString(obj.getAmountOfMetres()));
            preparedStatement.setString(2, Integer.toString(obj.getPeaple()));
            preparedStatement.setString(3, Integer.toString(house_id));

            int rows = preparedStatement.executeUpdate();

            System.out.println("rows added");

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("something went wrong");
        }finally{
            if(preparedStatement != null){
                try{
                    preparedStatement.close();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("something went wrong");
                }
            }if(conn != null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("something went wrong");
                }
            }
        }
    }

    @Override
    public void delete_home_people(int people){
        Connection conn = null;
        PreparedStatement statement = null;

        try{
            conn = daoFactory.getConnection();
            statement = conn.prepareStatement(DELETE_HOME_PEOPLE_SQL);

            statement.setString(1, Integer.toString(people));

            int rows = statement.executeUpdate();
            System.out.println("rows added");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong");
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Something went wrong");
                }
            }if(conn != null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Something went wrong");
                }
            }
        }


    }

    @Override
    public ArrayList<home> print_homes(){
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            conn = daoFactory.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(PRINT_HOMES_SQL);
            ArrayList<home> res = new ArrayList<home>();

            while(resultSet.next())
            {
                home home = new home(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
                res.add(home);
            }
            return res;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Something wet wrong!");
        }finally {
            if(statement != null){
                try{
                    statement.close();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("something went wrong");
                }
            }if(conn != null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("something went wrong");
                }
            }
        }


        return null;

    }

    @Override
    public void upgrade_home_people(home upd, int home_id){
        Connection conn = null;
        PreparedStatement statement = null;

        try{
            conn = daoFactory.getConnection();
            statement = conn.prepareStatement(UPDATE_HOME_PEOPLE_SQL);

            statement.setInt(1, upd.getAmountOfMetres());
            statement.setInt(2, upd.getPeaple());
            statement.setInt(3, home_id);

            int rows = statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong");
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Something went wrong");
                }
            }if(statement != null){
                try{
                    statement.close();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Something went wrong");
                }
            }
        }



    }

}
