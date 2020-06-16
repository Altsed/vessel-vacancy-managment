package main.java.com.altsed.spring.dao;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class VesselVacancyDAOImpl implements VesselVacancyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Vacancy> getVacancies() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Vacancy> query = currentSession.createQuery("from Vacancy order by vessel.name", Vacancy.class);
        List<Vacancy> vacancies = query.getResultList();
        return vacancies;
   }

    @Override
    public List<Position> getPositions() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Position> query = currentSession.createQuery("from Position", Position.class);
        List<Position> positions = query.getResultList();
        return positions;
    }

    @Override
    public List<Vessel> getVessels() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Vessel> query = currentSession.createQuery("from Vessel order by name", Vessel.class);
        List<Vessel> vessels = query.getResultList();
        return vessels;
    }

    @Override
    public void savePosition(Position thePosition) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(thePosition);
    }

    @Override
    public void saveVessel(Vessel theVessel) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theVessel);

    }

    @Override
    public void saveVacancy(Vacancy theVacancy) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theVacancy);
    }

    @Override
    public Vessel getVessel(int vesselId) {

        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Vessel.class, vesselId);

    }

    @Override
    public Position getPosition(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Position.class, theId);
    }

    @Override
    public Vacancy getVacancy(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Vacancy.class, theId);
    }

    @Override
    public void deleteVessel(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Vessel theVessel = currentSession.get(Vessel.class, theId);
        currentSession.delete(theVessel);
    }

    @Override
    public void deletePosition(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Position thePosition = currentSession.get(Position.class, theId);
        currentSession.delete(thePosition);
    }

    @Override
    public void deleteVacancy(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Vacancy theVacancy = currentSession.get(Vacancy.class, theId);
        currentSession.delete(theVacancy);
    }
}
