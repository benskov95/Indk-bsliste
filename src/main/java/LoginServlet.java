import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        String navn = request.getParameter("navn");
        String kode = request.getParameter("kodeord");

        if (servletContext.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();
            brugerMap.put("test", "test");
            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if (!((Map<String, String>)servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            // Gå til log-ind side.
            request.setAttribute("besked",  "Opret ny bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);

        }

        if (((Map<String, String>)servletContext.getAttribute("brugerMap")).get(navn).equals(kode)) {

            // Gå til huskelisten.
            request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request, response);
        }

         // Gå til log-ind. dvs index siden.
        request.setAttribute("besked",  "Koden var forkert. Prøv igen.");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
