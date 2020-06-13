package main.java.com.altsed.spring.entity;

import org.springframework.core.convert.converter.Converter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vessel")
public class Vessel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "vessel_type")
    private String vesselType;

    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "engine_power")
    private String enginePower;

    @OneToMany(mappedBy = "vessel",
            cascade = CascadeType.ALL)

    private List<Vacancy> vacancies;



    public Vessel() {
    }

    public Vessel(String name, String vesselType, String engineType, String enginePower) {
        this.name = name;
        this.vesselType = vesselType;
        this.engineType = engineType;
        this.enginePower = enginePower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVesselType() {
        return vesselType;
    }

    public void setVesselType(String vesselType) {
        this.vesselType = vesselType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
    public void add(Vacancy theVacancy){
        if (vacancies == null){
            vacancies = new ArrayList<>();
        }
        vacancies.add(theVacancy);
        theVacancy.setVessel(this);
    }

    @Override
    public String toString() {
        return "Vessel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vesselType='" + vesselType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", enginePower='" + enginePower + '\'' +
                '}';
    }

}


