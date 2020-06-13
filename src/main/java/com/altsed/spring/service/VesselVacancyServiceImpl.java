package main.java.com.altsed.spring.service;

import main.java.com.altsed.spring.dao.VesselVacancyDAO;
import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VesselVacancyServiceImpl implements VesselVacancyService{

    @Override
    public Vessel getVessel(int vesselId) {
        return vesselVacancyDAO.getVessel(vesselId);
    }

    @Autowired
    private VesselVacancyDAO vesselVacancyDAO;

    @Override
    @Transactional
    public List<Vacancy> getVacancies() {
        return vesselVacancyDAO.getVacancies();
    }

    @Override
    @Transactional
    public List<Position> getPositions() {
        return vesselVacancyDAO.getPositions();
    }

    @Override
    @Transactional
    public List<Vessel> getVessels() {
        return vesselVacancyDAO.getVessels();
    }

    @Override
    public void savePosition(Position thePosition) {
        vesselVacancyDAO.savePosition(thePosition);
    }

    @Override
    public void saveVessel(Vessel theVessel) {
        vesselVacancyDAO.saveVessel(theVessel);
    }

    @Override
    public void saveVacancy(Vacancy theVacancy) {
        vesselVacancyDAO.saveVacancy(theVacancy);
    }


}
