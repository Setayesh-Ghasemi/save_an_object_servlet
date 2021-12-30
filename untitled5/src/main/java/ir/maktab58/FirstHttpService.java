package ir.maktab58;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstHttpService extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("FirstHTTPService is initializing");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        out.print("<head>\n" + "</head>\n <body><p>\n");

        try {
            if (req.getParameter("name").isEmpty())
                throw new RuntimeException("Name field can't be null.");
            else {
                if (req.getParameter("name").equalsIgnoreCase("Setayesh"))
                    out.print("Bye Setayesh");
                else {
                    //req.getRequestDispatcher("/error").forward(req, resp);
                    req.getRequestDispatcher("1.html").forward(req, resp);
                    //resp.sendRedirect("/error");
                    //req.getRequestDispatcher("/error").include(req, resp);
                    //req.getRequestDispatcher("1.html").include(req, resp);
                }
            }
        } catch (RuntimeException e) {
            out.print(e.getMessage());
        }

        out.print("<br> . <br> See you later! </p> </body>");

        out.close();
    }
}
