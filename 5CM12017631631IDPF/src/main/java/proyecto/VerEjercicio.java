package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerEjercicio extends HttpServlet {

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
        HttpSession session = request.getSession();
        out.write(devolverJSON("x",(String)session.getAttribute("puntoX"),"y",(String)session.getAttribute("puntoy"),"ind",(String)session.getAttribute("ind"),"coeX",(String)session.getAttribute("coeX"),"coeY",(String)session.getAttribute("coeY")));
        session.setAttribute("coeY", null);
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    }
    
    private String devolverJSON(String clave,String valor,String clave1,String valor1,String clave2,String valor2,String clave3,String valor3,String clave4,String valor4) {
        StringBuilder json = new StringBuilder();
        
        json.append("[");
        json.append("{");
        json.append(jsonValue(clave, valor));
        json.append(",");
        json.append(jsonValue(clave1, valor1));
        json.append(",");
        json.append(jsonValue(clave2, valor2));
        json.append(",");
        json.append(jsonValue(clave3, valor3));
        json.append(",");
        json.append(jsonValue(clave4, valor4));
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
