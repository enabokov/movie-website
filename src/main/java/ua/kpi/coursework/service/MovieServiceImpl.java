package ua.kpi.coursework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.kpi.coursework.domain.Movie;
import ua.kpi.coursework.repository.MovieRepository;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Integer getTotalByYear(Integer year) {
        return movieRepository.countMoviesByYear(year);
    }

    @Override
    public List<Movie> getMoviesByYear(Integer year, Pageable limit) {
        return movieRepository.findMoviesByYear(year, limit);
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre, Pageable limit) {
        return movieRepository.findMoviesByGenre(genre, limit);
    }

    @Override
    public Movie getMovieById(Integer id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public Integer getTotalByGenre(String genre) {
        return movieRepository.countMoviesByGenre(genre);
    }

    @Override
    public List<String> getUniqueGenres() {
        return movieRepository.findDistinctGenre();
    }

    @Override
    public void save(Movie movie) {
        movie.setDescription("Desc");
        movie.setBudget("0");
        movie.setRating((float) 0);
        movie.setYear(2000);
        movie.setDurability(120);

        movieRepository.save(movie);
    }
}
