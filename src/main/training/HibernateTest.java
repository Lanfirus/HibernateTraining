package training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import training.model.Address;
import training.model.UserDetails;

import java.time.LocalDateTime;
import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        UserDetails userDetails2 = new UserDetails();
        userDetails.setUserName("Third User");
        userDetails2.setUserName("Forth User");
        Address addr = new Address();
        addr.setCity("Kiev");
        addr.setPincode("045352");
        addr.setState("NU");
        addr.setStreet("gdgh");
        Address addr2 = new Address();
        addr.setCity("Kiev2");
        addr.setPincode("0453522");
        addr.setState("NU2");
        addr.setStreet("gdgh2");

        userDetails.getListOfAddresses().add(addr);
        userDetails.getListOfAddresses().add(addr2);

        userDetails.setJoinedDate(new Date());
       // userDetails.setAddress(addr);
        userDetails.setDescription("description of the third user");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.save(userDetails2);
        session.getTransaction().commit();
        session.close();

        userDetails = null;
        new Object().hashCode();

       session = sessionFactory.openSession();
       session.beginTransaction();
       userDetails = session.get(UserDetails.class, 1);
        System.out.println("name is " + userDetails.getUserName());
    }
}
