package main.java.com.altsed.spring.entity.utils;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateVessel {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("main/java/com/altsed/spring/entity/utils/hibernate.cfg.xml")
                .addAnnotatedClass(Vacancy.class)
                .addAnnotatedClass(Vessel.class)
                .addAnnotatedClass(Position.class)

                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();
        //use the session object to save Java object
        try{

            //start a transaction
            session.beginTransaction();

            //greate new vessel

            Vessel tempVessel = new Vessel("Smitz2", "submarine", "nuckler", "10HP");


            //print the vessel detail
            System.out.println("tempVessel: " + tempVessel);


            session.save(tempVessel);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
