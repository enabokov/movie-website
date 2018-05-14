package ua.kpi.coursework.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    List<Movie> findByYear(Integer year);

}