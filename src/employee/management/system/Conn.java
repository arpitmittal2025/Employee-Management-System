package employee.management.system;

import java.sql.*; // this package is for Creating the connection string
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){ // Connecting JDBC(JAVA DATABASE CONNECTIVITY) There are 5 Steps of JDBC.
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1. Register the Driver Class 
            c = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/employeemanagementsystem",
    "root",
    "YOUR_MYSQL_PASSWORD"
); // 2. Creating the connection String "employeemanagementsystem" is the name of Database which i created in mysql workbench
            s = c.createStatement();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
