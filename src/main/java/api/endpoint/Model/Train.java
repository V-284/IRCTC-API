package api.endpoint.Model;

import jakarta.persistence.*;

@Entity
public class Train {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   public Integer sno;

    @Column
   public String trainname;
    @Column(nullable = false, unique = true)
   public Integer trainnumber;
    @Column
   public String Source;

    @Column
   public String Destination;
    @Column
   public Integer Seats;

    @Column
   public String route;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

//    @ManyToMany
//    @JoinTable(
//            name = "MIDTABLE",
//            joinColumns = @JoinColumn(name = "intermediate"),
//            inverseJoinColumns = @JoinColumn(name = "Source&Desti")
//    )
//    List<Stations> stationsList;


    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public Integer getSeats() {
        return Seats;
    }

    public void setSeats(Integer seats) {
        Seats = seats;
    }

    public String getTrainname() {
        return trainname;
    }

    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }

    public Integer getTrainnumber() {
        return trainnumber;
    }

    public void setTrainnumber(Integer trainnumber) {
        this.trainnumber = trainnumber;
    }
}