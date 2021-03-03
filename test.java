import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;


public class test {
  public static void main(String[] args){
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String url = "jdbc:mysql://localhost/bulletinboard";
    String user = "admin";
    String pass = "admin";

    try {
      
      con = DriverManager.getConnection(url,user,pass);
      pstmt = con.prepareStatement("select * from user");
      rs = pstmt.executeQuery();
      while (rs.next()) {
        System.out.println(rs.getString("name"));
        System.out.println(rs.getInt("age"));
        System.out.println(rs.getString("address"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}