package neilsayok.github.io;

import com.google.gson.Gson;
import neilsayok.github.io.Database.CustomerDAO;
import neilsayok.github.io.Models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetCustomer")
public class GetCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO dao = new CustomerDAO();
        response.getWriter().print(new Gson().toJson(dao.getCustomerByCustID(Integer.parseInt(request.getParameter("id")))));
    }

}
