package neilsayok.github.io.Database;


import org.json.JSONObject;

import java.sql.*;

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

    public JSONObject checkEmployee(String uname, String upass){
        JSONObject retObject = new JSONObject();
        retObject.put("stat",false);
        String query = "SELECT COUNT(*) AS C,emp_id,emp_name,emp_uname FROM tcs_bank.employee WHERE emp_uname='"+uname+"' AND emp_pass='"+upass+"'";
        try {
            ResultSet rs = smt.executeQuery(query);
            while(rs.next()) {
                if (rs.getInt("C") == 1) {
                    retObject.put("stat",true);
                    retObject.put("emp_uname", uname);
                    retObject.put("emp_pass",upass);
                    retObject.put("emp_id",rs.getInt("emp_id"));
                    retObject.put("emp_name",rs.getString("emp_name"));
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

//    public JSObject getEmployeeDetail(String uname, String upass){
//        String query = "SELECT * AS CNT FROM tcs_bank.employee WHERE emp_uname='"+uname+"' AND emp_pass='"+upass+"'";
//        try {
//            ResultSet rs = smt.executeQuery(query);
//
//            while(rs.next()) {
//                if (rs.getInt("CNT") == 1) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//        return false;
//    }
}
