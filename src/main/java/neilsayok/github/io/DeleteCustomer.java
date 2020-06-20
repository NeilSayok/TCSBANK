package neilsayok.github.io;

import neilsayok.github.io.Database.CustomerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (new CustomerDAO().deleteCustomerByID(Integer.parseInt(request.getParameter("id")))==1){
            response.getWriter().print("Deleted Successfully:");
        }else {
            response.getWriter().print("Deletion is not successful. Please try again:");
        }
    }


}
