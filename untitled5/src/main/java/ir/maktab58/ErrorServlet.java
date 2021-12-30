package ir.maktab58;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorServlet extends GenericServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Error initializing...");
        super.init(config);
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out = servletResponse.getWriter();
        servletResponse.setContentType("text/html");
        out.print("<head>\n header </head>\n <body> <h1> ERROR\n </h1>  </body>\n");
        out.close();
    }
}
