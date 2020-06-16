package main.java.com.altsed.spring.dao;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;

import java.util.List;

public interface VesselVacancyDAO {
    public List<Vacancy> getVacancies();

    public List<Position> getPositions();

    public List<Vessel> getVessels();

    void savePosition(Position thePosition);

    void saveVessel(Vessel theVessel);

    void saveVacancy(Vacancy theVacancy);

    Vessel getVessel(int vesselId);

    Position getPosition(int theId);

    Vacancy getVacancy(int theId);

    void deleteVessel(int theId);

    void deletePosition(int theId);

    void deleteVacancy(int theId);
}
