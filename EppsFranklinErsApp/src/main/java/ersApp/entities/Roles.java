package ersApp.entities;


import javax.persistence.*;

@Entity
@Table(name="ROLES", schema = "ersapp")

public class Roles {

    @Id
    @Column(name="ID")
    private int id;

    @Column(name="ROLE")
    private String role;

    public Roles(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
