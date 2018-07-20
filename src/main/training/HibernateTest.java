package training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import training.model.Address;
import training.model.UserDetails;
import training.model.Vehicle;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        UserDetails userDetails2 = new UserDetails();
        userDetails.setUserName("Third User");
        userDetails2.setUserName("Forth User");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Car");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Car2");
        userDetails.getVehicle().add(vehicle1);
        userDetails.getVehicle().add(vehicle2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userDetails);
        session.persist(userDetails2);
        session.getTransaction().commit();
        session.close();

        userDetails = null;

        session = sessionFactory.openSession();
       session.beginTransaction();
       userDetails = session.get(UserDetails.class, 1);
    }
}
