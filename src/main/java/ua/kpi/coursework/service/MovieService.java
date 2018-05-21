package ua.kpi.coursework.service;

import org.springframework.data.domain.Pageable;
import ua.kpi.coursework.domain.Movie;

import java.util.List;


public interface MovieService {

    List<Movie> getMoviesByYear(Integer year, Pageable limit);

    List<Movie> getMoviesByGenre(String genre, Pageable limit);

    Integer getTotalByGenre(String genre);

    List<String> getUniqueGenres();

    List<Integer> getUniqueYears();

    Movie getMovieById(Integer id);

    List<Movie> getMoviesByTitleLike(String title, Pageable limit);

    void save(Movie movie);
}