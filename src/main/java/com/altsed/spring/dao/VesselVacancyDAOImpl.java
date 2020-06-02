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
}
