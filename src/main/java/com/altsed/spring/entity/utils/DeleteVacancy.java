package main.java.com.altsed.spring.entity.utils;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteVacancy {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
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

            //get the vacancy detail object
            int theId = 1;
            Vacancy tempVacancy = session.get(Vacancy.class, theId);

            //print the vacancy detail
            System.out.println("tempVacancy: " + tempVacancy);

            //print the associated position and vessel
           // System.out.println("the associated position: " + tempVacancy.getPosition());
            System.out.println("the associated vessel: " + tempVacancy.getVessel());

            //remove the associated object references
            //break bi-directional links
            //tempVacancy.getPosition().setVacancy(null);

            //tempVacancy.getPosition().setVacancy(null);

            //delete the vacancy

            System.out.println("Deleting tempVacancy: " + tempVacancy);

            session.delete(tempVacancy);
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
