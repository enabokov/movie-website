package ua.kpi.coursework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ua.kpi.coursework.domain.User;
import ua.kpi.coursework.domain.UserRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository repository;

    @Autowired
    public DatabaseInitializer(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        User initial = new User();
        initial.setLogin("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        initial.setPassword(encoder.encode("admin"));
        repository.save(initial);
    }
}
