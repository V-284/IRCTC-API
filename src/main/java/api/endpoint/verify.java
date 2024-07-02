package api.endpoint;

import api.endpoint.Repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import api.endpoint.Model.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class verify implements UserDetailsService {
    @Autowired
    UserDB userDB;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String name;
        Users k = userDB.findByUsername(username);
        System.out.println("OKAYBOY");
        List<GrantedAuthority> ls = new ArrayList<>();
        if (k == null)
            throw new UsernameNotFoundException("Not Found");
        else {
            ls.add(new SimpleGrantedAuthority(k.getRole()));
            return new org.springframework.security.core.userdetails.User(username, k.getPassword(), ls);
        }
    }
}
