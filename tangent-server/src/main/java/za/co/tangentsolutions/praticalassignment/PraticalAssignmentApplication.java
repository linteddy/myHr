package za.co.tangentsolutions.praticalassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import za.co.tangentsolutions.praticalassignment.domain.ApplicationUser;
import za.co.tangentsolutions.praticalassignment.domain.Employee;
import za.co.tangentsolutions.praticalassignment.domain.User;

@SpringBootApplication
@RestController
public class PraticalAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PraticalAssignmentApplication.class, args);
    }

    @PostMapping("/login")
    public String login() {
        return "success";

    }

    @GetMapping("/login-success")
    public String success() {
        return "login success";
    }

    @GetMapping("/username")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @GetMapping("/me")
    public User me(Authentication authentication) {
        return sendData(authentication, "http://staging.tangent.tngnt.co/api/user/me/", User.class);
    }

    private <T> T sendData(Authentication authentication, String url, Class<T> responseType) {
        String token = ((ApplicationUser) authentication.getPrincipal()).getToken();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Token " + token);
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType);
        return responseEntity.getBody();
    }

    @GetMapping("/employee")
    public Employee employee(Authentication authentication){
        return sendData(authentication, "http://staging.tangent.tngnt.co/api/employee/me/", Employee.class);

    }


}
