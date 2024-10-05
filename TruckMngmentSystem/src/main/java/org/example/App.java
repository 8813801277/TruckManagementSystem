package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
        TruckServices truckServices = new TruckServices();

        Scanner sc = new Scanner(System.in);
        boolean ans = true;
        while(ans){
            System.out.println("Enter 1 for adding truck , 2 for update truck, " +
                    "3 for get all trucks , 4 for get truck by id , 5 for delete truck . press 6 to exit");
            int operation = sc.nextInt();
            switch (operation){
                case 1:
                    System.out.println("Enter details of your truck");
                    System.out.println("Enter name of truck:");
                    String name = sc.nextLine();
                    System.out.println("Enter model of truck:");
                    String model = sc.nextLine();
                    System.out.println("Enter capacity of truck:");
                    int capacity = sc.nextInt();
                    System.out.println("Enter driver name of truck:");
                    String drivername = sc.nextLine();
                    Truck truck = new Truck(name , model , capacity , drivername);
                    truckServices.addtruck(truck);
                    System.out.println("Truck added successfully");
                    break;

                case 2:
                    System.out.println("Enter details of truck you want to update");
                    System.out.println("Enter name of truck:");
                    String nameUpdate = sc.nextLine();
                    System.out.println("Enter model of truck");
                    String modelUpdate = sc.nextLine();
                    System.out.println("Enter capacity of truck");
                    int capacityUpdate = sc.nextInt();
                    System.out.println("Enter driver name of truck");
                    String drivernameUpdate = sc.nextLine();
                    Truck truckUpdate = new Truck(nameUpdate , modelUpdate , capacityUpdate , drivernameUpdate);
                    truckServices.updateTruck(truckUpdate);
                    System.out.println("Truck updated successfully");
                    break;

                case 3:
                    List<Truck> list = truckServices.getAllTrucks();
                    System.out.println(list);
                    break;
                case 4:
                    System.out.println("Enter id:");
                    int id = sc.nextInt();
                    System.out.println(truckServices.getTruckById(id));
                    break;

                case 5:
                    System.out.println("Enter id of truck to delete");
                    int idToDelete = sc.nextInt();
                    truckServices.deleteTruck(idToDelete);
                    System.out.println("Truck deleted successfully");
                    break;

                case 6:
                    ans=false;
            }
        }
    }
}