package za.co.tangentsolutions.praticalassignment.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import za.co.tangentsolutions.praticalassignment.Security.BaseMvcTest;
import za.co.tangentsolutions.praticalassignment.domain.Employee;
import za.co.tangentsolutions.praticalassignment.domain.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static za.co.tangentsolutions.praticalassignment.security.SecurityConstants.HEADER_STRING;

public class EmployeeControllerIT extends BaseMvcTest {

    private String token;

    @Before
    public void init() throws Exception {
        MvcResult result = login("pravin.gordhan", "pravin.gordhan").andReturn();
        token = extractToken(result);
    }

    @Test
    public void shouldGetCurrentlyLoggedInUser() throws Exception {
        String response = callApi("/api/v1/user");
        User user = mapper.readValue(response, User.class);
        assertThat(user).isNotEqualTo(null);
    }
    @Test
    public void shouldGetProfile() throws Exception {
        String response = callApi("/api/v1/profile");
        Employee employee = mapper.readValue(response, Employee.class);
       assertThat(employee).isNotEqualTo(null);
    }
    @Test
    public void shouldGetAListOfEmployees() throws Exception {
        String response = callApi("/api/v1/employees");
        List employees = mapper.readValue(response, List.class);
       assertThat(employees).isNotEqualTo(null);
       assertThat(employees.size()).isGreaterThan(0);
    }

    private String callApi(String urlTemplate) throws Exception {
        return mockMvc
                    .perform(get(urlTemplate).header(HEADER_STRING, token).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString();
    }
}
