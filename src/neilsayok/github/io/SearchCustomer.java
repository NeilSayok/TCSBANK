package neilsayok.github.io;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import neilsayok.github.io.Database.CustomerDAO;
import neilsayok.github.io.Models.CustomerDet;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SearchCustomer")
public class SearchCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO dao = new CustomerDAO();
        String ssnid = "";
        ssnid = request.getParameter("ssnid").trim();
        String custid = "";
        custid = request.getParameter("custid").trim();
        Gson gson = new Gson();
        String ret = "";
        JsonElement jsonElement;
        CustomerDet c = null;

        System.out.println(ssnid);
        System.out.println(custid);


        if (ssnid.length() > 0){
            c = dao.getCustomerBySSNID(Integer.parseInt(ssnid));
        }else if (custid.length() > 0){
            c = dao.getCustomerByCustID(Integer.parseInt(custid));
        }else {
            c = null;
        }

        if (c != null){
            ret = gson.toJson(c);
            JSONObject jsonObject = new JSONObject(ret);
            jsonObject.put("found",true);
            ret = gson.toJson(jsonObject.toString());
        }else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("found",false);
            ret = gson.toJson(jsonObject.toString());
        }

        System.out.println(ret);
        response.getWriter().print(ret);

    }


}
