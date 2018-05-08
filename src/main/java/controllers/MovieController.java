package main.java.controllers;

import main.java.entities.movie.Movie;
import main.java.helpers.DataHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class MovieController {

    private DataHelper dataHelper;

    public MovieController() {
        dataHelper = DataHelper.getInstance();
    }

    public List<Movie> getMovies(int limit, int offset) {
        Session session = this.dataHelper.getSession();
        Transaction transaction = session.beginTransaction();

        List<Movie> list = (List<Movie>) session.createNativeQuery(
        "SELECT * FROM movies m;"
        ).setFirstResult(offset).setMaxResults(limit).getResultList();

        transaction.commit();
        session.close();

        return list;
    }
}
