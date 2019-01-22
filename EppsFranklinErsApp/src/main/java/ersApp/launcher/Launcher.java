package ersApp.launcher;

import ersApp.data.ReimbursmentDao;
import ersApp.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Launcher {
    //our session factory
    static SessionFactory sessionFactory;

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        sessionFactory = launcher.configureSessionFactory();
        ReimbursmentDao reimbursmentDao = new ReimbursmentDao(sessionFactory);
        //reimbursmentDao.createNew(69.69,"Otheeeer again",4);
        //reimbursmentDao.changeStatus(7,3);

    }

    public SessionFactory configureSessionFactory() {


        Configuration configuration = new Configuration()
                .setProperties(setSessionFactoryProperties());


        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Reimbursement.class);
        configuration.addAnnotatedClass(Status.class);
        configuration.addAnnotatedClass(Type.class);
        configuration.addAnnotatedClass(Roles.class);

        //register our configuration withe the
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);

    }

    private Properties setSessionFactoryProperties() {

        Properties temp = new Properties();

        temp.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        temp.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        temp.setProperty("hibernate.connection.username", "quitefranklin13");
        temp.setProperty("hibernate.connection.password", "workpass");
        temp.setProperty("hibernate.connection.url", "jdbc:postgresql://mydatabase.cmnosqvtqsbs.us-east-2.rds.amazonaws.com/test");
        temp.setProperty("hibernate.connection.pool_size", "1");

        //temp.setProperty("hibernate.hbm2ddl.auto", "create");
        temp.setProperty("hibernate.show_sql", "true");
        temp.setProperty("hibernate.format_sql", "true");
        return temp;

    }
    public void createData(){

    }

}
