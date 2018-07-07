package MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that contains the methods used for querying the database
 * @author TeamBangan
 */
public class CRUD {
    //USER RELATED

    /**
     *
     * The method inserts a user to the database
     * @param con Connection connecting the system to the database
     * @param fullname String containing the full name of the user to be created
     * @param username String containing the username of the user to be created
     * @param password String containing the encrypted password of the user to be created
     * @param admin Integer representing the ID of the administrator who created the user
     * @throws SQLException
     */
    
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
    
    /**
     *
     * Method checks if the user with the user id is archived
     * @param con Connection connecting the system to the database
     * @param userID Integer representing the ID of the user to be checked
     * @return boolean indicating whether the user is indeed archived
     * @throws SQLException
     */
    public static boolean checkUserArchived(Connection con, int userID) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username from user "+
                "where user_id='" + userID + "' AND removed = 1");
        return rs.next();
    }
    
    /**
     *
     * Method archives a user given the user id
     * @param con Connection connecting the system to the database
     * @param userID Integer representing the ID of the user to be archived
     * @return boolean from checkUserArchived() method
     * @throws SQLException
     */
    public static boolean archiveUser(Connection con, int userID) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `removed` = 1"
                +" WHERE `user`.`user_id`='" + userID + "'");
        return checkUserArchived(con,userID);
    }
    
    /**
     *
     * Method updates the username of the user with the given username
     * @param con Connection connecting the system to the database
     * @param username String containing the username of the user to be updated
     * @param newusername String containing the new username of the user to be updated
     * @param admin Integer representing the ID of the administrator who updated the user
     * @throws SQLException
     */
    public static void updateUsername(Connection con, String username, String newusername, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `username` = '" + newusername + "', `updated_by` = '"+ admin +"' WHERE `user`.`username` = '" + username + "'");
    }
    
    /**
     *
     * Method updates the password of the user with the given username
     * @param con Connection connecting the system to the database
     * @param username String containing the username of the user to be updated
     * @param oldpassword String containing the password of the user to be updated
     * @param newpassword String containing the new password of the user to be updated
     * @param admin Integer representing the ID of the administrator who updated the user
     * @throws SQLException
     */
    public static void updatePassword(Connection con, String username, String oldpassword, String newpassword, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `password` = '" + newpassword + "', `updated_by` = '"+ admin +"' WHERE `user`.`username` = '" + username + "'");
    }
    
    /**
     * Method updates the full name of the user with the given username
     * @param con Connection connecting the system to the database
     * @param username String containing the username of the user to be updated
     * @param newfullname String containing the new full name of the user to be updated
     * @param admin Integer representing the ID of the administrator who updated the user
     * @throws SQLException
     */
    public static void updateFullname(Connection con, String username, String newfullname, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `user` SET `full_name` = '" + newfullname + "', `updated_by` = '"+ admin +"' WHERE `user`.`username` = '" + username + "'");
    }

    /**
     *
     * Method that checks if the user with the username given is present in the database
     * @param con Connection connecting the system to the database
     * @param username String containing the username of the user to be updated
     * @return boolean that indicates whether the user exists or not
     * @throws SQLException
     */
    public static boolean checkUserExists(Connection con, String username) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_id from user "+
                "where username='" + username + "' AND removed=0");
        return rs.next();
    }
    
    /**
     * Method returns the user ID and Password of the user with the given username
     * @param con Connection connecting the system to the database
     * @param username String containing the username of the user queried
     * @return ResultSet with the user ID and Password of the user
     * @throws SQLException
     */
    public static ResultSet selectUserIDPassword(Connection con, String username)
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `user_id`, `password` from user WHERE username='" + username + "'");
        return rs;
    }
    
    /**
     *
     * Method returns the username of the user with the given ID
     * @param con Connection connecting the system to the database
     * @param userid integer containing the user ID of the user queried
     * @return String of the username 
     * @throws SQLException
     */
    public static String selectUsername(Connection con, int userid) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username from user where user_id='" + userid + "'");
        rs.next();
        return rs.getString("username");
    }
    
    /**
     *
     * Method selects all user information of users that are not archived from the database
     * @param con Connection connecting the system to the database
     * @return ResultSet with user information
     * @throws SQLException
     */
    public static ResultSet selectUsersInfo(Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT user_id, username, full_name, added_by, "+
                "added_date, updated_by, updated_date FROM `user` "+
                "WHERE removed = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * Method selects all user information from the user with the given
     * @param con Connection connecting the system to the database
     * @param id Integer 
     * @return ResultSet of user information
     * @throws SQLException
     */
    public static ResultSet selectUserInfo(Connection con, int id) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT user_id, username, full_name, added_by, "+
                "added_date, updated_by, updated_date FROM `user` WHERE user_id = '"+ id +"'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con
     * @param username
     * @return
     * @throws SQLException
     */
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

    /**
     *
     * @param con Connection connecting the system to the database
     * @param name
     * @param admin
     * @throws SQLException
     */
    
    public static void insertCleaningCategory(
            Connection con, String name, int admin) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO cleaning_category"+
                "(`category_name`, `added_by`, `updated_by`)"+
                " VALUES('" + name + "','" + admin + "','" + admin + "')");
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @param itemID
     * @param itemQuantity
     * @throws SQLException
     */
    public static void insertCategoryItem(
            Connection con, int categoryID, int itemID, int itemQuantity, int admin) 
            throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO category_items"+
                "(`category_id`, `item_id`, `item_quantity`, `added_by`, `updated_by`) "+
                "VALUES('" 
                + categoryID + "','" 
                + itemID + "','" 
                + itemQuantity + "','"
                + admin + "','"
                + admin + "')");
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @param itemID
     * @param newItemQuantity
     * @throws SQLException
     */
    public static void updateCategoryItemQuantity(
            Connection con, int categoryID, int itemID, int newItemQuantity) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `category_items` "+
                "SET `item_quantity` = '" + newItemQuantity + 
                "' WHERE category_id = '" + categoryID + 
                "' AND item_id = '"+itemID+"'");
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @return
     * @throws SQLException
     */
    public static ResultSet selectCategoriesInfo(Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_id, category_name, added_by, "+
                "added_date, updated_by, updated_date FROM `cleaning_category` "+
                "WHERE removed = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @return
     * @throws SQLException
     */
    public static ResultSet selectCategoryItemsInfo(Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_id, item_id, item_quantity, added_by, "+
                "added_date, updated_by, updated_date FROM `category_items` "+
                "WHERE removed = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryName
     * @return
     * @throws SQLException
     */
    public static ResultSet selectCategoryItemsInfoUsingCategoryName(Connection con, String categoryName) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_id, item_id, item_quantity, added_by, "+
                "added_date, updated_by, updated_date FROM `category_items` "+
                "WHERE category_name = '"+categoryName+"' AND removed = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @param itemID
     * @return
     * @throws SQLException
     */
    public static ResultSet selectCategoryItemInfoCategoryIDItemID(Connection con, int categoryID, int itemID) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_id, item_id, item_quantity, added_by, "+
                "added_date, updated_by, updated_date FROM `category_items` "+
                "WHERE category_id = '"+ categoryID +"' AND item_id = '"+ itemID +"' AND removed = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @return
     * @throws SQLException
     */
    public static ResultSet selectCategoryItemsInfoUsingCategoryID(Connection con, int categoryID) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_id, item_id, item_quantity, added_by, "+
                "added_date, updated_by, updated_date FROM `category_items` "+
                "WHERE category_id = '"+ categoryID +"' AND removed = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param id
     * @return
     * @throws SQLException
     */
    public static ResultSet selectCategoryInfo(Connection con, int id) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_name, added_by, added_date, "+
                "updated_by, updated_date FROM `cleaning_category` WHERE category_id = '"+ id +"'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryName
     * @return
     * @throws SQLException
     */
    public static ResultSet selectCategoryInfoUsingCategoryName(Connection con, String categoryName) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT category_id, category_name, added_by, added_date, "+
                "updated_by, updated_date FROM `cleaning_category` WHERE category_name = '"+ categoryName +"'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryName
     * @return
     * @throws SQLException
     */
    public static int selectCategoryID(Connection con, String categoryName)
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `category_id` from cleaning_category WHERE category_name='" + categoryName + "'");
        if(rs.next())
            return rs.getInt("category_id");
        else{
            return -1;
        }
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryName
     * @return
     * @throws SQLException
     */
    public static boolean checkCategoryExists(Connection con, String categoryName) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT category_id from cleaning_category "+
                "where category_name='" + categoryName + "'");
        return rs.next();
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @return
     * @throws SQLException
     */
    public static boolean checkCategoryArchived(Connection con, int categoryID) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT category_name from cleaning_category "+
                "where category_id='" + categoryID + "' AND removed = 1");
        return rs.next();
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @return
     * @throws SQLException
     */
    public static boolean archiveCategory(Connection con, int categoryID) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `cleaning_category` SET `removed` = '"+1
                +"' WHERE category_id = '" + categoryID + "'");
        return checkCategoryArchived(con,categoryID);
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID integer representing the category ID
     * @param itemID integer representing the item ID
     * @return boolean indicating whether the category item is archived or not
     * @throws SQLException
     */
    public static boolean checkCategoryItemArchived(Connection con, int categoryID, int itemID) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT category_id from category_items "+
                "where category_id='" + categoryID + "' AND item_id='"+ itemID +"' AND removed = 1");
        return rs.next();
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @param itemID
     * @throws SQLException
     */
    public static boolean archiveCategoryItem(
            Connection con, int categoryID, int itemID) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `category_items` SET `removed` = '"+1
                +"' WHERE category_id='"+categoryID+"' AND item_id='"+itemID+"'");
        return checkCategoryItemArchived(con, categoryID, itemID);
    }
    
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @param categoryName
     * @return
     * @throws SQLException
     */
    public static boolean deleteCategory(
            Connection con, int categoryID, String categoryName)
            throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `category_items` "+
                "WHERE category_id='"+categoryID+"'");
        return !checkCategoryExists(con, categoryName);
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @param itemID
     * @throws SQLException
     */
    public static void deleteCategoryItem(
            Connection con, int categoryID, int itemID)
            throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `category_items` "+
                "WHERE category_id='"+categoryID+"' AND item_id='"+itemID+"'");
    }
    
    //END OF CATEGORY RELATED
    
    
    //ITEM RELATED

    /**
     *
     * @param con
     * @param itemName
     * @return
     * @throws SQLException
     */
    
    public static int selectItemID(Connection con, String itemName)
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `item_id` from item "+
                "WHERE item_name = '" + itemName + "'");
        if(rs.next())
            return rs.getInt("item_id");
        else{
            return -1;
        }
    }
    
    /**
     *
     * @param con
     * @param itemID
     * @return
     * @throws SQLException
     */
    public static String selectItemName(Connection con, int itemID)
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `item_name` from item WHERE item_id='" + itemID + "'");
        if(rs.next())
            return rs.getString("item_name");
        else
            return "404 Not Found";
    }
    
    /**
     *
     * @param con
     * @param id
     * @return
     * @throws SQLException
     */
    public static ResultSet selectItemInfo(Connection con, int id) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT item_name, quantity, metric, type, added_by, "+
                "added_date, updated_by, updated_date FROM `item` "+
                "WHERE item_id = '"+ id +"'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    /**
     *
     * @param con
     * @return
     * @throws SQLException
     */
    public static ResultSet selectItemsInfo(Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT item_id, item_name, quantity, metric, type, "+
                "added_by, added_date, updated_by, updated_date FROM `item` "+
                "WHERE removed = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
//    public static ResultSet selectItemInfo(Connection con, int itemID)
//            throws SQLException {
//        Statement stmt;
//        stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT `item_id, item` from item WHERE item_id='" + itemID + "'");
//        return rs;
//    }
    
    //END OF ITEM RELATED

    /**
     *
     * @param con
     * @param product
     * @param price
     * @param quantity
     * @throws SQLException
     */
    public static void insertInventory(Connection con, String product, String price, String quantity) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO item(`Product`, `Price`, `Quantity`) VALUES('" + product + "','" + price + "','" + quantity + "')");
    }

    /**
     *
     * @param con
     * @param product
     * @param price
     * @param quantity
     * @throws SQLException
     */
    public static void deleteInventory(Connection con, String product, String price, String quantity) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `inventory` WHERE `inventory`.`Product`='" + product + "' AND Price='" + price + "' AND Quantity='" + quantity + "'");
    }

    /**
     *
     * @param con
     * @param stock
     * @param product
     * @throws SQLException
     */
    public static void updateInventoryQ(Connection con, int stock, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `inventory` SET `Quantity` = '" + stock + "' WHERE `inventory`.`Product` = '" + product + "'");
    }

    /**
     *
     * @param con
     * @param product
     * @return
     * @throws SQLException
     */
    public static ResultSet selectInventoryQ(Connection con, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from inventory where Product='" + product + "'");
        return rs;
    }

    /**
     *
     * @param con
     * @param product
     * @param price
     * @param quantity
     * @return
     * @throws SQLException
     */
    public static ResultSet selectInventoryP(Connection con, String product, String price, String quantity) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Product" + " from inventory where Product='" + product + "' AND Price='" + price + "' AND Quantity='" + quantity + "'");
        return rs;
    }

    /**
     *
     * @param con
     * @param product
     * @return
     * @throws SQLException
     */
    public static ResultSet selectInventoryPrc(Connection con, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Price" + " from inventory where Product='" + product + "'");
        return rs;
    }

    /**
     *
     * @param con
     * @param name
     * @param product
     * @param price
     * @param quantity
     * @throws SQLException
     */
    public static void insert(Connection con, String name, String product, String price, int quantity) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO " + name + "(`Product`, `Price`, `Quantity`) VALUES('" + product + "','" + price + "','" + quantity + "')");
    }

    /**
     *
     * @param con
     * @param name
     * @param stock
     * @param product
     * @throws SQLException
     */
    public static void updateQ(Connection con, String name, int stock, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `" + name + "` SET `Quantity` = '" + stock + "' WHERE `" + name + "`.`Product` = '" + product + "'");
    }

    /**
     *
     * @param con
     * @param name
     * @param product
     * @throws SQLException
     */
    public static void delete(Connection con, String name, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `" + name + "` WHERE `" + name + "`.`Product`='" + product + "'");
    }

    /**
     *
     * @param con Connection connecting the system to the database
     * @param name
     * @param product
     * @return
     * @throws SQLException
     */
    public static ResultSet selectQ(Connection con, String name, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from " + name + " where Product='" + product + "'");
        return rs;
    }

    /**
     *
     * @param con Connection connecting the system to the database
     * @param name
     * @param product
     * @return
     * @throws SQLException
     */
    public static ResultSet selectPrc(Connection con, String name, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Price" + " from " + name + " where Product='" + product + "'");
        return rs;
    }

    /**
     *
     * @param con Connection connecting the system to the database
     * @param name
     * @param deduction
     * @param product
     * @throws SQLException
     */
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

    /**
     *
     * @param con Connection connecting the system to the database
     * @param name
     * @param additional
     * @param product
     * @throws SQLException
     */
    public static void addQ(Connection con, String name, int additional, String product) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from " + name + " where Product='" + product + "'");
        rs.next();
        int stock = rs.getInt("Quantity");
        stock = stock + additional;
        stmt.executeUpdate("UPDATE `" + name + "` SET `Quantity` = '" + stock + "' WHERE `" + name + "`.`Product` = '" + product + "'");
    }

    /**
     *
     * @param con Connection connecting the system to the database
     * @param name
     * @return
     * @throws SQLException
     */
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

    /**
     *
     * @param con Connection connecting the system to the database
     * @param name
     * @throws SQLException
     */
    public static void deleteContents(Connection con, String name) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `" + name + "`");
    }
}
