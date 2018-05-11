package main.java.entities.movie;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "movie_genre",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "genre"),
    }
)
class Genre implements Serializable {

    private Integer id;
    private String genre;

    public Genre() {}

    public Genre(String genre) {
        this.genre = genre;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
