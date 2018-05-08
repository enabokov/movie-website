package main.java.entities.movie;

import javax.persistence.*;

@Entity
@Table(
    name = "movie_language",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "language"),
    }
)
class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "language", nullable = false)
    private String language;
}
