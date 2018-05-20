package ua.kpi.coursework.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.kpi.coursework.domain.Movie;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    List<Movie> findMoviesByYear(Integer year, Pageable pageable);

    Integer countMoviesByYear(Integer year);

    @Query("SELECT DISTINCT m.genre FROM Movie m")
    List<String> findDistinctGenre();

    List<Movie> findMoviesByGenre(String genre, Pageable pageable);

    Integer countMoviesByGenre(String genre);

    Movie findMovieById(Integer id);
}