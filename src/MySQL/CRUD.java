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
        return rs.next();
    }
    //ITEM RELATED
    public static boolean checkItemExists(Connection con, String itemName) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT item_id from item where item_name='"+itemName+"' AND removed =0");
        return rs.next();        
    }
    public static boolean checkItemArchived(Connection con, String itemName) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT item_id from item where item_name='"+itemName+"' AND removed = 1 ");
        return rs.next();
    }
    public static ResultSet selectItemInfo(Connection con)throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from item where removed = 0");
        return rs;
    }
    public static String selectFullName(Connection con, int userid) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT full_name from user where user_id='" + userid + "'");
        if(rs.next())
            return rs.getString("full_name");
        else
            return "N/A";       
    }
    public static ResultSet selectItemInfoUsingItemName(Connection con,String itemName)throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from item where item_name = '"+itemName+"'");
        return rs;
    }
    public static ResultSet selectItemIDUsingItemName(Connection con,String itemName)throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT item_id from item where item_name = '"+itemName+"'");
        return rs;
    }
    public static void insertItem(Connection con, String itemName, int itemQty, int itemType, String itemMetric, int addedBy,int updatedBy) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO item(`item_name`,`quantity`,`metric`,`type`,`added_by`,`updated_by`) VALUES('"+itemName+"','"+itemQty+"','"+itemMetric+"','"+itemType+"','"+addedBy+"','"+updatedBy+"')");
    }
    public static void updateItem(Connection con, int itemID,String newItemName,int itemQty, int itemType, String itemMetric,int updatedBy) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `item` SET `item_name` = '"+newItemName+"',`quantity`='"+itemQty+"',`metric` = '"+itemMetric+"', `type` ='"+itemType+"',`updated_by` = '"+updatedBy+"' WHERE `item_id` = '"+itemID+"'");
    }
    public static boolean archiveItem(Connection con, String itemName) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `item` SET `removed` = 1 WHERE `item_name`='"+itemName+"' ");
        return checkItemArchived(con,itemName);
    }
    //END OF ITEM RELATED
    
    //ITEM TYPE RELATED
    public static boolean checkItemTypeExists(Connection con, String typeName) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT type_id from item_type where type_name='"+typeName+"' AND removed=0");
        return rs.next();
    }
    public static ResultSet selectItemTypeInfo(Connection con) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from item_type where removed = 0");
        return rs;
    }
    public static ResultSet selectItemTypeInfoUsingTypeName(Connection con,String typeName) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT type_id,type_name,type_details,added_by, added_date,updated_by, updated_date from `item_type` where type_name ='"+typeName+"' ");
        return rs;
    }
    public static ResultSet selectTypeIDFromItemType(Connection con,String itemTypeName) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT type_id from item_type where type_name='"+itemTypeName+"' ");
        return rs;
    }
    public static ResultSet selectItemNameFromItemType(Connection con) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT type_name from item_type where removed = 0");
        return rs;
    }
    
    public static void insertItemType(Connection con, String typeName, String typeDetails, int addedBy, int updatedBy, int removed) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO item_type(`type_name`,`type_details`,`added_by`,`updated_by`,`removed`)VALUES('"+typeName+"','"+typeDetails+"','"+addedBy+"','"+updatedBy+"','"+removed+"')");
        
    }
    public static void updateItemType(Connection con, String typeName, String newTypeName,String typeDetails,int updatedBy) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `item_type` SET `type_name` = '"+newTypeName+"',`type_details`='"+typeDetails+"',`updated_by` = '"+updatedBy+"' WHERE `item_type`.`type_name` = '"+typeName+"'");
    }
    public static boolean archiveItemType(Connection con, String typeName) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `item_type` SET `removed` = 1 WHERE `type_name`='"+typeName+"' ");
        return checkItemTypeArchived(con,typeName);
    }
    public static boolean checkItemTypeArchived(Connection con, String typeName) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();       
        ResultSet rs = stmt.executeQuery("SELECT type_id from item_type where type_name='"+typeName+"' AND removed = 1 ");
        return rs.next();
    }
    //END OF ITEM TYPE RELATED
   
    public static ResultSet selectUserPassword(Connection con,String username) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_id, password from user where username='" + username + "'");
        return rs;
    }
    public static String selectUsername(Connection con, int userid) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username from user where user_id='" + userid + "'");
        rs.next();
        return rs.getString("username");
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
}
