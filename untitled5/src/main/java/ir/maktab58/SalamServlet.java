package ir.maktab58;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Taban Soleymani
 */
public class SalamServlet implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("Servlet is initializing...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(servletConfig.getInitParameter("param1"));

        PrintWriter out = servletResponse.getWriter();
        servletResponse.setContentType("text/plain");

        try {
            if (servletRequest.getParameter("name").isEmpty())
                throw new RuntimeException("Name field can't be null.");
            else {
                if (servletRequest.getParameter("name").equalsIgnoreCase("Taban"))
                    out.print("Salam Taban");
                else {
                    out.println("I don't know you :(");
                }
            }
        } catch (RuntimeException e) {
            out.print(e.getMessage());
        }

        out.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroying...");
    }
}
