package main.java.entities.movie;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "movie_language",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "language"),
    }
)
class Language implements Serializable {

    private Integer id;
    private String language;

    public Language() {}

    public Language(String language) {
        this.language = language;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
