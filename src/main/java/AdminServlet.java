import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String navn = request.getParameter("navn");
        ServletContext servletContext = getServletContext();

        if (!((Map<String, String>)servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            request.setAttribute("besked",  "Brugeren findes ikke.");
            request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);

        }

        ((Map<String, String>)servletContext.getAttribute("brugerMap")).remove(navn);
        request.setAttribute("besked", "Bruger med navn " + navn + " er blevet slettet.");
        request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
