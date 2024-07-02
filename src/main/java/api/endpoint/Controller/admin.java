package api.endpoint.Controller;

import api.endpoint.Service.adminService;
import api.endpoint.temp2;
import api.endpoint.updateseat;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class admin {
    @Value("${api.key}")
    private String apiKey;
    @Value("${api.secret}")
    private String apiSecret;
    @Autowired
    adminService adminService;
    @PostMapping("/addtrain")
    public ResponseEntity<String> addTrain(@RequestBody temp2 temp2, HttpServletRequest httpServletRequest) {
        if (verify(httpServletRequest.getHeader("admin-apikey"), httpServletRequest.getHeader("admin-apisecret"))) {
            System.out.println(temp2.toString());
            if (adminService.addtrain(temp2))
                return ResponseEntity.ok("SUCCESS");
            return ResponseEntity.badRequest().body("ERROR");
        } else
            return ResponseEntity.badRequest().body("You are Not An Admin");
    }

    @PostMapping("/updateseats")
    public ResponseEntity<String> updatetrain(@RequestBody updateseat updateseat, HttpServletRequest httpServletRequest) {
        if (verify(httpServletRequest.getHeader("admin-apikey"), httpServletRequest.getHeader("admin-apisecret"))) {
            if (adminService.updateseats(updateseat))
                return ResponseEntity.ok("updated");
            else
                return ResponseEntity.badRequest().body("Train Not Found");
        } else return ResponseEntity.badRequest().body("You Are Not an Admin");
    }

private boolean verify(String apiKey,String apiSecret){

    return apiKey.equals(this.apiKey) && apiSecret.equals(this.apiSecret);


}
}
