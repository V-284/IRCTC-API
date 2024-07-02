package api.endpoint.Repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

public interface Bookings extends JpaRepository<api.endpoint.Model.Bookings,Integer> {

   List<api.endpoint.Model.Bookings> findByUsername(String username);
}
