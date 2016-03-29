
package conSql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/////////////////////////////////////////

public class ConectaBD {
    public Connection getConnection(){
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://192.168.1.42:3306/olimp", "admin", "admin");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }catch(Exception e1){
            System.out.println("Error: " + e1.getMessage());
        }
    return  cn;
    }
}
