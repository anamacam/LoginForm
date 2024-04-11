package com.StudentLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao {
    
    public boolean insert(User user) throws SQLException {
        
        Connection con = null;
        boolean result = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/login", "root", "system"); 
            
            String query = "INSERT INTO Login (UserName, Password) VALUES (?, ?)";

            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            
            int rowsAffected = pst.executeUpdate(); 
            
            if (rowsAffected > 0) {
                result = true;
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close(); // Cerrar la conexión en el bloque finally
            }
        }
        
        return result;
    }
    
}

