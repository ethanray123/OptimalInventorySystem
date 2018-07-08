package MySQL;

import java.sql.Connection;
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
    
    public static void UpdateJobItem(Connection con, int itemid, int qty, int jobid, int admin) throws SQLException
    {
        Statement stmt;
        stmt = con.createStatement();
        if(admin != -1){
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `job_items` SET `item_id` = '"+itemid+"',"
                + " `item_quantity` = '"+qty+"', `job_id` = '"+jobid+"', "
                + "`updated_by` = '"+admin+"' WHERE `item_id` = '"+itemid+"'");
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
}
