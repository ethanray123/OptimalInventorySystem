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
    
    public static String selectFullname(Connection con, int userid) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT full_name from user where user_id='" + userid + "'");
        if(rs.next())
            return rs.getString("full_name");
        else
            return "N/A";
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
    
    public static String getUsername(Connection con, int id) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT username FROM user WHERE user_id = '"+ id +"'";
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        String un = rs.getString("username");
        
        return un;
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
     * @param admin
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
     * @param adminID
     * @throws SQLException
     */
    public static void updateCategoryItemQuantity(
            Connection con, int categoryID, int itemID, int newItemQuantity, int adminID) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `category_items` "+
                "SET `item_quantity` = " + newItemQuantity + 
                ", `updated_by` = "+adminID+" WHERE category_id = " + categoryID + 
                " AND item_id = "+itemID);
    }
    
    /**
     *
     * @param con Connection connecting the system to the database
     * @param categoryID
     * @param newCategoryName
     * @param adminID
     * @throws SQLException
     */
    public static void updateCategoryName(
            Connection con, int categoryID, String newCategoryName, int adminID) 
            throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `cleaning_category` "+
                "SET `category_name` = '" + newCategoryName + 
                "', `updated_by` = "+adminID+" WHERE category_id = " + categoryID);
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
    
    
    public static ResultSet selectCategoryItemAddedUpdated(Connection con, int categoryID, int itemID) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT added_by, added_date, updated_by, updated_date "+
                "FROM `category_items` "+
                "WHERE category_id = '"+ categoryID +"' AND item_id = '"+ itemID +"' AND removed = 0";
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
     * @return 
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
    
    // START OF JOBS CRUD
    public static void insertJob(Connection con, int cat_id, int admin, String name) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        if(admin != -1){
            stmt.executeUpdate("INSERT INTO `job`(`job_name`, `category_id`, `added_by`, "
                + "`updated_by`) VALUES('"+name+"','"+cat_id+"','"+admin+"','"+admin+"')");
        }else{
            stmt.executeUpdate("INSERT INTO `job`(`category_id`, `added_by`, "
                + "`updated_by`) VALUES('"+cat_id+"',NULL,NULL)");
        }
    }
    
    public static int insertJobReturnID(Connection con, int cat_id, int admin, String name) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        int retval = -1;
        if(admin != -1){
            stmt.executeUpdate("INSERT INTO `job`(`job_name`, `category_id`, `added_by`, "
                + "`updated_by`) VALUES('"+name+"','"+cat_id+"','"+admin+"','"+admin+"')", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                retval = rs.getInt(1);
            }
        }
        return retval;
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
    
    public static String getCleaningCatName(Connection con, int id) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        String catName = "";
        ResultSet rs = stmt.executeQuery("SELECT `category_name` FROM "
            + "`cleaning_category` WHERE `category_id`='" + id + "'");
        
        if(rs.next()){
           catName = rs.getString("category_name");
        }
        return catName;
    }
    
    
    public static ResultSet selectJobsInfo(Connection con) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT `job_id`, `job_name`, `category_id`, `added_by`, `added_date`,"
            + "`updated_by`, `updated_date` FROM `job` WHERE `removed` = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static ResultSet selectJobsInfoUsingID(Connection con, int ID) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT `job_id`, `job_name`, `category_id`, `added_by`, `added_date`,"
            + "`updated_by`, `updated_date` FROM `job` WHERE `job_id` = '" + ID + "'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static void updateJob(Connection con, int cat_id, int admin, int jobid, String name) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        if(admin != -1){
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `job` SET `category_id` = '"+cat_id+"', `job_name` = '"+name+"', "
               + "`updated_by` = '"+admin+"' WHERE `job_id` = '"+jobid+"'");
        }
    }
    public static boolean archiveJob(Connection con, int jobID) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `job` SET `removed` = 1"
                +" WHERE `job_id`='" + jobID + "'");
        return checkJobArchived(con,jobID);
    }
    
    public static boolean checkJobArchived(Connection con, int jobID) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `job_id` FROM `job` "+
                "WHERE `job_id` ='" + jobID + "' AND `removed` = 1");
        return rs.next();
    }
    
    public static ResultSet selectCleaningCategoryNameInfo(Connection con) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT `category_name` FROM `cleaning_category` WHERE `removed` = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static String getJobName(Connection con, int id) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        String jobName = "";
        ResultSet rs = stmt.executeQuery("SELECT `job_name` FROM "
            + "`job` WHERE `job_id`='" + id + "'");
        
        if(rs.next()){
           jobName = rs.getString("job_name");
        }
        return jobName;
    }
    
    public static int getJobID(Connection con, String jobname) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        int ID = 0;
        ResultSet rs = stmt.executeQuery("SELECT `job_id` FROM "
            + "`job` WHERE `job_name`='" + jobname + "'");
        
        if(rs.next()){
           ID = rs.getInt("job_id");
        }
        return ID;
    }
    
    public static int getCatID(Connection con, int jobid) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        int ID = 0;
        ResultSet rs = stmt.executeQuery("SELECT `category_id` FROM "
            + "`job` WHERE `job_id`='" + jobid + "'");
        
        if(rs.next()){
           ID = rs.getInt("category_id");
        }
        return ID;
    }
    // END OF JOBS CRUD
    
    // START OF JOB_ITEMS CRUD
    public static ResultSet selectJobItem_ItemNameInfo(Connection con) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT `item_name` FROM `item` WHERE `removed` = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    public static int getJobItem_ItemQty(Connection con, int itemid) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        int itemqty = 0;
        ResultSet rs = stmt.executeQuery("SELECT `quantity` FROM `item` WHERE `item_id`='" + itemid + "'");
        
        if(rs.next()){
           itemqty = rs.getInt("quantity");
        }
        return itemqty;
    }
    
    
    public static String getJobItem_ItemName(Connection con, int itemID) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        String name = "";
        ResultSet rs = stmt.executeQuery("SELECT `item_name` FROM `item` WHERE `item_id`='" + itemID + "'");
        
        if(rs.next()){
           name = rs.getString("item_name");
        }
        return name;
    }
    
    public static int getJobItem_ItemID(Connection con, String itemname) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        int ID = 0;
        ResultSet rs = stmt.executeQuery("SELECT `item_id` FROM `item` WHERE `item_name`='" + itemname + "'");
        
        if(rs.next()){
           ID = rs.getInt("item_id");
        }
        return ID;
    }
    
    public static ResultSet selectJobItemsInfo(Connection con) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT `jobItem_id`, `item_id`, `item_quantity`, `job_id`, `added_by`, `added_date`,"
            + "`updated_by`, `updated_date` FROM `job_items` WHERE `removed` = 0";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static ResultSet selectJobItemsInfoUsingID(Connection con, int ID) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT `jobItem_id`, `item_id`, `item_quantity`, `job_id`, `added_by`, `added_date`,"
            + "`updated_by`, `updated_date` FROM `job_items` WHERE `jobItem_id` = '" + ID + "'";
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
    public static void insertJobItem(Connection con, int itemid, int qty, 
        int jobid, int admin) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        if(admin != -1){
            stmt.executeUpdate("INSERT INTO `job_items`(`item_id`, `item_quantity`, `job_id`, "
                + "`added_by`, `updated_by`) VALUES('"+itemid+"','"+qty+"', "
                + "'"+jobid+"', '"+admin+"','"+admin+"')");
        }
    }
    
    public static void UpdateItemQty(Connection con, int finalqty, int admin, int itemid) throws SQLException
    {
        Statement stmt, stmt2;
        stmt = con.createStatement();
        String query = "SELECT `quantity` FROM `item` WHERE `item_id` = '"+itemid+"'";
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int itemqty = rs.getInt("quantity");
        int newqty = itemqty + finalqty;
        System.out.println("\n\nnewqty: "+newqty);
        if(admin != -1){
            stmt2 = con.createStatement();
            stmt2.executeUpdate("UPDATE `item` SET `quantity` = '"+newqty+"', `updated_by` = '"+admin+"' WHERE `item_id` = '"+itemid+"'");
        }
    }
    
    public static int DeductJobItemQty(Connection con, int qty, int itemid) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        String query = "SELECT `quantity` FROM `item` WHERE `item_id` = '"+itemid+"'";
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int qtyresult = rs.getInt("quantity");
        System.out.println("qtyresult: "+qtyresult);
        int qtyDiff = qtyresult - qty;
        System.out.println("qty: "+qty);
        System.out.println("qtyDiff(qtyresult - qty): "+qtyDiff);
        return qtyDiff;
    }
    
    public static void UpdateJobItemQty(Connection con, int qty, int admin, int itemid) throws SQLException
    {
        Statement stmt;
        if(admin != -1){
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `item` SET `quantity` = '"+qty+"', `updated_by` = '"+admin+"' WHERE `item_id` = '"+itemid+"'");
        }
    }
    
    public static int insertJobItemReturnID(Connection con, int itemid, int qty, int jobid, int admin) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        int retval = -1;
        if(admin != -1){
            stmt.executeUpdate("INSERT INTO `job_items`(`item_id`, `item_quantity`, `job_id`, "
                + "`added_by`, `updated_by`) VALUES('"+itemid+"','"+qty+"', "
                + "'"+jobid+"', '"+admin+"','"+admin+"')", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                retval = rs.getInt(1);
            }
        }
        return retval;
    }
    
    public static int AddDeductItemQty(Connection con, int inputQty, int jobitemID) throws SQLException{
        Statement stmt, stmt2;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `item_quantity` FROM `job_items` WHERE jobItem_id ='" + jobitemID + "'");
        rs.next();
        int temp, operation, stock, itemqty;
        stock = rs.getInt("item_quantity");
        itemqty = rs.getInt("item_quantity");
        operation = stock - inputQty;
        if(operation < 0){
            temp = itemqty + inputQty;
        }else{
            temp = stock - inputQty;
        }
        return temp;
    }
    
    public static void UpdateJobItem(Connection con, int itemid, int qty, int jobid, int admin, int jobItemID) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        if(admin != -1){
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `job_items` SET `item_id` = '"+itemid+"',"
                + " `item_quantity` = '"+qty+"', `job_id` = '"+jobid+"', "
                + "`updated_by` = '"+admin+"' WHERE `jobItem_id` = '"+jobItemID+"'");
        }
    }
    
    public static boolean archiveJobItem(Connection con, int jobitemID, int itemID) throws SQLException {
        Statement stmt, stmt2, stmt3, stmt4;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `item_quantity` FROM `job_items` WHERE `jobItem_id` ='" + jobitemID + "'");
        rs.next();
        int itemqty = rs.getInt("item_quantity");
        stmt2 = con.createStatement();
        stmt2.executeUpdate("UPDATE `job_items` SET `item_quantity` = 0, `removed` = 1 WHERE `jobItem_id`='" + jobitemID + "'");
        
        stmt3 = con.createStatement();
        ResultSet rs2 = stmt.executeQuery("SELECT `quantity` FROM `item` WHERE `item_id` ='" + itemID + "'");
        rs2.next();
        int itemqty2 = rs2.getInt("quantity");
        int finalqty = itemqty + itemqty2;
        
        stmt4 = con.createStatement();
        stmt4.executeUpdate("UPDATE `item` SET `quantity` = '"+finalqty+"' WHERE `item_id`='" + itemID + "'");
        return checkJobItemArchived(con,jobitemID);
    }
    
    public static boolean checkJobItemArchived(Connection con, int jobItemID) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `jobItem_id` FROM `job_items` "+
                "WHERE `jobItem_id` ='" + jobItemID + "' AND `removed` = 1");
        return rs.next();
    }
    //END OF JOB_ITEMS CRUD
    
    //START OF DASHBOARD CRUD
    
    
    //END OF DASHBOARD CRUD
}
