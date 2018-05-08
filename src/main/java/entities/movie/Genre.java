package main.java.entities.movie;

import javax.persistence.*;

@Entity
@Table(
    name = "movie_genre",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "genre"),
    }
)
class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "genre", nullable = false)
    private String genre;
}
