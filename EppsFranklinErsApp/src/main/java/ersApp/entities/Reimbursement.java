package ersApp.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="REIMBURSEMENTS", schema= "ersapp")

public class Reimbursement {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="AMOUNT")
    private double amt;

    @Column(name="SUBMITTED")
    private Timestamp submit;

    @Column(name="RESOLVED")
    private Timestamp resolve;

    @Column(name="DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="STATUS_ID", referencedColumnName = "STATUS_ID")
    private Status statusid;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="AUTHOR_ID", referencedColumnName = "USER_ID")
    private User authId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="RESOLVER_ID", referencedColumnName = "USER_ID")
    private User resolveId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="TYPE_ID", referencedColumnName = "TYPE_ID")
    private Type typeId;


    public Reimbursement(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public Timestamp getSubmit() {
        return submit;
    }

    public void setSubmit(Timestamp submit) {
        this.submit = submit;
    }

    public Timestamp getResolve() {
        return resolve;
    }

    public void setResolve(Timestamp resolve) {
        this.resolve = resolve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatusid() {
        return statusid;
    }

    public void setStatusid(Status statusid) {
        this.statusid = statusid; }

    public User getAuthId() {
        return authId;
    }

    public void setAuthId(User authId) { this.authId = authId; }

    public User getResolveId() {
        return resolveId;
    }

    public void setResolveId(User resolveId) {
        this.resolveId = resolveId;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amt=" + amt +
                ", submit=" + submit +
                ", resolve=" + resolve +
                ", desc='" + description + '\'' +
                ", statusid=" + statusid +
                ", authId=" + authId +
                ", resolveId=" + resolveId +
                ", typeId=" + typeId +
                '}';
    }
}
