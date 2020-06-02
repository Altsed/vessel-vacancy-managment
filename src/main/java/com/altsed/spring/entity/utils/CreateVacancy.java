package main.java.com.altsed.spring.entity.utils;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateVacancy {
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

            //get vessel for new vacancy
            int theId = 2;
            Vessel tempVessel = session.get(Vessel.class, theId);

            //create or get position for vacancy
            theId = 12;
            Position tempPosition = session.get(Position.class, theId);
            theId = 14;
            Position tempPosition1 = session.get(Position.class, theId);

            //create the vacancy
            Vacancy tempVacancy = new Vacancy(false, tempPosition, tempVessel, 180);
            Vacancy tempVacancy1 = new Vacancy(true, tempPosition1, tempVessel, 180);

            //add vacancy to vessel
            tempVessel.add(tempVacancy);
            tempVessel.add(tempVacancy1);



            //print the vacancy detail
            System.out.println("tempVacancy: " + tempVacancy);
            System.out.println("tempVacancy1: " + tempVacancy1);



            session.save(tempVacancy);
            session.save(tempVacancy1);
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
