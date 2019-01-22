package ersApp.entities;


import javax.persistence.*;

@Entity
@Table(name="USERS", schema="ersapp")

public class User {


    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="USERNAME", unique = true)
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="FIRST_NAME")
    private String firstname;

    @Column(name="LAST_NAME")
    private String lastname;

    @Column(name="EMAIL", unique = true)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="ROLE_ID")
    private Roles roleId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRoleId() {
        return roleId ;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
       
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
