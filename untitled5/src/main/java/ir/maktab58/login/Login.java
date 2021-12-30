package ir.maktab58.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("Taban") && password.equals("61378Tns")) {
            req.getRequestDispatcher("/welcome").forward(req, resp);
        } else {
            out.print("Invalid user or pass :( <br>Please try again!");
            req.getRequestDispatcher("index1.html").include(req, resp);
        }
    }
}
