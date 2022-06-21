package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Preguntas extends HttpServlet {

    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
            StringBuilder json = new StringBuilder();
            json.append("[");            
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    Connection db = DriverManager.getConnection("jdbc:mysql://localhost/intercepcion","root", "rootroot");
    Statement s = db.createStatement();        
    ResultSet rs=s.executeQuery("select * from ejercicio;");
    while(rs.next())
    {
    String cadena=rs.getString("columna");
    StringBuilder ca =  new StringBuilder(cadena.substring(0, cadena.length()-1));
    ca.append(",\"id\" : \""+rs.getInt("id")+"\"}");
    json.append(ca.toString());
    json.append(",");
    }
    json = new StringBuilder(json.substring(0, json.length()-1));
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    json.append("]");
    System.out.print(json);
    out.write(json.toString());
    }

}
