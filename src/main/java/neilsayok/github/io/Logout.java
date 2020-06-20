package neilsayok.github.io;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("emp_id");
        session.removeAttribute("emp_name");
        session.removeAttribute("emp_uname");
        session.removeAttribute("emp_pass");
        session.invalidate();
        response.getWriter().print("success");

    }


}
