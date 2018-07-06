package MySQL;

/**
 * It's for me
 * @author Ethan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ethan
 */
public class Connect {

    /**
     *
     * Gets a connection from the database
     * @return the Connection to enable querying from the database
     */
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
