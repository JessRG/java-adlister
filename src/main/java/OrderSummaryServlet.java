import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderSummaryServlet", urlPatterns = "/order-summary")

//# Servlets Bonus Exercises
//       3. Create a servlet that listens for POST requests to ```/order-summary``` and souts out the name of the product ordered by the user and
//       the quantity. HINT: you will probably need to use the request object to get the parameters!
public class OrderSummaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String prodName = req.getParameter("productName");
        String quantity = req.getParameter("quantity");
        PrintWriter out = res.getWriter();

        try {
            out.printf("Product Name: %s\nQuantity: %d", prodName, Integer.parseInt(quantity));
        } finally {
            out.close();
        }
    }
}