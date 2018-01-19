package za.co.tangentsolutions.praticalassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/")
public class PraticalAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraticalAssignmentApplication.class, args);
	}

	@PostMapping("/authenticate")
    public Token login(@RequestBody User user){
	    RestTemplate restTemplate = new RestTemplate();
	   return restTemplate.postForObject("http://staging.tangent.tngnt.co/api-token-auth/",user,Token.class);

    }





}
