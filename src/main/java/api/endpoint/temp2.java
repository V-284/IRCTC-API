package api.endpoint;

import java.util.List;

public class temp2 {

    String name;
    Integer trainnumber;
    String source;
    String destination;
    Integer seats;

    List<String> midstations;

    public List<String> getMidstations() {
        return midstations;
    }

    public void setMidstations(List<String> midstations) {
        this.midstations = midstations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getTrainnumber() {
        return trainnumber;
    }

    public void setTrainnumber(Integer trainnumber) {
        this.trainnumber = trainnumber;

    }

    @Override
    public String toString() {
        return "temp2{" +
                "name='" + name + '\'' +
                ", trainnumber='" + trainnumber + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", midstations=" + midstations +
                '}';
    }
}
