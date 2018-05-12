package servlets;

import beans.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login")
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer hash = (Integer) request.getSession().getAttribute("emailHash");

        String page = "login.jsp";
        if (hash != null) {
            page = "index.jsp";
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html");
        request.getRequestDispatcher("WEB-INF/pages/" + page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserBean user = new UserBean();

        user.setEmail(email);
        user.setPassword(password);

        String page = "login.jsp";

        if (user.login()) {
            page = "index.jsp";
            response.setStatus(HttpServletResponse.SC_OK);
            request.getSession().setAttribute("email_hash", email.hashCode());
            request.getSession().setAttribute("email", email);
        }
        else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            request.setAttribute("error", "Email or password is not correct.");
        }

        request.getRequestDispatcher("WEB-INF/pages/" + page).forward(request, response);
    }
}
