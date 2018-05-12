package entities.user;

import javax.persistence.*;


@Entity
@Table(
    name = "Users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
    }
)
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private int age;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String sex;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User [id=" + this.id + ", email = " + this.email +
                ", age = " + this.age + ", name=" + this.name + ", sex=" + this.sex + "]";
    }
}
