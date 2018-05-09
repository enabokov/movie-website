package main.java.entities.movie;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "movie_status",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "status"),
    }
)
class Status implements Serializable {

    private Integer id;
    private String status;

    public Status() {}

    public Status(String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
