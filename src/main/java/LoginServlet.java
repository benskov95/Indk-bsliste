import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        HttpSession session = request.getSession();
        String navn = request.getParameter("navn");
        String kode = request.getParameter("kodeord");

        if (servletContext.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();
            brugerMap.put("test", "test");
            brugerMap.put("admin", "1234");
            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if(((Set<String>)servletContext.getAttribute("aktiveBrugere")) == null) {
            Set<String> aktiveBrugere = new HashSet<>();
            servletContext.setAttribute("aktiveBrugere", aktiveBrugere);
        }

        if (!((Map<String, String>)servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            request.setAttribute("besked",  "Opret ny bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);

        }

        if (((Map<String, String>)servletContext.getAttribute("brugerMap")).get(navn).equals(kode)) {

            if (navn.equals("admin")) {
            request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
            }

            if (!((Set<String>)servletContext.getAttribute("aktiveBrugere")).contains(navn)) {

                ((Set<String>)servletContext.getAttribute("aktiveBrugere")).add(navn);
                session.setAttribute("besked", "Du er logget på som " + navn);
                request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request, response);
            }
        }

        request.setAttribute("besked",  "Noget gik galt. Prøv igen.");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
