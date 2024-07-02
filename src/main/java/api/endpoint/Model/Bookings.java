package api.endpoint.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Bookings {
    @Column
            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)

            Integer sno;
    @Column
    String username;
    @Column
    String TrainName;
    @Column
    Integer TrainNumber;
    @Column
    Integer Seatsbooked;

    @Column
    String source;
    @Column
    String destination;

 @CreationTimestamp
   public LocalDateTime bookingdate;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTrainName() {
        return TrainName;
    }

    public void setTrainName(String trainName) {
        TrainName = trainName;
    }

    public Integer getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        TrainNumber = trainNumber;
    }

    public Integer getSeatsbooked() {
        return Seatsbooked;
    }

    public void setSeatsbooked(Integer seatsbooked) {
        Seatsbooked = seatsbooked;
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
}
