package ua.kpi.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.coursework.domain.Movie;
import ua.kpi.coursework.domain.MovieRepository;

import java.util.List;

@Service
public class MovieServiceImpl {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getByYear(Integer year) {
        return movieRepository.findByYear(year);
    }
}
