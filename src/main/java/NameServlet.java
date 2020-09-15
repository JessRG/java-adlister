import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NameServlet", urlPatterns = "/name")

//# Servlets Bonus Exercises
//        1. Create a servlet that returns your first and last name in a heading element to the user if navigating to ```/name```.
public class NameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name;

        try {
            if (req.getParameter("firstName") != null && req.getParameter("lastName") != null) {
                name = req.getParameter("firstName")+ " " + req.getParameter("lastName");
            } else {
                if(req.getParameter("firstName") != null) {
                    name = req.getParameter("firstName");
                } else if(req.getParameter("lastName") != null) {
                    name = req.getParameter("lastName");
                } else {
                    name = "John Doe";
                }
            }
            out.println(String.format("<h1>Hello %s!</h1>", name));
        } finally {
            out.close();
        }
    }
}