package ua.kpi.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ua.kpi.coursework.domain.Movie;
import ua.kpi.coursework.domain.MovieRepository;
import ua.kpi.coursework.domain.User;
import ua.kpi.coursework.domain.UserRepository;

import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public DatabaseInitializer(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User initial = new User();
        initial.setLogin("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        initial.setPassword(encoder.encode("admin"));
        userRepository.save(initial);

        // TODO: tmp list of movies, load db of movies

        Movie movie_1 = new Movie();
        movie_1.setTitle("Avatar");
        movie_1.setGenre("Adventure");
        movie_1.setYear(2018);
        movieRepository.save(movie_1);

        Movie movie_2 = new Movie();
        movie_2.setTitle("The big bang theory");
        movie_2.setGenre("Comedy");
        movie_2.setYear(2017);
        movieRepository.save(movie_2);

        Movie movie_3 = new Movie();
        movie_3.setTitle("Knight");
        movie_3.setGenre("Action");
        movie_3.setYear(2018);
        movieRepository.save(movie_3);

        Movie movie_4 = new Movie();
        movie_4.setTitle("Nemo 2");
        movie_4.setGenre("Cartoon");
        movie_4.setYear(2018);
        movieRepository.save(movie_4);

        Movie movie_5 = new Movie();
        movie_5.setTitle("Game of Thrones");
        movie_5.setGenre("Drama");
        movie_5.setYear(2018);
        movieRepository.save(movie_5);

        Movie movie_6 = new Movie();
        movie_6.setTitle("Insidious");
        movie_6.setGenre("Horror");
        movie_6.setYear(2018);
        movieRepository.save(movie_6);

    }
}
