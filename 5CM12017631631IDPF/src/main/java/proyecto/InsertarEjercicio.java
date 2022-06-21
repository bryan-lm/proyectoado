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


public class InsertarEjercicio extends HttpServlet {

    private PrintWriter outter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        outter = response.getWriter();
                 response.setContentType("application/json");
      response.addHeader("Access-Control-Allow-Origin", "*");
        String ind = request.getParameter("ind");
        String coeX = request.getParameter("coeX");
        String coeY = request.getParameter("coeY");
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String opCor = request.getParameter("opCor");
        String type = request.getParameter("type");
        String pregunta = request.getParameter("pregunta");
        String opcionA = request.getParameter("opcionA");
        String opcionB = request.getParameter("opcionB");
        String opcionC = request.getParameter("opcionC");
        String opcionD = request.getParameter("opcionD");
        String correcta = request.getParameter("correcta");
        PrintWriter out = response.getWriter();
              
         boolean b = true;
    
         try
        {       
                StringBuilder json = new StringBuilder();
                json.append("{");
                json.append(jsonValue("type", type));
                json.append(" , ");
                json.append(jsonValue("opCor", opCor));
                json.append(" , ");
                json.append(jsonValue("x", x));
                json.append(" , ");
                json.append(jsonValue("y", y));
                json.append(" , ");
                json.append(jsonValue("ind", ind));
                json.append(" , ");
                json.append(jsonValue("coeX", coeX));
                json.append(" , ");
                json.append(jsonValue("coeY", coeY));
                json.append(" , ");
                json.append(jsonValue("pregunta", pregunta));
                json.append(" , ");
                json.append(jsonValue("opcionA", opcionA));
                json.append(" , ");
                json.append(jsonValue("opcionB", opcionB));
                json.append(" , ");
                json.append(jsonValue("opcionC", opcionC));
                json.append(" , ");
                json.append(jsonValue("opcionD", opcionD));
                json.append(" , ");
                json.append(jsonValue("correcta", correcta));
                json.append("}");
               Class.forName("com.mysql.jdbc.Driver");
            Connection db = DriverManager.getConnection("jdbc:mysql://localhost/intercepcion","root", "rootroot");  
            Statement stmt;
            String query1 = "INSERT INTO ejercicio values(null,'"+json.toString()+"') ";
            stmt = db.createStatement();
            stmt.execute(query1);
            stmt.close();
            db.close();
                
                out.write(json.toString());
                
        }
        catch(Exception e)
        {
        e.printStackTrace();
        System.out.print(e.getMessage());
        out.write("[{pregunta: 'error'}]");
        }
        
       }

        private StringBuilder primerElementoJSON(String usuario) {
        StringBuilder json = new StringBuilder();
        
        json.append("[");
        json.append("{");
        json.append(jsonValue("usuario", usuario));
        return json;
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
