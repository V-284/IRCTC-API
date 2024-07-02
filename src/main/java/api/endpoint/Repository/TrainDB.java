package api.endpoint.Repository;

import api.endpoint.Model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainDB extends JpaRepository<Train,Integer> {

 // Train findByRoute(String name);
  Train findByTrainname(String number);

   api.endpoint.Model.Train findByTrainnameAndTrainnumber(String name,Integer number);
}
