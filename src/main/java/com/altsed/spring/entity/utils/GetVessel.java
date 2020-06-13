package main.java.com.altsed.spring.entity.utils;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class GetVessel {
    public static void main(String[] args) {
        //create session factory
        File file = new File("src/main/resources/hibernate.cfg.xml");
        SessionFactory factory = new Configuration()
                .configure("main/java/com/altsed/spring/entity/utils/hibernateMySql.cfg.xml")
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

            //get the vessel id from string
            String string = "Vessel{id=3, name='CrazyHorse', vesselType='Boat', engineType='coal', enginePower='20HP'}";
            String stringId[] = string.replaceAll("[^\\d,]", "").split(",");

            int theId = Integer.parseInt(stringId[0]);
            Vessel tempVessel = session.get(Vessel.class, theId);

            //print the vacancy detail
            System.out.println("tempVessel: " + tempVessel);

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
