package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckServices {

    public void addtruck(Truck truck){
        String query = "insert into truck (name,model,capacity,drivername) values (?,?,?,?)";
        try{
            Connection connection = ConnectionClass.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDrivername());

            int update = preparedStatement.executeUpdate();
            System.out.println("Row inserted: "+update);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Truck getTruckById(int id){
        String query = "select * from truck where id=?";
        Truck truck = new Truck();
        try{
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDrivername(resultSet.getString("drivername"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return truck;
    }

    public void updateTruck(Truck truck){
        String query = "update truck set name = ?, model = ?, capacity = ?, drivername = ? where id =?";
        try{
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDrivername());
            preparedStatement.setInt(5,truck.getId());

            int update = preparedStatement.executeUpdate();
            System.out.println("Row updated: "+update);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Truck> getAllTrucks(){
        String query = "select * from truck";
        List<Truck> list = new ArrayList<>();

        try{
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDrivername(resultSet.getString("drivername"));
                list.add(truck);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void deleteTruck(int id){
        String query = "delete from truck where id =?";
        try{
            Connection connection = ConnectionClass.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int update = preparedStatement.executeUpdate();
            System.out.println("Row deleted: "+update);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
