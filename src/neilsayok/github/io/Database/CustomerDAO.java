package neilsayok.github.io.Database;

import neilsayok.github.io.Models.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void createCustomer(Customer c){

    }
    //UPDATE Customer
    //DELETE CUSTOMER
    //READ ALL CUSTOMER
    //READ 1 CUSTOMER
}
