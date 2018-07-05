package MySQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Ethan
 */
public class CRUD {
    public static ResultSet selectNameFromUser(
            Connection con) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
        return rs;
    }
    
    public static ResultSet selectInventory(
            Connection con) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from inventory");
        return rs;
    }
    
    public static ResultSet selectCart(Connection con) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from cart");
        return rs;
    }
    
    public static void insertUser(Connection con,String fullname, 
            String username,String password, int admin) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        if(admin != -1){
            stmt.executeUpdate(
                "INSERT INTO user(`full_name`, `username`, `password`, "
                        + "`added_by`, `updated_by`) VALUES('"+fullname+"','"
                        +username+"','"+password+"','"+admin+"','"+admin+"')");
        }else{
            stmt.executeUpdate(
                "INSERT INTO user(`full_name`, `username`, `password`, "
                        + "`added_by`, `updated_by`) VALUES('"+fullname+"','"
                        +username+"','"+password+"',NULL,NULL)");
        }
    }
    
    public static void deleteUser(Connection con,String username) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `user` WHERE `user`.`Username`='"+username+"'");
    }
    
    public static void updatePassword(Connection con,String username,String oldpassword,String newpassword) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `Password` = '"+newpassword+"' WHERE `user`.`Username` = '"+username+"' AND Password='"+oldpassword+"'");
    }
    
    public static boolean checkUserExists(Connection con,String username) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_id from user where username='" + username + "'");
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    }
    
    public static ResultSet selectUserPassword(Connection con,String username) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `user_id`, `password` FROM `user` WHERE `username`='" + username + "'");
        return rs;
    }
    
    public static void insertInventory(Connection con,String product,String price,String quantity) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO inventory(`Product`, `Price`, `Quantity`) VALUES('"+product+"','"+price+"','"+quantity+"')");
    }
            
    public static void deleteInventory(Connection con,String product,String price,String quantity) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `inventory` WHERE `inventory`.`Product`='"+product+"' AND Price='"+price+"' AND Quantity='"+quantity+"'");
    }
          
    public static void updateInventoryQ(Connection con,int stock,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `inventory` SET `Quantity` = '"+stock+"' WHERE `inventory`.`Product` = '"+product+"'");
    }
    
    public static ResultSet selectInventoryQ(Connection con,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from inventory where Product='" + product + "'");
        return rs;
    }
    
    public static ResultSet selectInventoryP(Connection con,String product,String price,String quantity) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Product" + " from inventory where Product='"+product+"' AND Price='"+price+"' AND Quantity='"+quantity+"'");
        return rs;
    }
    
    public static ResultSet selectInventoryPrc(Connection con,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Price" + " from inventory where Product='"+product+"'");
        return rs;
    }
    
    public static void insert(Connection con,String name,String product,String price,int quantity) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO "+name+"(`Product`, `Price`, `Quantity`) VALUES('"+product+"','"+price+"','"+quantity+"')");
    }
    
    public static void updateQ(Connection con,String name,int stock,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `"+name+"` SET `Quantity` = '"+stock+"' WHERE `"+name+"`.`Product` = '"+product+"'");
    }
    
    public static void delete(Connection con,String name,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `"+name+"` WHERE `"+name+"`.`Product`='"+product+"'");
    }
    
    public static ResultSet selectQ(Connection con,String name,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from "+name+" where Product='"+product+"'");
        return rs;
    }
    
    public static ResultSet selectPrc(Connection con,String name,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Price" + " from "+name+" where Product='"+product+"'");
        return rs;
    }
    
    public static void deductQ(Connection con,String name,int deduction,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from "+name+" where Product='" + product + "'");
        rs.next();
        int stock = rs.getInt("Quantity");
        stock = stock - deduction;
        if(stock >= 0){
            stmt.executeUpdate("UPDATE `"+name+"` SET `Quantity` = '"+stock+"' WHERE `"+name+"`.`Product` = '"+product+"'");
        }
    }
    
    public static void addQ(Connection con,String name,int additional,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from "+name+" where Product='" + product + "'");
        rs.next();
            int stock = rs.getInt("Quantity");
            stock = stock + additional;
            stmt.executeUpdate("UPDATE `"+name+"` SET `Quantity` = '"+stock+"' WHERE `"+name+"`.`Product` = '"+product+"'");
    }
    
    public static double getTotal(Connection con,String name) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from "+name);
        double total=0;
        while(rs.next()){
            total = total + (rs.getInt("Quantity")*rs.getDouble("Price"));
        }
        return total;
    }
    
    public static void deleteContents(Connection con,String name) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `"+name+"`");
    }
    
    public static void insertJob(Connection con, int cat_id, int admin) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        if(admin != -1){
            stmt.executeUpdate("INSERT INTO `job`(`category_id`, `added_by`, "
                + "`updated_by`) VALUES('"+cat_id+"','"+admin+"','"+admin+"')");
        }else{
            stmt.executeUpdate("INSERT INTO `job`(`category_id`, `added_by`, "
                + "`updated_by`) VALUES('"+cat_id+"',NULL,NULL)");
        }
    }
    
    public static int getUserID(Connection con,String username) throws SQLException{
        Statement stmt;
        int id = -1;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `user_id` FROM `user` WHERE "
            + "`username`='" + username + "'");
        if(rs.next()){
            id =  rs.getInt("user_id");
        }
        return id;
    }
    
    public static String getNameOfUser(Connection con,String uname) throws SQLException{
        Statement stmt;
        String name = "";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `user_id` FROM `users` WHERE "
            + "`username`='" + uname + "'");
        if(rs.next()){
           name = rs.getString("username");
        }
        return name;
    }
    
    public static int getCleaningCatID(Connection con, String cleaning) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        int catID = 0;
        ResultSet rs = stmt.executeQuery("SELECT `category_id` FROM "
            + "`cleaning_category` WHERE `category_name`='" + cleaning + "'");
        
        if(rs.next()){
           catID = rs.getInt("category_id");
        }
        return catID;
    }
    
    public static ResultSet selectJobsInfo(Connection con) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT `job_id`, `category_id`, `added_by`, `added_date`,"
            + "`updated_by`, `updated_date` FROM `job` WHERE `removed` = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
}
