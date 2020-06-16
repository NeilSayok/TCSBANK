package neilsayok.github.io;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import neilsayok.github.io.Database.DAO;
import neilsayok.github.io.Models.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetCities")
public class GetCities extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        try {
            String resp = gson.toJson(dao.getAllCitiesForState(Integer.parseInt(request.getParameter("state_id"))));
            out.println(resp);
        }catch (Exception e){
            e.printStackTrace();
            out.println("error");
        }

    }
}
