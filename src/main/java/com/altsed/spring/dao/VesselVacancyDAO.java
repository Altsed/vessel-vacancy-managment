package main.java.com.altsed.spring.dao;

import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;

import java.util.List;

public interface VesselVacancyDAO {
    public List<Vacancy> getVacancies();

    public List<Position> getPositions();

    public List<Vessel> getVessels();
}
