package api.endpoint.Service;

import api.endpoint.Model.Train;
import api.endpoint.Repository.TrainDB;
import api.endpoint.temp2;
import api.endpoint.updateseat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService {
    @Autowired
    TrainDB train;

    public boolean addtrain(temp2 temp2) {
        Train x = new Train();

        String route=temp2.getSource();
        //List<Stations> y=new ArrayList<>();
                for(int i=0;i<temp2.getMidstations().size();i++) {
                    route=route+","+temp2.getMidstations().get(i);
            //        y.add(new Stations(temp2.getMidstations().get(i)));
                }
                route=route+","+temp2.getDestination();
          //      stations.saveAll(y);

        x.setTrainname(temp2.getName());
        x.setSource(temp2.getSource());
        x.setDestination(temp2.getDestination());
        x.setSeats(temp2.getSeats());
        x.setTrainnumber(temp2.getTrainnumber());
        x.setRoute(route);
     //   x.setStationsList(y);
        try {
            train.save(x);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean updateseats(updateseat name){
        Train k1=train.findByTrainnameAndTrainnumber(name.getName(),name.getNumber());
        if(k1==null)
          return false;
        else
            k1.setSeats(name.getSeats());
        train.save(k1);
        return true;
        }

    }
