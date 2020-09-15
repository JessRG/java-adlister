import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PongServlet", urlPatterns = "/pong")

//# Servlets Bonus Exercises
//        4. Create a servlet that listens for requests to ```/ping``` and a servlet that listens for requests to ```/pong```. The former servlet
//          should simply return a link that sends a request to the latter, and vice versa! If successfully built, the user should be able to
//          cycle back and forth between two pages by clicking on a ```PING!``` or ```PONG!``` link.
public class Pong extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try {
            out.println("<h1 align=\"right\"><a href=\"/ping\">PING!</a></h1>");
        } finally {
            out.close();
        }
    }
}