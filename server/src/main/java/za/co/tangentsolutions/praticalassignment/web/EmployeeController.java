package za.co.tangentsolutions.praticalassignment.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.tangentsolutions.praticalassignment.domain.Employee;
import za.co.tangentsolutions.praticalassignment.domain.User;
import za.co.tangentsolutions.praticalassignment.service.TangentRestService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    private TangentRestService tangentRestService;

    public EmployeeController(TangentRestService tangentRestService) {
        this.tangentRestService = tangentRestService;
    }

    @GetMapping("/user")
    public User me() {
        return tangentRestService.sendRequest("http://staging.tangent.tngnt.co/api/user/me/", User.class);
    }


    @GetMapping("/profile")
    public Employee profile() {
        return tangentRestService.sendRequest("http://staging.tangent.tngnt.co/api/employee/me/", Employee.class);

    }

    @GetMapping("/employees")
    public List employees() {
        return tangentRestService.sendRequest("http://staging.tangent.tngnt.co/api/employee/", List.class);
    }

    @GetMapping("/employees/{filter}")
    public List filterEmployees(@PathVariable("filter") String filter) {
        return tangentRestService.sendRequest("http://staging.tangent.tngnt.co/api/employee/?", List.class);
    }

}
