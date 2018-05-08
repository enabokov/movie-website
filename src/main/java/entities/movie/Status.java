package main.java.entities.movie;

import javax.persistence.*;

@Entity
@Table(
    name = "movie_status",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "status"),
    }
)
class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status", nullable = false)
    private String status;
}
