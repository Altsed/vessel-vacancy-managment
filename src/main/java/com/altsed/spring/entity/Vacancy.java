package main.java.com.altsed.spring.entity;

import javax.persistence.*;


@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "position_id")
    private Position position;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "vessel_id")
    private Vessel vessel;

    @Column(name = "duration_of_contract")
    private int durationOfContract;

    public Vacancy() {
    }

    public Vacancy(boolean status, Position position, Vessel vessel, int durationOfContract) {

        this.status = status;
        this.position = position;
        this.vessel = vessel;
        this.durationOfContract = durationOfContract;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public int getDurationOfContract() {
        return durationOfContract;
    }

    public void setDurationOfContract(int durationOfContract) {
        this.durationOfContract = durationOfContract;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", status=" + status +
            //    ", position=" + position +
                ", vessel=" + vessel +
                ", durationOfContract=" + durationOfContract +
                '}';
    }
}
