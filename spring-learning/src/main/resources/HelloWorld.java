import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by ymxing on 7/21/14.
 */
public class HelloWorld extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HelloWorld!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>HelloWorld!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}