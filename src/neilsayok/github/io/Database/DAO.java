package neilsayok.github.io.Database;


import neilsayok.github.io.Models.City;
import neilsayok.github.io.Models.State;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    Connection connection;
    Statement smt;

    public DAO() {
        DBConnection dbConnection = new DBConnection();
        connection = dbConnection.get_connection();
        try {
            smt = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public JSONObject checkEmployee(String uname, String upass) {
        JSONObject retObject = new JSONObject();
        retObject.put("stat", false);
        String query = "SELECT COUNT(*) AS C,emp_id,emp_name,emp_uname FROM tcs_bank.employee WHERE emp_uname='" + uname + "' AND emp_pass='" + upass + "'";
        try {
            ResultSet rs = smt.executeQuery(query);
            while (rs.next()) {
                if (rs.getInt("C") == 1) {
                    retObject.put("stat", true);
                    retObject.put("emp_uname", uname);
                    retObject.put("emp_pass", upass);
                    retObject.put("emp_id", rs.getInt("emp_id"));
                    retObject.put("emp_name", rs.getString("emp_name"));
                    return retObject;
                } else {

                    return retObject;
                }
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }


        return retObject;
    }

    public List<State> getAllState(){
        String query = "SELECT * FROM tcs_bank.states ORDER BY `name`";
        List<State> stateList = new ArrayList<>();
        try {
            ResultSet rs = smt.executeQuery(query);
            while (rs.next()){
                stateList.add(new State(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("country_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return stateList;
    }

    public List<City> getAllCitiesForState(int state_id){
        String query = "SELECT * FROM tcs_bank.cities WHERE state_id="+state_id;
        List<City> cityList = new ArrayList<>();
        try {
            ResultSet rs = smt.executeQuery(query);
            while (rs.next()){
                cityList.add(new City(rs.getInt("id"),
                        rs.getString("city"),
                        rs.getInt("state_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cityList;    }

}
