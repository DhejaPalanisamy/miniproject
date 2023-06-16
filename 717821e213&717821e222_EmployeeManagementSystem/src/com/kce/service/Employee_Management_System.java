package com.kce.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.kce.demo.EmployeeTable;

public class Employee_Management_System {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            boolean exit = false;
            while (!exit) {
                EmployeeTable.option();
                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        EmployeeTable.create();
                        break;
                    case 2:
                        System.out.println("Enter the number of employees to insert: ");
                        int noOfEmployees = sc.nextInt();
                        EmployeeTable.insert(noOfEmployees);
                        break;
                    case 3:
                        EmployeeTable.display();
                        break;
                    case 4:
                        System.out.println("Enter the employee name to delete: ");
                        String empName = sc.next();
                        EmployeeTable.delete(empName);
                        break;
                    case 5:
                        EmployeeTable.update();
                        break;
                    case 6:
                        EmployeeTable.display2();
                        break;
                    case 7:
                        EmployeeTable.truncateTable();
                        break;
                    case 8:
                        EmployeeTable.deleteTable();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }

                System.out.println("Do you want to continue (Y/N)?: ");
                String continueChoice = sc.next();
                if (continueChoice.equalsIgnoreCase("N")) {
                    exit = true;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}
