package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class calcularPuntosInterseccion extends HttpServlet {

    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        String coeficienteX = request.getParameter("coeX");
        String independiente = request.getParameter("inde");
        StringBuilder json = new StringBuilder();
        json.append("[");  
        double xres = 0;
        try
        {
            double x = Double.parseDouble(coeficienteX);
            double ind = Double.parseDouble(independiente);
            
            
            xres = -ind/x;
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
            out.write("[{'x':'error'}]");
        }
            json.append("]");
            HttpSession session = request.getSession();
            session.setAttribute("puntoX", String.valueOf(xres));
            session.setAttribute("puntoy", independiente);
            session.setAttribute("ind", independiente);
            session.setAttribute("coeX", coeficienteX);
            
            out.write(devolverJSON("x",String.valueOf(xres),"y",independiente));
    }
    
            private String devolverJSON(String clave,String valor,String clave1,String valor1) {
        StringBuilder json = new StringBuilder();
        
        json.append("[");
        json.append("{");
        json.append(jsonValue(clave, valor));
        json.append(",");
        json.append(jsonValue(clave1, valor1));
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
