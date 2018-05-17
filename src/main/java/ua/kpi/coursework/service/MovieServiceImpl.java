package ua.kpi.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.kpi.coursework.domain.Movie;
import ua.kpi.coursework.repository.MovieRepository;

import java.util.List;

@Service
public class MovieServiceImpl {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Integer getTotalByYear(Integer year) {
        return movieRepository.countMoviesByYear(year);
    }

    public List<Movie> getMoviesByYear(Integer year, Pageable limit) {
        return movieRepository.findMoviesByYear(year, limit);
    }

    public List<Movie> getMoviesByGenre(String genre, Pageable limit) {
        return movieRepository.findMoviesByGenre(genre, limit);
    }

    public Integer getTotalByGenre(String genre) {
        return movieRepository.countMoviesByGenre(genre);
    }

    public List<String> getUniqueGenres() {
        return movieRepository.findDistinctGenre();
    }
}
