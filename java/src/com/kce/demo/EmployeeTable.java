package com.kce.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.kce.util.DBUtil;

public class EmployeeTable {
	private static Connection connect;
	private static PreparedStatement pst;
	private static Statement stat;
	private static ResultSet rst;
	private static Scanner sc = new Scanner(System.in);
	
	public static void create() throws ClassNotFoundException, SQLException {
		connect = DBUtil.getConnection();
		pst = connect.prepareStatement("create table Employee (emp_id number(5) PRIMARY KEY)"+
		"emp_name varchar(15) NOT NULL"+"gender varchar(10)"+"phone_num varchar(10)"+
				"email_id varchar(75)"+"designation varchar(20)"+"salary decimal(10,2)"+")");
		System.out.println("Employee table is created successfully......!");
	}
	public static void insert(int noofemployees) throws ClassNotFoundException, SQLException {
		connect = DBUtil.getConnection();
		pst = connect.prepareStatement("insert into Employee values(?,?,?,?,?,?,?)");
		for(int i=0;i<noofemployees;i++) {
			System.out.println("Enter the employee id: ");
			pst.setInt(1, sc.nextInt());
			System.out.println("Enter the employee name: ");
			pst.setString(2, sc.next());
			System.out.println("Enter the gender: ");
			pst.setString(3, sc.next());
			System.out.println("Enter the phone number: ");
			pst.setString(4, sc.next());
			System.out.println("Enter the email id: ");
			pst.setString(5, sc.next());
			System.out.println("Enter the employee's designation: ");
			pst.setString(6, sc.next());
			System.out.println("Enter the employee's salary: ");
			pst.setInt(7, sc.nextInt());
		}
		System.out.println("Employee table is inserted successfully......!");
	}
	public static void display() throws ClassNotFoundException, SQLException {
		connect = DBUtil.getConnection();
		stat=connect.createStatement();
		rst=stat.executeQuery("select * from Employees");
		while(rst.next()) {
			System.out.println(rst.getInt(1)+"\n"+rst.getString(2)+"\n"+rst.getString(3)+
					"\n"+rst.getString(4)+"\n"+rst.getString(5)+"\n"+rst.getString(6)+"\n"+rst.getInt(7));
		}
	}
	public static void delete(String name) throws ClassNotFoundException, SQLException {
		connect = DBUtil.getConnection();
		stat=connect.createStatement();
		stat.executeUpdate("delete from Employee where emp_name="+name);
		System.out.println("Row deleted successfully......!");
	}
	public static void display1() throws ClassNotFoundException, SQLException {
		connect = DBUtil.getConnection();
		stat=connect.createStatement();
		rst=stat.executeQuery("select * from Employees");
		while(rst.next()) {
			System.out.println(rst.getInt(1)+"\n"+rst.getString(2)+"\n"+rst.getString(3)+
					"\n"+rst.getString(4)+"\n"+rst.getString(5)+"\n"+rst.getString(6)+"\n"+rst.getInt(7));
		}
	}
	public static void update() throws ClassNotFoundException, SQLException {
	    connect = DBUtil.getConnection();
	    pst = connect.prepareStatement("UPDATE Employee SET emp_name=?, gender=?, phone_num=?, email_id=?, designation=?, salary=? WHERE emp_id=?");
	  
	    System.out.println("Enter the employee id: ");
	    int empId = sc.nextInt();
	    
	    System.out.println("Enter the updated employee name: ");
	    pst.setString(1, sc.next());
	    
	    System.out.println("Enter the updated gender: ");
	    pst.setString(2, sc.next());
	    
	    System.out.println("Enter the updated phone number: ");
	    pst.setString(3, sc.next());
	    
	    System.out.println("Enter the updated email id: ");
	    pst.setString(4, sc.next());
	    
	    System.out.println("Enter the updated employee's designation: ");
	    pst.setString(5, sc.next());
	    
	    System.out.println("Enter the updated employee's salary: ");
	    pst.setInt(6, sc.nextInt());
	    
	    pst.setInt(7, empId);

	    int rowsUpdated = pst.executeUpdate();
	    if (rowsUpdated > 0) {
	        System.out.println("Employee record updated successfully!");
	    } else {
	        System.out.println("Failed to update employee record. Please check the employee id.");
	    }
	}
	public static void display2() throws ClassNotFoundException, SQLException {
	    connect = DBUtil.getConnection();
	    stat = connect.createStatement();
	    rst = stat.executeQuery("SELECT * FROM Employee");
	    while(rst.next()) {
	    	System.out.println(rst.getInt(1)+"\n"+rst.getString(2)+"\n"+rst.getString(3)+
					"\n"+rst.getString(4)+"\n"+rst.getString(5)+"\n"+rst.getString(6)+"\n"+rst.getInt(7));
		}
	}
	public static void truncateTable() throws ClassNotFoundException, SQLException {
	    connect = DBUtil.getConnection();
	    stat = connect.createStatement();
	    stat.executeUpdate("TRUNCATE TABLE Employee");
	    System.out.println("Employee table truncated successfully!");
	}
	public static void deleteTable() throws ClassNotFoundException, SQLException {
	    connect = DBUtil.getConnection();
	    stat = connect.createStatement();
	    stat.executeUpdate("DROP TABLE Employee");
	    System.out.println("Employee table deleted successfully........!");
	}
	public static void option() {
		System.out.println("1.Creating table"+"\n"+"2.Inserting data"+"\n"+"3.Displaying the data after inserting the details"+
	"\n"+"4.Deleteing a single row"+"\n"+"5.Updateing a row"+"\n"+"6.Displaying the table after update"+"\n"+
				"7.Deleting the entire rows of the table"+"\n"+"8.Deleting the created table");
	}
}
