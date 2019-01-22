package ersApp.entities;


import javax.persistence.*;

@Entity
@Table(name="TYPE", schema = "ersapp")

public class Type {

    @Id
    @Column(name="TYPE_ID")
    private int id;

    @Column(name="TYPE")
    private String type;

    public Type(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
