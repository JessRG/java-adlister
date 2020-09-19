package controller;

import model.Ad;
import model.DaoFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="AdServlet", urlPatterns="/ads")
public class AdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Generate and store the ads using the DaoFactory class
        List<Ad> allAds = DaoFactory.getAdsDao().all();

        // set the attribute with the request object
        request.setAttribute("allAds", allAds);

        // then transfer that information to ads/index.jsp
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}