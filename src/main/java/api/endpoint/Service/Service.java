package api.endpoint.Service;

import api.endpoint.Model.Users;
import api.endpoint.Repository.Bookings;

import api.endpoint.Repository.TrainDB;
import api.endpoint.Repository.UserDB;
import api.endpoint.bookseat;
import api.endpoint.sourceanddesti;
import api.endpoint.temp;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Service {
    @Autowired
    UserDB UserDB;
    @Autowired
    TrainDB train;
    @Autowired
    Bookings bookings;
    @Autowired
    PasswordEncoder passwordEncoder;

    public String register(temp temp) {

        if (UserDB.findByUsername(temp.getUsername()) == null) {
            System.out.println(temp.toString());
            Users x = new Users();
            x.setUsername(temp.getUsername());
            x.setPassword(passwordEncoder.encode(temp.getPassword()));
            x.setRole("user");
            try {
                UserDB.save(x);
            } catch (Exception e) {
                return "3";
            }
            return "2";
        } else return "1";
    }
    @Transactional
   @Lock(LockModeType.PESSIMISTIC_WRITE)
    public String Bookseat(bookseat bookseat) {
        int flag = 0;
        api.endpoint.Model.Train b =train.findByTrainnameAndTrainnumber(bookseat.getName(), bookseat.getNumber());
        if (b == null)
            return "1";
        else if (b.getSeats() == 0)
            return "2";

        else {
            api.endpoint.Model.Bookings bookings = new api.endpoint.Model.Bookings();
            Users a = UserDB.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            if (bookseat.getSeats() > b.getSeats()) {
                bookings.setSeatsbooked(b.getSeats());
                b.setSeats(0);
                flag = 1;
            } else{
                bookings.setSeatsbooked(bookseat.getSeats());
            b.setSeats(b.getSeats() - bookseat.getSeats());}
            bookings.setUsername(a.getUsername());
            bookings.setTrainName(bookseat.getName());
            bookings.setTrainNumber(bookseat.getNumber());
            bookings.setSource(bookseat.getSource());
            bookings.setDestination(bookseat.getDestination());
            train.save(b);
            this.bookings.save(bookings);
            if (flag == 1)
                return "3" + b.getSeats().toString();
            return "4";
        }

    }

    public List<api.endpoint.Model.Train> journey(sourceanddesti sourceanddesti) {

        List<api.endpoint.Model.Train> x = train.findAll();
        List<api.endpoint.Model.Train> y = new ArrayList<>();
        String route = null;
        for (int i = 0; i < x.size(); i++) {
            route = x.get(i).getRoute();
            if ((route.contains(sourceanddesti.getSource()) && route.contains(sourceanddesti.getDestination())
            ) && (route.indexOf(sourceanddesti.getSource()) < route.indexOf(sourceanddesti.getDestination()))) {
                y.add(x.get(i));
            }
        }
        return y;
    }

    public List<api.endpoint.Model.Bookings> bookingsList(){

       return bookings.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
