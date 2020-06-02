package main.java.com.altsed.spring.entity.utils;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteVessel {
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
            Vessel tempVessel = session.get(Vessel.class, theId);

            //print the vacancy detail
            System.out.println("tempVessel: " + tempVessel);

            //print the associated vacancy
           // System.out.println("the associated vacancy: " + tempVessel.getVacancies());

            //remove the associated object references
            //break bi-directional links

            //tempVessel.getVacancies().clear();
            //tempVessel.getVacancy().setPosition(null);


            //delete the vessel

            System.out.println("Deleting tempVessel: " + tempVessel);

            session.delete(tempVessel);
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
