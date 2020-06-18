package neilsayok.github.io.Database;

import neilsayok.github.io.Models.Account;
import neilsayok.github.io.Models.AccountDeT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    Connection connection;
    Statement smt;

    public AccountDAO() {
        DBConnection dbConnection = new DBConnection();
        connection = dbConnection.get_connection();
        try {
            smt = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public int createAccount(Account a){

        String query = "INSERT INTO `tcs_bank`.`account` (`customer_id`, `acc_type`, `acc_stat`, `acc_msg`, `acc_last_upd`)" +
                " VALUES" +
                " ('"+a.getCustomer_id()+"', '"+a.getAcc_type()+"', 'Account Created Successfully', '"+a.getAcc_msg()+"'," +
                " '"+System.currentTimeMillis()+"')";
        try {
            return smt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public  int updateAccount(AccountDeT a){
        String query = "UPDATE `tcs_bank`.`account` SET ";
        query += "`acc_msg`= 'Account Updated Successfully', ";
        if (a.getAcc_id() != null){
            query += "`acc_id`='"+a.getAcc_id() +"', ";
        }
        if (a.getCustomer_id() != null){
            query += "`customer_id`='"+a.getCustomer_id() +"', ";
        }
        if (a.getAcc_type() != null){
            query += "`acc_type`='"+a.getAcc_type() +"', ";
        }
        if (a.getAcc_status() != null){
            query += "`acc_stat`='"+a.getAcc_status() +"', ";
        }
        query += "`acc_last_upd`='"+System.currentTimeMillis()+"' ";
        query += " WHERE (`acc_id` = '"+a.getAcc_id()+"')";

        try {
            return smt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int updateAccountByAccID(int id,AccountDeT a){
        String query = "UPDATE `tcs_bank`.`account` SET ";
        query += "`acc_msg`= 'Account Updated Successfully', ";
        if (a.getAcc_id() != null){
            query += "`acc_id`='"+a.getAcc_id() +"', ";
        }
        if (a.getCustomer_id() != null){
            query += "`customer_id`='"+a.getCustomer_id() +"', ";
        }
        if (a.getAcc_type() != null){
            query += "`acc_type`='"+a.getAcc_type() +"', ";
        }
        if (a.getAcc_status() != null){
            query += "`acc_stat`='"+a.getAcc_status() +"', ";
        }
        query += "`acc_last_upd`='"+System.currentTimeMillis()+"' ";
        query += " WHERE (`acc_id` = '"+id+"')";

        try {
            return smt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    //TODO With JOIN
    public List<AccountDeT> getAllAccounts(){
        List<AccountDeT> accountDeTList = new ArrayList<>();
        String query = "SELECT a.acc_id, a.customer_id, a.acc_msg, a.acc_last_upd, atp.acc_typ_name, st.st_name " +
                "FROM `tcs_bank`.`account` a " +
                "left join `tcs_bank`.`acctype` atp on (a.acc_type=atp.acc_type) " +
                "left join `tcs_bank`.`status` st on(a.acc_stat=st.stat)";
        return getAccountDeTS(accountDeTList, query);
    }

    public List<AccountDeT> getAllAccountsByCustID(int id){
        List<AccountDeT> accountDeTList = new ArrayList<>();
        String query = "SELECT a.acc_id, a.customer_id, a.acc_msg, a.acc_last_upd, atp.acc_typ_name, st.st_name " +
                "FROM `tcs_bank`.`account` a " +
                "left join `tcs_bank`.`acctype` atp on (a.acc_type=atp.acc_type) " +
                "left join `tcs_bank`.`status` st on(a.acc_stat=st.stat) WHERE `customer_id`="+id;
        return getAccountDeTS(accountDeTList, query);
    }

    private List<AccountDeT> getAccountDeTS(List<AccountDeT> accountDeTList, String query) {
        try {
            ResultSet rs = smt.executeQuery(query);
            while (rs.next()){
                accountDeTList.add(new AccountDeT(
                        rs.getInt("acc_id"),
                        rs.getInt("customer_id"),
                        rs.getString("acc_typ_name"),
                        rs.getString("st_name"),
                        rs.getString("acc_msg"),
                        rs.getLong("acc_last_upd")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accountDeTList;
    }

    public AccountDeT getAccountByAccID(int id){
        String query = "SELECT a.acc_id, a.customer_id, a.acc_msg, a.acc_last_upd, atp.acc_typ_name, st.st_name " +
                "FROM `tcs_bank`.`account` a " +
                "left join `tcs_bank`.`acctype` atp on (a.acc_type=atp.acc_type) " +
                "left join `tcs_bank`.`status` st on(a.acc_stat=st.stat) WHERE `acc_id`="+id;
        return getAccountDeTS(new ArrayList<>(), query).get(0);
    }

    public int deletAccountByAccId(int id){
        String query = "DELETE FROM `tcs_bank`.`account` WHERE (`acc_id` = '"+id+"')";
        try {
            return smt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int deletAccountsByCustId(int id){
        String query = "DELETE FROM `tcs_bank`.`account` WHERE (`customer_id` = '"+id+"')";
        try {
            return smt.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }



}
