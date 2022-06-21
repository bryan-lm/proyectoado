package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerificarLogin extends HttpServlet {

    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
            StringBuilder json = new StringBuilder();        
    try
    {
        HttpSession session = request.getSession();
        String usuario = (String)session.getAttribute("usuario");
        
        if(usuario != null)
            json.append(devolverJSON(usuario));
        else
            json.append(devolverJSON("error"));
        
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    System.out.print(json);
    out.write(json.toString());
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
