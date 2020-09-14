import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")

//# Servlets Bonus Exercises
//        ### JSPs are not needed for the following exercises.
//        1. Create a servlet that returns your first and last name in a heading element to the user if navigating to ```/name```.

//        2. Create a servlet that returns a simple form if the user navigates to ```/order-form```. In servering up HTML, you may need to include
//          ```response.setHeader("content-type", "text/html");```. The form should include an input for the name of a product and an input for how
//          many of the product they want to order. The method of the form should be ```POST``` and the action should be ```/order-summary```.

//        3. Create a servlet that listens for POST requests to ```/order-summary``` and souts out the name of the product ordered by the user and
//          the quantity. HINT: you will probably need to use the request object to get the parameters!

//        4. Create a servlet that listens for requests to ```/ping``` and a servlet that listens for requests to ```/pong```. The former servlet
//          should simply return a link that sends a request to the latter, and vice versa! If successfully built, the user should be able to
//          cycle back and forth between two pages by clicking on a ```PING!``` or ```PONG!``` link.
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        out.println(String.format("<h1>Hello %s!</h1>", name != null ? name : "World"));
    }
}