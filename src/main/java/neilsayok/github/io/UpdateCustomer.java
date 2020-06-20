package neilsayok.github.io;

import neilsayok.github.io.Database.CustomerDAO;
import neilsayok.github.io.Models.Customer;
import neilsayok.github.io.Models.CustomerDet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        CustomerDet c = new CustomerDet();
        //data : "custid="+$("#cust_id").text()+"&address="+$("#add_inp").val()+"&age="+$("#age_inp").val()+"&name="+$("#name_inp").val(),
        if (!request.getParameter("name").trim().isEmpty())
            c.setCust_name(request.getParameter("name"));
        if (!request.getParameter("age").trim().isEmpty())
            c.setCust_age(Integer.valueOf(request.getParameter("age")));
        if (!request.getParameter("address").trim().isEmpty())
            c.setCust_address(request.getParameter("address"));
        c.setCust_id(Integer.valueOf(request.getParameter("custid")));
        CustomerDAO dao = new CustomerDAO();
        if(dao.updateCustomerByID(c.getCust_id(),c)==1){
            response.getWriter().print("Update Success");
        }else {
            response.getWriter().print("Update Not Success Please Again");
        }


    }


}
