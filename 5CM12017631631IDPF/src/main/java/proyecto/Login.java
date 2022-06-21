package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {

    private PrintWriter outter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        outter = response.getWriter();
                 response.setContentType("application/json");
      response.addHeader("Access-Control-Allow-Origin", "*");
 String usr = request.getParameter("User");
        String pass = request.getParameter("password");
        PrintWriter out = response.getWriter();
              
         boolean b = true;
    
         try
        {
        DB bd= new DB();
        bd.setConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/intercepcion");
        ResultSet rs=bd.executeQuery("select * from usuario where usuario='"+usr+"' and contraseña='"+pass+"';");
        if(rs.next())
        {
        String usuario=rs.getString("usuario");
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);
        b = false;
        System.out.print(devolverJSON(usuario));
        outter.write(devolverJSON(usuario));
        }
        if(b)
        {
        out.write(devolverJSONError());
        }
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        
       }

        private String devolverJSON(String usuario) {
        StringBuilder json = new StringBuilder();
        
        json.append("[");
        json.append("{");
        json.append(jsonValue("usuario", usuario));
        json.append("}");
        json.append("]");
        return json.toString();
    }
    
    private String devolverJSONError() {
        StringBuilder json = new StringBuilder();
        json.append("[");
        json.append("{");
        json.append(jsonValue("usuario", "error"));
        json.append("}");
        json.append("]");
        return json.toString();
    }

    private String jsonValue(String key, Object value) {
        return new StringBuilder()
                .append("\"")
                .append(key)
                .append("\" : \"")
                .append(value)
                .append("\"")
                .toString();
    }

}
