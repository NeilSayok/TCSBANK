package neilsayok.github.io;

import neilsayok.github.io.Database.CustomerDAO;
import neilsayok.github.io.Models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CreateCustomer")
public class CreateCustomer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer c = new Customer();
        c.setSsn_id(Integer.parseInt(request.getParameter("ssn_id")));
        c.setCust_name(request.getParameter("cust_name"));
        c.setCust_age(Integer.parseInt(request.getParameter("cust_age")));
        c.setCust_address(request.getParameter("cust_add"));
        c.setCust_city(Integer.parseInt(request.getParameter("cust_city")));
        c.setCust_state(Integer.parseInt(request.getParameter("cust_state")));
        c.setCust_msg(request.getParameter("cust_msg"));


        c.setCust_address(c.getCust_address().replace("'","''"));


        CustomerDAO dao = new CustomerDAO();
        try {
            if(dao.createCustomer(c)) {
                response.getWriter().print("success");
                return;
            }
            else
                response.getWriter().print("SSN ID is not unique");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            response.getWriter().print("Write Error");
        }


    }
}
