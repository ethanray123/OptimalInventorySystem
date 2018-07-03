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
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/optimaldb"+
                    "?useUnicode=true&useJDBCCompliantTimezoneShift=true"+
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            return con;
        }catch(ClassNotFoundException | SQLException e){
            return null;
        }
    }
}
