package api.endpoint.Controller;

import api.endpoint.*;
import api.endpoint.Model.Bookings;
import api.endpoint.Model.Train;
import api.endpoint.Model.Users;
import api.endpoint.Repository.UserDB;
import api.endpoint.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class api {
    @Autowired
    Service service;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDB userDB;
    @Autowired
    jwtbuilder jwtbuilder;

    @PostMapping("/register")
    public ResponseEntity<String> adduser(@RequestBody temp temp) {
        System.out.println(temp.toString());
        String x = service.register(temp);
        if (x.equals("1"))
            return ResponseEntity.badRequest().body("User Already Exists");
        else if (x.equals("2"))
            return ResponseEntity.ok("Registration Successful");
        else
            return ResponseEntity.internalServerError().body("Registration Failed");
    }

    // @PostMapping("/login")
    //public ResponseEntity<String> login(@RequestBody temp temp){

    @GetMapping("/check")
    public String get() {

        return "okay";
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody temp temp) {
        System.out.println(temp.toString());
        Users x = userDB.findByUsername(temp.getUsername());
        // System.out.println(x.toString());
        // Object role=x.getRole();
        if (x == null)
            return ResponseEntity.badRequest().body("Invalid Credentials");

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                UsernamePasswordAuthenticationToken(temp.getUsername()
                , temp.getPassword());
        try {
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Invalid Credentials");
            // if(hello.isAuthenticated())
        }

        String k = jwtbuilder.generateToken(temp.getUsername());
        return ResponseEntity.ok("success + " + k);
        // else return

    }

    @GetMapping("/admin")
    public String admin() {
        return "okay";
    }

    @PostMapping("/bookseat")
    public ResponseEntity<String> bookseat(@RequestBody bookseat bookseat)
    {
       String x= service.Bookseat(bookseat);
        if(x.equals("1"))
           return ResponseEntity.badRequest().body("Incorrect Train Name/Number");
        else if(x.equals("2"))
            return ResponseEntity.ok("No Seats Available");
        else if(x.startsWith("3"))
            return ResponseEntity.ok("Only "+x.substring(1)+" Seats Could have been Booked");
        else return ResponseEntity.ok("All Seats Booked");

    }
   @PostMapping("/planjourney")
  public ResponseEntity<List<Train>> checkstatus(@RequestBody sourceanddesti sourceanddesti)
   {
return ResponseEntity.ok(service.journey(sourceanddesti));
   }

   @GetMapping("/bookingdetails")
    public ResponseEntity<List<Bookings>> booking(){

        return ResponseEntity.ok(service.bookingsList());
   }

}