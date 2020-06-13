package main.java.com.altsed.spring.service;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;

import java.util.List;

public interface VesselVacancyService {
    public List<Vacancy> getVacancies();
    public List<Position> getPositions();
    public List<Vessel> getVessels();

    void savePosition(Position thePosition);

    void saveVessel(Vessel theVessel);

    void saveVacancy(Vacancy theVacancy);

    Vessel getVessel(int vesselId);
}
