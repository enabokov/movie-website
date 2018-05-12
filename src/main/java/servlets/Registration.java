package servlets;

import beans.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registration")
public class Registration extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer hash = (Integer) request.getSession().getAttribute("emailHash");

        String page = "registration.jsp";
        if (hash != null) {
            page = "index.jsp";
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html");
        request.getRequestDispatcher("WEB-INF/pages/" + page).forward(request, response);
    }

    private Boolean checkInputParams(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        String age = request.getParameter("age");

        if (email == null) {
            request.setAttribute("error", "Enter please email");
            return false;
        }

        if (password == null) {
            request.setAttribute("error", "Enter please password");
            return false;
        }

        if (!password.equals(repeatPassword)) {
            request.setAttribute("error", "Passwords are not equal");
            return false;
        }

        if (age == null)  {
            request.setAttribute("error", "Enter please age");
            return false;
        }

        return true;

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "index.jsp";
        if (!this.checkInputParams(request)) {
            page = "registration.jsp";
            request.getRequestDispatcher("WEB-INF/pages/" + page).forward(request, response);
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String sex = request.getParameter("sex");

        UserBean user = new UserBean();

        user.setEmail(email);
        user.setPassword(password);
        user.setAge(age);
        user.setName(name);
        user.setSurname(surname);
        user.setSex(sex);

        if (!user.save()){
            page = "registration.jsp";
            request.setAttribute("error", "Something goes wrong. Try later.");
            request.getRequestDispatcher("WEB-INF/pages/" + page).forward(request, response);
        }

        response.setStatus(HttpServletResponse.SC_OK);
        request.getSession().setAttribute("email_hash", email.hashCode());
        request.getSession().setAttribute("email", email);

        request.getRequestDispatcher("WEB-INF/pages/" + page).forward(request, response);
    }
}
