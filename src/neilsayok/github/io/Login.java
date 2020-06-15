package neilsayok.github.io;

import neilsayok.github.io.Database.DAO;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        DAO dao = new DAO();
        JSONObject dbReply = dao.checkEmployee(uname,upass);
        if(dbReply.getBoolean("stat")){
            //TODO Start Session
            HttpSession session = request.getSession();
            session.setAttribute("emp_id",dbReply.getInt("emp_id"));
            session.setAttribute("emp_name",dbReply.getString("emp_name"));
            session.setAttribute("emp_uname",dbReply.getString("emp_uname"));
            session.setAttribute("emp_pass",dbReply.getString("emp_pass"));
            session.setMaxInactiveInterval(600);
            out.print("success");


        }else{
            //TODO SEND ERROR
            out.print("error");
        }
        out.close();
    }


}
