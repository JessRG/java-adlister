import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderFormServlet", urlPatterns = "/order-form")

//# Servlets Bonus Exercises
//        2. Create a servlet that returns a simple form if the user navigates to ```/order-form```. In servering up HTML,
//        you may need to include ```response.setHeader("content-type", "text/html");```. The form should include an
//        input for the name of a product and an input for how many of the product they want to order. The method of
//        the form should be ```POST``` and the action should be ```/order-summary```.
public class OrderFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setHeader("content-type", "text/html");
        PrintWriter out = res.getWriter();
        try {
            out.printf("<form id=\"form1\" method=\"POST\" action=\"/order-summary\">\n" +
                    "   <label for=\"productName\">Product Name:</label>\n" +
                    "   <input id=\"productName\" name=\"productName\" placeholder=\"Enter the product name: \" /><br/>\n" +
                    "   <label for=\"quantity\">Quantity:</label>\n" +
                    "   <input id=\"quantity\" name=\"quantity\" placeholder=\"How many do you want to order: \" />\n" +
                    "</form>\n" +
                    "<button type=\"submit\" form=\"form1\">Submit</button>");
        } finally {
            out.close();
        }
    }
}