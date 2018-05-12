package beans;

import controllers.MovieController;

import java.io.Serializable;
import java.util.List;

public class MovieBean implements Serializable {

    private MovieController movieController;

    // required
    private String title;

    // optional
    private String description;
    private String status;
    private String genre;
    private String language;
    private Long rating;
    private String image;
    private Long budget;

    public MovieBean() {
        movieController = new MovieController();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public List getMovies(int limit, int offset) {
        return this.movieController.getMovies(limit, offset);
    }
}
