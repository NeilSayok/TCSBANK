package neilsayok.github.io.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public Connection get_connection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcs_bank","root","Mypassword1#");
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
