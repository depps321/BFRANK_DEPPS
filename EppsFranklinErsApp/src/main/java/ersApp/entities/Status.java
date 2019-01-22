package ersApp.entities;


import javax.persistence.*;

@Entity
@Table(name="STATUS", schema="ersapp")

public class Status {

    @Id
    @Column(name="STATUS_ID")
    private int id;

    @Column(name="STATUS")
    private String status;

    public Status(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
