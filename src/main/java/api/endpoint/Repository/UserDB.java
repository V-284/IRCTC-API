package api.endpoint.Repository;

import api.endpoint.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDB extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
