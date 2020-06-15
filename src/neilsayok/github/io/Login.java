package neilsayok.github.io;

import neilsayok.github.io.Database.DAO;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        DAO dao = new DAO();
        JSONObject dbReply = dao.checkEmployee(uname,upass);
        if(dbReply.getBoolean("stat")){
            //TODO Start Session
            System.out.println(dbReply.getString("emp_uname"));

        }else{
            //TODO SEND ERROR
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("error");
        }

    }


}
