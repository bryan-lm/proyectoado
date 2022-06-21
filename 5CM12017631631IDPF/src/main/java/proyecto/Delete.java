
package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.addHeader("Access-Control-Allow-Origin", "*");
            String id = request.getParameter("id");
            System.out.println(id);
            try{
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection db = DriverManager.getConnection("jdbc:mysql://localhost/intercepcion","root", "rootroot");  
                 Statement stmt;
                
                String query1 = "DELETE FROM ejercicio where id = "+id ;
                stmt = db.createStatement();
                stmt.execute(query1);
                stmt.close();
                db.close();
                out.write("{\"message\" : true}");
            
                
            }catch(Exception e){
                out.write("{\"message\" : false}");
            }
    }
}
