package ersApp.data;

import ersApp.entities.Reimbursement;
import ersApp.entities.Status;
import ersApp.entities.Type;
import ersApp.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static java.time.LocalDateTime.now;


public class ReimbursmentDao implements ReimbursmentInterface {
    SessionFactory sessionFactory;


    public ReimbursmentDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Reimbursement> listByUserId(User u) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<Reimbursement> b = null;


        tx.commit();
        session.close();
        return b;

    }

    @Override
    public void createNew( User u, double amt, String description, int type) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Reimbursement r = new Reimbursement();
        r.setAuthId(u);
        r.setAmt(amt);
        r.setDescription(description);
        Type t = (Type)session.get(Type.class, type);
        r.setTypeId(t);
        r.setStatusid((Status)session.get(Status.class, 2));
        Date d = new Date();
        r.setSubmit(new Timestamp(d.getTime()));
        session.save(r);
        tx.commit();
        session.close();

    }

    @Override
    public void changeStatus(User u, int reimbId , int status) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Date d = new Date();

        Reimbursement r = (Reimbursement)session.get(Reimbursement.class, reimbId);
        r.setStatusid((Status)session.get(Status.class,status));
        r.setResolve(new Timestamp(d.getTime()));
        r.setResolveId(u);
        session.save(r);
        tx.commit();
        session.close();

    }
}
