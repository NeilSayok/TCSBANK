package neilsayok.github.io.Database;

import neilsayok.github.io.Models.Customer;
import neilsayok.github.io.Models.CustomerDet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    Connection connection;
    Statement smt;

    public CustomerDAO() {
        DBConnection dbConnection = new DBConnection();
        connection = dbConnection.get_connection();
        try {
            smt = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //CURD CUSTOMER:

    //CREATE Customer
    public boolean createCustomer(Customer c) throws SQLException {
        String check = "SELECT ssn_id FROM `tcs_bank`.`customer` where `ssn_id`=" + c.getSsn_id();
        ResultSet rs = smt.executeQuery(check);
        while (rs.next()) {
            if (rs.getInt("ssn_id") == c.getSsn_id()) {
                return false;
            }
        }
        String query = "INSERT INTO `tcs_bank`.`customer` " +
                "(`ssn_id`, `cust_name`, `cust_age`, `cust_address`, `cust_city`, `cust_state`,`cust_msg`,`cust_last_update`)" +
                "VALUES " +
                "('" + c.getSsn_id() + "'," +
                " '" + c.getCust_name() + "'," +
                " '" + c.getCust_age() + "', " +
                "'" + c.getCust_address() + "'," +
                " '" + c.getCust_city() + "', " +
                "'" + c.getCust_state() + "', " +
                "'" + c.getCust_msg() + "', " +
                "'" + System.currentTimeMillis() + "')";

        smt.executeUpdate(query);
        System.out.println(query);

        return true;
    }

    //UPDATE Customer
    //DELETE CUSTOMER
    //READ ALL CUSTOMER
    public List<CustomerDet> getAllCustomers(){
        List<CustomerDet> customerList = new ArrayList<>();
        String query = "SELECT c.cust_id,c.ssn_id,c.cust_name,c.cust_age,c.cust_address,c1.city,s1.state,st.st_name," +
                "c.cust_msg,c.cust_last_update FROM `tcs_bank`.`customer` c " +
                "left join `tcs_bank`.`cities` c1 on (c.cust_city=c1.id) " +
                "left join `tcs_bank`.`states` s1 on(c.cust_state=s1.id) " +
                "left join `tcs_bank`.`status` st on(c.cust_stat=st.stat)";
        try {
            ResultSet rs = smt.executeQuery(query);
            while (rs.next()){
                customerList.add(new CustomerDet(
                        rs.getInt("cust_id"),
                        rs.getInt("ssn_id"),
                        rs.getString("cust_name"),
                        rs.getInt("cust_age"),
                        rs.getString("cust_address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("st_name"),
                        rs.getString("cust_msg"),
                        rs.getLong("cust_last_update")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return customerList;
    }
    //READ 1 CUSTOMER
    public CustomerDet getCustomerBySSNID(int id){
        String query = "SELECT c.cust_id,c.ssn_id,c.cust_name,c.cust_age,c.cust_address,c1.city,s1.state,st.st_name," +
                "c.cust_msg,c.cust_last_update FROM `tcs_bank`.`customer` c " +
                "left join `tcs_bank`.`cities` c1 on (c.cust_city=c1.id) " +
                "left join `tcs_bank`.`states` s1 on(c.cust_state=s1.id) " +
                "left join `tcs_bank`.`status` st on(c.cust_stat=st.stat) where ssn_id="+id;
        return getCustomerDet(query);
    }
    public CustomerDet getCustomerByCustID(int id){
        String query = "SELECT c.cust_id,c.ssn_id,c.cust_name,c.cust_age,c.cust_address,c1.city,s1.state,st.st_name," +
                "c.cust_msg,c.cust_last_update FROM `tcs_bank`.`customer` c " +
                "left join `tcs_bank`.`cities` c1 on (c.cust_city=c1.id) " +
                "left join `tcs_bank`.`states` s1 on(c.cust_state=s1.id) " +
                "left join `tcs_bank`.`status` st on(c.cust_stat=st.stat) where cust_id="+id;
        return getCustomerDet(query);
    }

    private CustomerDet getCustomerDet(String query) {
        try {
            ResultSet rs = smt.executeQuery(query);
            while (rs.next()){
                return new CustomerDet(
                        rs.getInt("cust_id"),
                        rs.getInt("ssn_id"),
                        rs.getString("cust_name"),
                        rs.getInt("cust_age"),
                        rs.getString("cust_address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("st_name"),
                        rs.getString("cust_msg"),
                        rs.getLong("cust_last_update")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }


}
