package main.java.webapp;

import main.java.beans.MovieBean;
import main.java.entities.movie.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Index")
public class Index extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MovieBean movieBean = new MovieBean();

        List<Movie> movies = movieBean.getMovies(15, 0);
        for(Object obj : movies)
            System.out.println(obj.toString());
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
