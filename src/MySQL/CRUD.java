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

    public static ResultSet selectUsers(
            Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");
        return rs;
    }

    public static ResultSet selectJobs(
            Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from job");
        return rs;
    }
    
    public static ResultSet selectJobItems(
            Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from required_items");
        return rs;
    }
    
    public static ResultSet selectItems(
            Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from item");
        return rs;
    }

    public static ResultSet selectItemType(
            Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from item_type");
        return rs;
    }

    public static ResultSet selectCategories(
            Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from cleaning_category");
        return rs;
    }
    
    public static ResultSet selectCategoryItems(
            Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from category_items");
        return rs;
    }
    
    //USER RELATED
    
    public static void insertUser(Connection con, String fullname,
            String username, String password, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        if (admin != -1) {
            stmt.executeUpdate(
                    "INSERT INTO user(`full_name`, `username`, `password`, "
                    + "`added_by`, `updated_by`) VALUES('" + fullname + "','"
                    + username + "','" 
                    + password + "','" 
                    + admin + "','" 
                    + admin + "')");
        } else {
            stmt.executeUpdate(
                    "INSERT INTO user(`full_name`, `username`, `password`, "
                    + "`added_by`, `updated_by`) VALUES('" + fullname + "','"
                    + username + "','" + password + "',NULL,NULL)");
        }
    }

    public static void archiveUser(Connection con, String username) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `removed` = '"+1
                +"' WHERE `user`.`username`='" + username + "'");
    }
    
    public static void updateUsername(Connection con, String username, String newusername, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `username` = '" + newusername + "', `updated_by` = '"+ admin +"' WHERE `user`.`username` = '" + username + "'");
    }
    
    public static void updatePassword(Connection con, String username, String oldpassword, String newpassword, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `password` = '" + newpassword + "', `updated_by` = '"+ admin +"' WHERE `user`.`username` = '" + username + "'");
    }
    
    public static void updateFullname(Connection con, String username, String newfullname, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `full_name` = '" + newfullname + "', `updated_by` = '"+ admin +"' WHERE `user`.`username` = '" + username + "'");
    }

    public static boolean checkUserExists(Connection con, String username) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_id from user "+
                "where username='" + username + "'");
        return rs.next();
    }
    
    public static ResultSet selectUserIDPassword(Connection con, String username)
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `user_id`, `password` from user WHERE username='" + username + "'");
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
    
    public static ResultSet selectUsersInfo(Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT user_id, username, full_name, added_by, "+
                "added_date, updated_by, updated_date FROM `user`";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static ResultSet selectUserInfo(Connection con, int id) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT user_id, username, full_name, added_by, "+
                "added_date, updated_by, updated_date FROM `user` WHERE user_id = '"+ id +"'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static ResultSet selectUserInfoUsingUsername(Connection con, String username) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT user_id, username, full_name, added_by, "+
                "added_date, updated_by, updated_date FROM `user` WHERE username = '"+ username +"'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    //END OF USER RELATED 
    
    //CATEGORY RELATED
    
    public static void insertCleaningCategory(
            Connection con, String name, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO cleaning_category"+
                "(`category_name`, `added_by`, `updated_by`)"+
                " VALUES('" + name + "','" + admin + "','" + admin + "')");
    }
    
    public static void insertCategoryItem(
            Connection con, int categoryID, int itemID, int itemQuantity) 
            throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO category_items"+
                "(`category_id`, `item_id`, `item_quantity`) "+
                "VALUES('" 
                + categoryID + "','" 
                + itemID + "','" 
                + itemQuantity + "')");
    }
    
    public static void updateItemQuantity(
            Connection con, int categoryID, int itemID, int newItemQuantity) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `category_items` "+
                "SET `item_quantity` = '" + newItemQuantity + 
                "' WHERE category_id = '" + categoryID + 
                "' AND item_id = '"+itemID+"'");
    }
    
    public static void removeCategoryItem(
            Connection con, int categoryID, int itemID)
            throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `category_items` "+
                "WHERE category_id='"+categoryID+"' AND item_id='"+itemID+"'");
    }
    
    public static ResultSet selectCategoriesInfo(Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_id, category_name, added_by, "+
                "added_date, updated_by, updated_date FROM `cleaning_category`";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static ResultSet selectCategoryInfo(Connection con, int id) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_name, added_by, added_date, "+
                "updated_by, updated_date FROM `cleaning_category` WHERE category_id = '"+ id +"'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static ResultSet selectCategoryInfoUsingCategoryName(Connection con, String categoryName) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_id, category_name, added_by, added_date, "+
                "updated_by, updated_date FROM `cleaning_category` WHERE category_name = '"+ categoryName +"'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static boolean checkCategoryExists(Connection con, String categoryName) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT category_id from cleaning_category "+
                "where category_name='" + categoryName + "'");
        return rs.next();
    }
    
    //END OF CATEGORY RELATED
    
    
    
    public static void insertInventory(Connection con, String product, String price, String quantity) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO item(`Product`, `Price`, `Quantity`) VALUES('" + product + "','" + price + "','" + quantity + "')");
    }

    public static void deleteInventory(Connection con, String product, String price, String quantity) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `inventory` WHERE `inventory`.`Product`='" + product + "' AND Price='" + price + "' AND Quantity='" + quantity + "'");
    }

    public static void updateInventoryQ(Connection con, int stock, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `inventory` SET `Quantity` = '" + stock + "' WHERE `inventory`.`Product` = '" + product + "'");
    }

    public static ResultSet selectInventoryQ(Connection con, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from inventory where Product='" + product + "'");
        return rs;
    }

    public static ResultSet selectInventoryP(Connection con, String product, String price, String quantity) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Product" + " from inventory where Product='" + product + "' AND Price='" + price + "' AND Quantity='" + quantity + "'");
        return rs;
    }

    public static ResultSet selectInventoryPrc(Connection con, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Price" + " from inventory where Product='" + product + "'");
        return rs;
    }

    public static void insert(Connection con, String name, String product, String price, int quantity) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO " + name + "(`Product`, `Price`, `Quantity`) VALUES('" + product + "','" + price + "','" + quantity + "')");
    }

    public static void updateQ(Connection con, String name, int stock, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `" + name + "` SET `Quantity` = '" + stock + "' WHERE `" + name + "`.`Product` = '" + product + "'");
    }

    public static void delete(Connection con, String name, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `" + name + "` WHERE `" + name + "`.`Product`='" + product + "'");
    }

    public static ResultSet selectQ(Connection con, String name, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from " + name + " where Product='" + product + "'");
        return rs;
    }

    public static ResultSet selectPrc(Connection con, String name, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Price" + " from " + name + " where Product='" + product + "'");
        return rs;
    }

    public static void deductQ(Connection con, String name, int deduction, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from " + name + " where Product='" + product + "'");
        rs.next();
        int stock = rs.getInt("Quantity");
        stock = stock - deduction;
        if (stock >= 0) {
            stmt.executeUpdate("UPDATE `" + name + "` SET `Quantity` = '" + stock + "' WHERE `" + name + "`.`Product` = '" + product + "'");
        }
    }

    public static void addQ(Connection con, String name, int additional, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from " + name + " where Product='" + product + "'");
        rs.next();
        int stock = rs.getInt("Quantity");
        stock = stock + additional;
        stmt.executeUpdate("UPDATE `" + name + "` SET `Quantity` = '" + stock + "' WHERE `" + name + "`.`Product` = '" + product + "'");
    }

    public static double getTotal(Connection con, String name) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from " + name);
        double total = 0;
        while (rs.next()) {
            total = total + (rs.getInt("Quantity") * rs.getDouble("Price"));
        }
        return total;
    }

    public static void deleteContents(Connection con, String name) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `" + name + "`");
    }
}
