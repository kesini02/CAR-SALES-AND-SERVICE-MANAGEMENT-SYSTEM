package service;
import java.sql.*;
public class jdbcconnect {
public Connection getconnection() {
Connection c=null;
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mohana","sql");
System.out.println("JDBC connection successful");

}catch (Exception e) {
System.out.println("Error in JDBC connection");
}

return c;

}
public static void main(String[] args) {
// TODO Auto-generated method stub

}

}
