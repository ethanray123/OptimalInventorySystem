package MySQL;

/**
 *
 * @author Ethan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection getConnection()
    {
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/optimaldb","root","root");
            return con;
        }catch(ClassNotFoundException | SQLException e){
            return null;
        }
    }
}
